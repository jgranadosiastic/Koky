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
                if (getValue()!=-1) {
                    return getValue();
                } else {
                    if (table.getErrorsList().isEmpty()) {
                       table.getErrorsList().add(String.format("La variable '%s' no ha sido declarada en ningun momento, linea %d columna %d.", id.getLexeme(), id.getLine(), id.getColumn())); 
                    }
                    return 0;
                }
                
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
                if ((Integer) table.getIdValue(id)!=null) {
                    return (Integer) table.getIdValue(id);
                } else {
                    return -1;
                }
                
            } else if (this.getAmbit().equals(AmbitEnum.LOCAL.name())) {
                if (tableToken != null) {
                    SymbolsTable sym = (SymbolsTable) table.getIdValue(tableToken);
                    if (sym.getIdValue(id)==null) {
                        if ((Integer) table.getIdValue(id)!=null) {
                            return (Integer) table.getIdValue(id);
                        } else {
                            return -1;
                        }      
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
