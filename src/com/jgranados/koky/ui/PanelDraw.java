package com.jgranados.koky.ui;

import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.instructions.graphicinstructions.Graphicable;
import com.jgranados.koky.instructions.varinstructions.Assignable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.stream.Collectors;
import com.jgranados.koky.instructions.ExecutionDescribable;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jose
 */
public class PanelDraw extends javax.swing.JPanel {

    private static final int PANEL_WIDTH = 1000;
    private static final int PANEL_HEIGHT = 600; //460
    private KokyPointer kokyPointer;
    private BufferedImage imageWithPointer;
    private BufferedImage imageNoPointer;
    private Graphics2D graphicsWithPointer;
    private Graphics2D graphicsNoPointer;
    File f = null;

    /**
     * Creates new form PanelDraw
     */
    public PanelDraw() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imageWithPointer == null) {
            kokyPointer = new KokyPointer(this.getWidth() / 2, this.getHeight() / 2, 0, this);
            initImages();
        }
        g.drawImage(imageWithPointer, 0, 0, null);
    }

    private void initImages() {
        imageWithPointer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        graphicsWithPointer = initImageGraphic(imageWithPointer);
        imageNoPointer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        graphicsNoPointer = initImageGraphic(imageNoPointer);

        kokyPointer.drawPointer(graphicsWithPointer);
    }

    private Graphics2D initImageGraphic(BufferedImage image) {
        Graphics2D imgGraphic = image.createGraphics();
        imgGraphic.setBackground(Color.WHITE);
        imgGraphic.clearRect(0, 0, this.getWidth(), this.getHeight());
        return imgGraphic;
    }

    public void runInstruction(Instruction instruction) {
        if (instruction instanceof Graphicable) {
            drawInstruction((Graphicable) instruction);
        } else if (instruction instanceof Assignable) {
            ((Assignable) instruction).assign();
        }
    }

    private void drawInstruction(Graphicable instruction) {
        // using the no pointer graphic to draw the instruction
        graphicsNoPointer = instruction.execute(graphicsNoPointer, kokyPointer);
        // cleanning the graphics with the pointer
        graphicsWithPointer.clearRect(0, 0, this.getWidth(), this.getHeight());
        // redrawing the graphics without the pointer
        graphicsWithPointer.drawImage(imageNoPointer, 0, 0, null);
        // adding the pointer to the draw
        kokyPointer.drawPointer(graphicsWithPointer);
        this.repaint();
    }

    public List<String> runInstructions(List<Instruction> instructions) {
        return instructions.stream().map((instruction) -> {
            runInstruction(instruction);
            if (instruction instanceof ExecutionDescribable) {
                return ((ExecutionDescribable) instruction).getExecutionDescription();
            }
            return "";
        }).collect(Collectors.toList());
    }

    public void generateImg() {

        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(null);
        try {
            
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                String PATH = JFC.getAbsolutePath();//Obtains the path to use
                f = new File(PATH);
                try {
                    ImageIO.write(imageWithPointer, "jpg", f);
                } catch (IOException ex) {
                    Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Checks if the user puts the file extension in the name
                if (!(PATH.endsWith(".jpg"))) {
                    File temp = new File(PATH + ".jpg");
                    JFC.renameTo(temp);//If not, we add it manually
                }
                JOptionPane.showMessageDialog(null, "¡Imagen guardada exitosamente!", "Guardado correcto", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {//In case of any problem, the program sends an error message
            JOptionPane.showMessageDialog(null, "Ups! Hubo un error al guardar el archivo.", "Oops! Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
