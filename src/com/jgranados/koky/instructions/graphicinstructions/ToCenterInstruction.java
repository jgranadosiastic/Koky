package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.interpreter.token.Token;
import com.jgranados.koky.ui.KokyPointer;
import com.jgranados.koky.instructions.logic.Messages;
import java.awt.Graphics2D;

/**
 *
 * @author jose
 */
public class ToCenterInstruction extends TranslationInstruction implements ExecutionDescribable {
    
    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        currentPointer.resetAngle();
        return super.execute(graphicsNoPointer, currentPointer);
    }

    @Override
    protected Integer calculateEndX(KokyPointer currentPointer) {
        return currentPointer.getPanelDrawWidth() / 2;
    }

    @Override
    protected Integer calculateEndY(KokyPointer currentPointer) {
        return currentPointer.getPanelDrawHeight() / 2;
    }

    @Override
    protected Integer calculateOutEndX(KokyPointer currentPointer) {
        return currentPointer.getPanelDrawWidth() / 2;
    }

    @Override
    protected Integer calculateOutEndY(KokyPointer currentPointer) {
        return currentPointer.getPanelDrawHeight() / 2;
    }
    
    @Override
    protected double calculateAccumulationX(KokyPointer currentPointer) {
        return 0d;
    }

    @Override
    protected double calculateAccumulationY(KokyPointer currentPointer) {
        return 0d;
    }

    @Override
    public String getExecutionDescription() {
        return Messages.centerMessage();
    }

    @Override
    public void assignAmbitToExpresions() {
        //Nothing this class don't have Expr
    }

    @Override
    public void assignTableTokenValue(Token token) {
        //Nothing this class don't have Expr
    }
    
}
