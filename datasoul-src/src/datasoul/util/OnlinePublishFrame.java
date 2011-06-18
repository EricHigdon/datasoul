/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OnlinePublishFrame.java
 *
 * Created on 17/06/2011, 23:39:12
 */
package datasoul.util;

import datasoul.DatasoulMainForm;
import datasoul.servicelist.ServiceListTable;
import java.net.URI;
import java.net.URLEncoder;
import javax.swing.JOptionPane;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 *
 * @author samuel
 */
public class OnlinePublishFrame extends javax.swing.JFrame {

    /** Creates new form OnlinePublishFrame */
    public OnlinePublishFrame() {
        initComponents();
        DatasoulMainForm.setDatasoulIcon(this);
        
        if (ServiceListTable.getActiveInstance() != null){
            txtTitle.setText(ServiceListTable.getActiveInstance().getTitle());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnPublish = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        lblUrl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        setTitle(bundle.getString("PUBLISH SERVICE PLAN ONLINE")); // NOI18N
        setResizable(false);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/window-close.png"))); // NOI18N
        btnClose.setText(bundle.getString("CLOSE")); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        jLabel1.setText(bundle.getString("PUBLISH SERVICE PLAN ONLINE")); // NOI18N

        btnPublish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/web-browser.png"))); // NOI18N
        btnPublish.setText(bundle.getString("PUBLISH")); // NOI18N
        btnPublish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublishActionPerformed(evt);
            }
        });

        jLabel3.setText(bundle.getString("DESCRIPTION")); // NOI18N

        lblUrl.setText("    ");

        jLabel2.setText(bundle.getString("TITLE")); // NOI18N

        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblUrl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
                        .addComponent(btnPublish)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnPublish)
                    .addComponent(lblUrl))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
            dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnPublishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublishActionPerformed
        
        if (ServiceListTable.getActiveInstance() == null || 
                ServiceListTable.getActiveInstance().getRowCount() == 0 ){
            
            JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("YOU CAN NOT PUBLISH AN EMPTY SERVICE."), "Datasoul", JOptionPane.ERROR_MESSAGE);
            
            return;
        }
        
        String content = ServiceListTable.getActiveInstance().getJSon();
        String title = txtTitle.getText();
        String locale = System.getProperty("user.language");
        
        HttpClient client = new HttpClient();
        client.getParams().setParameter("http.protocol.content-charset", "UTF-8");
        PostMethod method = new PostMethod(OnlineUpdateCheck.ONLINE_BASE_URL+"/service/");
        try{
            System.out.println(URLEncoder.encode(title, "UTF-8"));
            method.addParameter("title", URLEncoder.encode(title, "UTF-8"));
            method.addParameter("content", URLEncoder.encode(content, "UTF-8"));
            method.addParameter("locale", URLEncoder.encode(locale, "UTF-8"));
            method.addParameter("description", URLEncoder.encode(txtDescription.getText(), "UTF-8"));

            client.executeMethod(method);

            String url = method.getResponseBodyAsString().trim();
            
            lblUrl.setText("<html><a href='url'>"+url+"</a></html>");
            
            btnPublish.setEnabled(false);
            txtDescription.setEnabled(false);
            txtTitle.setEnabled(false);
            
            java.awt.Desktop.getDesktop().browse(new URI(url));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            method.releaseConnection();
        }

    }//GEN-LAST:event_btnPublishActionPerformed

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPublish;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblUrl;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}