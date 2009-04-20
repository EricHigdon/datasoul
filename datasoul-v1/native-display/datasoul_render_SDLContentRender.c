#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <jni.h> 
#include <SDL/SDL.h>
#include <SDL/SDL_thread.h>
#include "datasoul_render_SDLContentRender.h"

#define FRAMETIME_MS 30


typedef struct {
	SDL_Surface *screen;
	SDL_Surface *overlay[2];
	int overlayActive;
	SDL_Surface *background;
	int black;
	int clear;
	int needRefresh;
	int stopDisplay;
	int debugMode;
	char x11Display[1024];
	SDL_Thread *displayThread;
	
} globals_t;

static globals_t globals;

int displayThread (void *arg){
	
	Uint32 time1, time2, time3 = 0;
	
	while (globals.stopDisplay == 0){
		time1 = SDL_GetTicks();
		
		if (globals.needRefresh){

			// Update the screen

			// we are in black?
			if (globals.black && globals.needRefresh){
				SDL_FillRect (globals.screen, NULL, 0);	
			}else{
				// ok, "normal" painting"
				SDL_BlitSurface(globals.background, NULL, globals.screen, NULL);

				if (! globals.clear){
					SDL_BlitSurface(globals.overlay[globals.overlayActive], NULL, globals.screen, NULL);

				}
			}
			time3 = SDL_GetTicks();
			SDL_Flip(globals.screen);
			globals.needRefresh = 0;

		}
		
		time2 = SDL_GetTicks();
		// Sleep until the next screen refresh
		if ( (time2 - time1) < FRAMETIME_MS ){
			SDL_Delay ( FRAMETIME_MS - (time2 - time1) );
		}

		if (globals.debugMode) {
			fprintf(stderr, "Processing: %d ms, Sleeping: %d ms (%d, %d, %d)\n", 
					(time2 - time1), 
					FRAMETIME_MS - (time2 - time1),
					time1, time2, time3);
		}
	}

	return 0;

}



/*
 * Class:     datasoul_render_SDLContentRender
 * Method:    init
 */
JNIEXPORT void JNICALL Java_datasoul_render_SDLContentRender_init
(JNIEnv *env, jobject obj, jint width, jint height, jint top, jint left ){


        SDL_Surface *surface;

        Uint32 rmask, gmask, bmask, amask;

	if (width <= 0){
		width = 640;
	}
	if (height <= 0){
		height = 480;
	}

		
	char envopt2[1024];
	snprintf(envopt2, 1023, "SDL_VIDEO_WINDOW_POS=%d,%d", left, top);
	putenv(envopt2);
	
        if( SDL_Init( SDL_INIT_EVERYTHING ) == -1 )
        {
                return ;
        }


	globals.screen = SDL_SetVideoMode( width, height, 0, SDL_SWSURFACE | SDL_DOUBLEBUF | SDL_NOFRAME);
#if SDL_BYTEORDER == SDL_BIG_ENDIAN
        rmask = 0xff000000;
        gmask = 0x00ff0000;
        bmask = 0x0000ff00;
        amask = 0x000000ff;
#else
        rmask = 0x000000ff;
        gmask = 0x0000ff00;
        bmask = 0x00ff0000;
        amask = 0xff000000;
#endif

        surface = SDL_CreateRGBSurface(SDL_SWSURFACE, width, height, 32,
                        rmask, gmask, bmask, amask);

        globals.overlay[0] = SDL_DisplayFormatAlpha(surface);
        globals.overlay[1] = SDL_DisplayFormatAlpha(surface);
        globals.background = SDL_DisplayFormatAlpha(surface);
	
	SDL_FreeSurface(surface);

	globals.needRefresh = 1;
	globals.stopDisplay = 0;
	
	globals.displayThread = SDL_CreateThread( &displayThread, NULL);
}



/*
 * Class:     datasoul_render_SDLContentRender
 * Method:    cleanup
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_datasoul_render_SDLContentRender_cleanup
  (JNIEnv *env, jobject obj){

	  int x;
	  globals.stopDisplay = 1;

	  SDL_WaitThread(globals.displayThread, &x);
	  
}

void setImageOnSurface(JNIEnv *env, SDL_Surface *surface, jobject bytebuf){

	Uint8 Rshift, Gshift, Bshift, Ashift;
        Uint32 tmp;
	Uint8 *buf;
	int i;
	long size;

        buf = (Uint8*) (*env)->GetDirectBufferAddress(env, bytebuf);
        size = (*env)->GetDirectBufferCapacity(env, bytebuf);

        Rshift =  surface->format->Rshift;
        Gshift =  surface->format->Gshift;
        Bshift =  surface->format->Bshift;
        Ashift =  surface->format->Ashift;

        for (i=0; i<size; i=i+4){
                tmp = 0;
                tmp |= buf[i]   << Ashift;
                tmp |= buf[i+1] << Bshift;
                tmp |= buf[i+2] << Gshift;
                tmp |= buf[i+3] << Rshift;
                //if (i<20){
                //      fprintf(stderr, "%08x \n", tmp);
                //}
                memcpy ((Uint8*)surface->pixels+i, &tmp, 4);
        }

	
}

/*
 * Class:     datasoul_render_SDLContentRender
 * Method:    displayOverlay
 * Signature: (Ljava/nio/ByteBuffer;)V
 */
JNIEXPORT void JNICALL Java_datasoul_render_SDLContentRender_displayOverlay
  (JNIEnv *env, jobject obj, jobject bytebuf){

	  int x;
	  if ( globals.overlayActive == 0){
		  x = 1;
	  }else{
		  x = 0;
	  }
	setImageOnSurface(env, globals.overlay[x], bytebuf);
	globals.overlayActive = x;
	globals.needRefresh = 1;

	if (globals.debugMode > 0){
		fprintf(stdout, "Received overlay image!\n");
	}
	
}

/*
 * Class:     datasoul_render_SDLContentRender
 * Method:    nativeSetBackground
 * Signature: (Ljava/nio/ByteBuffer;)V
 */
JNIEXPORT void JNICALL Java_datasoul_render_SDLContentRender_nativeSetBackground
  (JNIEnv *env, jobject obj, jobject bytebuf){

	setImageOnSurface(env, globals.background, bytebuf);
	globals.needRefresh = 1;

}

/*
 * Class:     datasoul_render_SDLContentRender
 * Method:    setBlack
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_datasoul_render_SDLContentRender_setBlack
  (JNIEnv *env, jobject obj, jint active){
	  globals.black = active;
	  globals.needRefresh = 1;
}

/*
 * Class:     datasoul_render_SDLContentRender
 * Method:    setClear
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_datasoul_render_SDLContentRender_setClear
  (JNIEnv *env, jobject obj, jint active){
	  globals.clear = active;
	  globals.needRefresh = 1;
}

/*
 * Class:     datasoul_render_SDLContentRender
 * Method:    setDebugMode
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_datasoul_render_SDLContentRender_setDebugMode
  (JNIEnv *env, jobject obj, jint mode){

	globals.debugMode = mode;

}

/*
 * Class:     datasoul_render_SDLContentRender
 * Method:    setWindowTitle
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_datasoul_render_SDLContentRender_setWindowTitle
	(JNIEnv *env, jobject obj, jstring title){

     const char *str;
     str = (*env)->GetStringUTFChars(env, title, NULL);
     if (str == NULL) {
         return; /* OutOfMemoryError already thrown */
     }

     SDL_WM_SetCaption(str, NULL);	

     (*env)->ReleaseStringUTFChars(env, title, str);

}


/*
 * Class:     datasoul_render_SDLContentRender
 * Method:    shutdown
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_datasoul_render_SDLContentRender_shutdown
  (JNIEnv *env, jobject obj){
	SDL_Quit();
}

/*
 * Class:     datasoul_render_SDLContentRender
 * Method:    setX11Display
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_datasoul_render_SDLContentRender_setX11Display
  (JNIEnv *env, jobject obj, jstring x11displayStr){

	char *envoptX11 = (char*)malloc(1024);
        const char *str;
        str = (*env)->GetStringUTFChars(env, x11displayStr, NULL);
        snprintf(envoptX11, 1023, "DISPLAY=%s", str);
        (*env)->ReleaseStringUTFChars(env, x11displayStr, str);
	putenv(envoptX11);
	// do NOT free envoptX11. putenv stores only a pointer to it.
	// freeing envoptX11 will lose the value
}