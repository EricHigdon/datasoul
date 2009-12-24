/* 
 * Copyright 2005-2008 Samuel Mello & Eduardo Schnell
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
 * ExtServiceListPanel.java
 *
 * Created on May 23, 2008, 6:56 PM
 */

package datasoul.servicelist;

import datasoul.config.WindowPropConfig;
import datasoul.datashow.ImageListEditorForm;
import datasoul.datashow.ImageListServiceItem;
import datasoul.datashow.ImportServiceItemForm;
import datasoul.datashow.ServiceItem;
import datasoul.datashow.ServiceListColorRender;
import datasoul.datashow.ServiceListTable;
import datasoul.datashow.TextServiceItem;
import datasoul.datashow.TextServiceItemEditorForm;
import datasoul.song.AddSongForm;
import datasoul.song.Song;
import datasoul.song.SongEditorForm;
import datasoul.templates.TemplateComboBox;
import datasoul.util.ObjectManager;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author  samuel
 */
public class ExtServiceListPanel extends javax.swing.JPanel {

    private boolean updateSize;

    /** Creates new form ExtServiceListPanel */
    public ExtServiceListPanel() {
        initComponents();
        ServiceListTable.registerExtendedInstance(this);
        
        tableServiceList.setDraggable(false);
        
        TemplateComboBox comboBox = new TemplateComboBox(); 
        comboBox.setFilterType(TemplateComboBox.FILTER_GENERAL);
        this.tableServiceList.getColumnModel().getColumn(ServiceListTable.ExtendedServiceListTable.COLUMN_TEMPLATE).setCellEditor(new DefaultCellEditor(comboBox));          

        
        ServiceListColorRender cr = new ServiceListColorRender();
        for (int i=0; i<ServiceListTable.ExtendedServiceListTable.COLUMN_COUNT; i++){
            this.tableServiceList.getColumnModel().getColumn(i).setCellRenderer(cr);
        } 
          
        songsSearchPanel1.setSourceView(ObjectManager.VIEW_SERVICE);
        ObjectManager.getInstance().setExtServicePanel(this);
        
        
        // adjust columns
        tableServiceList.getColumnModel().getColumn(ServiceListTable.ExtendedServiceListTable.COLUMN_TIME).setPreferredWidth(20);
        tableServiceList.getColumnModel().getColumn(ServiceListTable.ExtendedServiceListTable.COLUMN_DURATION).setPreferredWidth(20);
        tableServiceList.getColumnModel().getColumn(ServiceListTable.ExtendedServiceListTable.COLUMN_TITLE).setPreferredWidth(200);

        WindowPropConfig.getInstance().getServiceSplit1(jSplitPane1);
        WindowPropConfig.getInstance().getServiceSplit2(jSplitPane2);
        WindowPropConfig.getInstance().getServiceSplit3(jSplitPane3);
        updateSize = true;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppmAddItem = new javax.swing.JPopupMenu();
        actAddSong = new javax.swing.JMenuItem();
        actAddText = new javax.swing.JMenuItem();
        actAddBible = new javax.swing.JMenuItem();
        actAddContentlessItem = new javax.swing.JMenuItem();
        actAddImageList = new javax.swing.JMenuItem();
        actImportItem = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane3 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableServiceList = new datasoul.util.DnDTable();
        toolBar = new javax.swing.JToolBar();
        btnAddWizard = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtHours = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMinutes = new javax.swing.JTextField();
        toolBar1 = new javax.swing.JToolBar();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textSong = new javax.swing.JTextPane();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSongName = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        songsSearchPanel1 = new datasoul.song.SongsSearchPanel();

        actAddSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_playlist.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        actAddSong.setText(bundle.getString("Add_Song")); // NOI18N
        actAddSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actAddSongActionPerformed(evt);
            }
        });
        ppmAddItem.add(actAddSong);

        actAddText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/font-x-generic.png"))); // NOI18N
        actAddText.setText(bundle.getString("Add_Text")); // NOI18N
        actAddText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actAddTextActionPerformed(evt);
            }
        });
        ppmAddItem.add(actAddText);

        actAddBible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_bookmark.png"))); // NOI18N
        actAddBible.setText(bundle.getString("Add_Bible_Text")); // NOI18N
        actAddBible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actAddBibleActionPerformed(evt);
            }
        });
        ppmAddItem.add(actAddBible);

        actAddContentlessItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_insert-note.png"))); // NOI18N
        actAddContentlessItem.setText(bundle.getString("Add_Contentless_Item")); // NOI18N
        actAddContentlessItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actAddContentlessItemActionPerformed(evt);
            }
        });
        ppmAddItem.add(actAddContentlessItem);

        actAddImageList.setText("Add Image List");
        actAddImageList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actAddImageListActionPerformed(evt);
            }
        });
        ppmAddItem.add(actAddImageList);

        actImportItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_task-assigned.png"))); // NOI18N
        actImportItem.setText(bundle.getString("Import_Item")); // NOI18N
        actImportItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actImportItemActionPerformed(evt);
            }
        });
        ppmAddItem.add(actImportItem);

        jSplitPane1.setDividerLocation(600);
        jSplitPane1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSplitPane1PropertyChange(evt);
            }
        });

        jSplitPane3.setDividerLocation(300);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSplitPane3PropertyChange(evt);
            }
        });

        jLabel2.setText(bundle.getString("Start_Time:")); // NOI18N

        jLabel1.setText(bundle.getString("Service_Title:")); // NOI18N

        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });
        txtTitle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTitleFocusLost(evt);
            }
        });

        tableServiceList.setModel(new javax.swing.table.DefaultTableModel(
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
        tableServiceList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableServiceListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableServiceList);

        toolBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        toolBar.setFloatable(false);
        toolBar.setMinimumSize(new java.awt.Dimension(30, 25));
        toolBar.setOpaque(false);

        btnAddWizard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/list-add.png"))); // NOI18N
        btnAddWizard.setText(bundle.getString("Add_Item")); // NOI18N
        btnAddWizard.setToolTipText(bundle.getString("Add_wizard_...")); // NOI18N
        btnAddWizard.setAlignmentY(0.0F);
        btnAddWizard.setBorderPainted(false);
        btnAddWizard.setFocusPainted(false);
        btnAddWizard.setFocusable(false);
        btnAddWizard.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddWizard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddWizardbtnAddActionPerformed(evt);
            }
        });
        toolBar.add(btnAddWizard);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/list-remove.png"))); // NOI18N
        btnRemove.setText(bundle.getString("Delete")); // NOI18N
        btnRemove.setToolTipText(bundle.getString("Delete_item")); // NOI18N
        btnRemove.setAlignmentY(0.0F);
        btnRemove.setBorderPainted(false);
        btnRemove.setFocusPainted(false);
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });
        toolBar.add(btnRemove);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/gtk-edit.png"))); // NOI18N
        btnEdit.setText(bundle.getString("Edit_Item")); // NOI18N
        btnEdit.setToolTipText(bundle.getString("Edit_selected_item_...")); // NOI18N
        btnEdit.setAlignmentY(0.0F);
        btnEdit.setBorderPainted(false);
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        toolBar.add(btnEdit);

        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/go-up.png"))); // NOI18N
        btnUp.setText(bundle.getString("Move_Up")); // NOI18N
        btnUp.setToolTipText(bundle.getString("Change_item_order_to_upper_position")); // NOI18N
        btnUp.setAlignmentY(0.0F);
        btnUp.setBorderPainted(false);
        btnUp.setFocusPainted(false);
        btnUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpMouseClicked(evt);
            }
        });
        toolBar.add(btnUp);

        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/go-down.png"))); // NOI18N
        btnDown.setText(bundle.getString("Move_Down")); // NOI18N
        btnDown.setToolTipText(bundle.getString("Change_item_order_to_lower_position")); // NOI18N
        btnDown.setAlignmentY(0.0F);
        btnDown.setBorderPainted(false);
        btnDown.setFocusPainted(false);
        btnDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDownMouseClicked(evt);
            }
        });
        toolBar.add(btnDown);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        txtHours.setColumns(2);
        txtHours.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHours.setText("00");
        txtHours.setMinimumSize(new java.awt.Dimension(30, 27));
        txtHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoursActionPerformed(evt);
            }
        });
        txtHours.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoursFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoursFocusLost(evt);
            }
        });
        txtHours.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHoursKeyPressed(evt);
            }
        });
        jPanel1.add(txtHours);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(":");
        jPanel1.add(jLabel3);

        txtMinutes.setColumns(2);
        txtMinutes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMinutes.setText("00");
        txtMinutes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMinutesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMinutesFocusLost(evt);
            }
        });
        jPanel1.add(txtMinutes);

        toolBar1.setFloatable(false);
        toolBar1.setMinimumSize(new java.awt.Dimension(30, 25));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_task.png"))); // NOI18N
        jLabel8.setText(bundle.getString("Service_Plan")); // NOI18N
        toolBar1.add(jLabel8);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(toolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane3.setLeftComponent(jPanel3);

        txtNotes.setColumns(20);
        txtNotes.setRows(5);
        txtNotes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNotesFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtNotes);

        jLabel4.setText(bundle.getString("Service_Notes:")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane3.setRightComponent(jPanel2);

        jSplitPane1.setLeftComponent(jSplitPane3);

        jSplitPane2.setDividerLocation(350);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSplitPane2PropertyChange(evt);
            }
        });

        jScrollPane3.setViewportView(textSong);

        jToolBar2.setFloatable(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_zoom-object.png"))); // NOI18N
        jLabel5.setText(bundle.getString("Preview")); // NOI18N
        jToolBar2.add(jLabel5);

        jLabel6.setText(bundle.getString("Author:")); // NOI18N

        jLabel7.setText(bundle.getString("Song:")); // NOI18N

        lblSongName.setText("     ");

        lblAuthor.setText("     ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSongName)
                    .addComponent(lblAuthor))
                .addContainerGap(154, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblSongName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblAuthor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(jPanel4);
        jSplitPane2.setLeftComponent(songsSearchPanel1);

        jSplitPane1.setRightComponent(jSplitPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoursFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoursFocusLost
        try{
            int x = Integer.parseInt(txtHours.getText());
            if (x < 0 || x > 24){
                throw new Exception();
            }
            ServiceListTable.getActiveInstance().setStartHour(x);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Invalid_value"));
            txtHours.setText(Integer.toString(ServiceListTable.getActiveInstance().getStartHour()));
        }
        revalidate();
    }//GEN-LAST:event_txtHoursFocusLost

    private void txtMinutesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMinutesFocusLost
        try{
            int x = Integer.parseInt(txtMinutes.getText());
            if (x < 0 || x > 60){
                throw new Exception();
            }
            ServiceListTable.getActiveInstance().setStartMinute(x);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Invalid_value"));
            txtMinutes.setText(Integer.toString(ServiceListTable.getActiveInstance().getStartMinute()));
        }
    }//GEN-LAST:event_txtMinutesFocusLost

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void txtTitleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTitleFocusLost
        ServiceListTable.getActiveInstance().setTitle(txtTitle.getText());
    }//GEN-LAST:event_txtTitleFocusLost

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        tableServiceList.removeItem();
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tableServiceList.getSelectedRow() == -1){
            return;
        }
        
        ServiceItem item = (ServiceItem)ServiceListTable.getActiveInstance().getServiceItem( tableServiceList.getSelectedRow() );
        if(item instanceof Song){
            SongEditorForm sef = new SongEditorForm((Song)item);
            sef.setVisible(true);
        }else if(item instanceof TextServiceItem){
            TextServiceItemEditorForm tsief = new TextServiceItemEditorForm((TextServiceItem)item);
            tsief.setLocationRelativeTo(this);
            tsief.setVisible(true);
        }else if(item instanceof ContentlessServiceItem){
            String s = JOptionPane.showInputDialog(this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Service_Item_Name:"), item.getTitle());
            if (s != null && !s.trim().equals("")){
                item.setTitle(s);
            }
            tableServiceList.repaint();
        }else if (item instanceof ImageListServiceItem){
            ImageListEditorForm ilsi = new ImageListEditorForm((ImageListServiceItem)item);
            ilsi.setVisible(true);
        }

        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpMouseClicked
        tableServiceList.upItem();
    }//GEN-LAST:event_btnUpMouseClicked

    private void btnDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDownMouseClicked
        tableServiceList.downItem();
    }//GEN-LAST:event_btnDownMouseClicked

    private void txtNotesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNotesFocusLost
        ServiceListTable.getActiveInstance().setNotes(txtNotes.getText());
}//GEN-LAST:event_txtNotesFocusLost

    private void txtHoursKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoursKeyPressed
    }//GEN-LAST:event_txtHoursKeyPressed

    private void txtHoursFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoursFocusGained
        txtHours.selectAll();
    }//GEN-LAST:event_txtHoursFocusGained

    private void txtMinutesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMinutesFocusGained
        txtMinutes.selectAll();
    }//GEN-LAST:event_txtMinutesFocusGained

    private void tableServiceListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableServiceListMouseClicked
        if (evt.getClickCount() > 1){
            btnEditActionPerformed(null);
        }
    }//GEN-LAST:event_tableServiceListMouseClicked

    private void btnAddWizardbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddWizardbtnAddActionPerformed
        ppmAddItem.show(this.btnAddWizard, 0, btnAddWizard.getHeight());
    }//GEN-LAST:event_btnAddWizardbtnAddActionPerformed

    private void actAddSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actAddSongActionPerformed
        AddSongForm asf = new AddSongForm();
        asf.setLocationRelativeTo(this);
        asf.setVisible(true);
    }//GEN-LAST:event_actAddSongActionPerformed

    private void actAddTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actAddTextActionPerformed
        TextServiceItemEditorForm tsief = new TextServiceItemEditorForm(new TextServiceItem());
        tsief.setLocationRelativeTo(this);
        tsief.setVisible(true);
    }//GEN-LAST:event_actAddTextActionPerformed

    private void actAddContentlessItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actAddContentlessItemActionPerformed
        String s = JOptionPane.showInputDialog(this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Service_Item_Name:"), "");
        if (s != null && !s.trim().equals("")){
            ContentlessServiceItem csi = new ContentlessServiceItem();
            csi.setTitle(s);
            csi.setTemplate("");
            ServiceListTable.getActiveInstance().addItem(csi);
        }
    }//GEN-LAST:event_actAddContentlessItemActionPerformed

    private void actImportItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actImportItemActionPerformed
        ImportServiceItemForm isif = new ImportServiceItemForm();
        isif.setLocationRelativeTo(this);
        isif.setVisible(true);
    }//GEN-LAST:event_actImportItemActionPerformed

    private void txtHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoursActionPerformed

    private void actAddBibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actAddBibleActionPerformed
        TextServiceItemEditorForm tsief = new TextServiceItemEditorForm(new TextServiceItem());
        tsief.setLocationRelativeTo(this);
        tsief.setBibleVisible(true);
        tsief.setVisible(true);
}//GEN-LAST:event_actAddBibleActionPerformed

    private void jSplitPane1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSplitPane1PropertyChange
        if (updateSize && evt.getPropertyName().equals(javax.swing.JSplitPane.DIVIDER_LOCATION_PROPERTY)){
                WindowPropConfig.getInstance().setServiceSplit1(Integer.toString(jSplitPane1.getDividerLocation()));
        }
    }//GEN-LAST:event_jSplitPane1PropertyChange

    private void jSplitPane3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSplitPane3PropertyChange
        if (updateSize && evt.getPropertyName().equals(javax.swing.JSplitPane.DIVIDER_LOCATION_PROPERTY)){
                WindowPropConfig.getInstance().setServiceSplit3(Integer.toString(jSplitPane3.getDividerLocation()));
        }
    }//GEN-LAST:event_jSplitPane3PropertyChange

    private void jSplitPane2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSplitPane2PropertyChange
        if (updateSize && evt.getPropertyName().equals(javax.swing.JSplitPane.DIVIDER_LOCATION_PROPERTY)){
                WindowPropConfig.getInstance().setServiceSplit2(Integer.toString(jSplitPane2.getDividerLocation()));
        }
    }//GEN-LAST:event_jSplitPane2PropertyChange

    private void actAddImageListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actAddImageListActionPerformed
        ImageListServiceItem newitem = new ImageListServiceItem();
        ServiceListTable.getActiveInstance().addItem(newitem);
        ImageListEditorForm form = new ImageListEditorForm(newitem);
        form.setVisible(true);
    }//GEN-LAST:event_actAddImageListActionPerformed
    
    public JTable getTableServiceList(){
        return tableServiceList;
    }
    
    public void setStartHourMinute(String hour, String minute){
        txtHours.setText(hour);
        txtMinutes.setText(minute);
    }
    
    public void setTitle(String title){
        txtTitle.setText(title);
    }
    
    public void setNotes(String notes){
        txtNotes.setText(notes);
    }

    public void viewSong(Song song) {
        lblSongName.setText(song.getTitle());
        lblAuthor.setText(song.getSongAuthor());
        textSong.setText(song.getText().replace(Song.CHORUS_MARK, "").replace(Song.SLIDE_BREAK, ""));
        textSong.setCaretPosition(0);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem actAddBible;
    private javax.swing.JMenuItem actAddContentlessItem;
    private javax.swing.JMenuItem actAddImageList;
    private javax.swing.JMenuItem actAddSong;
    private javax.swing.JMenuItem actAddText;
    private javax.swing.JMenuItem actImportItem;
    private javax.swing.JButton btnAddWizard;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblSongName;
    private javax.swing.JPopupMenu ppmAddItem;
    private datasoul.song.SongsSearchPanel songsSearchPanel1;
    private datasoul.util.DnDTable tableServiceList;
    private javax.swing.JTextPane textSong;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JToolBar toolBar1;
    private javax.swing.JTextField txtHours;
    private javax.swing.JTextField txtMinutes;
    private javax.swing.JTextArea txtNotes;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
    
}
