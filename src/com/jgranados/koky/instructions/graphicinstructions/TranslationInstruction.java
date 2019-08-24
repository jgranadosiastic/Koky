package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.ui.EndPosition;
import com.jgranados.koky.ui.KokyPointer;
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
        int outPosX = endPosX; //Out position
        int outPosY = endPosY;
        if (currentPointer.getEndPosition() != null) {
            if (TranslationUtils.isOutOfRange(currentPointer.getEndPosition().getEndPosX(), currentPointer.getEndPosition().getEndPosY())) {
                outPosX = calculateOutEndX(currentPointer);
                outPosY = calculateOutEndY(currentPointer);
            }
        }
        currentPointer.setEndPosition(new EndPosition(outPosX, outPosY));
        if (TranslationUtils.isOutOfRange(outPosX, outPosY)) {
            EndPosition endPosition = TranslationUtils.getEndPosition(new EndPosition(outPosX, outPosY), currentPointer);
            endPosX = endPosition.getEndPosX();
            endPosY = endPosition.getEndPosY();
        } else {
            endPosX = outPosX;
            endPosY = outPosY;
        }
        currentPointer.setAccumulationX(calculateAccumulationX(currentPointer));
        currentPointer.setAccumulationY(calculateAccumulationY(currentPointer));
        currentPointer.setAccumulationOutX(calculateAccumulationX(currentPointer));
        currentPointer.setAccumulationOutY(calculateAccumulationY(currentPointer));
        drawLine(graphicsNoPointer, currentPointer, endPosX, endPosY);
        return graphicsNoPointer;
    }

    protected void drawLine(Graphics2D graphics, KokyPointer currentPointer, int endX, int endY) {
        if (!currentPointer.isPenUp()) {
            graphics.setColor(currentPointer.getPenColor());
            graphics.setColor(currentPointer.getPenColor());
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

    protected abstract double calculateAccumulationOutX(KokyPointer currentPointer);

    protected abstract double calculateAccumulationOutY(KokyPointer currentPointer);

}
