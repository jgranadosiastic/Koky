/*
 * Procedure call for execute
 */
package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.instructions.varinstructions.Assignable;
import com.jgranados.koky.interpreter.symbolstable.ProcedureTable;
import com.jgranados.koky.interpreter.token.Token;
import com.jgranados.koky.ui.KokyPointer;
import java.awt.Graphics2D;
import java.util.List;

/**
 *
 * @author bryan
 */
public class ProcedureCall extends GraphicsInstruction implements ExecutionDescribable{
    
    private List<Token> parameters; //lista de parametros a enviar para que se ejecute el procedimiento
    private String procedureName;   //nombre del procedimiento
    private ProcedureTable proceduresTable;  // tabla de procedimientos para llamar al procedimiento especifico

    public ProcedureCall(List<Token> parameters, String procedureName, ProcedureTable proceduresTable) {
        this.parameters = parameters;
        this.procedureName = procedureName;
        this.proceduresTable = proceduresTable;
    }
    

    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
       
        //ejecucion de las instrucciones que ya trae 
        //verificando si el nombre del procedimiento esta guardado en la tabla
        if (this.proceduresTable.getProcedureTable().containsKey(procedureName)) {
                //obteniendo la lista de instrucciones guardada en el procedimiento 
                for(Instruction instruction: this.proceduresTable.getProcedureTable().get(procedureName)){
                    if (instruction instanceof Graphicable) {
                        graphicsNoPointer = ((Graphicable) instruction).execute(graphicsNoPointer, currentPointer);
                        System.out.println("**** SE EJECUTARA UNA INSTRUCCION GRAFICABLE QUE TRAE EL PROCEDIMIENTO ->"+procedureName);
                    } else if (instruction instanceof Assignable) {
                        ((Assignable) instruction).assign();
                        System.out.println("**** SE EJECUTARA UNA INSTRUCCION ASIGNABLE QUE TRAE EL PROCEDIMIENTO ->"+procedureName);
                    }
                }
            
        } else {
            System.out.println("**** EL PROCEDIMIENTO QUE SE TRATA DE LLAMAR NUNCA SE DECLARO :(");
        }
        
        // Do nothing
        return graphicsNoPointer;
    
    }

    @Override
    public String getExecutionDescription() {
        return "Se a Llamado al Procedimiento ->"+procedureName+" y Se a ejecutado";
    }
        
        
}
