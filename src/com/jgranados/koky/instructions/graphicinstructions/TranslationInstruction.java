
package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.ui.KokyPointer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Arrays;

/**
 *
 * @author jose
 */
public abstract class TranslationInstruction extends GraphicsInstruction {

    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        int [] outPositions = {currentPointer.getOutPosX(), currentPointer.getOutPosY()};
        int endPosX = calculateEndX(currentPointer);
        int endPosY = calculateEndY(currentPointer);
        int outPosX = endPosX; //Out position
        int outPosY = endPosY;
        if (TranslationUtils.isOutOfRange(currentPointer.getOutPosX(), currentPointer.getOutPosY(), currentPointer)) {
            outPosX = calculateOutEndX(currentPointer);
            outPosY = calculateOutEndY(currentPointer);
        }
        currentPointer.setOutPosX(outPosX);
        currentPointer.setOutPosY(outPosY);
        if (TranslationUtils.isOutOfRange(outPosX, outPosY, currentPointer)) {
            if (!TranslationUtils.isOutOfRange(outPositions[0], outPositions[1], currentPointer)) {
                outPositions = Arrays.copyOf(TranslationUtils.setEndPosition(currentPointer, TranslationUtils.INIT_METHOD), TranslationUtils.ARRAY_SIZE);
            } else {
                outPositions = Arrays.copyOf(TranslationUtils.setOutPosition(currentPointer), TranslationUtils.ARRAY_SIZE);
            }
            endPosX = outPositions[0];
            endPosY = outPositions[1];
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

