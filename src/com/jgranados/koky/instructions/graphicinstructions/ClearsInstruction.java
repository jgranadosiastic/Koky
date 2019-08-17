package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.interpreter.token.Token;
import com.jgranados.koky.ui.KokyPointer;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author jose
 */
public class ClearsInstruction extends GraphicsInstruction implements ExecutionDescribable {

    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        graphicsNoPointer.setBackground(Color.WHITE);
        graphicsNoPointer.clearRect(0, 0, currentPointer.getPanelDrawWidth(),
                currentPointer.getPanelDrawHeight());
        currentPointer.resetPosition();
        return graphicsNoPointer;
    }

    @Override
    public String getExecutionDescription() {
        return "He limpiado la pantalla.";
    }

    @Override
    public void assignAmbitToExpresions() {
       //Nothing this class don't have Expresions
    }

    @Override
    public void assignTableTokenValue(Token token) {
        //Nothing this class don't have Expresions
    }

}
