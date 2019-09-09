package com.jgranados.koky.ui;

import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author fabricio
 */
public class JOptionPaneMultiInput {

    public static final String TITLE_OPTION_PANE = "Ingresar valores";
    public static final int NUMBER_COLUMNS = 5;
    public static final int HORIZONTAL_SPACER = 15;

    public static List getMultiInput(String[] inputs) {

        List<JTextField> textFields = new LinkedList<>();
        List<String> arguments = new LinkedList<>();
        JPanel myPanel = new JPanel();

        for (int i = 0; i < inputs.length; i++) {
            myPanel.add(new JLabel(inputs[i]));
            textFields.add(new JTextField(NUMBER_COLUMNS));
            myPanel.add(textFields.get(i));
            if (i < inputs.length) {
                myPanel.add(Box.createHorizontalStrut(HORIZONTAL_SPACER)); // a spacer
            }
        }
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                TITLE_OPTION_PANE, JOptionPane.DEFAULT_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            for (JTextField textField : textFields) {
                if (textField.getText().trim().isEmpty()) {
                    return null;
                }
                arguments.add(textField.getText());
            }
            return arguments;
        }
        return null;
    }

}
