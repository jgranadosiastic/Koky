package com.jgranados.koky.interpreter.symbolstable;
import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.instructions.graphicinstructions.ProcedureInstruction;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.interpreter.token.Token;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jose
 */
public class ProcedureTable {

    private Map<String,ProcedureInstruction> procedureTable;
    private List<String> errorsList;
    
    public ProcedureTable(List<String> errorsList) {
        this.errorsList = errorsList;
        this.procedureTable = new HashMap<>();
        
    }
    public boolean compareSentParameters(List<Expr> list, Token id){
        if (this.procedureTable.containsKey(id.getLexeme())) {
           if (list.size()!=procedureTable.get(id.getLexeme()).getParameters().size()) {
                errorsList.add(String.format("El procedimiento '%s' no se puede ejecutar por inconsistencias en los parametros", id.getLexeme()));
                return false;
            } else {
                return true;
            } 
        } else {
           errorsList.add(String.format("El Procedimiento '%s' No ha si do declarado anteriormente, linea %d columna %d .", id.getLexeme(), id.getLine(), id.getColumn()));
           return false; 
        }
        
    }

    public boolean exists(Token id, List<Token> listParameters,boolean isAnalyzingFile) {
        if (this.procedureTable.containsKey(id.getLexeme())) {
            if (isAnalyzingFile) {
                errorsList.add(String.format("El Nombre '%s' que intenta declarar para el Procedimiento  en el archivo que estoy leyendo, linea %d columna %d ya fue declarado anteriormente.", id.getLexeme(), id.getLine(), id.getColumn()));
            } else {
                errorsList.add(String.format("El nombre '%s' que intenta declarar para el Procedimiento ya fue declarado anteriormente en el area de instrucciones en otra funcion.", id.getLexeme()));
            }
            return true;
        } else {
            return compareRepeatsParameters(listParameters,id);
        }
        
    }
    
    public boolean compareRepeatsParameters(List<Token> list, Token id){
        List<String> listAux = new ArrayList();
        for(Token token : list){
            listAux.add(token.getLexeme());
        }
        Set<String> parameters = new HashSet<>(listAux);
        boolean repeatParameter = false;
        for (String key : parameters) {
            if (Collections.frequency(listAux, key)>1) {  
                repeatParameter = true;
                errorsList.add(String.format("No se Puede Repetir el Nombre de los Parametros recibidos en el Procedimiento -> '%s'.", id.getLexeme()));
                break;
            }
        }
        return repeatParameter;
    }

    public List<Instruction> getListValue(Token id) {
        return this.procedureTable.get(id.getLexeme()).getInstructions();
    }

    public boolean addProcedure(Token id, ProcedureInstruction procedureInstruction) {
        procedureTable.put(id.getLexeme(), procedureInstruction);
        procedureInstruction.getSymTableGlobal().addSymTable(id, procedureInstruction.getSymTableLocal());
        procedureInstruction.getSymTableGlobal().getErrorsList().clear();
        procedureInstruction.getSymTableLocal().getErrorsList().clear();
        return true;
    }
    
    public void cleanAll() {
        this.procedureTable.clear();
    }

    public Map<String, ProcedureInstruction> getProcedureTable() {
        return procedureTable;
    }

    public void setProcedureTable(Map<String, ProcedureInstruction> procedureTable) {
        this.procedureTable = procedureTable;
    }
    
    public List<Token> getParameters(String id){
        return this.procedureTable.get(id).getParameters();
    }
    
}


