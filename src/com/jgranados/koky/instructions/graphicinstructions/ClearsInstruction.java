package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.ui.KokyPointer;
import com.rmendez.koky.instructions.Languages;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author jose
 */
public class ClearsInstruction extends GraphicsInstruction implements ExecutionDescribable {
    
    private Languages all = Languages.ALL, spanish = Languages.SPANISH,
            english = Languages.ENGLISH, kiche = Languages.KICHE;
    
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
        if (all.getTypeLanguage()==true) {
           return "He limpiado la pantalla.";
        }else if (english.getTypeLanguage()==true) {
           return "I have cleaned the screen.";
        }else if (spanish.getTypeLanguage()==true) {
           return "He limpiado la pantalla.";
        }else if (kiche.getTypeLanguage()==true) {
            return "KICHE KICHE KICHE";
        }
       
        return "He limpiado la pantalla.";
    }

}
