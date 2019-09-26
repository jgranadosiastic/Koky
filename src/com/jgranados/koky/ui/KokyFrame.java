package com.jgranados.koky.ui;

import com.jgranados.koky.challengeshistory.HistoryHandler;

import com.jgranados.koky.instructions.graphicinstructions.TranslationUtils;
import com.jgranados.koky.instructions.logic.Languages;
import com.jgranados.koky.instructions.logic.Messages;
import com.jgranados.koky.ui.challenges.ChallengesFrame;
import com.jgranados.koky.ui.challenges.ChallengesHistory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jose
 */
public class KokyFrame extends KFrame {

    private static final String ICON_URL = "/com/jgranados/koky/ui/images/kok_pointer.png";
    private static final String CHALLENGE_BUTTON = "challengeButton";
    private static final String CLEAN_ALL_BUTTON = "cleanAllButton";
    private static final int NUM_SUBSTRING = 2;
    private PanelDraw panelDraw;
    private String lastInput;
    private ArrayList<String> historyInput = new ArrayList<>();
    private int history = 0;
    private int instructionsMade = 0;
    private ArrayList<String> instructionsMadeList = new ArrayList<>();
    private Boolean makingChallenge = false;
    private HistoryHandler challengeHistoryHandler = new HistoryHandler();
    private DrawingInstruction draw;

    public KokyFrame() {
        super(false);
        panelDraw = new PanelDraw();
        initComponents();
        languageLabel.setText(super.language.name());
        txtInstruction.requestFocusInWindow();
        this.getContentPane().setBackground(new java.awt.Color(0, 153, 0));
        this.saveFileChooser.setFileFilter(new FileNameExtensionFilter(KOK_EXTENSION_DESC, KOK_EXTENSION));
        this.draw = new DrawingInstruction(this);
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
        txtMessages = super.getEditorPane();
        scrollpnl = new javax.swing.JScrollPane();
        scrollpnl.setViewportView(panelDraw);
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        helpPane = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        btnCleanAll = new javax.swing.JButton();
        btnSaveInstructions = new javax.swing.JButton();
        btnChangeImage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        languageLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnOpenFile = new javax.swing.JMenu();
        btnSaveInstructionsMenuItem = new javax.swing.JMenuItem();
        btnOpenEditor = new javax.swing.JMenuItem();
        btnClose = new javax.swing.JMenuItem();
        lenguagesMenu = new javax.swing.JMenu();
        lenguagesAll = new javax.swing.JMenuItem();
        lenguageEnglish = new javax.swing.JMenuItem();
        lenguageSpanish = new javax.swing.JMenuItem();
        lenguageKiche = new javax.swing.JMenuItem();
        exportMenu = new javax.swing.JMenu();
        changeVarNameMenu = new javax.swing.JMenuItem();
        changeSizeButton = new javax.swing.JMenuItem();
        interactiveMenu = new javax.swing.JMenu();
        takeChallengeMenuItem = new javax.swing.JMenuItem();
        challengeHistoryMEnuItem = new javax.swing.JMenuItem();
        drawingMenu = new javax.swing.JMenu();
        squareMenuItem = new javax.swing.JMenuItem();
        triangleMenuItem = new javax.swing.JMenuItem();
        circleMenuItem = new javax.swing.JMenuItem();
        pentagonMenuItem = new javax.swing.JMenuItem();
        starMenuItem = new javax.swing.JMenuItem();
        cubeMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        btnInstructions = new javax.swing.JMenuItem();
        colorItem = new javax.swing.JMenuItem();
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
        txtInstruction.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtInstructionKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
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
        scrollpnl.setPreferredSize(new Dimension(PanelDraw.DEFAULT_WIDTH, PanelDraw.DEFAULT_HEIGHT));

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

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Lenguaje:");

        languageLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCleanAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnChangeImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSaveInstructions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(languageLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnCleanAll, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChangeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(languageLabel))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(153, 51, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(114, 35));

        btnOpenFile.setForeground(new java.awt.Color(255, 255, 255));
        btnOpenFile.setText("Archivo");

        btnSaveInstructionsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        btnSaveInstructionsMenuItem.setText("Guardar Instrucciones");
        btnSaveInstructionsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveInstructionsMenuItemActionPerformed(evt);
            }
        });
        btnOpenFile.add(btnSaveInstructionsMenuItem);

        btnOpenEditor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        btnOpenEditor.setText("Abrir el Editor de Texto");
        btnOpenEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenEditorActionPerformed(evt);
            }
        });
        btnOpenFile.add(btnOpenEditor);

        btnClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        btnClose.setText("Salir");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        btnOpenFile.add(btnClose);

        jMenuBar1.add(btnOpenFile);

        lenguagesMenu.setForeground(new java.awt.Color(255, 255, 255));
        lenguagesMenu.setText("Idiomas");
        lenguagesMenu.setToolTipText("");

        lenguagesAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        lenguagesAll.setText("Todos");
        lenguagesAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lenguagesAllActionPerformed(evt);
            }
        });
        lenguagesMenu.add(lenguagesAll);

        lenguageEnglish.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        lenguageEnglish.setText("Ingles");
        lenguageEnglish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lenguageEnglishActionPerformed(evt);
            }
        });
        lenguagesMenu.add(lenguageEnglish);

        lenguageSpanish.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        lenguageSpanish.setText("Español");
        lenguageSpanish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lenguageSpanishActionPerformed(evt);
            }
        });
        lenguagesMenu.add(lenguageSpanish);

        lenguageKiche.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        lenguageKiche.setText("Kiche");
        lenguageKiche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lenguageKicheActionPerformed(evt);
            }
        });
        lenguagesMenu.add(lenguageKiche);

        jMenuBar1.add(lenguagesMenu);

        exportMenu.setForeground(new java.awt.Color(255, 255, 255));
        exportMenu.setText("Imagen");

        changeVarNameMenu.setText("Guardar Imagen");
        changeVarNameMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeVarNameMenuActionPerformed(evt);
            }
        });
        exportMenu.add(changeVarNameMenu);

        changeSizeButton.setText("Cambiar tamaño Imagen");
        changeSizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSizeButtonActionPerformed(evt);
            }
        });
        exportMenu.add(changeSizeButton);

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

        drawingMenu.setText("Dibujos predefinidos");

        squareMenuItem.setText("Cuadrado");
        squareMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squareMenuItemActionPerformed(evt);
            }
        });
        drawingMenu.add(squareMenuItem);

        triangleMenuItem.setText("Triangulo");
        triangleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangleMenuItemActionPerformed(evt);
            }
        });
        drawingMenu.add(triangleMenuItem);

        circleMenuItem.setText("Circulo");
        circleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circleMenuItemActionPerformed(evt);
            }
        });
        drawingMenu.add(circleMenuItem);

        pentagonMenuItem.setText("Pentagono");
        pentagonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pentagonMenuItemActionPerformed(evt);
            }
        });
        drawingMenu.add(pentagonMenuItem);

        starMenuItem.setText("Estrella");
        starMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                starMenuItemActionPerformed(evt);
            }
        });
        drawingMenu.add(starMenuItem);

        cubeMenuItem.setText("Cubo");
        cubeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cubeMenuItemActionPerformed(evt);
            }
        });
        drawingMenu.add(cubeMenuItem);

        interactiveMenu.add(drawingMenu);

        jMenuBar1.add(interactiveMenu);

        helpMenu.setForeground(new java.awt.Color(255, 255, 255));
        helpMenu.setText("Ayuda");

        btnInstructions.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        btnInstructions.setText("Instrucciones");
        btnInstructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstructionsActionPerformed(evt);
            }
        });
        helpMenu.add(btnInstructions);

        colorItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        colorItem.setText("Consultar color");
        colorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorItemActionPerformed(evt);
            }
        });
        helpMenu.add(colorItem);

        btnAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        btnAbout.setText("Acerca de...");
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });
        helpMenu.add(btnAbout);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(scrollpnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
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
                            .addComponent(scrollpnl, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
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
        cleanAll(CLEAN_ALL_BUTTON);
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

    //Metodo para parsear
    public void run(String input) {
        parseInstruction(input, this.panelDraw);
        this.txtInstructions.append(input + LINE);
        this.txtInstruction.setText("");
        errorLanguage();
        historyInput.add(input);
        history = historyInput.size();
        lastInput = "";
        if (makingChallenge) {
            instructionsMade++;
            instructionsMadeList.add(input);
        }
    }

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
            try {
                Transferable t = systemCopy.getContents(null);
                if (t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    txtInstruction.setText(txtInstruction.getText() + t.getTransferData(DataFlavor.stringFlavor));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_colorItemActionPerformed
    private void changeVarNameMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeVarNameMenuActionPerformed
        generateImage();
    }//GEN-LAST:event_changeVarNameMenuActionPerformed


    private void btnOpenEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenEditorActionPerformed
        new EditorFrame(this);
    }//GEN-LAST:event_btnOpenEditorActionPerformed

    private void takeChallengeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeChallengeMenuItemActionPerformed
        int yesOrNoMessage = JOptionPane.YES_NO_OPTION;
        int userElection = JOptionPane.showConfirmDialog(this, "Todos tus cambios actuales se van a borrar ¿Deseas continuar?", "Retos | Koky", yesOrNoMessage);
        if (userElection == 0) {
            cleanAll(CHALLENGE_BUTTON);
            String userName = JOptionPane.showInputDialog(this, "¿Cuál es tu nombre?", "Ingresa un nombre de usuario", JOptionPane.INFORMATION_MESSAGE);
            if (userName == null) {
            } else if (userName.equals("")) {
                ChallengesFrame challengesFrame = new ChallengesFrame(panelDraw.returnDraw(), "Amigo", instructionsMade, this.makingChallenge, this, challengeHistoryHandler);
                challengesFrame.setVisible(true);
                makingChallenge = true;
                enableButonsInChallenge(false);
            } else {
                ChallengesFrame challengesFrame = new ChallengesFrame(panelDraw.returnDraw(), userName, instructionsMade, this.makingChallenge, this, challengeHistoryHandler);
                challengesFrame.setVisible(true);
                makingChallenge = true;
                enableButonsInChallenge(false);
            }
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
        selectLanguageAll();
        languageLabel.setText(super.language.name());
        addMessageInfo(Messages.changeMessage());
    }//GEN-LAST:event_lenguagesAllActionPerformed

    private void lenguageEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenguageEnglishActionPerformed
        selectLanguageEnglish();
        languageLabel.setText(super.language.name());
        addMessageInfo(Messages.changeMessage());
    }//GEN-LAST:event_lenguageEnglishActionPerformed

    private void lenguageSpanishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenguageSpanishActionPerformed
        selectLanguageSpanish();
        languageLabel.setText(super.language.name());
        addMessageInfo(Messages.changeMessage());
    }//GEN-LAST:event_lenguageSpanishActionPerformed

    private void lenguageKicheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenguageKicheActionPerformed
        selectLanguageKiche();
        languageLabel.setText(super.language.name());
        addMessageInfo(Messages.changeMessage());
    }//GEN-LAST:event_lenguageKicheActionPerformed

    private void changeSizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSizeButtonActionPerformed
        int answer = JOptionPane.showConfirmDialog(null, "    ¿Esta seguro?\nSe borrar la pantalla", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            List<String> inputs = JOptionPaneMultiInput.getMultiInput(
                    new String[]{TranslationUtils.PLAIN_TEXT_WIDTH, TranslationUtils.PLAIN_TEXT_HEIGHT});
            int width = 0;
            int height = 0;
            try {
                width = Integer.parseInt(inputs.get(0));
                height = Integer.parseInt(inputs.get(1));
                if (width < PanelDraw.MINIMUN_WIDTH || height < PanelDraw.MINIMUN_HEIGHT) {
                    JOptionPane.showMessageDialog(
                            this, "Parametro(s) menor(es) a los minimos. Se ha limitado el tamaño a (" + PanelDraw.MINIMUN_WIDTH + " x "
                            + PanelDraw.MINIMUN_HEIGHT + ")");
                }
                JViewport viewport = (JViewport) scrollpnl.getViewport();
                viewport.remove(panelDraw);
                panelDraw = new PanelDraw(width, height);
                viewport.add(panelDraw);
                repaint();
            } catch (NullPointerException e1) {
                JOptionPane.showMessageDialog(
                        this, "Campos incompletos. Intentalo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e2) {
                JOptionPane.showMessageDialog(this, "Ingresar numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_changeSizeButtonActionPerformed
    private void squareMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareMenuItemActionPerformed
        if (Languages.SPANISH.getTypeLanguage() || Languages.ALL.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.SQUARE_INSTRUCTION_SPANISH);
        } else if (Languages.ENGLISH.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.SQUARE_INSTRUCTION_ENGLISH);
        } else if (Languages.KICHE.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.SQUARE_INSTRUCTION_QUICHE);
        }
    }//GEN-LAST:event_squareMenuItemActionPerformed

    private void triangleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangleMenuItemActionPerformed
        if (Languages.SPANISH.getTypeLanguage() || Languages.ALL.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.TRIANGLE_ISTRUCTION_SPANISH);
        } else if (Languages.ENGLISH.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.TRIANGLE_INSTRUCTION_ENGLISH);
        } else if (Languages.KICHE.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.TRIANGLE_INSTRUCTION_QUICHE);
        }
    }//GEN-LAST:event_triangleMenuItemActionPerformed

    private void circleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circleMenuItemActionPerformed
        if (Languages.SPANISH.getTypeLanguage() || Languages.ALL.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.CIRCLE_INSTRUCTION_SPANISH);
        } else if (Languages.ENGLISH.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.CIRCLE_INSTRUCTION_ENGLISH);
        } else if (Languages.KICHE.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.CIRCLE_INSTRUCTION_QUICHE);
        }
    }//GEN-LAST:event_circleMenuItemActionPerformed

    private void pentagonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pentagonMenuItemActionPerformed
        if (Languages.SPANISH.getTypeLanguage() || Languages.ALL.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.PENTAGON_INSTRUCTION_SPANISH);
        } else if (Languages.ENGLISH.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.PENTAGON_INSTRUCTION_ENGLISH);
        } else if (Languages.KICHE.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.PENTAGON_INSTRUCTION_QUICHE);
        }
    }//GEN-LAST:event_pentagonMenuItemActionPerformed

    private void starMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_starMenuItemActionPerformed
        if (Languages.SPANISH.getTypeLanguage() || Languages.ALL.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.STAR_INSTRUCTION_SPANISH);
        } else if (Languages.ENGLISH.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.STAR_INSTRUCTION_ENGLISH);
        } else if (Languages.KICHE.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.STAR_INSTRUCTION_QUICHE);
        }     }//GEN-LAST:event_starMenuItemActionPerformed

    private void cubeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cubeMenuItemActionPerformed
        if (Languages.SPANISH.getTypeLanguage() || Languages.ALL.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.CUBE_INSTRUCTION_SPANISH);
        } else if (Languages.ENGLISH.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.CUBE_INSTRUCTION_ENGLISH);
        } else if (Languages.KICHE.getTypeLanguage()) {
            this.draw.drawingInstruction(DrawingInstruction.CUBE_INSTRUCTION_QUICHE);
        }
    }//GEN-LAST:event_cubeMenuItemActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnInstructionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstructionsActionPerformed
        openInstructions();
    }//GEN-LAST:event_btnInstructionsActionPerformed

    public String getCurrentLine() {
        return txtInstruction.getText();
    }

    public int returnTotalAttempts() {
        return instructionsMade;
    }

    public ArrayList<String> returnComandsList() {
        return this.instructionsMadeList;
    }

    public void cleanInstructionsMadeList() {
        this.instructionsMadeList.clear();
    }

    public void cleanAll(String buttonActioned) {
        parseInstruction(returnCleanLenguage(), this.panelDraw);
        txtInstructions.setText("");
        txtInstruction.setText("");
        txtMessages.setText("<p style=\"margin-top: 0\"></p>");
        instructionsSymTable.cleanAll();
        instructionsSymProcedureTable.cleanAll();
        if (buttonActioned.equals(CHALLENGE_BUTTON)) {
            instructionsMade = 0;
        }
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

    public PanelDraw getPanelDraw() {
        return this.panelDraw;
    }

    public String saveInstructionsToFile() {
        return saveInstructionsToFile(txtInstructions.getText());
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

    public void enableButonsInChallenge(Boolean inputInstruction) {
        btnOpenFile.setEnabled(inputInstruction);
        helpMenu.setEnabled(inputInstruction);
        exportMenu.setEnabled(inputInstruction);
        interactiveMenu.setEnabled(inputInstruction);
        btnCleanAll.setEnabled(inputInstruction);
        btnSaveInstructions.setEnabled(inputInstruction);
        lenguagesMenu.setEnabled(inputInstruction);
    }

    public File openFile() {
        int status = saveFileChooser.showOpenDialog(this);
        if (status == JFileChooser.APPROVE_OPTION) {
            File file = saveFileChooser.getSelectedFile();
            return file;
        }
        return null;
    }

    public JTextArea getTxtInstructions() {
        return txtInstructions;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAbout;
    private javax.swing.JButton btnChangeImage;
    private javax.swing.JButton btnCleanAll;
    private javax.swing.JMenuItem btnClose;
    private javax.swing.JMenuItem btnInstructions;
    private javax.swing.JMenuItem btnOpenEditor;
    private javax.swing.JMenu btnOpenFile;
    private javax.swing.JButton btnSaveInstructions;
    private javax.swing.JMenuItem btnSaveInstructionsMenuItem;
    private javax.swing.JMenuItem challengeHistoryMEnuItem;
    private javax.swing.JMenuItem changeSizeButton;
    private javax.swing.JMenuItem changeVarNameMenu;
    private javax.swing.JMenuItem circleMenuItem;
    private javax.swing.JMenuItem colorItem;
    private javax.swing.JMenuItem cubeMenuItem;
    private javax.swing.JMenu drawingMenu;
    private javax.swing.JMenu exportMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JEditorPane helpPane;
    private javax.swing.JMenu interactiveMenu;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel languageLabel;
    private javax.swing.JMenuItem lenguageEnglish;
    private javax.swing.JMenuItem lenguageKiche;
    private javax.swing.JMenuItem lenguageSpanish;
    private javax.swing.JMenuItem lenguagesAll;
    private javax.swing.JMenu lenguagesMenu;
    private javax.swing.JMenuItem pentagonMenuItem;
    private javax.swing.JFileChooser saveFileChooser;
    private javax.swing.JScrollPane scrollpnl;
    private javax.swing.JMenuItem squareMenuItem;
    private javax.swing.JMenuItem starMenuItem;
    private javax.swing.JMenuItem takeChallengeMenuItem;
    private javax.swing.JMenuItem triangleMenuItem;
    private javax.swing.JTextField txtInstruction;
    private javax.swing.JTextArea txtInstructions;
    private javax.swing.JEditorPane txtMessages;
    // End of variables declaration//GEN-END:variables
}
