/*
 * SongEditorFrame.java
 *
 * Created on 26 de Dezembro de 2005, 21:14
 */

package datasoul.song;

import datasoul.*;
import datasoul.util.*;
import datasoul.datashow.*;
import datasoul.song.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.Keymap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 *
 * @author  Administrador
 */
public class SongEditorForm extends javax.swing.JFrame {
    

    private Song song;
    private boolean newSong;

    /**
     * Creates new form SongEditorFrame
     */
    public SongEditorForm(File file) {
        initComponents();
        
        Document dom=null;
        Node node=null;

        try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                //Using factory get an instance of document builder
                DocumentBuilder db = dbf.newDocumentBuilder();

                //parse using builder to get DOM representation of the XML file
                dom = db.parse(file);

                //node = dom.getDocumentElement().getChildNodes().item(0);
                node = dom.getElementsByTagName("Song").item(0);
                
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this,"Error, the file is not well formed\nErro:"+e.getMessage(),"DataSoul Error",0);    
        }        

        song = new Song();
        try {
            song.readObject(node);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error, the file is not well formed\nErro:"+e.getMessage(),"DataSoul Error",0);    
        }

        this.setTitle(song.getFileName());
        
        //fill object
        fillGuiValues();
        
        newSong = false;
        
        this.center();        

        highlightchord(this.textChordsSimplified);
        highlightchord(this.textChordsCompleted);
        highlightlyric(this.textLyrics);
    }

    /**
     * Creates new form SongEditorFrame
     */
    public SongEditorForm(Song songIn) {
        initComponents();

        song = songIn;
        this.setTitle(songIn.getFileName());
        
        //fill object
        fillGuiValues();
        
        newSong = false;
        
        this.center();        
        
        highlightchord(this.textChordsSimplified);
        highlightchord(this.textChordsCompleted);
        highlightlyric(this.textLyrics);
    }
    
    public SongEditorForm() {
        initComponents();

        song = new Song();

        this.setTitle("");
        
        newSong = true;
        
        this.center();
        
        highlightchord(this.textChordsSimplified);
        highlightchord(this.textChordsCompleted);
        highlightlyric(this.textLyrics);
    }

    public void center(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle frame = getBounds();
        setLocation((screen.width - frame.width)/2, (screen.height - frame.height)/2);
    }
    
    
    private void fillGuiValues(){
        fieldName.setText(song.getSongName());
        fieldAuthor.setText(song.getSongAuthor());
        textLyrics.setText(song.getLyrics());
        textChordsCompleted.setText(song.getChordsComplete());
        textChordsSimplified.setText(song.getChordsSimplified());
    }

    private void actualizeValues(){
        song.setSongName(fieldName.getText());
        song.setSongAuthor(fieldAuthor.getText());
        song.setLyrics(textLyrics.getText());
        song.setChordsComplete(textChordsCompleted.getText());
        song.setChordsSimplified(textChordsSimplified.getText());
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        fieldName = new javax.swing.JTextField();
        labelName = new javax.swing.JLabel();
        labelAuthor = new javax.swing.JLabel();
        fieldAuthor = new javax.swing.JTextField();
        tabSong = new javax.swing.JTabbedPane();
        scroolLyric = new javax.swing.JScrollPane();
        textLyrics = new javax.swing.JTextPane();
        scroolChordsComplete = new javax.swing.JScrollPane();
        textChordsCompleted = new javax.swing.JTextPane();
        scroolChordsSimplified = new javax.swing.JScrollPane();
        textChordsSimplified = new javax.swing.JTextPane();
        toolBar = new javax.swing.JToolBar();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        textLine = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBreak = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        fieldName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNameKeyTyped(evt);
            }
        });

        labelName.setFont(new java.awt.Font("Arial", 1, 11));
        labelName.setText(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("NAME"));
        labelName.setFocusable(false);

        labelAuthor.setFont(new java.awt.Font("Arial", 1, 11));
        labelAuthor.setText(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("AUTHOR"));
        labelAuthor.setFocusable(false);

        tabSong.setFont(new java.awt.Font("Arial", 1, 11));
        tabSong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textChordsCompleteKeyPressed(evt);
            }
        });

        textLyrics.setFont(new java.awt.Font("Courier New", 0, 12));
        textLyrics.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textLyricsKeyPressed(evt);
            }
        });

        scroolLyric.setViewportView(textLyrics);

        tabSong.addTab(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("LYRICS"), scroolLyric);

        textChordsCompleted.setFont(new java.awt.Font("Courier New", 0, 12));
        textChordsCompleted.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textChordsCompleteKeyPressed(evt);
            }
        });

        scroolChordsComplete.setViewportView(textChordsCompleted);

        tabSong.addTab(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("CHORDS_COMPLETE"), scroolChordsComplete);

        textChordsSimplified.setFont(new java.awt.Font("Courier New", 0, 12));
        textChordsSimplified.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textChordsSimplifiedKeyPressed(evt);
            }
        });

        scroolChordsSimplified.setViewportView(textChordsSimplified);

        tabSong.addTab(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Chords_Simplified"), scroolChordsSimplified);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/save.gif")));
        btnSave.setText("Save");
        btnSave.setMaximumSize(new java.awt.Dimension(60, 32));
        btnSave.setMinimumSize(new java.awt.Dimension(60, 32));
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        toolBar.add(btnSave);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/delete.gif")));
        btnClose.setText("Close");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        toolBar.add(btnClose);

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
        toolBar.add(jSeparator2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(labelName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fieldName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(labelAuthor)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fieldAuthor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)))
                .addContainerGap())
            .add(toolBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(tabSong, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(toolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelName)
                    .add(fieldName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelAuthor)
                    .add(fieldAuthor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(16, 16, 16)
                .add(tabSong, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
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
       
        String inStr = this.textLyrics.getText();
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
         
        this.textLyrics.setText(sb.toString());
        highlightlyric(this.textLyrics);        
    }//GEN-LAST:event_btnBreakActionPerformed

    private void textChordsSimplifiedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textChordsSimplifiedKeyPressed
        highlightchord(this.textChordsSimplified);
    }//GEN-LAST:event_textChordsSimplifiedKeyPressed

    private void textChordsCompleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textChordsCompleteKeyPressed
        highlightchord(this.textChordsCompleted);
    }//GEN-LAST:event_textChordsCompleteKeyPressed

    private void textLyricsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textLyricsKeyPressed
        highlightlyric(this.textLyrics);
    }//GEN-LAST:event_textLyricsKeyPressed

    private void fieldNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNameKeyTyped
        if(evt.getKeyCode()==16)
            return;
        // samuelm: changed to check against disallowd chars to avoid problems with non-english chars
        //String allowed="ZXCVBNMASDFGHJKL?QWERTYUIOPzxcvbnmasdfghjkl?qwertyuiop1234567890'???????????";
        String disallowed = "\\/:*?\"<>|";
        if(disallowed.contains(String.valueOf(evt.getKeyChar())))
            evt.consume();
    }//GEN-LAST:event_fieldNameKeyTyped

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        
        if(this.fieldName.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please fill the field \"Song Name\"");
            return;
        }

        String filename = this.fieldName.getText();
        if(!filename.contains(".song"))
            filename = filename + ".song";
        String path = System.getProperty("user.dir") + System.getProperty("file.separator") + 
                "songs"+ System.getProperty("file.separator")+filename;
        
        if(!path.equals(song.getFilePath())){
            File file = new File(song.getFilePath());
            file.delete();
        }
        song.setFilePath(path);
        
        saveFile();            
        
    }//GEN-LAST:event_btnSaveMouseClicked

  private void saveFile(){
        actualizeValues();
        
        try{
            Node node = song.writeObject();
            Document doc = node.getOwnerDocument();
            doc.appendChild( node);                        // Add Root to Document
            FileOutputStream fos = new FileOutputStream(song.getFilePath());
            org.apache.xml.serialize.XMLSerializer xs = new org.apache.xml.serialize.XMLSerializer();
            OutputFormat outFormat = new OutputFormat();
            outFormat.setIndenting(true);
            outFormat.setEncoding("ISO-8859-1");
            xs.setOutputFormat(outFormat);
            xs.setOutputByteStream(fos);
            xs.serialize(doc);
            fos.close();

        } catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error writing file.\nErro:"+e.getMessage(),"DataSoul Error",0);    
        }
        
        if(newSong){
            AllSongsListTable.getInstance().addItem(song);
            newSong = false;
            AllSongsListTable.getInstance().sortByName();            
        }
    }
    
    /**
     * @param args the command line arguments
     */
/*    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SongEditorFrame().setVisible(true);
            }
        });
    }
  */  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBreak;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField fieldAuthor;
    private javax.swing.JTextField fieldName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelAuthor;
    private javax.swing.JLabel labelName;
    private javax.swing.JScrollPane scroolChordsComplete;
    private javax.swing.JScrollPane scroolChordsSimplified;
    private javax.swing.JScrollPane scroolLyric;
    private javax.swing.JTabbedPane tabSong;
    private javax.swing.JTextPane textChordsCompleted;
    private javax.swing.JTextPane textChordsSimplified;
    private javax.swing.JTextField textLine;
    private javax.swing.JTextPane textLyrics;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
    

    public void highlightlyric(JTextComponent textComp){
        removeHighlights(textComp);
        highlight(textComp,"\n"+TextServiceItem.SLIDE_BREAK+"\n",Color.ORANGE);
        highlight(textComp,"\n"+TextServiceItem.CHORUS_MARK+"\n",Color.PINK);
    }

    public void highlightchord(JTextComponent textComp){
        removeHighlights(textComp);
        for(String chord:ChordsDB.getInstance().getChordsName()){
            highlight(textComp,chord,Color.decode("0xddddff"));
        }
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
