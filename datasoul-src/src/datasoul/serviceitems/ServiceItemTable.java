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

/*
 * ServiceItemTable.java
 *
 * Created on February 10, 2006, 11:22 PM
 */

package datasoul.serviceitems;

import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import datasoul.render.ContentManager;
import datasoul.render.gstreamer.GstManagerServer;
import datasoul.render.gstreamer.commands.GstDisplayCmdVideoPause;
import datasoul.serviceitems.imagelist.ImageListServiceItem;
import datasoul.serviceitems.text.TextServiceItem;

/**
 *
 * @author  samuelm
 */
public class ServiceItemTable extends javax.swing.JPanel implements ListSelectionListener {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -7691279789517845510L;
	ServiceItem item;
    private boolean videoEnded;
    private boolean isPaused;

    private ImageIcon iconPlay;
    private ImageIcon iconPause;
    
    /** Creates new form ServiceItemTable */
    public ServiceItemTable() {
        initComponents();
        lblPrefix.setText("");
        ServiceItem empty = new ServiceItem();
        setServiceItem(empty, 0);
        videoEnded = false;

        iconPlay = new ImageIcon(getClass().getResource("/datasoul/icons/v2/media-playback-start.png"));
        iconPause = new ImageIcon(getClass().getResource("/datasoul/icons/v2/media-playback-pause.png"));

        btnPlayPause.setText("");
        btnPlayPause.setIcon(iconPause);
        
        this.displayTable.addKeyListener(new ServiceItemTableKeyListner(this));
        addTableListener(this);
    }

    public void setFocusInTable(){
        this.displayTable.requestFocus();
    }

    public void setTitlePrefix(String s){
        lblPrefix.setText(s);
    }

    public void setMediaControlsEnabled(boolean b){
        btnPlayPause.setEnabled(b);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrSlideTable = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        pnlHeader = new javax.swing.JPanel();
        lblPrefix = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnPlayPause = new javax.swing.JButton();

        setDoubleBuffered(false);

        scrSlideTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                scrSlideTableComponentResized(evt);
            }
        });
        scrSlideTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                scrSlideTablePropertyChange(evt);
            }
        });

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrSlideTable.setViewportView(displayTable);

        lblPrefix.setText("jLabel1");
        pnlHeader.add(lblPrefix);

        lblTitle.setText("jLabel1");
        pnlHeader.add(lblTitle);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        btnPlayPause.setText(bundle.getString("PAUSE")); // NOI18N
        btnPlayPause.setFocusPainted(false);
        btnPlayPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayPauseActionPerformed(evt);
            }
        });
        pnlHeader.add(btnPlayPause);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
            .addComponent(scrSlideTable, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrSlideTable, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void scrSlideTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_scrSlideTablePropertyChange

    }//GEN-LAST:event_scrSlideTablePropertyChange

    private void scrSlideTableComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_scrSlideTableComponentResized
        if (item != null){
            item.updateHeights(displayTable);
        }
        
    }//GEN-LAST:event_scrSlideTableComponentResized

    private void btnPlayPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayPauseActionPerformed


        if (isPaused){
            btnPlayPause.setIcon(iconPause);
            isPaused = false;
        }else{
            btnPlayPause.setIcon(iconPlay);
            isPaused = true;
        }

        System.out.println(isPaused);

        if (videoEnded){
            item.showItem();
            ContentManager.getInstance().slideChange(-1);
            videoEnded = false;
        }else{
            GstManagerServer.getInstance().sendCommand(new GstDisplayCmdVideoPause(isPaused));
        }


    }//GEN-LAST:event_btnPlayPauseActionPerformed

    public void notifyVideoEnd(){
        btnPlayPause.setIcon(iconPause);
        isPaused = true;
        videoEnded = true;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlayPause;
    private javax.swing.JTable displayTable;
    private javax.swing.JLabel lblPrefix;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JScrollPane scrSlideTable;
    // End of variables declaration//GEN-END:variables
    
    public void setServiceItem(ServiceItem item, int initialslide){
        this.item = item;
        videoEnded = false;
        isPaused = false;
        item.registerJTable(displayTable); 
        item.updateHeights(displayTable);
        lblTitle.setText(item.getTitle() );
        lblTitle.setIcon(item.getIcon());
        scrSlideTable.setVisible(item.getShowSlideTable());
        btnPlayPause.setVisible(item.getShowMediaControls());
        setSlideIndex(initialslide);
        revalidate();
    }

    public ServiceItem getServiceItem(){
        return this.item;        
    }
    
    public void addTableListener(ListSelectionListener listener){
        displayTable.getSelectionModel().addListSelectionListener(listener);
    }
    
    public String getSlideText(){
        
        int selectedRow = displayTable.getSelectedRow();
        if (selectedRow == -1) {
            selectedRow = 0;
        }

        if (! (item instanceof TextServiceItem)){
            return "";
        }
        
        return ((TextServiceItem)item).getSlideText(selectedRow);
    }

    public String getNextSlideText(){
        
        int selectedRow = displayTable.getSelectedRow();
        if (selectedRow == -1) {
            selectedRow = 0;
        }
        
        if (selectedRow+1 >= displayTable.getRowCount()){
            return "";
        }

        if (! (item instanceof TextServiceItem)){
            return "";
        }
        
        return ((TextServiceItem)item).getSlideText(selectedRow+1);
    }

    public BufferedImage getSlideImage(){
        int selectedRow = displayTable.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }

        if (! (item instanceof ImageListServiceItem)){
            return null;
        }
        
        if (item.getRowCount() < 1){
            return null;
        }

        return ((ImageListServiceItem)item).getImage(selectedRow);
    }

    public BufferedImage getNextSlideImage(){
        int selectedRow = displayTable.getSelectedRow();
        if (selectedRow == -1) {
            selectedRow = 0;
        }

        if (selectedRow+1 >= displayTable.getRowCount()){
            return null;
        }

        if (! (item instanceof ImageListServiceItem)){
            return null;
        }

        return ((ImageListServiceItem)item).getImage(selectedRow+1);
    }

    public int getSlideIndex(){
        return displayTable.getSelectedRow();
    }

    public void setSlideIndex(int x){
        displayTable.changeSelection(x, 1, false, false);
    }

    public int getSlideCount(){
        return displayTable.getRowCount();
    }
    
    public void goNextMarkedSlide(){
        int actualSlide = getSlideIndex();
        int nextMarkedSlide = getServiceItem().getNextMarkedSlide(actualSlide);
        this.setSlideIndex(nextMarkedSlide);
    }
    public void goPreviousMarkedSlide(){
        int actualSlide = getSlideIndex();
        int previousMarkedSlide = getServiceItem().getPreviousMarkedSlide(actualSlide);
        setSlideIndex(previousMarkedSlide);
    }

    public void valueChanged(ListSelectionEvent e) {

        try{
            int x = displayTable.getSelectedRow();

            // try to show next two slides
            if ( (x + 2 > e.getLastIndex()) && (x + 2 < displayTable.getRowCount()) ) {
                    displayTable.scrollRectToVisible( displayTable.getCellRect(x + 2, 0, true) );
            }else if ( (x + 1 > e.getLastIndex()) && (x + 1 < displayTable.getRowCount()) ) {
                    displayTable.scrollRectToVisible( displayTable.getCellRect(x + 1, 0, true) );
            }

            // try to show previous two slides
            if ( (x - 2 < e.getFirstIndex()) && (x - 2 >= 0) ) {
                    displayTable.scrollRectToVisible( displayTable.getCellRect(x - 2, 0, true) );
            }else if ( (x - 1 < e.getFirstIndex()) && (x - 1 >= 0 )) {
                    displayTable.scrollRectToVisible( displayTable.getCellRect(x - 1, 0, true) );
            }

            // ensure that the actual slide is being shown
            displayTable.scrollRectToVisible( displayTable.getCellRect(x, 0, true) );
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }

    public void setHeaderVisible(boolean b){
        pnlHeader.setVisible(b);
    }

    public void addTableKeyListener(KeyListener key){
        displayTable.addKeyListener(key);
    }

}

