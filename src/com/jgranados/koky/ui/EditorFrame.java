/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.koky.ui;

import com.jgranados.koky.components.Tab;
import javax.swing.JOptionPane;

/**
 *
 * @author anclenius
 */
public class EditorFrame extends javax.swing.JFrame {
    
    private int unnamedTabs;
    
    public EditorFrame() {
        initComponents();
        this.setVisible(true);
        this.unnamedTabs = 0;
    }
    
    public EditorFrame(String text) {
        initComponents();
        this.setVisible(true);
        this.unnamedTabs = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        newFile = new javax.swing.JButton();
        closeTab = new javax.swing.JButton();
        saveFile = new javax.swing.JButton();
        loadFile = new javax.swing.JButton();
        undoFile = new javax.swing.JButton();
        redoFile = new javax.swing.JButton();
        executeFile = new javax.swing.JButton();
        Inputs = new javax.swing.JTabbedPane();
        Outputs = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnOpenFIle = new javax.swing.JMenu();
        btnSaveInstructionsMenuItem = new javax.swing.JMenuItem();
        bntOpenFile = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnInstructions = new javax.swing.JMenuItem();
        btnAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        newFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/new.png"))); // NOI18N
        newFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        newFile.setFocusable(false);
        newFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        jToolBar1.add(newFile);

        closeTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/close.png"))); // NOI18N
        closeTab.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        closeTab.setFocusable(false);
        closeTab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        closeTab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        closeTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeTabActionPerformed(evt);
            }
        });
        jToolBar1.add(closeTab);

        saveFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/save.png"))); // NOI18N
        saveFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveFile.setFocusable(false);
        saveFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(saveFile);

        loadFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/open.png"))); // NOI18N
        loadFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loadFile.setFocusable(false);
        loadFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loadFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(loadFile);

        undoFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/undo.png"))); // NOI18N
        undoFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        undoFile.setFocusable(false);
        undoFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        undoFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(undoFile);

        redoFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/redo.png"))); // NOI18N
        redoFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        redoFile.setFocusable(false);
        redoFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        redoFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(redoFile);

        executeFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/play.png"))); // NOI18N
        executeFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        executeFile.setFocusable(false);
        executeFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        executeFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        executeFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeFileActionPerformed(evt);
            }
        });
        jToolBar1.add(executeFile);

        jMenuBar1.setBackground(new java.awt.Color(153, 51, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(114, 35));

        btnOpenFIle.setForeground(new java.awt.Color(255, 255, 255));
        btnOpenFIle.setText("Archivo");

        btnSaveInstructionsMenuItem.setText("Guardar Instrucciones");
        btnSaveInstructionsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveInstructionsMenuItemActionPerformed(evt);
            }
        });
        btnOpenFIle.add(btnSaveInstructionsMenuItem);

        bntOpenFile.setText("Abrir archivo");
        bntOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntOpenFileActionPerformed(evt);
            }
        });
        btnOpenFIle.add(bntOpenFile);

        jMenuBar1.add(btnOpenFIle);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Ayuda");

        btnInstructions.setText("Instrucciones");
        jMenu2.add(btnInstructions);

        btnAbout.setText("Acerca de...");
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });
        jMenu2.add(btnAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Inputs, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Outputs, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Inputs, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addComponent(Outputs))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveInstructionsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveInstructionsMenuItemActionPerformed
        
    }//GEN-LAST:event_btnSaveInstructionsMenuItemActionPerformed

    private void bntOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntOpenFileActionPerformed
        

    }//GEN-LAST:event_bntOpenFileActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        new AboutDialog(this).setVisible(true);
    }//GEN-LAST:event_btnAboutActionPerformed

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        unnamedTabs++;
        Tab newTab = new Tab("Pestaña "+unnamedTabs);
        Inputs.addTab("*"+newTab.getName(), newTab);
    }//GEN-LAST:event_newFileActionPerformed

    private void executeFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeFileActionPerformed
        Tab tab = (Tab)Inputs.getSelectedComponent();
        JOptionPane.showMessageDialog(null,tab.getText());
    }//GEN-LAST:event_executeFileActionPerformed

    private void closeTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeTabActionPerformed
        int index = Inputs.getSelectedIndex();
        try{
            Inputs.remove(index);
        }catch(Exception ex){
            System.out.println("Controlada");
        }
    }//GEN-LAST:event_closeTabActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Inputs;
    private javax.swing.JTabbedPane Outputs;
    private javax.swing.JMenuItem bntOpenFile;
    private javax.swing.JMenuItem btnAbout;
    private javax.swing.JMenuItem btnInstructions;
    private javax.swing.JMenu btnOpenFIle;
    private javax.swing.JMenuItem btnSaveInstructionsMenuItem;
    private javax.swing.JButton closeTab;
    private javax.swing.JButton executeFile;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton loadFile;
    private javax.swing.JButton newFile;
    private javax.swing.JButton redoFile;
    private javax.swing.JButton saveFile;
    private javax.swing.JButton undoFile;
    // End of variables declaration//GEN-END:variables
}
