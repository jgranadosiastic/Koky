
package com.jgranados.koky.interpreter.symbolstable;

import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.interpreter.token.Token;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jcsr
 */



import com.jgranados.koky.interpreter.token.Token;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jose
 */
public class ProcedureTable {
    
// clase creada con el fin de tener una tabla de procesos, y llevar el control de los parametros de cada funcion
    // aqui se guardara toda la informacion de una funcion: sus parametros, sus instrucciones, y el id que identifica a la funcion.

    private Map<String, List<Instruction>> procedureTable;
    private List<String> errorsList;
    //private Map<String, List<Token>> parametersTable;

    public ProcedureTable(List<String> errorsList) {
        this.errorsList = errorsList;
        procedureTable = new HashMap<>();
    }

    public boolean exists(Token id, boolean isAnalyzingFile) {
        List<Instruction> list = this.procedureTable.get(id.getLexeme());
        if (list == null) {
            if (isAnalyzingFile) {
                errorsList.add(String.format("La variable '%s' para la funcion no se ha creado en el archivo que estoy leyendo, linea %d columna %d. Debe crear la variable antes de usarla.", id.getLexeme(), id.getLine(), id.getColumn()));
            } else {
                errorsList.add(String.format("La variable '%s' para la funcion no se ha creado en el area de instrucciones. Ingrese una instrucción para crear la variable.", id.getLexeme()));
            }
            return false;
        }
        return true;
    }

    public List<Instruction> getListValue(Token id) {
        return this.procedureTable.get(id.getLexeme());
    }

    public boolean addId(Token id, List<Instruction> value, boolean isAnalyzingFile) {
        if (this.procedureTable.containsKey(id.getLexeme())) {
            if (isAnalyzingFile) {
                errorsList.add(String.format("La variable '%s' que intenta declarar para la funcion  en el archivo que estoy leyendo, linea %d columna %d ya fue declarada anteriormente.", id.getLexeme(), id.getLine(), id.getColumn()));
            } else {
                errorsList.add(String.format("La variable '%s' que intenta declarar para la funcion ya fue declarada anteriormente en el area de instrucciones en otra funcion.", id.getLexeme()));
            }
            return false;
        }
        procedureTable.put(id.getLexeme(), value);
        return true;
    }

    public void assignValueToId(Token id, List<Instruction> value) {
        this.procedureTable.put(id.getLexeme(), value);
    }
    
    public void cleanAll() {
        this.procedureTable.clear();
    }
}


