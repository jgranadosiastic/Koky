package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.ui.KokyPointer;
import com.jgranados.koky.instructions.logic.Messages;

/**
 *
 * @author jose
 */
public abstract class PositionInstruction extends TranslationInstruction implements ExecutionDescribable {

    private KokyPointer currentPointer;

    @Override
    protected Integer calculateEndX(KokyPointer currentPointer) {
        this.currentPointer = currentPointer;
        Integer normalizedEndX = getPositionX(currentPointer);
        if (normalizedEndX != null) {
            return normalizedEndX + currentPointer.getPanelDrawWidth() / 2;
        }
        return currentPointer.getPosX();
    }

    @Override
    protected Integer calculateEndY(KokyPointer currentPointer) {
        Integer normalizedEndY = getPositionY(currentPointer);
        if (normalizedEndY != null) {
            return currentPointer.getPanelDrawHeight() / 2 - normalizedEndY;
        }
        return currentPointer.getPosY();
    }

    @Override
    protected Integer calculateOutEndX(KokyPointer currentPointer) {
        this.currentPointer = currentPointer;
        Integer normalizedEndX = getPositionX(currentPointer);
        if (normalizedEndX != null) {
            return normalizedEndX + currentPointer.getPanelDrawWidth() / 2;
        }
        return currentPointer.getPosX();
    }

    @Override
    protected Integer calculateOutEndY(KokyPointer currentPointer) {
        Integer normalizedEndY = getPositionY(currentPointer);
        if (normalizedEndY != null) {
            return currentPointer.getPanelDrawHeight() / 2 - normalizedEndY;
        }
        return currentPointer.getPosY();
    }

    @Override
    protected double calculateAccumulationX(KokyPointer currentPointer) {
        return 0d;
    }

    @Override
    protected double calculateAccumulationY(KokyPointer currentPointer) {
        return 0d;
    }

    protected abstract Integer getPositionX(KokyPointer currentPointer);

    protected abstract Integer getPositionY(KokyPointer currentPointer);

    @Override
    public String getExecutionDescription() {
        return Messages.positionMessage(currentPointer.getCoordinatePosX(),
                currentPointer.getCoordinatePosY());
    }
}
