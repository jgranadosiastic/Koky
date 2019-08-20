package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.ui.KokyPointer;
import com.jgranados.koky.instructions.logic.Messages;
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
        return Messages.clearsMessage();
    }

}
