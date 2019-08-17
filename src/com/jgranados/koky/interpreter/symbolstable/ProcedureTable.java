
package com.jgranados.koky.interpreter.symbolstable;
import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.interpreter.token.Token;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jose
 */
public class ProcedureTable {

    private Map<String, List<Instruction>> procedureTable;
    private List<String> errorsList;
    private Map<String, List<Token>> parametersTable;
    private SymbolsTable temporarySymbolTable;
    public ProcedureTable(List<String> errorsList) {
        this.errorsList = errorsList;
        this.procedureTable = new HashMap<>();
        this.parametersTable = new HashMap<>();
        this.temporarySymbolTable = new SymbolsTable();
        
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

    public boolean addProcedure(Token id, List<Instruction> value, boolean isAnalyzingFile) {
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
    
    public void addParameters(Token id, List<Token> value) {
        //save parameters of Procedure
        parametersTable.put(id.getLexeme(), value);
    }
    
    public void cleanAll() {
        this.procedureTable.clear();
        this.parametersTable.clear();
    }
    
    
    public boolean sameParameters(Token id, List<Token> list,boolean isAnalyzingFile) {
        List<Token> parameters = parametersTable.get(id.getLexeme());
        if (parameters.size() == list.size()) {
            return true;
        } else {
            if (isAnalyzingFile) {
                errorsList.add(String.format("El numero de los parametros de la funcion '%s' no son los mismos que los que se le estan tratando de asignar  en el archivo que estoy leyendo, linea %d columna %d.", id.getLexeme(), id.getLine(), id.getColumn()));
            } else {
                errorsList.add(String.format("El numero de los parametros de la funcion '%s' no son los mismos que los que se le estan tratando de asignar en el area de instrucciones en otra funcion.", id.getLexeme()));
            }
            return false;
        }
    }

    public Map<String, List<Instruction>> getProcedureTable() {
        return procedureTable;
    }

    public void setProcedureTable(Map<String, List<Instruction>> procedureTable) {
        this.procedureTable = procedureTable;
    }

    public Map<String, List<Token>> getParametersTable() {
        return parametersTable;
    }

    public void setParametersTable(Map<String, List<Token>> parametersTable) {
        this.parametersTable = parametersTable;
        
        
        
        
    }
    
    
    
    
    
    
    
    

    public SymbolsTable getTemporarySymbolTable() {
        return temporarySymbolTable;
    }

    public void setTemporarySymbolTable(SymbolsTable temporarySymbolTable) {
        this.temporarySymbolTable = temporarySymbolTable;
    }
    
    
}


