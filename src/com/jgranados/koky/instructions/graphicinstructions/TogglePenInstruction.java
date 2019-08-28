package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.instructions.logic.Messages;
import com.jgranados.koky.ui.KokyPointer;
import java.awt.Graphics2D;

/**
 *
 * @author jose
 */
public class TogglePenInstruction extends GraphicsInstruction implements ExecutionDescribable{

    private boolean toggle;

    public TogglePenInstruction(boolean toggle) {
        this.toggle = toggle;
    }
    
    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        currentPointer.setIsPenUp(toggle);
        return graphicsNoPointer;
    }
    
    @Override
    public String getExecutionDescription() {
        if (toggle==true) {
            return Messages.togglePenFalseTurtle();
        }else{
            return Messages.togglePenTrueTurtle();
        }
    }
}
