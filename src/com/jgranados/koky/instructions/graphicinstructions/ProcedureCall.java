package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.instructions.varinstructions.Assignable;
import com.jgranados.koky.interpreter.expr.Expr;
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
public class ProcedureCall extends GraphicsInstruction implements ExecutionDescribable {

    private List<Expr> parameters;
    private Token procedureName;
    private ProcedureTable proceduresTable;
    private SymbolsTable symbolsTable;
    private String executionDescription;

    public ProcedureCall(List<Expr> parameters, Token procedureName, ProcedureTable proceduresTable, SymbolsTable symbolsTable) {
        this.parameters = parameters;
        this.procedureName = procedureName;
        this.proceduresTable = proceduresTable;
        this.symbolsTable = symbolsTable;
        this.executionDescription = "";
    }

    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        addValueToParameters();
        //checking if the procedure name exists
        if (this.symbolsTable.exists(procedureName, true)) {
            //I compare if the number of parameters to send is equal to the number of parameters to receive in the procedure 
            if (this.proceduresTable.compareSentParameters(parameters, procedureName.getLexeme())) {
                //executing instructions
                for (Instruction instruction : this.proceduresTable.getProcedureTable().get(procedureName.getLexeme())) {
                    instruction.assignAmbitToExpresions();
                    instruction.assignTableTokenValue(procedureName);
                    if (instruction instanceof Graphicable) {
                        graphicsNoPointer = ((Graphicable) instruction).execute(graphicsNoPointer, currentPointer);
                    } else if (instruction instanceof Assignable) {
                        ((Assignable) instruction).assign();
                    }
                }
                executionDescription = "Se llamo al Procedimiento ->" + procedureName.getLexeme();

            }

        } else {
            executionDescription = "El Procedimiento ->" + procedureName.getLexeme() + " que trata de llamar No existe";
        }

        return graphicsNoPointer;

    }

    public void addValueToParameters() {
        SymbolsTable sym = (SymbolsTable) symbolsTable.getIdValue(procedureName);
        List<Token> parameters = proceduresTable.getParameters(procedureName.getLexeme());
        for (int i = 0; i < parameters.size(); i++) {
            sym.assignValueToId(parameters.get(i), this.parameters.get(i).operate());
        }
       
    }
    
    public void addTableTokenExpr(){
        
    }

    @Override
    public String getExecutionDescription() {
        return executionDescription;
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
