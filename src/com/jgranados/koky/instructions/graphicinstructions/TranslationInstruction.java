package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.ui.KokyPointer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author jose
 */
public abstract class TranslationInstruction extends GraphicsInstruction {

    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        int endPosX = calculateEndX(currentPointer);
        int endPosY = calculateEndY(currentPointer);
        currentPointer.setAccumulationX(calculateAccumulationX(currentPointer));
        currentPointer.setAccumulationY(calculateAccumulationY(currentPointer));
        drawLine(graphicsNoPointer, currentPointer, endPosX, endPosY);
        return graphicsNoPointer;
    }

    protected void drawLine(Graphics2D graphics, KokyPointer currentPointer, int endX, int endY) {
        if (!currentPointer.isPenUp()) {
            graphics.setColor(currentPointer.getPenColor());
            graphics.setColor(currentPointer.getPenColor());
            graphics.setStroke(new BasicStroke(currentPointer.getWidth()));
            if (currentPointer.isErasing()) {
                graphics.setColor(Color.WHITE);
            }
            graphics.drawLine(currentPointer.getPosX(), currentPointer.getPosY(), endX, endY);
        }
        currentPointer.setPosX(endX);
        currentPointer.setPosY(endY);
    }

    protected abstract Integer calculateEndX(KokyPointer currentPointer);

    protected abstract Integer calculateEndY(KokyPointer currentPointer);

    protected abstract double calculateAccumulationX(KokyPointer currentPointer);

    protected abstract double calculateAccumulationY(KokyPointer currentPointer);
}
