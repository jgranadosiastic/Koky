/*
 * Instruccion para manejar el procedimiento
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
public class ProcedureInstruction extends GraphicsInstruction implements ExecutionDescribable{
    
    
    private String processName; 
    //private SymbolsTable table;           //tabla de parametros podrian ser solo referencias hacia los verdaderos se supone que ya fueron declarados
    private List<Token> parameters;     //lista de parametros es una opcion a la tabla anterior para manejar parametros temporales
    private List<Instruction> instructions; //instruccion que vienen en la funcion
    private ProcedureTable proceduresTable;  // tabla de procedimientos

    public ProcedureInstruction(String processName, List<Token> parameters, List<Instruction> instructions, ProcedureTable proceduresTable) {
        this.processName = processName;
        this.parameters = parameters;
        this.instructions = instructions;
        this.proceduresTable = proceduresTable;
    }
    
    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        //Ejecutando instrucciones, hasta que se llame al procedimiento, cuando se declara no se deben ejecutar.
        
        /*
        for (Instruction instruction : instructions) {
            if (instruction instanceof Graphicable) {
                graphicsNoPointer = ((Graphicable) instruction).execute(graphicsNoPointer, currentPointer);
            } else if (instruction instanceof Assignable) {
                ((Assignable) instruction).assign();
            }
        }
        */
        System.out.println("****** SI TODO VA BIEN DIGAMOS QUE ESTE PROCEDIMIENTO YA ESTA GUARDADO");
        
        return graphicsNoPointer;
    }

    @Override
    public String getExecutionDescription() {
        
        return "Se a guardado el procedimiento ->"+processName+" en espera de ser ejecutado";
    }
    
    
}
