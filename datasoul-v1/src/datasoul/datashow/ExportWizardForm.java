/*
 * ExportWizardForm.java
 *
 * Created on 6 de Marco de 2006, 21:28
 */

package datasoul.datashow;

import datasoul.song.Song;
import datasoul.song.SongViewerPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author  Administrador
 */
public class ExportWizardForm extends javax.swing.JFrame {
    
    /** Creates new form ExportWizardForm */
    public ExportWizardForm() {
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
        btnExportSongs = new javax.swing.JButton();
        btnExportServiceList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Export Wizard");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        btnExportSongs.setBackground(new java.awt.Color(255, 255, 255));
        btnExportSongs.setFont(new java.awt.Font("Arial", 1, 11));
        btnExportSongs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/exportSongsChords.gif")));
        btnExportSongs.setText("Export Songs Chords");
        btnExportSongs.setBorderPainted(false);
        btnExportSongs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExportSongs.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnExportSongs.setIconTextGap(14);
        btnExportSongs.setMaximumSize(new java.awt.Dimension(150, 150));
        btnExportSongs.setMinimumSize(new java.awt.Dimension(150, 150));
        btnExportSongs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportSongsActionPerformed(evt);
            }
        });

        btnExportServiceList.setBackground(new java.awt.Color(255, 255, 255));
        btnExportServiceList.setFont(new java.awt.Font("Arial", 1, 11));
        btnExportServiceList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/exportServiceList.gif")));
        btnExportServiceList.setText("Export Service List");
        btnExportServiceList.setBorderPainted(false);
        btnExportServiceList.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExportServiceList.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnExportServiceList.setIconTextGap(14);
        btnExportServiceList.setMaximumSize(new java.awt.Dimension(150, 150));
        btnExportServiceList.setMinimumSize(new java.awt.Dimension(150, 150));
        btnExportServiceList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportServiceListActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnExportSongs, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnExportServiceList, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(btnExportSongs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnExportServiceList, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportServiceListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportServiceListActionPerformed
        JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
            try {
                StyleContext sc = new StyleContext();
                Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
                Style nameStyle = sc.addStyle("nameStyle",defaultStyle);
                StyleConstants.setForeground(nameStyle,Color.BLACK);
                StyleConstants.setBackground(nameStyle,Color.white);
                StyleConstants.setFontFamily(nameStyle,"Arial");
                StyleConstants.setFontSize(nameStyle,18);

                JEditorPane jep = new JEditorPane();
                jep.setContentType("text/rtf");

                javax.swing.text.Document doc = jep.getDocument();

                doc.insertString(doc.getLength(),"Service List \n\n",nameStyle);
                StyleConstants.setFontSize(nameStyle,12);
                
                for(int i=0;i<ServiceListTable.getInstance().getRowCount();i++){
                    doc.insertString(doc.getLength(),i+") "+ServiceListTable.getInstance().getValueAt(i,0).toString()+"\n",nameStyle);                    
                }

                ByteArrayOutputStream osOut = new ByteArrayOutputStream();
                int length = doc.getLength();
                doc.getDefaultRootElement().getElement(0);
                jep.getEditorKit().write(osOut, doc, 0, length);                  
                
                String filePath = fc.getSelectedFile().getPath();
                if(!filePath.contains(".rtf"))
                    filePath = filePath + ".rtf";
                FileOutputStream fos = new FileOutputStream(filePath);
                fos.write(osOut.toByteArray());
                fos.close();

                osOut.close();
            } catch (Exception ex) {
            }
        }

    }//GEN-LAST:event_btnExportServiceListActionPerformed

    private void btnExportSongsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportSongsActionPerformed
        JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
            try {
                ByteArrayOutputStream osOut = new ByteArrayOutputStream();    
                for(int i=0;i<ServiceListTable.getInstance().getRowCount();i++){
                    if(ServiceListTable.getInstance().getValueAt(i,0) instanceof Song){
                        Song song = (Song)ServiceListTable.getInstance().getValueAt(i,0);
                        SongViewerPanel svp = new SongViewerPanel();
                        svp.viewSong(song);
                        osOut = svp.exportRTFSong(osOut);
                    }
                }
                
                String filePath = fc.getSelectedFile().getPath();
                if(!filePath.contains(".rtf"))
                    filePath = filePath + ".rtf";
                FileOutputStream fos = new FileOutputStream(filePath);
                fos.write(osOut.toByteArray());
                fos.close();

            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_btnExportSongsActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExportWizardForm().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportServiceList;
    private javax.swing.JButton btnExportSongs;
    // End of variables declaration//GEN-END:variables
    
}
