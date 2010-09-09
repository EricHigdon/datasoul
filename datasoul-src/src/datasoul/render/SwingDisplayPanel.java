/* 
 * Copyright 2005-2010 Samuel Mello & Eduardo Schnell
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

package datasoul.render;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SwingDisplayPanel extends javax.swing.JPanel  {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8385004717965058615L;
	private ContentDisplayRenderer contentDisplay;

    /** Creates new form SwingDisplayPanel */
    public SwingDisplayPanel() {
        initComponents();
        contentDisplay = new ContentDisplayRenderer() {
            @Override
            public void repaint() {
                    SwingDisplayPanel.this.repaint();
            }
        };
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    }//GEN-LAST:event_formKeyPressed

    @Override
    public void paint (Graphics g){
        BufferedImage img = contentDisplay.getActiveImage();
        if (img != null){
            g.clearRect(0, 0, img.getWidth(), img.getHeight());
            synchronized(img){
                g.drawImage(img, 0,0, img.getWidth(), img.getHeight(), null);
            }
        }
    }

    public void initDisplay(int w, int h) {
        contentDisplay.initDisplay(w, h);
        this.setSize(w, h);
    }

    public ContentDisplayRenderer getContentDisplay(){
        return contentDisplay;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}

