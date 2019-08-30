
package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.interpreter.expr.AmbitEnum;
import com.jgranados.koky.instructions.logic.Messages;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.interpreter.token.Token;
import com.jgranados.koky.ui.KokyPointer;
import java.awt.Graphics2D;

/**
 *
 * @author dntn
 */
public class WidthInstruction extends GraphicsInstruction implements ExecutionDescribable {
    
    private Expr width;
    
    public WidthInstruction(Expr width) {
        this.width = width;
    }
    
    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        currentPointer.setWidth(this.width.operate());
        return graphicsNoPointer;
    }
    
    @Override
    public String getExecutionDescription() {        
        return Messages.widthMessage(width.operate());
    }

    @Override
    public void assignAmbitToExpresions() {
        if(this.getAmbit()!=null){
            width.setAmbit(this.getAmbit());
        }else{
            width.setAmbit(AmbitEnum.GLOBAL);
        }
    }

    @Override
    public void assignTableTokenValue(Token token) {
        width.setTableToken(token);
    }
    
}
