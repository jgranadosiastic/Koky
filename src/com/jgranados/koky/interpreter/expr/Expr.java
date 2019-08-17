package com.jgranados.koky.interpreter.expr;

import com.jgranados.koky.interpreter.parser.sym;
import com.jgranados.koky.interpreter.symbolstable.SymbolsTable;
import com.jgranados.koky.interpreter.token.Token;

/**
 *
 * @author jose
 */
public class Expr {

    private int operator;
    private Expr left;
    private Expr right;
    private SymbolsTable table;
    private Token id;
    private int literalValue;

    public Expr(int operator, Expr left, Expr right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }
    
    public Expr(String literalValue) {
        this.literalValue = Integer.valueOf(literalValue);
    }
    
    public Expr(Token id, SymbolsTable table) {
        this.table = table;
        this.id = id;
    }

    public int operate() {
        switch (operator) {
            case sym.PLUS:
                return left.operate() + right.operate();
            case sym.MINUS:
                return left.operate() - right.operate();
            case sym.MULT:
                return left.operate() * right.operate();
            case sym.DIV:
                return left.operate() / right.operate();
            default:
                return getValue();
        }
    }

    public int getOperator() {
        return operator;
    }

    public Expr getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }

    private int getValue() {
        if (id != null) {
            return table.getIdValue(id);
        }
        return literalValue;
    }

}
