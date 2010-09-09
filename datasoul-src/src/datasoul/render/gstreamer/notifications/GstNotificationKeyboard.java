/* 
 * Copyright 2005-2010 Samuel Mello
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; version 2 of the License.
 * 
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 * 
 */

package datasoul.render.gstreamer.notifications;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import datasoul.util.DatasoulKeyListener;

/**
 *
 * @author samuel
 */
public class GstNotificationKeyboard extends GstNotification {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1010397600008855550L;
	private KeyEvent key;
    
    public GstNotificationKeyboard(KeyEvent key){
        this.key = key;
    }

    @Override
    public void run(){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                DatasoulKeyListener.getInstance().keyPressed(key);
            }
        });

    }

}

