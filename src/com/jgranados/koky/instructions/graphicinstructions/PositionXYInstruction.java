package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.interpreter.expr.AmbitEnum;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.interpreter.token.Token;
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

    @Override
    public void assignAmbitToExpresions() {
        if(this.getAmbit()!=null){
            posX.changeAmbit(this.getAmbit());
        }else{
            posX.changeAmbit(AmbitEnum.GLOBAL);
        }
        if(this.getAmbit()!=null){
            posY.changeAmbit(this.getAmbit());
        }else{
            posY.changeAmbit(AmbitEnum.GLOBAL);
        }

    }

    @Override
    public void assignTableTokenValue(Token token) {
        posX.changeTableToken(token);
        posY.changeTableToken(token);
    }

}
