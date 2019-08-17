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
    private String ambit;
    private Token tableToken;

    public Expr(int operator, Expr left, Expr right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
        this.ambit = AmbitEnum.GLOBAL.name();
    }

    public Expr(String literalValue) {
        this.literalValue = Integer.valueOf(literalValue);
        this.ambit = AmbitEnum.GLOBAL.name();
    }

    public Expr(Token id, SymbolsTable table) {
        this.table = table;
        this.id = id;
        this.ambit = AmbitEnum.GLOBAL.name();
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
            if (this.getAmbit()==null || this.getAmbit().equals(AmbitEnum.GLOBAL.name())) {
                System.out.println("Entro a la tabla global: "+table.getIdValue(id));
                return (Integer) table.getIdValue(id);
            } else if (this.getAmbit().equals(AmbitEnum.LOCAL.name())) {
                if (tableToken != null) {
                    SymbolsTable sym = (SymbolsTable) table.getIdValue(tableToken);
                    if (sym.getIdValue(id)==null) {
                        return (Integer) table.getIdValue(id);
                    } else {
                        return (Integer) sym.getIdValue(id);
                    }
                } else {
                    return literalValue;
                }
            }
        }
        return literalValue;
    }

    public String getAmbit() {
        return ambit;
    }

    public void setAmbit(String ambit) {
        this.ambit = ambit;
    }

    public Token getTableToken() {
        return tableToken;
    }

    public void setTableToken(Token tableToken) {
        this.tableToken = tableToken;
    }

    
    
}
