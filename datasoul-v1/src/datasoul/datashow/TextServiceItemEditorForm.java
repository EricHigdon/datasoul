/*
 * EditTextItem.java
 *
 * Created on 9 de Marco de 2006, 21:04
 */

package datasoul.datashow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author  Administrador
 */
public class TextServiceItemEditorForm extends javax.swing.JFrame {
    
    private TextServiceItem textServiceItem;
    private boolean isNewItem;
    
    /** Creates new form EditTextItem */
    public TextServiceItemEditorForm(TextServiceItem textServiceItem) {
        initComponents();
        
        this.textServiceItem = textServiceItem;
    
        if(this.textServiceItem.getTitle().equals("")){
            isNewItem = true;
        }else{
            isNewItem = false;
        }
        //read value
        this.fieldTitle.setText(textServiceItem.getTitle());

        this.textText.setText(textServiceItem.getText());

        this.center();

        highlightlyric(this.textText);
    }

    public void center(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle frame = getBounds();
        setLocation((screen.width - frame.width)/2, (screen.height - frame.height)/2);
    }
    
    private void actualizeValues(){
        this.textServiceItem.setTitle(this.fieldTitle.getText());
        
        this.textServiceItem.setText(this.textText.getText());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        fieldTitle = new javax.swing.JTextField();
        labelTitle = new javax.swing.JLabel();
        labelTitle1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textText = new javax.swing.JTextArea();
        toolBar = new javax.swing.JToolBar();
        btnApply = new javax.swing.JButton();
        btnClose1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        textLine = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBreak = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        fieldTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldTitleKeyTyped(evt);
            }
        });

        labelTitle.setFont(new java.awt.Font("Arial", 1, 11));
        labelTitle.setText("Title");

        labelTitle1.setFont(new java.awt.Font("Arial", 1, 11));
        labelTitle1.setText("Text");

        textText.setColumns(20);
        textText.setRows(5);
        textText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textTextKeyPressed(evt);
            }
        });

        jScrollPane1.setViewportView(textText);

        btnApply.setText("Apply");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        toolBar.add(btnApply);

        btnClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/delete.gif")));
        btnClose1.setText("Close");
        btnClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnClose1MouseClicked(evt);
            }
        });

        toolBar.add(btnClose1);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setMaximumSize(new java.awt.Dimension(100, 100));
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 10));
        toolBar.add(jSeparator1);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMaximumSize(new java.awt.Dimension(100, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(210, 250));
        textLine.setText("2");

        jLabel1.setText("Break slide in");

        btnBreak.setText("break");
        btnBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBreakActionPerformed(evt);
            }
        });

        jLabel2.setText("lines");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(textLine, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnBreak)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(3, 3, 3)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textLine, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2)
                    .add(btnBreak)
                    .add(jLabel1))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        toolBar.add(jPanel1);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setMinimumSize(new java.awt.Dimension(100, 100));
        toolBar.add(jSeparator2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(labelTitle)
                .addContainerGap(666, Short.MAX_VALUE))
            .add(toolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 700, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(fieldTitle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .add(labelTitle1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap(49, Short.MAX_VALUE)
                        .add(labelTitle)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                    .add(layout.createSequentialGroup()
                        .add(toolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(27, 27, 27)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(fieldTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(labelTitle1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBreakActionPerformed
        int lines = 0;
        String str = this.textLine.getText();
        try{
            lines = Integer.parseInt(str);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"Please in the next time digit a number!");
            return;
        }
        
        String inStr = this.textText.getText();
        StringBuffer sb = new StringBuffer();
        inStr = inStr.replace(TextServiceItem.CHORUS_MARK+"\r\n","");
        inStr = inStr.replace(TextServiceItem.SLIDE_BREAK+"\r\n","\n\n");
        inStr = inStr.replace(TextServiceItem.CHORUS_MARK+"\n","");
        inStr = inStr.replace(TextServiceItem.SLIDE_BREAK+"\n","\n\n");
        String str2;
        int count = 0;
        for(int i=0; i< inStr.length()-2;i++){
            str = inStr.substring(i,i+1);
            str2 = inStr.substring(i,i+2);
            if(str2.equals("\n\r")){
                sb.append(TextServiceItem.CHORUS_MARK+"\n");
                count =0;
                i=i+2;
                continue;
            }
            if(str2.equals("\n\n")){
                sb.append("\n"+TextServiceItem.CHORUS_MARK+"\n");
                count =0;
                i=i+2;
                continue;
            }
            if(str.equals("\n")){
                count ++;
            }
            sb.append(str);
            if(count==lines){
                sb.append(TextServiceItem.SLIDE_BREAK+"\n");
                count =0;
            }
        }
        sb.append(inStr.substring(inStr.length()-2,inStr.length()));
        this.textText.setText(sb.toString());
        highlightlyric(this.textText);        
    }//GEN-LAST:event_btnBreakActionPerformed

    private void btnClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClose1MouseClicked
        this.dispose();
    }//GEN-LAST:event_btnClose1MouseClicked

    private void textTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTextKeyPressed
        highlightlyric(this.textText);
    }//GEN-LAST:event_textTextKeyPressed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        actualizeValues();
        
        if(this.textServiceItem.getTitle().equals("")){
            JOptionPane.showMessageDialog(this,"You must field the Title");
            return;
        }

        if(isNewItem){
            ServiceListTable.getInstance().addItem(this.textServiceItem);
            isNewItem = false;
        }
    }//GEN-LAST:event_btnApplyActionPerformed

    private void fieldTitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTitleKeyTyped
        if(evt.getKeyCode()==16)
            return;
        // samuelm: changed to check against disallowd chars to avoid problems with non-english chars
        //String allowed="ZXCVBNMASDFGHJKL?QWERTYUIOPzxcvbnmasdfghjkl?qwertyuiop1234567890'???????????";
        String disallowed = "\\/:*?\"<>|";
        if(disallowed.contains(String.valueOf(evt.getKeyChar())))
            evt.consume();
    }//GEN-LAST:event_fieldTitleKeyTyped
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnBreak;
    private javax.swing.JButton btnBreakfd;
    private javax.swing.JButton btnClose1;
    private javax.swing.JTextField fieldTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelTitle1;
    private javax.swing.JTextField textLine;
    private javax.swing.JTextArea textText;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables

    public void highlightlyric(JTextComponent textComp){
        removeHighlights(textComp);
        highlight(textComp,"\n"+TextServiceItem.SLIDE_BREAK+"\n",Color.ORANGE);
        highlight(textComp,"\n"+TextServiceItem.CHORUS_MARK+"\n",Color.PINK);
    }
    // Creates highlights around all occurrences of pattern in textComp
    public void highlight(JTextComponent textComp, String pattern, Color color) {
        Highlighter.HighlightPainter highlightPainter = new MyHighlightPainter(color);
    
        try {
            Highlighter hilite = textComp.getHighlighter();
            javax.swing.text.Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;

            // Search for pattern
            while ((pos = text.indexOf(pattern, pos)) >= 0) {
                // Create highlighter using private painter and apply around pattern
                hilite.addHighlight(pos, pos+pattern.length(), highlightPainter);
                pos += pattern.length();
            }
        } catch (BadLocationException e) {

        }
    }
    
    // Removes only our private highlights
    public void removeHighlights(JTextComponent textComp) {
        Highlighter hilite = textComp.getHighlighter();
        hilite.removeAllHighlights();
    }
    
   // A private subclass of the default highlight painter
    class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter {
        public MyHighlightPainter(Color color) {
            super(color);
        }
    }
    
}
