/*
 * tabla de procedimientos almacenados para ejecutar
 */
package com.jgranados.koky.interpreter.symbolstable;

import com.jgranados.koky.instructions.Instruction;
import java.util.Map;

/**
 *
 * @author bryan
 */
public class ProceduresTable {
    private Map<String, Instruction> proTable;

    public ProceduresTable(Map<String, Instruction> proTable) {
        this.proTable = proTable;
    }
    /*Esta podria ser una manera para almacenar los procedimientos y luego llamarlos para ejecutarlos*/
         
}
