package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.instructions.logic.Messages;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.ui.KokyPointer;

/**
 *
 * @author jose
 */
public class BackwardInstruction extends TranslationInstruction implements ExecutionDescribable {

   private Expr steps;

    public BackwardInstruction(Expr steps) {
        this.steps = steps;
    }

    @Override
    protected Integer calculateEndX(KokyPointer currentPointer) {
        return currentPointer.getPosX() - TranslationUtils
                .calculateXDimension(
                        currentPointer.getAngle(),
                        steps.operate(),
                        currentPointer.getAccumulationX());
    }

    @Override
    protected Integer calculateEndY(KokyPointer currentPointer) {
        return currentPointer.getPosY() + TranslationUtils
                .calculateYDimension(
                        currentPointer.getAngle(),
                        steps.operate(),
                        currentPointer.getAccumulationY());
    }

    @Override
    protected Integer calculateOutEndX(KokyPointer currentPointer) {
        return currentPointer.getOutPosX() - TranslationUtils
                .calculateXDimension(
                        currentPointer.getAngle(),
                        steps.operate(),
                        currentPointer.getAccumulationX());
    }

    @Override
    protected Integer calculateOutEndY(KokyPointer currentPointer) {
        return currentPointer.getOutPosY() + TranslationUtils
                .calculateYDimension(
                        currentPointer.getAngle(),
                        steps.operate(),
                        currentPointer.getAccumulationY());
    }
    
    @Override
    protected double calculateAccumulationX(KokyPointer currentPointer) {
        return TranslationUtils.calculateAccumulationX(
                currentPointer.getAngle(),
                steps.operate(),
                currentPointer.getAccumulationX());
    }

    @Override
    protected double calculateAccumulationY(KokyPointer currentPointer) {
        return TranslationUtils.calculateAccumulationY(
                currentPointer.getAngle(),
                steps.operate(),
                currentPointer.getAccumulationY());
    }
    
    @Override
    public String getExecutionDescription() {
        return Messages.bkMessage(steps);
    }
}
