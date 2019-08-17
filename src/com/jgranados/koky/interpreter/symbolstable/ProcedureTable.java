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
    private Map<String, List<Token>> parametersTable;
    private Map<String, SymbolsTable> localSymTable;
    

    public ProcedureTable(List<String> errorsList) {
        this.errorsList = errorsList;
        procedureTable = new HashMap<>();
        parametersTable = new HashMap<>();
        localSymTable = new HashMap<>();
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

    public List<Instruction> getInstructionList(Token id) {
        return this.procedureTable.get(id.getLexeme());
    }

    public List<Token> getParameterList(Token id) {
        return this.parametersTable.get(id.getLexeme());
    }
    
    public SymbolsTable getLocalSymbolsTable(Token id){
        return this.localSymTable.get(id.getLexeme());
    }

    public boolean addProcedure(Token id, List<Instruction> value, List<Token> parameters, boolean isAnalyzingFile) {
        if (this.procedureTable.containsKey(id.getLexeme())) {
            if (isAnalyzingFile) {
                errorsList.add(String.format("La variable '%s' que intenta declarar para la funcion  en el archivo que estoy leyendo, linea %d columna %d ya fue declarada anteriormente.", id.getLexeme(), id.getLine(), id.getColumn()));
            } else {
                errorsList.add(String.format("La variable '%s' que intenta declarar para la funcion ya fue declarada anteriormente en el area de instrucciones en otra funcion.", id.getLexeme()));
            }
            return false;
        }
        SymbolsTable symTable = createLocalSymTable( parameters, isAnalyzingFile);
        
        procedureTable.put(id.getLexeme(), value);
        parametersTable.put(id.getLexeme(), parameters);
        localSymTable.put(id.getLexeme(), symTable);
        return true;
    }
    
    public SymbolsTable createLocalSymTable(List<Token> parameters,boolean isAnalyzingFile){
        SymbolsTable symTable = new SymbolsTable(errorsList);
        for (Token parameter : parameters) {   
            Integer value = symTable.getIdValue(parameter);
            if(value==null){
                symTable.addId(parameter, 0, isAnalyzingFile);
            }else{
                errorsList.add(String.format("La variable del parametro '%s' ya esta declarada. No pueden existir dos parametros con el mismo nombre, linea %d columna %d.", parameter.getLexeme(), parameter.getLine(), parameter.getColumn()));
                symTable.cleanAll();
                return null;
            }
                
            
            
        }
        return symTable;
    }

    public void assignInstructionToId(Token id, List<Instruction> value) {
        this.procedureTable.put(id.getLexeme(), value);
    }

    public void assignParametersToId(Token id, List<Token> parameters) {
        this.parametersTable.put(id.getLexeme(), parameters);
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
    
    
}