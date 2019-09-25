package com.jgranados.koky.ui;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jesfrin
 */
public class KokyImageDialog extends javax.swing.JDialog {

    private  List<String> SMALL_IMAGES;
    private  List<String> BIG_IMAGES;
    private String imgUrl;
    private PanelDraw panel;

    /**
     * Creates new form KokyImageDialog
     */
    public KokyImageDialog(java.awt.Frame parent, boolean modal, PanelDraw panel) {
        super(parent, modal);
        initComponents();
        this.panel = panel;
        loadLargeAddress();
        loadSmallAddress();
        imgUrl = "/com/jgranados/koky/ui/images/kokyG.png";
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        buttonNext = new javax.swing.JButton();
        buttonPrevious = new javax.swing.JButton();
        buttonAccept = new javax.swing.JButton();
        buttonRandom = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 0));
        setResizable(false);

        jPanel.setBackground(new java.awt.Color(0, 153, 0));
        jPanel.setForeground(new java.awt.Color(51, 255, 51));

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/kokyG.png"))); // NOI18N

        buttonNext.setBackground(new java.awt.Color(255, 255, 255));
        buttonNext.setForeground(new java.awt.Color(0, 153, 0));
        buttonNext.setText("Siguiente");
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });

        buttonPrevious.setBackground(new java.awt.Color(255, 255, 255));
        buttonPrevious.setForeground(new java.awt.Color(0, 153, 0));
        buttonPrevious.setText("Anterior");
        buttonPrevious.setPreferredSize(new java.awt.Dimension(92, 27));
        buttonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreviousActionPerformed(evt);
            }
        });

        buttonAccept.setBackground(new java.awt.Color(255, 255, 255));
        buttonAccept.setForeground(new java.awt.Color(0, 153, 0));
        buttonAccept.setText("Aceptar");
        buttonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAcceptActionPerformed(evt);
            }
        });

        buttonRandom.setBackground(new java.awt.Color(255, 255, 255));
        buttonRandom.setForeground(new java.awt.Color(0, 153, 0));
        buttonRandom.setText("Aleatorio");
        buttonRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRandomActionPerformed(evt);
            }
        });

        buttonCancel.setBackground(new java.awt.Color(255, 255, 255));
        buttonCancel.setForeground(new java.awt.Color(0, 153, 0));
        buttonCancel.setText("Cancelar");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(buttonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonNext))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonRandom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAccept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonNext)))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(buttonAccept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonRandom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonCancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreviousActionPerformed
        seePreviousImage();
    }//GEN-LAST:event_buttonPreviousActionPerformed

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
        seeNextImage();
    }//GEN-LAST:event_buttonNextActionPerformed

    private void buttonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcceptActionPerformed
        int imagePosition = BIG_IMAGES.indexOf(imgUrl);
        try {
            this.panel.changeImage(SMALL_IMAGES.get(imagePosition));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen");
            Logger.getLogger(KokyImageDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_buttonAcceptActionPerformed

    private void buttonRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRandomActionPerformed
        int numero = (int) (Math.random() * 6);
        try {
            this.panel.changeImage(SMALL_IMAGES.get(numero));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen");
            Logger.getLogger(KokyImageDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_buttonRandomActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAccept;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton buttonPrevious;
    private javax.swing.JButton buttonRandom;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel lblImage;
    // End of variables declaration//GEN-END:variables

    private void seePreviousImage() {
        int imagePosition = BIG_IMAGES.indexOf(imgUrl);
        if (imagePosition == 0) {
            imagePosition = BIG_IMAGES.size() - 1;
        } else {
            imagePosition--;
        }
        this.imgUrl = BIG_IMAGES.get(imagePosition);
        this.lblImage.setIcon(new ImageIcon(getClass().getResource(BIG_IMAGES.get(imagePosition))));
    }

    private void seeNextImage() {
        int imagePosition = BIG_IMAGES.indexOf(imgUrl);
        if (imagePosition == (BIG_IMAGES.size() - 1)) {
            imagePosition = 0;
        } else {
            imagePosition++;
        }
        this.imgUrl = BIG_IMAGES.get(imagePosition);
        this.lblImage.setIcon(new ImageIcon(getClass().getResource(BIG_IMAGES.get(imagePosition))));
    }

    private void loadLargeAddress() {
        this.BIG_IMAGES = new LinkedList<>();
        BIG_IMAGES.add("/com/jgranados/koky/ui/images/kokyG.png");
        BIG_IMAGES.add("/com/jgranados/koky/ui/images/tortuga1G.png");
        BIG_IMAGES.add("/com/jgranados/koky/ui/images/tortuga2G.png");
        BIG_IMAGES.add("/com/jgranados/koky/ui/images/tortuga3G.png");
        BIG_IMAGES.add("/com/jgranados/koky/ui/images/tortuga4G.png");
        BIG_IMAGES.add("/com/jgranados/koky/ui/images/tortuga5G.png");
        BIG_IMAGES.add("/com/jgranados/koky/ui/images/tortuga6G.png");
    }

    private void loadSmallAddress() {
        SMALL_IMAGES = new LinkedList<>();
        SMALL_IMAGES.add("/com/jgranados/koky/ui/images/kok_pointer_32.png");
        SMALL_IMAGES.add("/com/jgranados/koky/ui/images/tortuga1.png");
        SMALL_IMAGES.add("/com/jgranados/koky/ui/images/tortuga2.png");
        SMALL_IMAGES.add("/com/jgranados/koky/ui/images/tortuga3.png");
        SMALL_IMAGES.add("/com/jgranados/koky/ui/images/tortuga4.png");
        SMALL_IMAGES.add("/com/jgranados/koky/ui/images/tortuga5.png");
        SMALL_IMAGES.add("/com/jgranados/koky/ui/images/tortuga6.png");
    }

}
