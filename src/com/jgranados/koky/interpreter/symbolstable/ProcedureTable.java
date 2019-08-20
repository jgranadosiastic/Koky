package com.jgranados.koky.interpreter.symbolstable;
import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.interpreter.expr.Expr;
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
    public boolean compareSentParameters(List<Expr> list, String procedureName){
        if (list.size()!=parametersTable.get(procedureName).size()) {
            errorsList.add(String.format("El procedimiento '%s' no se puede ejecutar por inconsistencias en los parametros", procedureName));
            return false;
        } else {
            return true;
        }
    
    }

    public boolean exists(Token id, boolean isAnalyzingFile) {
        List<Instruction> list = this.procedureTable.get(id.getLexeme());
        if (list == null) {
            if (isAnalyzingFile) {
                errorsList.add(String.format("El Procedimiento '%s' no se ha declarado en el archivo que estoy leyendo, linea %d columna %d. Debe Declararlo para poder llamarlo.", id.getLexeme(), id.getLine(), id.getColumn()));
            } else {
                errorsList.add(String.format("El Procedimiento '%s' no se ha declarado en el area de instrucciones. Debe declararlo para poder llamarlo.", id.getLexeme()));
            }
            return false;
        }
        return true;
    }

    public List<Instruction> getListValue(Token id) {
        return this.procedureTable.get(id.getLexeme());
    }

    public boolean addProcedure(Token id,SymbolsTable localTable, boolean isAnalyzingFile, SymbolsTable symTable,List<Instruction> instructions,List<Token> parametersList) {
        if (this.procedureTable.containsKey(id.getLexeme())) {
            if (isAnalyzingFile) {
                errorsList.add(String.format("La variable '%s' que intenta declarar para la funcion  en el archivo que estoy leyendo, linea %d columna %d ya fue declarada anteriormente.", id.getLexeme(), id.getLine(), id.getColumn()));
            } else {
                errorsList.add(String.format("La variable '%s' que intenta declarar para la funcion ya fue declarada anteriormente en el area de instrucciones en otra funcion.", id.getLexeme()));
            }
            return false;
        }
        procedureTable.put(id.getLexeme(), instructions);
        this.parametersTable.put(id.getLexeme(), parametersList);
        symTable.addSymTable(id, localTable, isAnalyzingFile);
        symTable.getErrorsList().clear();
        localTable.getErrorsList().clear();
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

    public Map<String, List<Instruction>> getProcedureTable() {
        return procedureTable;
    }

    public void setProcedureTable(Map<String, List<Instruction>> procedureTable) {
        this.procedureTable = procedureTable;
    }

    public Map<String, List<Token>> getParametersTable() {
        return parametersTable;
    }
    
    public List<Token> getParameters(String id){
        return this.parametersTable.get(id);
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


