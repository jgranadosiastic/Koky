package com.jgranados.koky.interpreter.excepcions;

import com.jgranados.koky.interpreter.token.Token;
import java.util.List;

/**
 *
 * @author bryan
 */
public class ExceptionOfValue extends Exception{
    private Token id;
    private List<String> errorList;
    public ExceptionOfValue(String msg, Token id, List<String> errorList){
        super(msg);
        this.id = id;
        this.errorList = errorList;
        
    }
    public void addError(){
        /*The absence of a variable is verified up to this point, given that
            obvious validation of expressions in the country to avoid problems
            with the parameters in the procedures*/
        if (errorList.isEmpty()) {
           errorList.add(String.format("La variable '%s' no ha sido declarada en ningun momento, linea %d columna %d.", id.getLexeme(), id.getLine(), id.getColumn())); 
        }
    }
}
