package com.jgranados.koky.instructions;

import com.jgranados.koky.interpreter.token.Token;

/**
 *
 * @author jose
 */
public abstract class Instruction {
    private String ambit;
    
    

    public String getAmbit() {
        return ambit;
    }

    public void setAmbit(String ambit) {
        this.ambit = ambit;
    }
    
    public abstract void assignAmbitToExpresions();
    public abstract void assignTableTokenValue(Token token);

}
