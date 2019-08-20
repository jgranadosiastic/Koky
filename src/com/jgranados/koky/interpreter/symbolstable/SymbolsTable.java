package com.jgranados.koky.interpreter.symbolstable;

import com.jgranados.koky.interpreter.token.Token;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jose
 */
public class SymbolsTable {

    private Map<String, Object> symTable;
    private List<String> errorsList;

    public SymbolsTable(List<String> errorsList) {
        this.errorsList = errorsList;
        symTable = new HashMap<>();
    }
    public SymbolsTable() {
        symTable = new HashMap<>();
    }

    public boolean exists(Token id, boolean isAnalyzingFile) {
        Object value = this.symTable.get(id.getLexeme());
        if (value == null) {
            if (isAnalyzingFile) {
                errorsList.add(String.format("La Variable '%s' no se ha declarado en el archivo que estoy leyendo, linea %d columna %d. Por tanto no existe.", id.getLexeme(), id.getLine(), id.getColumn()));
            } else {
                errorsList.add(String.format("La Variable '%s' no se ha declarado en el area de instrucciones, linea %d columna %d. Por tanto no existe.", id.getLexeme(), id.getLine(), id.getColumn()));
            }
            return false;
        }
        return true;
    }

    public Object getIdValue(Token id) {
        return this.symTable.get(id.getLexeme());
    }

    public boolean addId(Token id, int value, boolean isAnalyzingFile) {
        if (this.symTable.containsKey(id.getLexeme())) {
            if (isAnalyzingFile) {
                errorsList.add(String.format("La variable '%s' que intenta declar en el archivo que estoy leyendo, linea %d columna %d ya fue declarada anteriormente.", id.getLexeme(), id.getLine(), id.getColumn()));
            } else {
                errorsList.add(String.format("La variable '%s' que intenta declar ya fue declarada anteriormente en el area de instrucciones.", id.getLexeme()));
            }
            return false;
        }
        symTable.put(id.getLexeme(), value);
        return true;
    }
    
    public SymbolsTable createSymTable(List<Token> parameters,boolean isAnalyzingFile){
        SymbolsTable sym = new SymbolsTable(this.errorsList);
        for (Token parameter : parameters) {
            sym.addId(parameter, 0, isAnalyzingFile);      
        }
        
        return sym;
    }
    
    public void addSymTable(Token id, SymbolsTable sym) {
        this.symTable.put(id.getLexeme(), sym);
    }
    
    public boolean verifyParameter(Token id) {
        if (!this.symTable.containsKey(id.getLexeme())) {
            return false;
        }
        return true;
    }

    public void assignValueToId(Token id, int value) {
        this.symTable.put(id.getLexeme(), value);
    }
    public void removeParameter(Token id) {
        this.symTable.remove(id.getLexeme());
    }
    
    public void cleanAll() {
        this.symTable.clear();
    }

    public Map<String, Object> getSymTable() {
        return symTable;
    }

    public void setSymTable(Map<String, Object> symTable) {
        this.symTable = symTable;
    }

    public List<String> getErrorsList() {
        return errorsList;
    }

    public void setErrorsList(List<String> errorsList) {
        this.errorsList = errorsList;
    }
    
    
}
