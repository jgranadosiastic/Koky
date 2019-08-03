package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.ui.KokyPointer;

/**
 *
 * @author jose
 */
public class PositionXYInstruction extends PositionInstruction {

    private Expr posX;
    private Expr posY;

    public PositionXYInstruction(Expr posX, Expr posY) {
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    protected Integer getPositionX(KokyPointer currentPointer) {
        return posX.operate();
    }

    @Override
    protected Integer getPositionY(KokyPointer currentPointer) {
        return posY.operate();
    }

}
