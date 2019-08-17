package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.ui.KokyPointer;
import com.rmendez.koky.instructions.Languages;
import java.awt.Graphics2D;

/**
 *
 * @author jose
 */
public class ToCenterInstruction extends TranslationInstruction implements ExecutionDescribable {
    
    private Languages all = Languages.ALL, spanish = Languages.SPANISH,
            english = Languages.ENGLISH, kiche = Languages.KICHE;
    
    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        currentPointer.resetAngle();
        return super.execute(graphicsNoPointer, currentPointer);
    }

    @Override
    protected Integer calculateEndX(KokyPointer currentPointer) {
        return currentPointer.getPanelDrawWidth() / 2;
    }

    @Override
    protected Integer calculateEndY(KokyPointer currentPointer) {
        return currentPointer.getPanelDrawHeight() / 2;
    }

    @Override
    protected double calculateAccumulationX(KokyPointer currentPointer) {
        return 0d;
    }

    @Override
    protected double calculateAccumulationY(KokyPointer currentPointer) {
        return 0d;
    }

    @Override
    public String getExecutionDescription() {
        if (all.getTypeLanguage()==true) {
           return "Me moví al centro.";
        }else if (english.getTypeLanguage()==true) {
            return "I moved downtown.";
        }else if (spanish.getTypeLanguage()==true) {
           return "Me moví al centro.";
        }else if (kiche.getTypeLanguage()==true) {
           return "KICHE KICHE KICHE.";
        }
        return "Me moví al centro.";
    }
    
}
