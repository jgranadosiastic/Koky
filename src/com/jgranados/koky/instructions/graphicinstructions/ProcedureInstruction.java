package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.interpreter.expr.AmbitEnum;
import com.jgranados.koky.interpreter.token.Token;
import java.util.List;

/**
 *
 * @author bryan
 */
public class ProcedureInstruction extends Instruction implements ExecutionDescribable{
    
    private String processName; 
    private List<Instruction> instructions;

    public ProcedureInstruction(String processName, List<Instruction> instructions) {
        this.processName = processName;
        this.instructions = instructions;
        this.changeInstructionAmbit();
    }
    
    public void changeInstructionAmbit(){
        AmbitEnum ambit = null;
        for (Instruction instruction : instructions) {
            instruction.setAmbit(ambit.LOCAL);
        }
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
