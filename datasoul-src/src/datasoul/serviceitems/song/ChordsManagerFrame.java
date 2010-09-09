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
 * ChordsManagerFrame.java
 *
 * Created on 11 November 2006, 13:47
 */

package datasoul.serviceitems.song;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author  samuelm
 */
public class ChordsManagerFrame extends javax.swing.JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6654284171762467231L;
	private ChordsDB chordsDB;
    private Style chordShapeStyle;
      
    /** Creates new form ChordsManagerFrame */
    public ChordsManagerFrame() {
        initComponents();
        chordsDB = ChordsDB.getInstance();

        tableChordsList.setModel(chordsDB);

        panelChordShapes.setLayout(new GridLayout());
        
        StyleContext sc = new StyleContext();
        chordShapeStyle = sc.addStyle("chordShapeStyle",null);        
    }

    private void showChord(){

        panelChordShapes.setContentType("text/rtf");

        javax.swing.text.Document doc = panelChordShapes.getDocument();

        try {
        
            doc.remove(0,doc.getLength());

            Chord chord = (Chord)tableChordsList.getModel().getValueAt(tableChordsList.getSelectedRow(),0);

            panelChordShapes.removeAll();

            ArrayList<String> shapes = chord.getShapes();
            for(int i=0;i<shapes.size();i++){
                ChordShapePanel csp = new ChordShapePanel(2, chord.getName(), shapes.get(i));

                StyleConstants.setIcon(chordShapeStyle, new ImageIcon(csp.createImage()));
                    doc.insertString(doc.getLength(),"text to be ignored", chordShapeStyle);
            }
            
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        split1 = new javax.swing.JSplitPane();
        scroolChordShapesPanel = new javax.swing.JScrollPane();
        panelChordShapes = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        scrollChorsList = new javax.swing.JScrollPane();
        tableChordsList = new datasoul.util.DnDTable();
        fieldString = new javax.swing.JTextField();
        labelString = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        setTitle(bundle.getString("CHORDS MANAGER")); // NOI18N

        jToolBar1.setFloatable(false);
        jToolBar1.setOpaque(false);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/document-new.png"))); // NOI18N
        btnNew.setText(bundle.getString("NEW")); // NOI18N
        btnNew.setBorderPainted(false);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNew);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/gtk-edit.png"))); // NOI18N
        btnEdit.setText(bundle.getString("EDIT")); // NOI18N
        btnEdit.setBorderPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/edit-delete.png"))); // NOI18N
        btnDelete.setText(bundle.getString("DELETE")); // NOI18N
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDelete);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/window-close.png"))); // NOI18N
        btnClose.setText(bundle.getString("CLOSE")); // NOI18N
        btnClose.setBorderPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jToolBar1.add(btnClose);

        split1.setDividerLocation(160);

        scroolChordShapesPanel.setViewportView(panelChordShapes);

        split1.setRightComponent(scroolChordShapesPanel);

        tableChordsList.setModel(new javax.swing.table.DefaultTableModel(
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
        tableChordsList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableChordsListKeyPressed(evt);
            }
        });
        tableChordsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableChordsListMouseClicked(evt);
            }
        });
        scrollChorsList.setViewportView(tableChordsList);

        fieldString.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldStringKeyPressed(evt);
            }
        });

        labelString.setText(bundle.getString("SEARCH")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelString)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldString, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(scrollChorsList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelString, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldString, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollChorsList, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );

        split1.setLeftComponent(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(split1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(split1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldStringKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldStringKeyPressed
        for(int i=0; i<tableChordsList.getRowCount();i++){
            String searchStr;
            if(String.valueOf(evt.getKeyChar()).equals("\b")&&(fieldString.getText().length()>0)){
                searchStr = fieldString.getText().substring(0,fieldString.getText().length()-1);
            }else{
                searchStr = fieldString.getText()+evt.getKeyChar();
            }

            if(tableChordsList.getValueAt(i,0).toString().startsWith(searchStr)){
                tableChordsList.getSelectionModel().setSelectionInterval(i,i);
                this.scrollChorsList.getVerticalScrollBar().setValue(i*tableChordsList.getRowHeight());
                showChord();
                break;
            }
        }
 
    }//GEN-LAST:event_fieldStringKeyPressed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tableChordsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableChordsListMouseClicked
        showChord();
    }//GEN-LAST:event_tableChordsListMouseClicked

    private void tableChordsListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableChordsListKeyPressed
        showChord();
    }//GEN-LAST:event_tableChordsListKeyPressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(JOptionPane.showConfirmDialog(this,java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("ARE YOU SURE THAT YOU WANT TO DELETE THIS CHORD?"),java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("CONFIRM"),JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            tableChordsList.removeItem();
            ChordsDB.getInstance().save();
        }
        this.repaint();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        ChordEditorForm cef = new ChordEditorForm(chordsDB, (Chord)tableChordsList.getModel().getValueAt(tableChordsList.getSelectedRow(),0));
        cef.setLocationRelativeTo(this);
        cef.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        ChordEditorForm cef = new ChordEditorForm(chordsDB, null);
        cef.setLocationRelativeTo(this);
        cef.setVisible(true);
    }//GEN-LAST:event_btnNewActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JTextField fieldString;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelString;
    private javax.swing.JEditorPane panelChordShapes;
    private javax.swing.JScrollPane scrollChorsList;
    private javax.swing.JScrollPane scroolChordShapesPanel;
    private javax.swing.JSplitPane split1;
    private datasoul.util.DnDTable tableChordsList;
    // End of variables declaration//GEN-END:variables
    
}


