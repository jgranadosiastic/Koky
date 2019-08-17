package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.colors.ColorEnum;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.ui.KokyPointer;
import java.awt.Color;
import java.awt.Graphics2D;
import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.interpreter.token.Token;

/**
 *
 * @author jose
 */
public class ColorInstruction extends GraphicsInstruction implements ExecutionDescribable {

    private Expr intColor;
    private String hexaColor;
    private boolean isIntColor;

    public ColorInstruction(Expr color) {
        this.intColor = color;
        this.isIntColor = true;
    }

    public ColorInstruction(String color) {
        this.hexaColor = color;
    }

    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        if (isIntColor) {
            ColorEnum color = ColorEnum.fromValue(intColor.operate());
            currentPointer.setPenColor(color.getColor());
        } else {
            currentPointer.setPenColor(Color.decode(hexaColor));
        }
        return graphicsNoPointer;
    }

    @Override
    public String getExecutionDescription() {
        ColorEnum color = ColorEnum.fromValue(intColor.operate());
        return "Dibujaré con color " + color.toString();
    }

    @Override
    public void assignAmbitToExpresions() {
        intColor.setAmbit(this.getAmbit());
    }
    @Override
    public void assignTableTokenValue(Token token) {
        intColor.setTableToken(token);
    }
}
