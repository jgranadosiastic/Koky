/*
 * Instruction to handle the procedure
 */
package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.interpreter.expr.AmbitEnum;
import com.jgranados.koky.interpreter.symbolstable.SymbolsTable;
import com.jgranados.koky.interpreter.token.Token;
import com.jgranados.koky.ui.KokyPointer;
import java.awt.Graphics2D;
import java.util.List;

/**
 *
 * @author bryan
 */
public class ProcedureInstruction extends GraphicsInstruction implements ExecutionDescribable{
    
    
    private String processName; 
    private List<Token> parameters;
    private SymbolsTable symTable;
    private List<Instruction> instructions;
    
    public ProcedureInstruction(String processName, List<Token> parameters,List<Instruction> instructions ,SymbolsTable symTable) {
        this.processName = processName;
        this.parameters = parameters;
        this.symTable = symTable;
        this.instructions = instructions;
        changeInstructionAmbit();
    }
    
    public void changeInstructionAmbit(){
        for (Instruction instruction : instructions) {
            instruction.setAmbit(AmbitEnum.LOCAL.name());
        }
    }
    
    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        return graphicsNoPointer;
    }

    @Override
    public String getExecutionDescription() {
        return "Se a guardado el procedimiento ->"+processName+" en espera de ser ejecutado";
    }

    @Override
    public void assignAmbitToExpresions() {
        //Nothing this class don't have Expr
    }

    @Override
    public void assignTableTokenValue(Token token) {
        //Nothing this class don't have Expr
    }
    
}
