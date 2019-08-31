package com.jgranados.koky.instructions.varinstructions;

import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.interpreter.expr.AmbitEnum;
import com.jgranados.koky.instructions.logic.Messages;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.interpreter.symbolstable.ProcedureTable;
import com.jgranados.koky.interpreter.symbolstable.SymbolsTable;
import com.jgranados.koky.interpreter.token.Token;

/**
 *
 * @author jose
 */
public class VarAssignationInstruction extends Instruction implements Assignable,ExecutionDescribable {
    private SymbolsTable symTable;
    private ProcedureTable procedureTable;
    private Token id;
    private Expr expr;

    public VarAssignationInstruction(SymbolsTable symTable, ProcedureTable procedureTable, Token id, Expr expr) {
        this.symTable = symTable;
        this.procedureTable = procedureTable;
        this.id = id;
        this.expr = expr;
    }

    @Override
    public void assign() {
        if (procedureTable.existName(id)) {
             symTable.assignValueToId(id, expr.operate());
        } else {
            
        }
    }

    @Override
    public void assignAmbitToExpresions() {
        if(this.getAmbit()!=null){
            expr.setAmbit(this.getAmbit());
        }else{
            expr.setAmbit(AmbitEnum.GLOBAL);
        }
        
    }

    @Override
    public void assignTableTokenValue(Token token) {
        expr.setTableToken(token);
    }
    
    public String getExecutionDescription() {
        return Messages.newAssignment();
    } 

}
