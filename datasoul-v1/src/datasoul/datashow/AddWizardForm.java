/*
 * AddWizardForm.java
 *
 * Created on 8 de Marco de 2006, 21:12
 */

package datasoul.datashow;

import datasoul.song.AddSongForm;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 *
 * @author  Administrador
 */
public class AddWizardForm extends javax.swing.JFrame {
    
    /** Creates new form AddWizardForm */
    public AddWizardForm() {
        initComponents();
        this.center();
    }

    public void center(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle frame = getBounds();
        setLocation((screen.width - frame.width)/2, (screen.height - frame.height)/2);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        btnAddText = new javax.swing.JButton();
        btnAddImages = new javax.swing.JButton();
        btnAddVideo = new javax.swing.JButton();
        btnImportItem = new javax.swing.JButton();
        btnAddSong = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Wizard");
        setAlwaysOnTop(true);
        btnAddText.setBackground(new java.awt.Color(255, 255, 255));
        btnAddText.setFont(new java.awt.Font("Arial", 1, 11));
        btnAddText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/AddText.gif")));
        btnAddText.setText("Add Text");
        btnAddText.setBorderPainted(false);
        btnAddText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddText.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAddText.setIconTextGap(14);
        btnAddText.setMaximumSize(new java.awt.Dimension(150, 150));
        btnAddText.setMinimumSize(new java.awt.Dimension(150, 150));
        btnAddText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTextActionPerformed(evt);
            }
        });

        btnAddImages.setBackground(new java.awt.Color(255, 255, 255));
        btnAddImages.setFont(new java.awt.Font("Arial", 1, 11));
        btnAddImages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/AddImages.gif")));
        btnAddImages.setText("Add Images");
        btnAddImages.setBorderPainted(false);
        btnAddImages.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddImages.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAddImages.setIconTextGap(14);
        btnAddImages.setMaximumSize(new java.awt.Dimension(150, 150));
        btnAddImages.setMinimumSize(new java.awt.Dimension(150, 150));
        btnAddImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImagesActionPerformed(evt);
            }
        });

        btnAddVideo.setBackground(new java.awt.Color(255, 255, 255));
        btnAddVideo.setFont(new java.awt.Font("Arial", 1, 11));
        btnAddVideo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/AddVideo.gif")));
        btnAddVideo.setText("Add Video");
        btnAddVideo.setBorderPainted(false);
        btnAddVideo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddVideo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAddVideo.setIconTextGap(14);
        btnAddVideo.setMaximumSize(new java.awt.Dimension(150, 150));
        btnAddVideo.setMinimumSize(new java.awt.Dimension(150, 150));
        btnAddVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVideoActionPerformed(evt);
            }
        });

        btnImportItem.setBackground(new java.awt.Color(255, 255, 255));
        btnImportItem.setFont(new java.awt.Font("Arial", 1, 11));
        btnImportItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/ImportItem.gif")));
        btnImportItem.setText("Import Item");
        btnImportItem.setBorderPainted(false);
        btnImportItem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnImportItem.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnImportItem.setIconTextGap(14);
        btnImportItem.setMaximumSize(new java.awt.Dimension(150, 150));
        btnImportItem.setMinimumSize(new java.awt.Dimension(150, 150));
        btnImportItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportItemActionPerformed(evt);
            }
        });

        btnAddSong.setBackground(new java.awt.Color(255, 255, 255));
        btnAddSong.setFont(new java.awt.Font("Arial", 1, 11));
        btnAddSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/AddSong.gif")));
        btnAddSong.setText("Add Song");
        btnAddSong.setBorderPainted(false);
        btnAddSong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddSong.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAddSong.setIconTextGap(14);
        btnAddSong.setMaximumSize(new java.awt.Dimension(150, 150));
        btnAddSong.setMinimumSize(new java.awt.Dimension(150, 150));
        btnAddSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSongActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel.setFont(new java.awt.Font("Arial", 1, 11));
        btnCancel.setText("Cancel");
        btnCancel.setBorderPainted(false);
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setIconTextGap(14);
        btnCancel.setMaximumSize(new java.awt.Dimension(150, 150));
        btnCancel.setMinimumSize(new java.awt.Dimension(150, 150));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(btnAddImages, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(btnAddSong, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(btnAddVideo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .add(btnAddText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(btnImportItem, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 206, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAddSong, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnAddText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAddImages, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnAddVideo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnImportItem, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSongActionPerformed
        AddSongForm asf = new AddSongForm();
        asf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddSongActionPerformed

    private void btnImportItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportItemActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_btnImportItemActionPerformed

    private void btnAddVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVideoActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_btnAddVideoActionPerformed

    private void btnAddImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImagesActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_btnAddImagesActionPerformed

    private void btnAddTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTextActionPerformed
        TextServiceItemEditorForm tsief = new TextServiceItemEditorForm(new TextServiceItem());
        tsief.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddTextActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddImages;
    private javax.swing.JButton btnAddSong;
    private javax.swing.JButton btnAddText;
    private javax.swing.JButton btnAddVideo;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnImportItem;
    // End of variables declaration//GEN-END:variables
    
}