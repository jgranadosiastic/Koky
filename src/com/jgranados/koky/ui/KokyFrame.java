package com.jgranados.koky.ui;

import com.jgranados.koky.challengeshistory.HistoryHandler;
import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.instructions.logic.Languages;
import com.jgranados.koky.instructions.logic.Messages;
import com.jgranados.koky.interpreter.lexer.Lexer;
import com.jgranados.koky.interpreter.lexer.languages.LexerAll;
import com.jgranados.koky.interpreter.lexer.languages.LexerEs;
import com.jgranados.koky.interpreter.lexer.languages.LexerKiche;
import com.jgranados.koky.interpreter.parser.Parser;
import com.jgranados.koky.interpreter.symbolstable.SymbolsTable;
import com.jgranados.koky.ui.challenges.ChallengesFrame;
import com.jgranados.koky.ui.challenges.ChallengesHistory;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java_cup.runtime.Scanner;
import java_cup.runtime.SymbolFactory;
import javax.swing.JColorChooser;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
    private static final int NUM_SUBSTRING = 2;
    private static final String JPG_FILE_EXTENSION = "jpg";
    private static final String JPG__DOT_FILE_EXTENSION = ".jpg";
    private static final String CLEARS = "clears";
    private static final String LINE = "\n";
    private static final String BR = "<br>";
    private Lexer lexerEn;
    private LexerAll lexerAll;
    private LexerEs lexerSp;
    private LexerKiche lexerKi;
    private Parser myParser;
    private PanelDraw panelDraw;
    private SymbolsTable instructionsSymTable;
    private String lastInput;
    private ArrayList<String> historyInput = new ArrayList<>();
    private int history = 0;
    private int instructionsMade = 0;
    private Boolean coutingSteps = false;
    private HistoryHandler challengeHistoryHandler = new HistoryHandler();
    private Scanner sc;
    public static List<String> infoMes = new ArrayList<>();

    public KokyFrame() {
        panelDraw = new PanelDraw();
        initComponents();
        txtInstruction.requestFocusInWindow();
        typeLanguage();
        this.getContentPane().setBackground(new java.awt.Color(0, 153, 0));
        this.saveFileChooser.setFileFilter(new FileNameExtensionFilter(KOK_EXTENSION_DESC, KOK_EXTENSION));
    }

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
        btnChangeImage = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnOpenFIle = new javax.swing.JMenu();
        btnSaveInstructionsMenuItem = new javax.swing.JMenuItem();
        bntOpenFile = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        btnInstructions = new javax.swing.JMenuItem();
        colorItem = new javax.swing.JMenuItem();
        btnAbout = new javax.swing.JMenuItem();
        exportMenu = new javax.swing.JMenu();
        changeVarNameMenu = new javax.swing.JMenuItem();
        interactiveMenu = new javax.swing.JMenu();
        takeChallengeMenuItem = new javax.swing.JMenuItem();
        challengeHistoryMEnuItem = new javax.swing.JMenuItem();
        lenguagesMenu = new javax.swing.JMenu();
        lenguagesAll = new javax.swing.JMenuItem();
        lenguageEnglish = new javax.swing.JMenuItem();
        lenguageSpanish = new javax.swing.JMenuItem();
        lenguageKiche = new javax.swing.JMenuItem();

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

        btnChangeImage.setBackground(new java.awt.Color(255, 255, 255));
        btnChangeImage.setForeground(new java.awt.Color(0, 153, 0));
        btnChangeImage.setText("Cambiar icono");
        btnChangeImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCleanAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSaveInstructions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnChangeImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnCleanAll, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChangeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
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

        bntOpenFile.setText("Abrir archivo");
        bntOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntOpenFileActionPerformed(evt);
            }
        });
        btnOpenFIle.add(bntOpenFile);

        jMenuBar1.add(btnOpenFIle);

        helpMenu.setForeground(new java.awt.Color(255, 255, 255));
        helpMenu.setText("Ayuda");

        btnInstructions.setText("Instrucciones");
        helpMenu.add(btnInstructions);

        colorItem.setText("Consultar color");
        colorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorItemActionPerformed(evt);
            }
        });
        helpMenu.add(colorItem);

        btnAbout.setText("Acerca de...");
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });
        helpMenu.add(btnAbout);

        jMenuBar1.add(helpMenu);

        exportMenu.setForeground(new java.awt.Color(255, 255, 255));
        exportMenu.setText("Exportar");

        changeVarNameMenu.setText("Guardar Imagen");
        changeVarNameMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeVarNameMenuActionPerformed(evt);
            }
        });
        exportMenu.add(changeVarNameMenu);

        jMenuBar1.add(exportMenu);

        interactiveMenu.setForeground(new java.awt.Color(255, 255, 255));
        interactiveMenu.setText("Interactivo");

        takeChallengeMenuItem.setText("¡Tomar un reto!");
        takeChallengeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeChallengeMenuItemActionPerformed(evt);
            }
        });
        interactiveMenu.add(takeChallengeMenuItem);

        challengeHistoryMEnuItem.setText("Historial de retos");
        challengeHistoryMEnuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                challengeHistoryMEnuItemActionPerformed(evt);
            }
        });
        interactiveMenu.add(challengeHistoryMEnuItem);

        jMenuBar1.add(interactiveMenu);

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
                            .addComponent(scrollpnl, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
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
                parseInstruction(input);
                this.txtInstructions.append(input + LINE);
                this.txtInstruction.setText("");
                errorLanguage();
                historyInput.add(input);
                history = historyInput.size();
                lastInput = "";
                if (coutingSteps) {
                    instructionsMade++;
                }
                break;
            case KeyEvent.VK_UP:
                // remember the last command
                history--;
                if (history >= 0) {
                    this.txtInstruction.setText(historyInput.get(history));
                } else {
                    history = 0;
                }
                break;
            case KeyEvent.VK_DOWN:
                history++;
                if (history < historyInput.size()) {
                    this.txtInstruction.setText(historyInput.get(history));
                } else {
                    this.txtInstruction.setText(lastInput);
                    history = historyInput.size();
                }
                break;
            default:
                lastInput = this.txtInstruction.getText();
                break;
        }
    }//GEN-LAST:event_txtInstructionKeyReleased

    private void btnCleanAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanAllActionPerformed
        cleanAll();
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

    private void bntOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntOpenFileActionPerformed
        saveFileChooser.showOpenDialog(this);
        // TODO open dialog frame 
    }//GEN-LAST:event_bntOpenFileActionPerformed

    private void btnChangeImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeImageActionPerformed
        KokyImageDialog k = new KokyImageDialog(this, true, panelDraw);
        k.setVisible(true);
    }//GEN-LAST:event_btnChangeImageActionPerformed

    private void colorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorItemActionPerformed
        Color selectedColor = JColorChooser.showDialog(null, "Seleccione un color", Color.YELLOW);
        String hexaString = null;
        if (selectedColor != null) {
            hexaString = "#" + Integer.toHexString(selectedColor.getRGB()).substring(NUM_SUBSTRING).toUpperCase();
            Clipboard systemCopy = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection selectedString = new StringSelection(hexaString);
            systemCopy.setContents(selectedString, selectedString);
        }
    }//GEN-LAST:event_colorItemActionPerformed
    private void changeVarNameMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeVarNameMenuActionPerformed
        generateImage();
    }//GEN-LAST:event_changeVarNameMenuActionPerformed

    private void takeChallengeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeChallengeMenuItemActionPerformed
        int yesOrNoMessage = JOptionPane.YES_NO_OPTION;
        int userElection = JOptionPane.showConfirmDialog(this, "Todos tus cambios actuales se van a borrar ¿Deseas continuar?", "Retos | Koky", yesOrNoMessage);
        if (userElection == 0) {
            cleanAll();
            String userName = JOptionPane.showInputDialog(this, "¿Cuál es tu nombre?", "Ingresa un nombre de usuario", JOptionPane.INFORMATION_MESSAGE);
            ChallengesFrame challengesFrame = new ChallengesFrame(panelDraw.returnDraw(), userName, instructionsMade, this.coutingSteps, this, challengeHistoryHandler);
            challengesFrame.setVisible(true);
            coutingSteps = true;
            enableButonsInChallenge(false);
        } else {
            JOptionPane.showMessageDialog(this, "Puedes continuar dibujando.", "Salir de reto", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_takeChallengeMenuItemActionPerformed

    private void challengeHistoryMEnuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_challengeHistoryMEnuItemActionPerformed
        try {
            ChallengesHistory challengesHistoryFrame = new ChallengesHistory(challengeHistoryHandler);
            challengesHistoryFrame.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_challengeHistoryMEnuItemActionPerformed

    private void lenguagesAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenguagesAllActionPerformed

        Languages.ALL.setTypeLanguage(true);
        Languages.ENGLISH.setTypeLanguage(false);
        Languages.SPANISH.setTypeLanguage(false);
        Languages.KICHE.setTypeLanguage(false);
        typeLanguage();
        addMessagesInfo(Messages.changeMessage());
    }//GEN-LAST:event_lenguagesAllActionPerformed

    private void lenguageEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenguageEnglishActionPerformed

        Languages.ALL.setTypeLanguage(false);
        Languages.ENGLISH.setTypeLanguage(true);
        Languages.SPANISH.setTypeLanguage(false);
        Languages.KICHE.setTypeLanguage(false);
        typeLanguage();
        addMessagesInfo(Messages.changeMessage());
    }//GEN-LAST:event_lenguageEnglishActionPerformed

    private void lenguageSpanishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenguageSpanishActionPerformed

        Languages.ALL.setTypeLanguage(false);
        Languages.ENGLISH.setTypeLanguage(false);
        Languages.SPANISH.setTypeLanguage(true);
        Languages.KICHE.setTypeLanguage(false);
        typeLanguage();
        addMessagesInfo(Messages.changeMessage());
    }//GEN-LAST:event_lenguageSpanishActionPerformed

    private void lenguageKicheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenguageKicheActionPerformed

        Languages.ALL.setTypeLanguage(false);
        Languages.ENGLISH.setTypeLanguage(false);
        Languages.SPANISH.setTypeLanguage(false);
        Languages.KICHE.setTypeLanguage(true);
        typeLanguage();
        addMessagesInfo(Messages.changeMessage());
    }//GEN-LAST:event_lenguageKicheActionPerformed

    public String getCurrentLine() {
        return txtInstruction.getText();
    }

    public int returnTotalAttempts() {
        return instructionsMade;
    }

    public void cleanAll() {
        parseInstruction(CLEARS);
        txtInstructions.setText("");
        txtInstruction.setText("");
        txtMessages.setText("<p style=\"margin-top: 0\"></p>");
        instructionsSymTable.cleanAll();
        instructionsMade = 0;
    }

    public void generateImage() {
        JFileChooser locationFileChooser = new JFileChooser();
        int selection = locationFileChooser.showSaveDialog(null);
        try {
            if (selection == JFileChooser.APPROVE_OPTION) {
                File fileToExport = locationFileChooser.getSelectedFile();
                String filePath = fileToExport.getAbsolutePath();//Obtains the path to use
                try {
                    ImageIO.write(panelDraw.returnDraw(), JPG_FILE_EXTENSION, fileToExport);
                } catch (IOException ex) {
                    Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Checks if the user puts the file extension in the end of the file name
                if (!(filePath.endsWith(JPG__DOT_FILE_EXTENSION))) {
                    File temp = new File(filePath + JPG__DOT_FILE_EXTENSION);
                    fileToExport.renameTo(temp);//If not, we add it manually
                }
                JOptionPane.showMessageDialog(null, "¡Imagen guardada exitosamente!", "Guardado correcto", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {//In case of any problem, the program sends an error message
            JOptionPane.showMessageDialog(null, "¡Ups! Hubo un error al guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addMessagesInfo(List<String> messages) {
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

    private void parseInstruction(String instruction) {
        if (Languages.ALL.getTypeLanguage()==true) {
            lexerAll(lexerAll, instruction);
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
            lexerSpanish(lexerSp, instruction);
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
            lexerEnglish(lexerEn, instruction);
        }else if (Languages.KICHE.getTypeLanguage()==true) {
            lexerKiche(lexerKi, instruction);
        }
        
    }

    private void saveInstructionsToFile() {
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
    }

    private String normalizeFileName(String baseName) {
        if (!baseName.endsWith("." + KOK_EXTENSION)) {
            return baseName + "." + KOK_EXTENSION;
        }
        return baseName;
    }
    
    private void typeLanguage(){
        if(Languages.ALL.getTypeLanguage() == true){
            lexerAll = new LexerAll(new StringReader(""));
            sc = lexerAll;
            instructionsSymTable = new SymbolsTable(lexerAll.getErrorsList());
            typeParser(sc, instructionsSymTable);    
        }else if (Languages.SPANISH.getTypeLanguage() == true) {
            lexerSp = new LexerEs(new StringReader(""));
            sc = lexerSp;
            instructionsSymTable = new SymbolsTable(lexerSp.getErrorsList());
            typeParser(sc, instructionsSymTable);         
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
            lexerEn = new Lexer(new StringReader(""));
            sc = lexerEn;
            instructionsSymTable = new SymbolsTable(lexerEn.getErrorsList());
            typeParser(sc, instructionsSymTable);
         
        }else if (Languages.KICHE.getTypeLanguage()==true) {
            lexerKi = new LexerKiche(new StringReader(""));
            sc = lexerKi;
            instructionsSymTable = new SymbolsTable(lexerKi.getErrorsList());
            typeParser(sc, instructionsSymTable);   
        }
        
    }
    
    private void typeParser(Scanner sc, SymbolsTable symbols){
        myParser = new Parser(sc, symbols);
    }
    
    //type of lexer to execute
    private void lexerAll(LexerAll lexer, String instruction){
        lexer.yyreset(new StringReader(instruction + LINE));
            try {
                List<Instruction> instructions = (List<Instruction>) this.myParser.parse().value;
                if (lexer.getErrorsList().isEmpty()) {
                    List<String> executionDescriptions = panelDraw.runInstructions(instructions);
                    addSuccessMessages(executionDescriptions);
                }
            } catch (Exception ex) {
                Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void lexerSpanish(LexerEs lexer, String instruction){
        lexer.yyreset(new StringReader(instruction + LINE));
            try {
                List<Instruction> instructions = (List<Instruction>) this.myParser.parse().value;
                if (lexer.getErrorsList().isEmpty()) {
                    List<String> executionDescriptions = panelDraw.runInstructions(instructions);
                    addSuccessMessages(executionDescriptions);
                }
            } catch (Exception ex) {
                Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void lexerEnglish(Lexer lexer, String instruction){
        lexer.yyreset(new StringReader(instruction + LINE));
            try {
                List<Instruction> instructions = (List<Instruction>) this.myParser.parse().value;
                if (lexer.getErrorsList().isEmpty()) {
                    List<String> executionDescriptions = panelDraw.runInstructions(instructions);
                    addSuccessMessages(executionDescriptions);
                }
            } catch (Exception ex) {
                Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void lexerKiche(LexerKiche lexer, String instruction){
        lexer.yyreset(new StringReader(instruction + LINE));
            try {
                List<Instruction> instructions = (List<Instruction>) this.myParser.parse().value;
                if (lexer.getErrorsList().isEmpty()) {
                    List<String> executionDescriptions = panelDraw.runInstructions(instructions);
                    addSuccessMessages(executionDescriptions);
                }
            } catch (Exception ex) {
                Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    //return error according to language
    private void errorLanguage(){
        if (Languages.ALL.getTypeLanguage()==true) {
            addMessagesInfo(this.lexerAll.getErrorsList());
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
            addMessagesInfo(this.lexerEn.getErrorsList());
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
            addMessagesInfo(this.lexerSp.getErrorsList());
        }else if (Languages.KICHE.getTypeLanguage()==true) {
            addMessagesInfo(this.lexerKi.getErrorsList());
        }
    }
    public void enableButonsInChallenge(Boolean inputInstruction){
        btnOpenFIle.setEnabled(inputInstruction);
        helpMenu.setEnabled(inputInstruction);
        exportMenu.setEnabled(inputInstruction);
        interactiveMenu.setEnabled(inputInstruction);
        btnCleanAll.setEnabled(inputInstruction);
        btnSaveInstructions.setEnabled(inputInstruction);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bntOpenFile;
    private javax.swing.JMenuItem btnAbout;
    private javax.swing.JButton btnChangeImage;
    private javax.swing.JButton btnCleanAll;
    private javax.swing.JMenuItem btnInstructions;
    private javax.swing.JMenu btnOpenFIle;
    private javax.swing.JButton btnSaveInstructions;
    private javax.swing.JMenuItem btnSaveInstructionsMenuItem;
    private javax.swing.JMenuItem challengeHistoryMEnuItem;
    private javax.swing.JMenuItem changeVarNameMenu;
    private javax.swing.JMenuItem colorItem;
    private javax.swing.JMenu exportMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JEditorPane helpPane;
    private javax.swing.JMenu interactiveMenu;
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
    private javax.swing.JMenuItem lenguageEnglish;
    private javax.swing.JMenuItem lenguageKiche;
    private javax.swing.JMenuItem lenguageSpanish;
    private javax.swing.JMenuItem lenguagesAll;
    private javax.swing.JMenu lenguagesMenu;
    private javax.swing.JFileChooser saveFileChooser;
    private javax.swing.JScrollPane scrollpnl;
    private javax.swing.JMenuItem takeChallengeMenuItem;
    private javax.swing.JTextField txtInstruction;
    private javax.swing.JTextArea txtInstructions;
    private javax.swing.JEditorPane txtMessages;
    // End of variables declaration//GEN-END:variables
}
