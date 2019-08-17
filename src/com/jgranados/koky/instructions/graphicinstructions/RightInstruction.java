package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.ui.KokyPointer;
import com.rmendez.koky.instructions.Languages;
import java.awt.Graphics2D;

/**
 *
 * @author jose
 */
public class RightInstruction extends GraphicsInstruction implements ExecutionDescribable {
    private Expr angle;
    private Languages all = Languages.ALL, spanish = Languages.SPANISH,
            english = Languages.ENGLISH, kiche = Languages.KICHE;
    
    public RightInstruction(Expr angle) {
        this.angle = angle;
    }

    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        currentPointer.addAngle(angle.operate());
        return graphicsNoPointer;
    }

    @Override
    public String getExecutionDescription() {
        if (all.getTypeLanguage()==true) {
           return "Giré " + angle.operate() + " grados a la derecha.";
        }else if (english.getTypeLanguage()==true) {
            return "Turn " + angle.operate() + " degrees to the right.";
        }else if (spanish.getTypeLanguage()==true) {
           return "Giré " + angle.operate() + " grados a la derecha.";
        }else if (kiche.getTypeLanguage()==true) {
            return "KICHE " + angle.operate() + " KICHE KICHE KICHE.";
        }
        return "Giré " + angle.operate() + " grados a la derecha.";
    }
    
}
