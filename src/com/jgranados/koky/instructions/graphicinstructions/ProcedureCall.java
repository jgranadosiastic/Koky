/*
 * Procedure call for execute
 */
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
            boolean flag = true;
            //I compare if the number of parameters to send is equal to the number of parameters to receive in the procedure 
            if (parameters.size() != this.proceduresTable.getParametersTable().get(procedureName.getLexeme()).size()) {
                executionDescription = "El Procedimiento ->" + procedureName.getLexeme() + " No se puede ejecutar por inconcistencias en los parametros";
                flag = false;

            }
            if (flag) {
                //clean temporary table and copy of the persistent temporary table of symbols so that the variables are not lost
//                 proceduresTable.getTemporarySymbolTable().cleanAll();
//                for (String key: symbolsTable.getSymTable().keySet()){
//                        proceduresTable.getTemporarySymbolTable().assignValueToId(new Token(key, 0, 0), symbolsTable.getSymTable().get(key));
//                }

                //assignment of temporary parameters
//                for (int i = 0; i < parameters.size(); i++) {
//                              symbolsTable.assignValueToId(this.proceduresTable.getParametersTable().get(procedureName).get(i), 
//                                parameters.get(i).operate());
//                }
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
                executionDescription = "Se ha Llamado al Procedimiento ->" + procedureName.getLexeme() + " y se ha ejecutado";

                //Elimination of temporary parameters
//                for (int i = 0; i < parameters.size(); i++) {
//                    symbolsTable.removeParameter(this.proceduresTable.getParametersTable().get(procedureName).get(i));
//                }
                //backup of variables to the persistent symbol table
//                for (String key: proceduresTable.getTemporarySymbolTable().getSymTable().keySet()){
//                        symbolsTable.assignValueToId(new Token(key, 0, 0), proceduresTable.getTemporarySymbolTable().getSymTable().get(key));
//                }
                //clean temporary symbol table
                //proceduresTable.getTemporarySymbolTable().cleanAll();
            }

        } else {
            executionDescription = "El Procedimiento ->" + procedureName.getLexeme() + " que trata de llamar No existe";
        }

        // Do nothing
        return graphicsNoPointer;

    }

    public void addValueToParameters() {
        try {
            SymbolsTable sym = (SymbolsTable) symbolsTable.getIdValue(procedureName);
            List<Token> parameters = proceduresTable.getParameters(procedureName.getLexeme());
            for (int i = 0; i < parameters.size(); i++) {
                sym.assignValueToId(parameters.get(i), this.parameters.get(i).operate());
            }
        } catch (Exception e) {
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
