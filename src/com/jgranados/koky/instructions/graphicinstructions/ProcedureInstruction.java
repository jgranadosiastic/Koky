package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.interpreter.expr.AmbitEnum;
import com.jgranados.koky.interpreter.symbolstable.ProcedureTable;
import com.jgranados.koky.interpreter.symbolstable.SymbolsTable;
import com.jgranados.koky.interpreter.token.Token;
import java.util.List;

/**
 *
 * @author bryan
 */
public class ProcedureInstruction extends Instruction implements ExecutionDescribable{
    
    private Token processName; 
    private List<Token> parameters;
    private SymbolsTable symTableLocal;
    private SymbolsTable symTableGlobal;
    private List<Instruction> instructions;
    private ProcedureTable procedureTable;

    public ProcedureInstruction(Token processName, List<Token> parameters, SymbolsTable symTableLocal, SymbolsTable symTableGlobal, List<Instruction> instructions, ProcedureTable procedureTable) {
        this.processName = processName;
        this.parameters = parameters;
        this.symTableLocal = symTableLocal;
        this.symTableGlobal = symTableGlobal;
        this.instructions = instructions;
        this.procedureTable = procedureTable;
        this.changeInstructionAmbit();
        this.addProcedureInstruction();
    }    
    
    public void changeInstructionAmbit(){
        AmbitEnum ambit = null;
        for (Instruction instruction : instructions) {
            instruction.setAmbit(ambit.LOCAL);
        }
    }
    public void addProcedureInstruction(){
        this.procedureTable.addProcedure(processName, this);
    }
    
    @Override
    public String getExecutionDescription() {
        return "Se a guardado el procedimiento ->"+processName.getLexeme()+" en espera de ser ejecutado";
    }

    @Override
    public void assignAmbitToExpresions() {
        //Nothing this class don't have Expr
    }

    @Override
    public void assignTableTokenValue(Token token) {
        //Nothing this class don't have Expr
    }

    public Token getProcessName() {
        return processName;
    }

    public void setProcessName(Token processName) {
        this.processName = processName;
    }

    public List<Token> getParameters() {
        return parameters;
    }

    public void setParameters(List<Token> parameters) {
        this.parameters = parameters;
    }

    public SymbolsTable getSymTableLocal() {
        return symTableLocal;
    }

    public void setSymTableLocal(SymbolsTable symTableLocal) {
        this.symTableLocal = symTableLocal;
    }

    public SymbolsTable getSymTableGlobal() {
        return symTableGlobal;
    }

    public void setSymTableGlobal(SymbolsTable symTableGlobal) {
        this.symTableGlobal = symTableGlobal;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public ProcedureTable getProcedureTable() {
        return procedureTable;
    }

    public void setProcedureTable(ProcedureTable procedureTable) {
        this.procedureTable = procedureTable;
    }

    
    
}
