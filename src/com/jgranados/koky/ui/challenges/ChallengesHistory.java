package com.jgranados.koky.ui.challenges;

import com.jgranados.koky.challengeshistory.ChallengeRegistry;
import com.jgranados.koky.challengeshistory.HistoryHandler;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

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
    private ObservableList<ChallengeRegistry> challengesObsList;
    private List<ChallengeRegistry> challengesList;
    private ChallengeRegistry challengeSelected;

    public ChallengesHistory(HistoryHandler inputHistoryHandler) throws IOException {
        challengesList = new ArrayList<>();
        challengesObsList = ObservableCollections.observableList(challengesList);
        challengeSelected = new ChallengeRegistry();
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.challengesHistoryHandler = inputHistoryHandler;
        this.challengesHistoryHandler.uploadHistoryData();
        TextLineNumber lineNumber = new TextLineNumber(ComandsTextArea);
        ComandsScrollPane.setRowHeaderView(lineNumber);
        showChallengesListTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        ChallengesTableScrollPane = new javax.swing.JScrollPane();
        challengeRegistryTable = new javax.swing.JTable();
        timeTitleLabel = new javax.swing.JLabel();
        ShowFormatedTimeLabel = new javax.swing.JLabel();
        instructionsQCLabel = new javax.swing.JLabel();
        instructionsENLabel = new javax.swing.JLabel();
        intructionsESLabel = new javax.swing.JLabel();
        selectedImageLabel = new javax.swing.JLabel();
        turtleImageLabel = new javax.swing.JLabel();
        ComandsScrollPane = new javax.swing.JScrollPane();
        ComandsTextArea = new javax.swing.JTextArea();
        challengeTitleLabel = new javax.swing.JLabel();
        ChallengeDescriptionTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial de Retos | Koky");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${challengesList}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, challengeRegistryTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${userName}"));
        columnBinding.setColumnName("User Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalInstructions}"));
        columnBinding.setColumnName("Total Instructions");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalSeconds}"));
        columnBinding.setColumnName("Total Seconds");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${challengeSelected}"), challengeRegistryTable, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        ChallengesTableScrollPane.setViewportView(challengeRegistryTable);
        if (challengeRegistryTable.getColumnModel().getColumnCount() > 0) {
            challengeRegistryTable.getColumnModel().getColumn(0).setResizable(false);
            challengeRegistryTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            challengeRegistryTable.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(ChallengesTableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 450, 240));

        timeTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeTitleLabel.setText("Tiempo:");
        getContentPane().add(timeTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 20));

        ShowFormatedTimeLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        ShowFormatedTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(ShowFormatedTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 150, 20));

        instructionsQCLabel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        instructionsQCLabel.setForeground(new java.awt.Color(0, 0, 0));
        instructionsQCLabel.setText("Ri ch'ojib'al chawe are' !");
        getContentPane().add(instructionsQCLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, -1, -1));

        instructionsENLabel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        instructionsENLabel.setForeground(new java.awt.Color(0, 0, 0));
        instructionsENLabel.setText("Select in table to see the image created!");
        getContentPane().add(instructionsENLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, -1, -1));

        intructionsESLabel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        intructionsESLabel.setForeground(new java.awt.Color(0, 0, 0));
        intructionsESLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        intructionsESLabel.setText("¡Selecciona uno en la tabla para ver la imagen!");
        intructionsESLabel.setFocusable(false);
        getContentPane().add(intructionsESLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 240, 20));

        selectedImageLabel.setBackground(new java.awt.Color(255, 255, 255));
        selectedImageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(selectedImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 550, 270));

        turtleImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jgranados/koky/ui/images/Challenges2.png"))); // NOI18N
        getContentPane().add(turtleImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 398, -1));

        ComandsTextArea.setEditable(false);
        ComandsTextArea.setColumns(20);
        ComandsTextArea.setRows(5);
        ComandsScrollPane.setViewportView(ComandsTextArea);

        getContentPane().add(ComandsScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 290, 270));

        challengeTitleLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        challengeTitleLabel.setText("Reto:");
        getContentPane().add(challengeTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        ChallengeDescriptionTextField.setEditable(false);
        getContentPane().add(ChallengeDescriptionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 490, 20));

        jLabel2.setText("Comandos utilizados:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public String generateTime(int inputSeconds) {
        int hours = inputSeconds / 3600;
        int minutes = (inputSeconds - (3600 * hours)) / 60;
        int seconds = inputSeconds - ((hours * 3600) + (minutes * 60));
        String strTime = hours + "h " + minutes + "m " + seconds + "s";
        return strTime;
    }

//    public void actualizarListadoLibros(List<ChallengeRegistry> challengesInputList) {
//        this.challengesObsList.clear();
//        this.challengesObsList.addAll((List<ChallengeRegistry>) (List<?>) challengesInputList);
//    }
    public void showChallengesListTable() {
        this.challengesObsList.clear();
        this.challengesObsList.addAll((List<ChallengeRegistry>) (List<?>) challengesHistoryHandler.returnAllRegistrys());
    }

    public ObservableList<ChallengeRegistry> getChallengesList() {
        return challengesObsList;
    }

    public void setChallenges(ObservableList<ChallengeRegistry> newChallengesList) {
        this.challengesObsList = newChallengesList;
    }

    public ChallengeRegistry getChallengeSelected() {
        return challengeSelected;
    }

    public void setChallengeSelected(ChallengeRegistry challengeSelected) {
        ComandsTextArea.setText("");
        if (challengeSelected != null) {
            this.challengeSelected = challengeSelected.cloneRegistry();
            ChallengeDescriptionTextField.setText(challengeSelected.getChallengeDescription());
            String path = CHALLENGES_URL + challengeSelected.getIdentifierRegistry();
            ImageIcon icono = new ImageIcon(path);
            Image img = icono.getImage().getScaledInstance(calculateProporcionalWidth(icono.getIconHeight(), icono.getIconWidth(), selectedImageLabel.getHeight()), selectedImageLabel.getHeight(), Image.SCALE_SMOOTH);           
            selectedImageLabel.setIcon(new ImageIcon(img));
            ShowFormatedTimeLabel.setText(generateTime(challengeSelected.getTotalSeconds()));
            for (int i = 0; i < challengeSelected.getInstructionsList().size(); i++) {
                ComandsTextArea.append(challengeSelected.getInstructionsList().get(i) + "\n");
            }
        } else {
            this.challengeSelected = null;
        }
    }
    
    private int calculateProporcionalWidth(int imageHeight, int imageWidth, int labelHeight){
    int result;
    result = (int ) (imageWidth*labelHeight)/imageHeight;
    return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ChallengeDescriptionTextField;
    private javax.swing.JScrollPane ChallengesTableScrollPane;
    private javax.swing.JScrollPane ComandsScrollPane;
    private javax.swing.JTextArea ComandsTextArea;
    private javax.swing.JLabel ShowFormatedTimeLabel;
    private javax.swing.JTable challengeRegistryTable;
    private javax.swing.JLabel challengeTitleLabel;
    private javax.swing.JLabel instructionsENLabel;
    private javax.swing.JLabel instructionsQCLabel;
    private javax.swing.JLabel intructionsESLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel selectedImageLabel;
    private javax.swing.JLabel timeTitleLabel;
    private javax.swing.JLabel turtleImageLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
