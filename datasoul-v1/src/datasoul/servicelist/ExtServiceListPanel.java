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

import datasoul.bible.AddBibleTextFrame;
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
        actAddBibleText = new javax.swing.JMenuItem();
        actAddContentlessItem = new javax.swing.JMenuItem();
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
        jSeparator1 = new javax.swing.JSeparator();
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
        jSeparator3 = new javax.swing.JSeparator();
        btnNew = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSaveAs = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
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

        actAddSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/playsound.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        actAddSong.setText(bundle.getString("Add_Song")); // NOI18N
        actAddSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actAddSongActionPerformed(evt);
            }
        });
        ppmAddItem.add(actAddSong);

        actAddText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/kwrite.png"))); // NOI18N
        actAddText.setText(bundle.getString("Add_Text")); // NOI18N
        actAddText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actAddTextActionPerformed(evt);
            }
        });
        ppmAddItem.add(actAddText);

        actAddBibleText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/lower.png"))); // NOI18N
        actAddBibleText.setText(bundle.getString("Add_Bible_Text")); // NOI18N
        actAddBibleText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actAddBibleTextActionPerformed(evt);
            }
        });
        ppmAddItem.add(actAddBibleText);

        actAddContentlessItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/knotes.png"))); // NOI18N
        actAddContentlessItem.setText(bundle.getString("Add_Contentless_Item")); // NOI18N
        actAddContentlessItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actAddContentlessItemActionPerformed(evt);
            }
        });
        ppmAddItem.add(actAddContentlessItem);

        actImportItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/document.png"))); // NOI18N
        actImportItem.setText(bundle.getString("Import_Item")); // NOI18N
        actImportItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actImportItemActionPerformed(evt);
            }
        });
        ppmAddItem.add(actImportItem);

        jSplitPane1.setDividerLocation(600);

        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

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

        btnAddWizard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/window_new.png"))); // NOI18N
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

        jSeparator1.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        toolBar.add(jSeparator1);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/editdelete.png"))); // NOI18N
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

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/edit.png"))); // NOI18N
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

        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/up.png"))); // NOI18N
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

        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/down.png"))); // NOI18N
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
        txtHours.setText("8");
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

        jLabel8.setFont(jLabel8.getFont().deriveFont(jLabel8.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/klipper_dock.png"))); // NOI18N
        jLabel8.setText(bundle.getString("Service_Plan")); // NOI18N
        toolBar1.add(jLabel8);

        jSeparator3.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        toolBar1.add(jSeparator3);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/filenew.png"))); // NOI18N
        btnNew.setText(bundle.getString("New")); // NOI18N
        btnNew.setBorderPainted(false);
        btnNew.setFocusPainted(false);
        btnNew.setFocusable(false);
        btnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        toolBar1.add(btnNew);

        btnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/fileopen.png"))); // NOI18N
        btnOpen.setText(bundle.getString("Open")); // NOI18N
        btnOpen.setBorderPainted(false);
        btnOpen.setFocusPainted(false);
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });
        toolBar1.add(btnOpen);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/filesave.png"))); // NOI18N
        btnSave.setText(bundle.getString("Save")); // NOI18N
        btnSave.setBorderPainted(false);
        btnSave.setFocusPainted(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        toolBar1.add(btnSave);

        btnSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/filesaveas.png"))); // NOI18N
        btnSaveAs.setText(bundle.getString("Save_As")); // NOI18N
        btnSaveAs.setBorderPainted(false);
        btnSaveAs.setFocusPainted(false);
        btnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAsActionPerformed(evt);
            }
        });
        toolBar1.add(btnSaveAs);

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/compfile.png"))); // NOI18N
        btnExport.setText(bundle.getString("Export")); // NOI18N
        btnExport.setBorderPainted(false);
        btnExport.setFocusPainted(false);
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        toolBar1.add(btnExport);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(toolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtTitle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(12, 12, 12))
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(toolBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(toolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel1)
                        .add(jLabel2)
                        .add(txtTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(toolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
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

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .add(jLabel4))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane3.setRightComponent(jPanel2);

        jSplitPane1.setLeftComponent(jSplitPane3);

        jSplitPane2.setDividerLocation(350);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPane3.setViewportView(textSong);

        jToolBar2.setFloatable(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/kappfinder.png"))); // NOI18N
        jLabel5.setText(bundle.getString("Preview")); // NOI18N
        jToolBar2.add(jLabel5);

        jLabel6.setText(bundle.getString("Author:")); // NOI18N

        jLabel7.setText(bundle.getString("Song:")); // NOI18N

        lblSongName.setText("     ");

        lblAuthor.setText("     ");

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jToolBar2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel6)
                    .add(jLabel7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblSongName)
                    .add(lblAuthor))
                .addContainerGap(176, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jToolBar2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(lblSongName))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(lblAuthor))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(jPanel4);
        jSplitPane2.setLeftComponent(songsSearchPanel1);

        jSplitPane1.setRightComponent(jSplitPane2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jSplitPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSplitPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
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

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        ServiceListTable.getActiveInstance().openServiceList();
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        ServiceListTable.getActiveInstance().saveServiceList();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAsActionPerformed
        ServiceListTable.getActiveInstance().saveServiceListAs();
    }//GEN-LAST:event_btnSaveAsActionPerformed

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
            tsief.setVisible(true);
        }else if(item instanceof ContentlessServiceItem){
            String s = JOptionPane.showInputDialog(this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Service_Item_Name:"), item.getTitle());
            if (s != null && !s.trim().equals("")){
                item.setTitle(s);
            }
            tableServiceList.repaint();
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

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        ServiceListTable.getActiveInstance().fileNew();
}//GEN-LAST:event_btnNewActionPerformed

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
        asf.setVisible(true);
    }//GEN-LAST:event_actAddSongActionPerformed

    private void actAddTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actAddTextActionPerformed
        TextServiceItemEditorForm tsief = new TextServiceItemEditorForm(new TextServiceItem());
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
        isif.setVisible(true);
    }//GEN-LAST:event_actImportItemActionPerformed

    private void txtHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoursActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        ServiceListExporterPanel p = new ServiceListExporterPanel();
        p.setLocationRelativeTo(this);
        p.setVisible(true);
    }//GEN-LAST:event_btnExportActionPerformed

private void actAddBibleTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actAddBibleTextActionPerformed
    AddBibleTextFrame frame = new AddBibleTextFrame();
    frame.setLocationRelativeTo(this);
    frame.setVisible(true);
}//GEN-LAST:event_actAddBibleTextActionPerformed
    
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
    private javax.swing.JMenuItem actAddBibleText;
    private javax.swing.JMenuItem actAddContentlessItem;
    private javax.swing.JMenuItem actAddSong;
    private javax.swing.JMenuItem actAddText;
    private javax.swing.JMenuItem actImportItem;
    private javax.swing.JButton btnAddWizard;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveAs;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
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
