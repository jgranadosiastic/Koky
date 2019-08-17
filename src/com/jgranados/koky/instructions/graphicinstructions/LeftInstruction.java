package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.interpreter.token.Token;
import com.jgranados.koky.ui.KokyPointer;
import java.awt.Graphics2D;

/**
 *
 * @author jose
 */
public class LeftInstruction extends GraphicsInstruction implements ExecutionDescribable {

    private Expr angle;

    public LeftInstruction(Expr angle) {
        this.angle = angle;
    }
    
    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        currentPointer.addAngle(-angle.operate());
        return graphicsNoPointer;
    }

    @Override
    public String getExecutionDescription() {
        return "Giré " + angle.operate() + " grados a la izquierda.";
    }

    @Override
    public void assignAmbitToExpresions() {
        angle.setAmbit(this.getAmbit());
    }
    
    @Override
    public void assignTableTokenValue(Token token) {
        angle.setTableToken(token);
    }
    
}
