package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.interpreter.token.Token;
import com.jgranados.koky.ui.KokyPointer;
import java.awt.Graphics2D;

/**
 *
 * @author jose
 */
public class ToggleTurtleInstruction extends GraphicsInstruction {

    private boolean toggle;

    public ToggleTurtleInstruction(boolean toggle) {
        this.toggle = toggle;
    }
    
    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        currentPointer.setHidden(!toggle);
        return graphicsNoPointer;
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
