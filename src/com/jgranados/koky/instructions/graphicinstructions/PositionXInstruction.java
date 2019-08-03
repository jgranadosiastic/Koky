package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.ui.KokyPointer;

/**
 *
 * @author jose
 */
public class PositionXInstruction extends PositionInstruction {

    private Expr posX;

    public PositionXInstruction(Expr posX) {
        this.posX = posX;
    }

    @Override
    protected Integer getPositionX(KokyPointer currentPointer) {
        return posX.operate();
    }

    @Override
    protected Integer getPositionY(KokyPointer currentPointer) {
        return null;
    }

}
