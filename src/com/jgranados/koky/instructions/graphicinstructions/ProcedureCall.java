/*
 * Procedure call for execute
 */
package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.interpreter.token.Token;
import com.jgranados.koky.ui.KokyPointer;
import java.awt.Graphics2D;
import java.util.List;

/**
 *
 * @author bryan
 */
public class ProcedureCall extends GraphicsInstruction implements ExecutionDescribable{
    
    private List<Token> tokens;

    public ProcedureCall(List<Token> tokens) {
        this.tokens = tokens;
    }
    

    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getExecutionDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
}
