/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.koky.ui.challenges;

import com.jgranados.koky.ui.KokyFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
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
import javax.swing.JFileChooser;
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
    private static final String JPG_FILE_EXTENSION = "jpg";
    private static final String JPG__DOT_FILE_EXTENSION = ".jpg";
    private ArrayList<String> challengesList = new ArrayList<>();
    private BufferedImage nuevaImagen = null;
    private String userName;
    private int milliseconds = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    private int totalTimeInSeconds = 0;
    private Boolean state = true;

    public ChallengesFrame(BufferedImage prueba, String inputUserName) {
        initComponents();
        this.nuevaImagen = prueba;
        this.userName = inputUserName;
        initStyleComponents();
        this.setLocationRelativeTo(null);
        importChallenges();
        selectRandomChallenge();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startStopButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        challengeDescriptionTextPane = new javax.swing.JTextPane();
        userTimeLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        millisecondsLabel = new javax.swing.JLabel();
        endChallengeButton = new javax.swing.JButton();
        userNameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Retos | Koky");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("challengesFrame"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        startStopButton.setText("¡Iniciar reto!");
        startStopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startStopButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startStopButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        challengeDescriptionTextPane.setBackground(new java.awt.Color(148, 196, 28));
        jScrollPane2.setViewportView(challengeDescriptionTextPane);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 110, 80));

        userTimeLabel.setText("00 : 00 : 00 : ");
        getContentPane().add(userTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, -1));

        timeLabel.setForeground(new java.awt.Color(0, 0, 0));
        timeLabel.setText("Tu tiempo:");
        getContentPane().add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        millisecondsLabel.setText("0000");
        getContentPane().add(millisecondsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, -1, -1));

        endChallengeButton.setText("¡Listo!");
        endChallengeButton.setEnabled(false);
        endChallengeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endChallengeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(endChallengeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        userNameTextField.setEditable(false);
        userNameTextField.setBackground(new java.awt.Color(148, 196, 28));
        userNameTextField.setForeground(new java.awt.Color(0, 0, 0));
        userNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(userNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 180, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/Challenges.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        state = false;
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void startStopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startStopButtonActionPerformed
        moveToCorner();
        state = true;
        Thread userTimerThread = new Thread() {
            public void run() {
                for (;;) {
                    if (state == true) {
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
                            millisecondsLabel.setText("" + milliseconds);
                            System.out.println(hours + " : " + minutes + " : " + seconds + " : ");
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
        startStopButton.setEnabled(false);
        endChallengeButton.setEnabled(true);
    }//GEN-LAST:event_startStopButtonActionPerformed

    private void endChallengeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endChallengeButtonActionPerformed
        state = false;
        System.out.println("Tiempo final: "+totalTimeInSeconds);
    }//GEN-LAST:event_endChallengeButtonActionPerformed

    public void generateImage() {
        JFileChooser locationFileChooser = new JFileChooser();
        int selection = locationFileChooser.showSaveDialog(null);
        try {
            if (selection == JFileChooser.APPROVE_OPTION) {
                File fileToExport = locationFileChooser.getSelectedFile();
                String filePath = fileToExport.getAbsolutePath();//Obtains the path to use
                try {
                    ImageIO.write(nuevaImagen, JPG_FILE_EXTENSION, fileToExport);
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
        for (int i = 0; i < challengesList.size(); i++) {
            System.out.println(i + " - " + challengesList.get(i));
        }
    }

    private void initStyleComponents() {
        StyledDocument challengeTextPane = challengeDescriptionTextPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        challengeTextPane.setParagraphAttributes(0, challengeTextPane.getLength(), center, false);
        userNameTextField.setText("¡Hola " +userName+"!");
    }

    private void moveToCorner() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - this.getWidth();
        int y = (int) rect.getMaxY() - this.getHeight();
        this.setLocation(x, y);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane challengeDescriptionTextPane;
    private javax.swing.JButton endChallengeButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel millisecondsLabel;
    private javax.swing.JButton startStopButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JLabel userTimeLabel;
    // End of variables declaration//GEN-END:variables
}
