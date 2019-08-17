package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.ui.KokyPointer;
import com.rmendez.koky.instructions.Languages;

/**
 *
 * @author jose
 */
public class ForwardInstruction extends TranslationInstruction implements ExecutionDescribable {

    private Expr steps;
    private Languages all = Languages.ALL, spanish = Languages.SPANISH,
            english = Languages.ENGLISH, kiche = Languages.KICHE;
    
    public ForwardInstruction(Expr steps) {
        this.steps = steps;
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
        if (all.getTypeLanguage()==true) {
            return "Avancé " + steps.operate() + " pasos.";
        }else if (english.getTypeLanguage()==true) {
            return "Advance " + steps.operate() + " steps.";
        }else if (spanish.getTypeLanguage()==true) {
            return "Avancé " + steps.operate() + " pasos.";
        }else if (kiche.getTypeLanguage()==true) {
            return "KICHE " + steps.operate() + " KICHE.";
        }
        return "Avancé " + steps.operate() + " pasos.";
    }

}
