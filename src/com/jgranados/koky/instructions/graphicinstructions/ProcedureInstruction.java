/*
 * Instruction to handle the procedure
 */
package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.interpreter.symbolstable.ProcedureTable;
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
    private List<Instruction> instructions;
    private ProcedureTable proceduresTable;
    private SymbolsTable symTable;

    public ProcedureInstruction(String processName, List<Token> parameters, List<Instruction> instructions, ProcedureTable proceduresTable, SymbolsTable symTable) {
        this.processName = processName;
        this.parameters = parameters;
        this.instructions = instructions;
        this.proceduresTable = proceduresTable;
        this.symTable = symTable;
    }
    
    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        //Elimination of temporary parameters
        for(Token parameter: parameters){
            if (symTable.getIdValue(parameter)==null || symTable.getIdValue(parameter).intValue()==0) {
                symTable.removeParameter(parameter);
            }
            
        }
        return graphicsNoPointer;
    }

    @Override
    public String getExecutionDescription() {
        return "Se a guardado el procedimiento ->"+processName+" en espera de ser ejecutado";
    }

    public List<Token> getParameters() {
        return parameters;
    }

    public void setParameters(List<Token> parameters) {
        this.parameters = parameters;
    }
    
    
    
    
}
