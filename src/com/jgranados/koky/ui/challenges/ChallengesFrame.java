package com.jgranados.koky.ui.challenges;

import com.jgranados.koky.challengeshistory.HistoryHandler;
import com.jgranados.koky.ui.KokyFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author jonycr
 */
public class ChallengesFrame extends javax.swing.JFrame {

    /**
     * Creates new form ChallengesFrame
     */
    private static final String CHALLENGES_FILE = "src/com/jgranados/koky/challengesfiles/Challenges.txt";
    private static final String ICON_URL = "src/com/jgranados/koky/ui/images/kok_pointer.png";
    private static final String CHALLENGES_URL = "ImagenesRetos/";
    private static final String JPG_FILE_EXTENSION = "jpg";
    private static final String JPG__DOT_FILE_EXTENSION = ".jpg";
    private ArrayList<String> challengesList = new ArrayList<>();
    private String userName;
    private int milliseconds = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    private int totalTimeInSeconds = 0;
    private int instructionAttempts = 0;
    private String timeString = "";
    private Boolean chronometerState = true;
    private Boolean coutingInstructions;
    private KokyFrame koyFrame;
    private HistoryHandler historyHandler;
    private BufferedImage userDraw;

    public ChallengesFrame(BufferedImage prueba, String inputUserName, int numberOfIntructions, boolean instructionsNumber, KokyFrame inputKokyFrame, HistoryHandler inputHandler) {
        initComponents();
        this.userDraw = prueba;
        this.userName = inputUserName;
        this.koyFrame = inputKokyFrame;
        this.instructionAttempts = numberOfIntructions;
        this.coutingInstructions = instructionsNumber;
        this.historyHandler = inputHandler;
        initStyleComponents();
        this.setLocationRelativeTo(null);
        importChallenges();
        selectRandomChallenge();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            //With this method we can set up what we want this frame do before close it.
            public void windowClosing(WindowEvent windowEvent) {
                if (startButton.isEnabled()) {
                    //If user haven't start the challenge it can be closed normally.
                    JOptionPane.showMessageDialog(windowEvent.getWindow(), "¡Reto cancelado! Puedes continuar dibujando.", "Salir de reto", JOptionPane.INFORMATION_MESSAGE);
                    koyFrame.enableButonsInChallenge(true);
                    windowEvent.getWindow().dispose();
                } else {
                    //If user is already in a challenge, program ask for confirmation.
                    int userElection = JOptionPane.showConfirmDialog(null, "¿Esta seguro que deseas cancelar el reto? Los cambios no se guardarán si lo haces.", "Cerrar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (userElection == JOptionPane.YES_OPTION) {
                        chronometerState = false;
                        koyFrame.cleanInstructionsMadeList();
                        koyFrame.enableButonsInChallenge(true);
                        windowEvent.getWindow().dispose();
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        challengeDescriptionTextPane = new javax.swing.JTextPane();
        userTimeLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        millisecondsLabel = new javax.swing.JLabel();
        endChallengeButton = new javax.swing.JButton();
        yourChallengeIsLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        framWallpaperLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Retos | Koky");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("challengesFrame"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        startButton.setText("¡Iniciar reto!");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        challengeDescriptionTextPane.setEditable(false);
        challengeDescriptionTextPane.setBackground(new java.awt.Color(148, 196, 28));
        jScrollPane2.setViewportView(challengeDescriptionTextPane);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 110, 80));

        userTimeLabel.setText("00 : 00 : 00 : ");
        getContentPane().add(userTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        timeLabel.setForeground(new java.awt.Color(0, 0, 0));
        timeLabel.setText("Tu tiempo:");
        getContentPane().add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        millisecondsLabel.setText("0000");
        getContentPane().add(millisecondsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, -1));

        endChallengeButton.setText("¡Listo!");
        endChallengeButton.setEnabled(false);
        endChallengeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endChallengeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(endChallengeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        yourChallengeIsLabel.setForeground(new java.awt.Color(0, 0, 0));
        yourChallengeIsLabel.setText("Tu reto es:");
        getContentPane().add(yourChallengeIsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        userNameTextField.setEditable(false);
        userNameTextField.setBackground(new java.awt.Color(148, 196, 28));
        userNameTextField.setForeground(new java.awt.Color(0, 0, 0));
        userNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(userNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 180, -1));

        framWallpaperLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/Challenges.png"))); // NOI18N
        getContentPane().add(framWallpaperLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        int yesOrNoMessage = JOptionPane.YES_NO_OPTION;
        int userElection = JOptionPane.showConfirmDialog(this, "¿Deseas abandonar el reto?", "Retos | Koky", yesOrNoMessage);
        if (userElection == 0) {
            chronometerState = false;
            koyFrame.cleanInstructionsMadeList();
            koyFrame.enableButonsInChallenge(true);
            this.dispose();
        } else {
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        koyFrame.cleanAll();
        koyFrame.cleanInstructionsMadeList();
        moveToCorner();
        chronometerState = true;
        Thread userTimerThread = new Thread() {
            public void run() {
                for (;;) {
                    if (chronometerState == true) {
                        try {
                            sleep(1);
                            if (milliseconds >= 1000) {
                                milliseconds = 0;
                                seconds++;
                                totalTimeInSeconds++;
                            }
                            if (seconds >= 60) {
                                milliseconds = 0;
                                seconds = 0;
                                minutes++;
                            }
                            if (minutes >= 60) {
                                milliseconds = 0;
                                seconds = 0;
                                minutes = 0;
                                hours++;
                            }
                            userTimeLabel.setText(hours + " : " + minutes + " : " + seconds + " : ");
                            timeString = hours + " : " + minutes + " : " + seconds + " : ";
                            millisecondsLabel.setText("" + milliseconds);
                            milliseconds++;
                        } catch (Exception e) {
                        }
                    } else {
                        break;
                    }
                }
            }
        };
        userTimerThread.start();
        startButton.setEnabled(false);
        endChallengeButton.setEnabled(true);
    }//GEN-LAST:event_startButtonActionPerformed

    private void endChallengeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endChallengeButtonActionPerformed
        File imagesCarpet = new File(CHALLENGES_URL);
        if (!imagesCarpet.exists()) {
            imagesCarpet.mkdir();
        }
        chronometerState = false;
        ImageIcon icon = new ImageIcon(ICON_URL);
        JOptionPane.showMessageDialog(null, "¡Excelente trabajo!", "Reto completado.", JOptionPane.DEFAULT_OPTION, icon);
        String imageIdentifier = generateIdentifier(userName, totalTimeInSeconds, milliseconds, koyFrame.returnTotalAttempts());
        try {
            historyHandler.addChallengeRegistry(userName, totalTimeInSeconds, koyFrame.returnTotalAttempts(), imageIdentifier, challengeDescriptionTextPane.getText(), koyFrame.returnComandsList());
            File outputFile = new File(CHALLENGES_URL + imageIdentifier);
            ImageIO.write(userDraw, JPG_FILE_EXTENSION, outputFile);
            koyFrame.cleanInstructionsMadeList();
        } catch (IOException ex) {
            Logger.getLogger(ChallengesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        coutingInstructions = false;
        instructionAttempts = 0;
        koyFrame.enableButonsInChallenge(true);
        this.dispose();
    }//GEN-LAST:event_endChallengeButtonActionPerformed

    public String generateIdentifier(String user, int seconds, int instructions, int milliseconds) {
        String newIdentifier = "";
        newIdentifier = user + "_" + seconds + "_" + milliseconds + "_" + instructions + JPG__DOT_FILE_EXTENSION;
        return newIdentifier;
    }

    private void importChallenges() {
        challengesList.clear();
        File challengesTxtFile = new File(CHALLENGES_FILE);
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(challengesTxtFile))) {
                String textLine = reader.readLine();
                while (textLine != null) {
                    challengesList.add(textLine);
                    textLine = reader.readLine();
                }
                reader.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChallengesFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChallengesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void selectRandomChallenge() {
        int intervalNumber = challengesList.size() - 1;
        int challengeNumber = (int) (Math.random() * intervalNumber) + 1;
        challengeDescriptionTextPane.setText(challengesList.get(challengeNumber));
    }

    private void initStyleComponents() {
        StyledDocument challengeTextPane = challengeDescriptionTextPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        challengeTextPane.setParagraphAttributes(0, challengeTextPane.getLength(), center, false);
        userNameTextField.setText("¡Hola " + userName + "!");
    }

    private void moveToCorner() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - this.getWidth();
        int y = (int) rect.getMaxY() - this.getHeight();
        this.setLocation(x, y);
    }

    public int obtainChallengeTime() {
        return totalTimeInSeconds;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane challengeDescriptionTextPane;
    private javax.swing.JButton endChallengeButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel framWallpaperLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel millisecondsLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JLabel userTimeLabel;
    private javax.swing.JLabel yourChallengeIsLabel;
    // End of variables declaration//GEN-END:variables
}
