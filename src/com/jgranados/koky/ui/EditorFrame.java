package com.jgranados.koky.ui;

import com.jgranados.koky.components.InputTab;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import com.jgranados.koky.instructions.logic.Languages;
import com.jgranados.koky.instructions.logic.Messages;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anclenius
 */
public class EditorFrame extends KFrame {
    
    private UndoManager undoManager;
    private KokyFrame kokyFrame;
    private int unnamedTabs;
    private JEditorPane txtMessages;
    private MessageDialog messageDialog;
    private List<String> messages;
    
    
    public EditorFrame(KokyFrame kokyFrame) {
        super(true);
        messages = new ArrayList<>();
        this.txtMessages = super.getEditorPane();
        txtMessages.setContentType("text/html");
        initComponents();
        this.kokyFrame = kokyFrame;
        this.setVisible(true);
        this.unnamedTabs = 0;
        this.saveFileChooser.setFileFilter(new FileNameExtensionFilter(KokyFrame.KOK_EXTENSION_DESC, KokyFrame.KOK_EXTENSION));
        this.addTab();
        this.undoFile.setEnabled(true);
        this.redoFile.setEnabled(true);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveFileChooser = new javax.swing.JFileChooser();
        jToolBar1 = new javax.swing.JToolBar();
        newFile = new javax.swing.JButton();
        closeTab = new javax.swing.JButton();
        saveFile = new javax.swing.JButton();
        loadFile = new javax.swing.JButton();
        undoFile = new javax.swing.JButton();
        redoFile = new javax.swing.JButton();
        executeFile = new javax.swing.JButton();
        Inputs = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnOpenFIle = new javax.swing.JMenu();
        btnSaveInstructionsMenuItem = new javax.swing.JMenuItem();
        bntOpenFile = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnInstructions = new javax.swing.JMenuItem();
        btnAbout = new javax.swing.JMenuItem();
        lenguagesMenu = new javax.swing.JMenu();
        lenguagesAll = new javax.swing.JMenuItem();
        lenguageEnglish = new javax.swing.JMenuItem();
        lenguageSpanish = new javax.swing.JMenuItem();
        lenguageKiche = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Texto");

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
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        jToolBar1.add(saveFile);

        loadFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/open.png"))); // NOI18N
        loadFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loadFile.setFocusable(false);
        loadFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loadFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        loadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileActionPerformed(evt);
            }
        });
        jToolBar1.add(loadFile);

        undoFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/undo.png"))); // NOI18N
        undoFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        undoFile.setFocusable(false);
        undoFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        undoFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        undoFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoFileActionPerformed(evt);
            }
        });
        jToolBar1.add(undoFile);

        redoFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/redo.png"))); // NOI18N
        redoFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        redoFile.setFocusable(false);
        redoFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        redoFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        redoFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoFileActionPerformed(evt);
            }
        });
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

        Inputs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                InputsStateChanged(evt);
            }
        });

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

        lenguagesMenu.setForeground(new java.awt.Color(255, 255, 255));
        lenguagesMenu.setText("Idiomas");
        lenguagesMenu.setToolTipText("");

        lenguagesAll.setText("Todos");
        lenguagesAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lenguagesAllActionPerformed(evt);
            }
        });
        lenguagesMenu.add(lenguagesAll);

        lenguageEnglish.setText("Ingles");
        lenguageEnglish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lenguageEnglishActionPerformed(evt);
            }
        });
        lenguagesMenu.add(lenguageEnglish);

        lenguageSpanish.setText("Español");
        lenguageSpanish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lenguageSpanishActionPerformed(evt);
            }
        });
        lenguagesMenu.add(lenguageSpanish);

        lenguageKiche.setText("Kiche");
        lenguageKiche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lenguageKicheActionPerformed(evt);
            }
        });
        lenguagesMenu.add(lenguageKiche);

        jMenuBar1.add(lenguagesMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Inputs)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Inputs, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveInstructionsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveInstructionsMenuItemActionPerformed
        String name = kokyFrame.saveInstructionsToFile();
        int index = Inputs.getSelectedIndex();
        Inputs.setTitleAt(index, name);
        unnamedTabs--;
        JOptionPane.showMessageDialog(null, "Archivo Guardado");
        this.setVisible(true);
    }//GEN-LAST:event_btnSaveInstructionsMenuItemActionPerformed

    private void bntOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntOpenFileActionPerformed
        openFile();
    }//GEN-LAST:event_bntOpenFileActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        new AboutDialog(this).setVisible(true);
    }//GEN-LAST:event_btnAboutActionPerformed

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        addTab();
    }//GEN-LAST:event_newFileActionPerformed

    private void executeFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeFileActionPerformed
        this.run();
    }//GEN-LAST:event_executeFileActionPerformed

    private void closeTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeTabActionPerformed
        int index = Inputs.getSelectedIndex();
        unnamedTabs--;
        try{
            Inputs.remove(index);
        } catch(Exception ex){
            System.out.println("Controlada");
        }
    }//GEN-LAST:event_closeTabActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        InputTab tab = (InputTab)Inputs.getSelectedComponent();
        String name = kokyFrame.saveInstructionsToFile(tab.getText());
        int index = Inputs.getSelectedIndex();
        Inputs.setTitleAt(index, name);
        unnamedTabs--;
        JOptionPane.showMessageDialog(null, "Archivo Guardado");
        this.setVisible(true);
    }//GEN-LAST:event_saveFileActionPerformed

    private void InputsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_InputsStateChanged
        InputTab tab = (InputTab)Inputs.getSelectedComponent();
        this.undoManager = tab.getManager();
        this.undoFile.setEnabled(true);
        this.redoFile.setEnabled(true);
    }//GEN-LAST:event_InputsStateChanged

    private void undoFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoFileActionPerformed
        try {
            undoManager.undo();
        } catch (CannotRedoException ex) {
            
        }
    }//GEN-LAST:event_undoFileActionPerformed

    private void redoFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoFileActionPerformed
        try {
            undoManager.redo();
        } catch (CannotRedoException cre) {
            
        }
    }//GEN-LAST:event_redoFileActionPerformed

    private void loadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileActionPerformed
        openFile();
    }//GEN-LAST:event_loadFileActionPerformed

    private void lenguagesAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenguagesAllActionPerformed
        
        messages.clear();
        Languages.ALL.setTypeLanguage(true);
        Languages.ENGLISH.setTypeLanguage(false);
        Languages.SPANISH.setTypeLanguage(false);
        Languages.KICHE.setTypeLanguage(false);
        typeLanguage();
        messages = Messages.changeMessage();
        JOptionPane.showMessageDialog(null, messages);
    }//GEN-LAST:event_lenguagesAllActionPerformed

    private void lenguageEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenguageEnglishActionPerformed
        messages.clear();
        Languages.ALL.setTypeLanguage(false);
        Languages.ENGLISH.setTypeLanguage(true);
        Languages.SPANISH.setTypeLanguage(false);
        Languages.KICHE.setTypeLanguage(false);
        typeLanguage();
        messages = Messages.changeMessage();
        JOptionPane.showMessageDialog(null, messages);
    }//GEN-LAST:event_lenguageEnglishActionPerformed

    private void lenguageSpanishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenguageSpanishActionPerformed
        messages.clear();
        Languages.ALL.setTypeLanguage(false);
        Languages.ENGLISH.setTypeLanguage(false);
        Languages.SPANISH.setTypeLanguage(true);
        Languages.KICHE.setTypeLanguage(false);
        typeLanguage();
        messages = Messages.changeMessage();
        JOptionPane.showMessageDialog(null, messages);
    }//GEN-LAST:event_lenguageSpanishActionPerformed

    private void lenguageKicheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenguageKicheActionPerformed
        messages.clear();
        Languages.ALL.setTypeLanguage(false);
        Languages.ENGLISH.setTypeLanguage(false);
        Languages.SPANISH.setTypeLanguage(false);
        Languages.KICHE.setTypeLanguage(true);
        typeLanguage();
        messages = Messages.changeMessage();
        JOptionPane.showMessageDialog(null, messages);
    }//GEN-LAST:event_lenguageKicheActionPerformed

    
    public void run() {
        InputTab in = (InputTab)Inputs.getSelectedComponent();
        this.kokyFrame.setVisible(true);
        super.parseInstruction(in.getText(),this.kokyFrame.getPanelDraw());
        if(messageDialog == null || !messageDialog.isVisible()) {
            messageDialog = new MessageDialog(this.txtMessages);
            messageDialog.setVisible(true);
        } else if (messageDialog.isVisible()) {
            messageDialog.dispose();
            messageDialog = new MessageDialog(this.txtMessages);
            messageDialog.setVisible(true);
        }
        
        
        
    }
    
    public void addTab() {
        unnamedTabs++;
        InputTab newTab = new InputTab("Pestaña "+unnamedTabs);
        Inputs.addTab("*"+newTab.getName(), newTab);
        this.undoManager = newTab.getManager();
        Inputs.setSelectedIndex(Inputs.getComponentCount()-1);
        newTab.getTextArea().requestFocus();
    }
    
    public void addTab(String input,String name) {
        InputTab newTab = new InputTab(name);
        newTab.setText(input);
        Inputs.addTab(name, newTab);
        this.undoManager = newTab.getManager();
        Inputs.setSelectedIndex(Inputs.getComponentCount()-1);
    }
    
    public void openFile(){
        File file = kokyFrame.openFile();
        String name = file.getName();
        String buffer = "";
        try {
            Scanner scan = new Scanner(new FileInputStream(file));
            while (scan.hasNext()) {
                buffer += scan.nextLine() + "\n";
            }
            System.out.println(buffer);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        addTab(buffer,name);
        
        
        this.setVisible(true);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Inputs;
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
    private javax.swing.JMenuItem lenguageEnglish;
    private javax.swing.JMenuItem lenguageKiche;
    private javax.swing.JMenuItem lenguageSpanish;
    private javax.swing.JMenuItem lenguagesAll;
    private javax.swing.JMenu lenguagesMenu;
    private javax.swing.JButton loadFile;
    private javax.swing.JButton newFile;
    private javax.swing.JButton redoFile;
    private javax.swing.JButton saveFile;
    private javax.swing.JFileChooser saveFileChooser;
    private javax.swing.JButton undoFile;
    // End of variables declaration//GEN-END:variables
}