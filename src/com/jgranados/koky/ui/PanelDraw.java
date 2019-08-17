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
import java.io.IOException;


/**
 *
 * @author jose
 */
public class PanelDraw extends javax.swing.JPanel {

    private static final int PANEL_WIDTH = 1000;
    private static final int PANEL_HEIGHT = 460;     
    private KokyPointer kokyPointer;
    private BufferedImage imageWithPointer;
    private BufferedImage imageNoPointer;
    private Graphics2D graphicsWithPointer;
    private Graphics2D graphicsNoPointer;

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
            kokyPointer = new KokyPointer(this.getWidth() / 2, this.getHeight() / 2, 0, this, KokyPointer.BRUSH_WIDTH);
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
        cleanAndDraw();
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

    public void changeImage(String url) throws IOException {
        this.kokyPointer.setImage(url);
        kokyPointer.drawPointer(graphicsWithPointer);
        cleanAndDraw();
    }

    public void cleanAndDraw() {
        // cleanning the graphics with the pointer
        graphicsWithPointer.clearRect(0, 0, this.getWidth(), this.getHeight());
        // redrawing the graphics without the pointer
        graphicsWithPointer.drawImage(imageNoPointer, 0, 0, null);
        // adding the pointer to the draw
        kokyPointer.drawPointer(graphicsWithPointer);
        this.repaint();
    }

}
