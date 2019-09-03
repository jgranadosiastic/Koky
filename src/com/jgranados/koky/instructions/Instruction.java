package com.jgranados.koky.instructions;

import com.jgranados.koky.interpreter.expr.AmbitEnum;
import com.jgranados.koky.interpreter.token.Token;

/**
 *
 * @author jose
 */
public abstract class Instruction {
    private AmbitEnum ambit;

    public AmbitEnum getAmbit() {
        return ambit;
    }

    public void setAmbit(AmbitEnum ambit) {
        this.ambit = ambit;
    }
    
    public abstract void assignAmbitToExpresions();
    public abstract void assignTableTokenValue(Token token);

}
