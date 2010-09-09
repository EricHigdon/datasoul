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

/*
 * GstDisplayFrame.java
 *
 * Created on Mar 5, 2010, 5:49:55 PM
 */

package datasoul.render.gstreamer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import org.gstreamer.Element;
import org.gstreamer.swing.VideoComponent;

import datasoul.DatasoulMainForm;
import datasoul.render.ContentDisplayRenderer;

/**
 *
 * @author samuellucas
 */
public class GstDisplayFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -171894252068723465L;
	private MyVideoComponent vcomp;
    private ContentDisplayRenderer render;

    /** Creates new form GstDisplayFrame */
    public GstDisplayFrame() {
        initComponents();
        DatasoulMainForm.setDatasoulIcon(this);
        render = new ContentDisplayRenderer() {
            @Override
            public void repaint() {
                try {
                    SwingUtilities.invokeAndWait(new Runnable() {

                        public void run() {
                            GstDisplayFrame.this.repaint();
                        }
                    });
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } catch (InvocationTargetException ex) {
                    ex.printStackTrace();
                }

            }
        };
    }

    public ContentDisplayRenderer getContentDisplay(){
        return render;
    }

    public Element getVideoSink(){
        return vcomp.getElement();
    }

    public void init(int width, int height){
        vcomp = new MyVideoComponent();
        render.initDisplay(width, height);
        vcomp.setOpaque(false);
        vcomp.setBackground(Color.BLACK);
        this.setBackground(Color.BLACK);
        vcomp.setPreferredSize(new Dimension(width, height));
        this.setPreferredSize(new Dimension(width, height));
        this.add( vcomp,  BorderLayout.CENTER );
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(java.awt.Color.black);
        setResizable(false);
        setUndecorated(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    public class MyVideoComponent extends VideoComponent {
            /**
		 * 
		 */
		private static final long serialVersionUID = -966652712395463586L;

			@Override
            public void paint(Graphics g){
                    g.setColor(Color.BLACK);
                    g.fillRect(0,0, GstDisplayFrame.this.getWidth(), GstDisplayFrame.this.getHeight());
                    super.paint (g);
                    BufferedImage img = render.getActiveImage();
                    if (img != null){
                        synchronized(img){
                            g.drawImage(img, 0,0, GstDisplayFrame.this.getWidth(), GstDisplayFrame.this.getHeight(), null);
                        }
                    }
            }
    }



}

