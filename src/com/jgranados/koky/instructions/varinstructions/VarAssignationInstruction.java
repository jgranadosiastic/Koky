package com.jgranados.koky.instructions.varinstructions;

import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.interpreter.symbolstable.SymbolsTable;
import com.jgranados.koky.interpreter.token.Token;

/**
 *
 * @author jose
 */
public class VarAssignationInstruction extends Instruction implements Assignable {
    private SymbolsTable symTable;
    private Token id;
    private Expr expr;

    public VarAssignationInstruction(SymbolsTable symTable, Token id, Expr expr) {
        this.symTable = symTable;
        this.id = id;
        this.expr = expr;
    }

    @Override
    public void assign() {
        symTable.assignValueToId(id, expr.operate());
    }
    
}
