package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.ui.KokyPointer;
import com.jgranados.koky.instructions.logic.Messages;

/**
 *
 * @author jose
 */
public class ForwardInstruction extends TranslationInstruction implements ExecutionDescribable {

    private Expr steps;
    private Messages message;
    
    public ForwardInstruction(Expr steps) {
        this.steps = steps;
        message = new Messages();
    }

    @Override
    protected Integer calculateEndX(KokyPointer currentPointer) {
        return currentPointer.getPosX() + TranslationUtils
                .calculateXDimension(
                        currentPointer.getAngle(),
                        steps.operate(),
                        currentPointer.getAccumulationX());
    }

    @Override
    protected Integer calculateEndY(KokyPointer currentPointer) {
        return currentPointer.getPosY() - TranslationUtils
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
        return message.fdMessage(steps);
    }

}
