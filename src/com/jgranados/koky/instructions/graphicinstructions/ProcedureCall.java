/*
 * Procedure call for execute
 */
package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.instructions.varinstructions.Assignable;
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
public class ProcedureCall extends GraphicsInstruction implements ExecutionDescribable{
    
    private List<Token> parameters;
    private String procedureName;
    private ProcedureTable proceduresTable;
    private SymbolsTable symbolsTable;
    private String executionDescription;
    
    public ProcedureCall(List<Token> parameters, String procedureName, ProcedureTable proceduresTable, SymbolsTable symbolsTable) {
        this.parameters = parameters;
        this.procedureName = procedureName;
        this.proceduresTable = proceduresTable;
        this.symbolsTable = symbolsTable;
        this.executionDescription = "";
    }
    

    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        
        //checking if the procedure name exists
        if (this.proceduresTable.getProcedureTable().containsKey(procedureName)) {
            boolean flag = true;
            //I compare if the number of parameters to send is equal to the number of parameters to receive in the procedure 
            if (parameters.size()==this.proceduresTable.getParametersTable().get(procedureName).size()) {
                for(Token param:parameters){
                    if (symbolsTable.getIdValue(param)==null || symbolsTable.getIdValue(param).intValue()==0) {
                        flag = false;
                        executionDescription = "X_Los Parametros que esta enviando en ->"+procedureName+ " No fueron declarados o no se les ha asignado valor.";
                        break;
                    }
                }    
            } else {
                executionDescription = "El Procedimiento ->"+procedureName+ " No se puede ejecutar por inconcistencias en los parametros";
                flag =false;

            } 
            if (flag) {
                //assignment of temporary parameters
                for (int i = 0; i < parameters.size(); i++) {
                        if (!symbolsTable.verifyParameter(this.proceduresTable.getParametersTable().get(procedureName).get(i))) {
                            symbolsTable.assignValueToId(this.proceduresTable.getParametersTable().get(procedureName).get(i), 
                                symbolsTable.getIdValue(parameters.get(i)));
                        }
                }
                //executing instructions
                for(Instruction instruction: this.proceduresTable.getProcedureTable().get(procedureName)){
                    if (instruction instanceof Graphicable) {
                        graphicsNoPointer = ((Graphicable) instruction).execute(graphicsNoPointer, currentPointer);
                    } else if (instruction instanceof Assignable) {
                        ((Assignable) instruction).assign();
                    }
                }
                executionDescription = "Se a Llamado al Procedimiento ->"+procedureName+" y Se ha ejecutado";

                //Elimination of temporary parameters
                for (int i = 0; i < parameters.size(); i++) {
                    symbolsTable.removeParameter(this.proceduresTable.getParametersTable().get(procedureName).get(i));
                }
            
            }

        } else {
                executionDescription = "El Procedimiento ->"+procedureName+" que trata de llamar No existe";
            }
        
        // Do nothing
        return graphicsNoPointer;
    
    }

    @Override
    public String getExecutionDescription() {
        return executionDescription;
    }
        
        
}
