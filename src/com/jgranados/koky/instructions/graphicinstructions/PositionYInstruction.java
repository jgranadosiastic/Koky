package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.interpreter.expr.AmbitEnum;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.interpreter.token.Token;
import com.jgranados.koky.ui.KokyPointer;
/**
 *
 * @author jose
 */
public class PositionYInstruction extends PositionInstruction {

    private Expr posY;

    public PositionYInstruction(Expr posY) {
        this.posY = posY;
    }

    @Override
    protected Integer getPositionX(KokyPointer currentPointer) {
        return null;
    }

    @Override
    protected Integer getPositionY(KokyPointer currentPointer) {
        return posY.operate();
    }

    @Override
    public void assignAmbitToExpresions() {
        if(this.getAmbit()!=null){
            posY.setAmbit(this.getAmbit());
        }else{
            posY.setAmbit(AmbitEnum.GLOBAL);
        }
    }

    @Override
    public void assignTableTokenValue(Token token) {
        posY.setTableToken(token);
    }

    
}
