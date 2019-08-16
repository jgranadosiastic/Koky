package com.jgranados.koky.ui;

import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.interpreter.lexer.Lexer;
import com.jgranados.koky.interpreter.parser.Parser;
import com.jgranados.koky.interpreter.symbolstable.SymbolsTable;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author jose
 */
public class KokyFrame extends javax.swing.JFrame {

    private static final String ICON_URL = "/com/jgranados/koky/ui/images/kok_pointer.png";
    private static final String KOK_EXTENSION = "kok";
    private static final String KOK_EXTENSION_DESC = "Archivos Kok";

    private static final String CLEARS = "clears";
    private static final String LINE = "\n";
    private static final String BR = "<br>";
    private Lexer myLexer;
    private Parser myParser;
    private PanelDraw panelDraw;
    private SymbolsTable instructionsSymTable;
    private String lastInput;

    /**
     * Creates new form KokFrame
     */
    public KokyFrame() {
        panelDraw = new PanelDraw();
        initComponents();
        myLexer = new Lexer(new StringReader(""));
        instructionsSymTable = new SymbolsTable(myLexer.getErrorsList());
        myParser = new Parser(myLexer, instructionsSymTable);
        txtInstruction.requestFocusInWindow();
        this.getContentPane().setBackground(new java.awt.Color(0, 153, 0));
        this.saveFileChooser.setFileFilter(new FileNameExtensionFilter(KOK_EXTENSION_DESC, KOK_EXTENSION));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveFileChooser = new javax.swing.JFileChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtInstructions = new javax.swing.JTextArea();
        txtInstruction = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessages = new javax.swing.JEditorPane();
        scrollpnl = new javax.swing.JScrollPane();
        scrollpnl.setViewportView(panelDraw);
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        helpPane = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        btnCleanAll = new javax.swing.JButton();
        btnSaveInstructions = new javax.swing.JButton();
        btnOpenEditor = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnOpenFIle = new javax.swing.JMenu();
        btnSaveInstructionsMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnInstructions = new javax.swing.JMenuItem();
        btnAbout = new javax.swing.JMenuItem();

        saveFileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Koky");
        setBackground(new java.awt.Color(0, 153, 0));
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICON_URL)));
        setMinimumSize(new java.awt.Dimension(800, 600));

        jSplitPane1.setBackground(new java.awt.Color(0, 153, 0));
        jSplitPane1.setResizeWeight(0.6);

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        txtInstructions.setColumns(20);
        txtInstructions.setRows(5);
        jScrollPane3.setViewportView(txtInstructions);

        txtInstruction.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtInstruction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInstructionActionPerformed(evt);
            }
        });
        txtInstruction.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtInstructionKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
            .addComponent(txtInstruction)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInstruction))
        );

        jSplitPane1.setLeftComponent(jPanel2);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(300, 22));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 26));

        txtMessages.setContentType("text/html"); // NOI18N
        txtMessages.setText("");
        jScrollPane1.setViewportView(txtMessages);

        jSplitPane1.setRightComponent(jScrollPane1);

        scrollpnl.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        helpPane.setEditable(false);
        try {
            helpPane.setPage(getClass().getResource("/com/jgranados/koky/ui/basicInstructions.html")
            );
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        }
        jScrollPane4.setViewportView(helpPane);

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));

        btnCleanAll.setBackground(new java.awt.Color(255, 255, 255));
        btnCleanAll.setForeground(new java.awt.Color(0, 153, 0));
        btnCleanAll.setText("Limpiar Todo");
        btnCleanAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanAllActionPerformed(evt);
            }
        });

        btnSaveInstructions.setBackground(new java.awt.Color(255, 255, 255));
        btnSaveInstructions.setForeground(new java.awt.Color(0, 153, 0));
        btnSaveInstructions.setText("Guardar");
        btnSaveInstructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveInstructionsActionPerformed(evt);
            }
        });

        btnOpenEditor.setBackground(new java.awt.Color(255, 255, 255));
        btnOpenEditor.setForeground(new java.awt.Color(0, 153, 0));
        btnOpenEditor.setText("Editor de Texto");
        btnOpenEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenEditorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCleanAll, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
            .addComponent(btnSaveInstructions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOpenEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnCleanAll, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnOpenEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollpnl, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollpnl, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtInstructionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInstructionKeyReleased
        String input = this.getCurrentLine();
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                this.run(input);
                break;
            case KeyEvent.VK_UP:
                // remember the last command
                if (!input.endsWith(this.lastInput)) {
                    this.txtInstruction.setText(lastInput);
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_txtInstructionKeyReleased

    private void btnCleanAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanAllActionPerformed
        parseInstruction(CLEARS);
        txtInstructions.setText("");
        txtInstruction.setText("");
        txtMessages.setText("<p style=\"margin-top: 0\"></p>");
        instructionsSymTable.cleanAll();
    }//GEN-LAST:event_btnCleanAllActionPerformed

    private void btnSaveInstructionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveInstructionsActionPerformed
        saveInstructionsToFile();
    }//GEN-LAST:event_btnSaveInstructionsActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        new AboutDialog(this).setVisible(true);
    }//GEN-LAST:event_btnAboutActionPerformed

    private void btnSaveInstructionsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveInstructionsMenuItemActionPerformed
        saveInstructionsToFile();
    }//GEN-LAST:event_btnSaveInstructionsMenuItemActionPerformed

    private void btnOpenEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenEditorActionPerformed
        new EditorFrame(this);
    }//GEN-LAST:event_btnOpenEditorActionPerformed

    private void txtInstructionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInstructionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInstructionActionPerformed
    
    //Metodo para parsear
    public void run(String input) {
        parseInstruction("clears\n");
        parseInstruction(input);
        this.txtInstructions.append(input + LINE);
        this.txtInstruction.setText("");
        addErrorMessages(this.myLexer.getErrorsList());
        lastInput = input;
    }
    
    public String getCurrentLine() {
        return txtInstruction.getText();
    }

    private void addErrorMessages(List<String> messages) {
        List<String> errorMessages = messages
                .stream()
                .map(message -> "<font color=\"red\">" + message + "</font>")
                .collect(Collectors.toList());
        addMessages(errorMessages);
        messages.clear();
    }

    private void addSuccessMessages(List<String> messages) {
        addMessages(messages);
    }

    public void addMessages(List<String> messages) {
        if (!messages.isEmpty()) {
            HTMLDocument doc = (HTMLDocument) txtMessages.getDocument();
            try {
                doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()), String.join(BR, messages) + BR);
            } catch (BadLocationException | IOException ex) {
                Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtMessages.setCaretPosition(doc.getLength());
        }
    }

    public void parseInstruction(String instruction) {
        this.myLexer.yyreset(new StringReader(instruction + LINE));
        try {
            List<Instruction> instructions = (List<Instruction>) this.myParser.parse().value;
            if (this.myLexer.getErrorsList().isEmpty()) {
                List<String> executionDescriptions = panelDraw.runInstructions(instructions);
                addSuccessMessages(executionDescriptions);
            }
        } catch (Exception ex) {
            Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String saveInstructionsToFile() {
        saveFileChooser.showSaveDialog(this);
        File file = new File(normalizeFileName(saveFileChooser.getSelectedFile().getAbsolutePath()));
        try (PrintWriter printer = new PrintWriter(file);) {
            printer.print(txtInstructions.getText());
        } catch (IOException e) {
            e.printStackTrace(System.out);
            JOptionPane.showMessageDialog(
                    this,
                    "Error guardando instrucciones en el archivo\n" + file.getAbsolutePath(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return file.getName();
    }
    public String saveInstructionsToFile(String input) {
        saveFileChooser.showSaveDialog(this);
        File file = new File(normalizeFileName(saveFileChooser.getSelectedFile().getAbsolutePath()));
        try (PrintWriter printer = new PrintWriter(file);) {
            printer.print(input);
        } catch (IOException e) {
            e.printStackTrace(System.out);
            JOptionPane.showMessageDialog(
                    this,
                    "Error guardando instrucciones en el archivo\n" + file.getAbsolutePath(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return file.getName();
    }
    
    public void openInstructionsFromFile() {
        saveFileChooser.showOpenDialog(this);
        File file = new File(normalizeFileName(saveFileChooser.getSelectedFile().getAbsolutePath()));
    }

    private String normalizeFileName(String baseName) {
        if (!baseName.endsWith("." + KOK_EXTENSION)) {
            return baseName + "." + KOK_EXTENSION;
        }
        return baseName;
    }
    
    public File openFile() {
        int status = saveFileChooser.showOpenDialog(this);
        if (status == JFileChooser.APPROVE_OPTION) {
            File file = saveFileChooser.getSelectedFile();
            return file;
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAbout;
    private javax.swing.JButton btnCleanAll;
    private javax.swing.JMenuItem btnInstructions;
    private javax.swing.JButton btnOpenEditor;
    private javax.swing.JMenu btnOpenFIle;
    private javax.swing.JButton btnSaveInstructions;
    private javax.swing.JMenuItem btnSaveInstructionsMenuItem;
    private javax.swing.JEditorPane helpPane;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JFileChooser saveFileChooser;
    private javax.swing.JScrollPane scrollpnl;
    private javax.swing.JTextField txtInstruction;
    private javax.swing.JTextArea txtInstructions;
    private javax.swing.JEditorPane txtMessages;
    // End of variables declaration//GEN-END:variables
}
