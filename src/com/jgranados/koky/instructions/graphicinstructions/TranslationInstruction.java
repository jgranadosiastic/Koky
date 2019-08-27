package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.ui.EndPosition;
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
        EndPosition endPosition = new EndPosition(currentPointer.getOutPosX(), currentPointer.getOutPosY());
        int endPosX = calculateEndX(currentPointer);
        int endPosY = calculateEndY(currentPointer);
        int outPosX = endPosX; //Out position
        int outPosY = endPosY;
        if (TranslationUtils.isOutOfRange(currentPointer.getOutPosX(), currentPointer.getOutPosY())) {
            outPosX = calculateOutEndX(currentPointer);
            outPosY = calculateOutEndY(currentPointer);
        }
        currentPointer.setOutPosX(outPosX);
        currentPointer.setOutPosY(outPosY);
        if (TranslationUtils.isOutOfRange(outPosX, outPosY)) {
            if (!TranslationUtils.isOutOfRange(endPosition.getPosX(), endPosition.getPosY())) {
                endPosition = TranslationUtils.getEndPosition(currentPointer);
            } else {
                endPosition = TranslationUtils.getOutPosition(currentPointer);
            }
            endPosX = endPosition.getPosX();
            endPosY = endPosition.getPosY();
        } else {
            endPosX = outPosX;
            endPosY = outPosY;
        }
        currentPointer.setAccumulationX(calculateAccumulationX(currentPointer));
        currentPointer.setAccumulationY(calculateAccumulationY(currentPointer));
        currentPointer.setOutAccumulationX(calculateAccumulationX(currentPointer));
        currentPointer.setOutAccumulationY(calculateAccumulationY(currentPointer));
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

    protected abstract Integer calculateOutEndX(KokyPointer currentPointer);

    protected abstract Integer calculateOutEndY(KokyPointer currentPointer);

    protected abstract double calculateAccumulationX(KokyPointer currentPointer);

    protected abstract double calculateAccumulationY(KokyPointer currentPointer);

}
