package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.instructions.logic.Messages;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.ui.KokyPointer;
import java.awt.Graphics2D;

/**
 *
 * @author jose
 */
public class RightInstruction extends GraphicsInstruction implements ExecutionDescribable {
    private Expr angle;
    private Messages message;
    
    public RightInstruction(Expr angle) {
        this.angle = angle;
        message = new Messages();
    }

    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        currentPointer.addAngle(angle.operate());
        return graphicsNoPointer;
    }

    @Override
    public String getExecutionDescription() {
        return message.rightMessage(angle);
    }
    
}
