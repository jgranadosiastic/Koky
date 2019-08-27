package com.jgranados.koky.ui.challenges;

import com.jgranados.koky.challengeshistory.ChallengeRegistry;
import com.jgranados.koky.challengeshistory.HistoryHandler;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jonycr
 */
public class ChallengesHistory extends javax.swing.JFrame implements Serializable {

    /**
     * Creates new form ChallengesHistory
     */
    private static final String CHALLENGES_URL = "ImagenesRetos/";
    private HistoryHandler challengesHistoryHandler;

    public ChallengesHistory(HistoryHandler inputHistoryHandler) throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.challengesHistoryHandler = inputHistoryHandler;
        this.challengesHistoryHandler.uploadHistoryData();
        addRowToTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        challengeRegistryTable = new javax.swing.JTable();
        instructionsQCLabel = new javax.swing.JLabel();
        instructionsENLabel = new javax.swing.JLabel();
        intructionsESLabel = new javax.swing.JLabel();
        selectedImageLabel = new javax.swing.JLabel();
        turtleImageLabel = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial de Retos | Koky");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        challengeRegistryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Tiempo", "Intrucciones", "Imagen", "Reto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        challengeRegistryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                challengeRegistryTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(challengeRegistryTable);
        if (challengeRegistryTable.getColumnModel().getColumnCount() > 0) {
            challengeRegistryTable.getColumnModel().getColumn(0).setResizable(false);
            challengeRegistryTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            challengeRegistryTable.getColumnModel().getColumn(1).setResizable(false);
            challengeRegistryTable.getColumnModel().getColumn(2).setResizable(false);
            challengeRegistryTable.getColumnModel().getColumn(2).setPreferredWidth(60);
            challengeRegistryTable.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 540, 230));

        instructionsQCLabel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        instructionsQCLabel.setForeground(new java.awt.Color(0, 0, 0));
        instructionsQCLabel.setText("Ri ch'ojib'al chawe are' !!");
        getContentPane().add(instructionsQCLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, -1, -1));

        instructionsENLabel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        instructionsENLabel.setForeground(new java.awt.Color(0, 0, 0));
        instructionsENLabel.setText("Select in table to see the image created!");
        getContentPane().add(instructionsENLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        intructionsESLabel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        intructionsESLabel.setForeground(new java.awt.Color(0, 0, 0));
        intructionsESLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        intructionsESLabel.setText("¡Selecciona uno en la tabla para ver la imagen !");
        intructionsESLabel.setFocusable(false);
        getContentPane().add(intructionsESLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 240, 20));

        selectedImageLabel.setBackground(new java.awt.Color(255, 255, 255));
        selectedImageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(selectedImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 550, 260));

        turtleImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/Challenges2.png"))); // NOI18N
        getContentPane().add(turtleImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 278, 398, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void challengeRegistryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_challengeRegistryTableMouseClicked
        int index = challengeRegistryTable.getSelectedRow();
        TableModel model = challengeRegistryTable.getModel();
        String imageName = model.getValueAt(index, 3).toString();
        String path = CHALLENGES_URL+imageName;
        ImageIcon icono = new ImageIcon(path);
        Image img = icono.getImage().getScaledInstance(selectedImageLabel.getWidth(), selectedImageLabel.getHeight(), Image.SCALE_SMOOTH);
        selectedImageLabel.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_challengeRegistryTableMouseClicked

    public void addRowToTable() {
        DefaultTableModel model = (DefaultTableModel) challengeRegistryTable.getModel();
        List<ChallengeRegistry> challengesList = challengesHistoryHandler.returnAllRegistrys();
        Object rowData[] = new Object[5];
        for (int i = 0; i < challengesList.size(); i++) {
            rowData[0] = challengesList.get(i).getUserName();
            rowData[1] = generateTime(challengesList.get(i).getTotalSeconds());
            rowData[2] = challengesList.get(i).getTotalInstructions();
            rowData[3] = challengesList.get(i).getIdentifierRegistry();
            rowData[4] = challengesList.get(i).getChallengeDescription();
            model.addRow(rowData);
        }
    }
    
    public String generateTime(int inputSeconds){
        int hours=inputSeconds/3600;
        int minutes=(inputSeconds-(3600*hours))/60;
        int seconds=inputSeconds-((hours*3600)+(minutes*60));
        String strTime = hours+"h "+minutes+"m "+seconds+"s";
        return strTime;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable challengeRegistryTable;
    private javax.swing.JLabel instructionsENLabel;
    private javax.swing.JLabel instructionsQCLabel;
    private javax.swing.JLabel intructionsESLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel selectedImageLabel;
    private javax.swing.JLabel turtleImageLabel;
    // End of variables declaration//GEN-END:variables
}
