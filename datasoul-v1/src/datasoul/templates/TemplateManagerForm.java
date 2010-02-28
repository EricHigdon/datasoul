/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TemplateManagerForm.java
 *
 * Created on Dec 19, 2009, 10:44:46 AM
 */

package datasoul.templates;

import datasoul.config.DisplayControlConfig;
import datasoul.render.OutputDevice;
import datasoul.util.ObjectManager;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author samuel
 */
public class TemplateManagerForm extends javax.swing.JFrame implements ListSelectionListener {

    /** Creates new form TemplateManagerForm */
    public TemplateManagerForm() {
        initComponents();

        TemplateManager manager = TemplateManager.getInstance();
        jTableTemplates.setModel( manager );

        jTableTemplates.getSelectionModel().addListSelectionListener(this);

        cbDefaultImages.setTargetContent(DisplayTemplate.TARGET_CONTENT_IMAGES);
        cbDefaultImages.setSelectedItem(DisplayControlConfig.getInstance().getDefaultTemplateImage());
        cbDefaultText.setTargetContent(DisplayTemplate.TARGET_CONTENT_TEXT);
        cbDefaultText.setSelectedItem(DisplayControlConfig.getInstance().getDefaultTemplateText());
        cbDefaultSong.setTargetContent(DisplayTemplate.TARGET_CONTENT_SONG);
        cbDefaultSong.setSelectedItem(DisplayControlConfig.getInstance().getDefaultTemplateSong());

        cbMonitorImages.setTargetContent(DisplayTemplate.TARGET_CONTENT_MONITOR);
        cbMonitorImages.setSelectedItem(DisplayControlConfig.getInstance().getMonitorTemplateImage());
        cbMonitorText.setTargetContent(DisplayTemplate.TARGET_CONTENT_MONITOR);
        cbMonitorText.setSelectedItem(DisplayControlConfig.getInstance().getMonitorTemplateText());
        cbMonitorSong.setTargetContent(DisplayTemplate.TARGET_CONTENT_MONITOR);
        cbMonitorSong.setSelectedItem(DisplayControlConfig.getInstance().getMonitorTemplateSong());
        cbMonitorContentless.setTargetContent(DisplayTemplate.TARGET_CONTENT_MONITOR);
        cbMonitorContentless.setSelectedItem(DisplayControlConfig.getInstance().getMonitorTemplateContentless());

        pnlMonitor.setVisible(OutputDevice.isMonitorAllowed());

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTemplates = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnDeleteTemplate = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnImport = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblPreview = new javax.swing.JLabel();
        pnlMonitor = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbMonitorSong = new datasoul.templates.TemplateComboBox();
        cbMonitorText = new datasoul.templates.TemplateComboBox();
        cbMonitorImages = new datasoul.templates.TemplateComboBox();
        jLabel9 = new javax.swing.JLabel();
        cbMonitorContentless = new datasoul.templates.TemplateComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbDefaultSong = new datasoul.templates.TemplateComboBox();
        cbDefaultText = new datasoul.templates.TemplateComboBox();
        cbDefaultImages = new datasoul.templates.TemplateComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datasoul Template Manager");

        jTableTemplates.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableTemplates);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/document-new.png"))); // NOI18N
        btnNew.setText("New Template");
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        btnNew.setToolTipText(bundle.getString("Create_a_new_template")); // NOI18N
        btnNew.setBorderPainted(false);
        btnNew.setFocusPainted(false);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/document-open.png"))); // NOI18N
        btnLoad.setText(bundle.getString("Edit")); // NOI18N
        btnLoad.setToolTipText(bundle.getString("Load_selected_template")); // NOI18N
        btnLoad.setBorderPainted(false);
        btnLoad.setFocusPainted(false);
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnDeleteTemplate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/edit-delete.png"))); // NOI18N
        btnDeleteTemplate.setText(bundle.getString("Delete")); // NOI18N
        btnDeleteTemplate.setToolTipText(bundle.getString("Delete_selected_template")); // NOI18N
        btnDeleteTemplate.setBorderPainted(false);
        btnDeleteTemplate.setFocusPainted(false);
        btnDeleteTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTemplateActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/window-close.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setText("Available Templates");

        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_task-assigned.png"))); // NOI18N
        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        jLabel2.setText("Preview:");

        lblPreview.setText("      ");
        lblPreview.setMaximumSize(new java.awt.Dimension(100, 500));
        lblPreview.setMinimumSize(new java.awt.Dimension(100, 15));

        pnlMonitor.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitor Templates"));

        jLabel3.setText("Song:");

        jLabel4.setText("Text:");

        jLabel5.setText("Images:");

        cbMonitorSong.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMonitorSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonitorSongActionPerformed(evt);
            }
        });

        cbMonitorText.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMonitorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonitorTextActionPerformed(evt);
            }
        });

        cbMonitorImages.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMonitorImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonitorImagesActionPerformed(evt);
            }
        });

        jLabel9.setText("Contentless:");

        cbMonitorContentless.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMonitorContentless.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonitorContentlessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMonitorLayout = new javax.swing.GroupLayout(pnlMonitor);
        pnlMonitor.setLayout(pnlMonitorLayout);
        pnlMonitorLayout.setHorizontalGroup(
            pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMonitorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMonitorLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(cbMonitorText, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMonitorLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(cbMonitorSong, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMonitorLayout.createSequentialGroup()
                        .addGroup(pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbMonitorContentless, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMonitorImages, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlMonitorLayout.setVerticalGroup(
            pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMonitorLayout.createSequentialGroup()
                .addGroup(pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbMonitorSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbMonitorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbMonitorImages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbMonitorContentless, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Default Templates"));

        jLabel6.setText("Song:");

        jLabel7.setText("Text:");

        jLabel8.setText("Images:");

        cbDefaultSong.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDefaultSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDefaultSongActionPerformed(evt);
            }
        });

        cbDefaultText.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDefaultText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDefaultTextActionPerformed(evt);
            }
        });

        cbDefaultImages.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDefaultImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDefaultImagesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(cbDefaultImages, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(cbDefaultText, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(cbDefaultSong, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbDefaultSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbDefaultText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbDefaultImages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(lblPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlMonitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteTemplate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                        .addComponent(pnlMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteTemplate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClose))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed


        try{
            ObjectManager.getInstance().setBusyCursor();
            if ( jTableTemplates.getSelectedRowCount() == 1){
                Object x = jTableTemplates.getValueAt( jTableTemplates.getSelectedRow(), jTableTemplates.getSelectedColumn() );
                if (x instanceof String){
                    String str = (String) x;
                    TemplateEditorFrame f = new TemplateEditorFrame();
                    f.open(str);
                    f.setVisible(true);
                }
            }
        }finally{
            ObjectManager.getInstance().setDefaultCursor();
        }
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        TemplateEditorFrame f = new TemplateEditorFrame();
        f.newTemplate();
        f.setVisible(true);
}//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteTemplateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTemplateActionPerformed


        if ( jTableTemplates.getSelectedRowCount() == 1){
            Object x = jTableTemplates.getValueAt( jTableTemplates.getSelectedRow(), jTableTemplates.getSelectedColumn() );
            if (x instanceof String){
                String str = (String) x;
                int confirm = JOptionPane.showConfirmDialog(this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Delete_template_")+x+"?", java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Confirm"), JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION){
                    try{
                        TemplateManager.getInstance().deleteTemplate(str);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this,java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Unable_to_delete_template:")+e.getMessage(),java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Datasoul_Error"),0);
                    }// try
                }//if confirm
            }// if instance of
        }// if selected

    }//GEN-LAST:event_btnDeleteTemplateActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed

        // Consistency check
        DisplayControlConfig d = DisplayControlConfig.getInstance();
        String defImage = cbDefaultImages.getSelectedItem()==null?"":cbDefaultImages.getSelectedItem().toString();
        String defText = cbDefaultText.getSelectedItem()==null?"":cbDefaultText.getSelectedItem().toString();
        String defSong = cbDefaultSong.getSelectedItem()==null?"":cbDefaultSong.getSelectedItem().toString();
        String monImage = cbMonitorImages.getSelectedItem()==null?"":cbMonitorImages.getSelectedItem().toString();
        String monText = cbMonitorText.getSelectedItem()==null?"":cbMonitorText.getSelectedItem().toString();
        String monSong = cbMonitorSong.getSelectedItem()==null?"":cbMonitorSong.getSelectedItem().toString();
        String monContentless = cbMonitorContentless.getSelectedItem()==null?"":cbMonitorContentless.getSelectedItem().toString();

        if (!d.getDefaultTemplateImage().equals(defImage) ){
            d.setDefaultTemplateImage(defImage);
        }
        if (!d.getDefaultTemplateText().equals(defText) ){
            d.setDefaultTemplateText(defText);
        }
        if (!d.getDefaultTemplateSong().equals(defSong) ){
            d.setDefaultTemplateSong(defSong);
        }
        if (!d.getMonitorTemplateImage().equals(monImage) ){
            d.setMonitorTemplateImage(monImage);
        }
        if (!d.getMonitorTemplateText().equals(monText) ){
            d.setMonitorTemplateText(monText);
        }
        if (!d.getMonitorTemplateSong().equals(monSong) ){
            d.setMonitorTemplateSong(monSong);
        }
        if (!d.getMonitorTemplateContentless().equals(monContentless)){
            d.setMonitorTemplateContentless(monContentless);
        }


        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Datasoul 1.x Templates (*.template)", "template"));
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Datasoul Templates (*.templatez)", "templatez"));
        File dir = new File(System.getProperty("datasoul.stgloc") + System.getProperty("file.separator") + "templates");
        fc.setCurrentDirectory(dir);
        fc.setMultiSelectionEnabled(true);
        fc.setDialogTitle(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Select_the_file_to_save."));
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            for (File f : fc.getSelectedFiles()){
                DisplayTemplate.importTemplate(f.getAbsolutePath());
            }
        }

    }//GEN-LAST:event_btnImportActionPerformed

    private void cbMonitorSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonitorSongActionPerformed
        if (cbMonitorSong.getSelectedItem() != null && ! cbMonitorSong.isUpdating()){
            DisplayControlConfig.getInstance().setMonitorTemplateSong(cbMonitorSong.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbMonitorSongActionPerformed

    private void cbMonitorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonitorTextActionPerformed
        if (cbMonitorText.getSelectedItem() != null && ! cbMonitorText.isUpdating()){
            DisplayControlConfig.getInstance().setMonitorTemplateText(cbMonitorText.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbMonitorTextActionPerformed

    private void cbMonitorImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonitorImagesActionPerformed
        if (cbMonitorImages.getSelectedItem() != null && ! cbMonitorImages.isUpdating()){
            DisplayControlConfig.getInstance().setMonitorTemplateImage(cbMonitorImages.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbMonitorImagesActionPerformed

    private void cbDefaultSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDefaultSongActionPerformed
        if (cbDefaultSong.getSelectedItem() != null && ! cbDefaultSong.isUpdating()){
            DisplayControlConfig.getInstance().setDefaultTemplateSong(cbDefaultSong.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbDefaultSongActionPerformed

    private void cbDefaultTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDefaultTextActionPerformed
        if (cbDefaultText.getSelectedItem() != null && ! cbDefaultText.isUpdating()){
            DisplayControlConfig.getInstance().setDefaultTemplateText(cbDefaultText.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbDefaultTextActionPerformed

    private void cbDefaultImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDefaultImagesActionPerformed
        if (cbDefaultImages.getSelectedItem() != null && ! cbDefaultImages.isUpdating()){
            DisplayControlConfig.getInstance().setDefaultTemplateImage(cbDefaultImages.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbDefaultImagesActionPerformed

    private void cbMonitorContentlessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonitorContentlessActionPerformed
        if (cbMonitorContentless.getSelectedItem() != null && ! cbMonitorContentless.isUpdating()){
            DisplayControlConfig.getInstance().setMonitorTemplateContentless(cbMonitorContentless.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbMonitorContentlessActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDeleteTemplate;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnNew;
    private datasoul.templates.TemplateComboBox cbDefaultImages;
    private datasoul.templates.TemplateComboBox cbDefaultSong;
    private datasoul.templates.TemplateComboBox cbDefaultText;
    private datasoul.templates.TemplateComboBox cbMonitorContentless;
    private datasoul.templates.TemplateComboBox cbMonitorImages;
    private datasoul.templates.TemplateComboBox cbMonitorSong;
    private datasoul.templates.TemplateComboBox cbMonitorText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTemplates;
    private javax.swing.JLabel lblPreview;
    private javax.swing.JPanel pnlMonitor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent arg0) {
        if (jTableTemplates.getSelectedRow() >= 0){

            DisplayTemplateMetadata meta = TemplateManager.getInstance().getDisplayTemplateMetadata(jTableTemplates.getSelectedRow());
            ImageIcon icon = new ImageIcon(meta.getMiniImage());
            lblPreview.setIcon(icon);
            lblPreview.setText("");
        }else{
            lblPreview.setIcon(null);
        }
    }

}
