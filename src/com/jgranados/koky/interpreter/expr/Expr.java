package com.jgranados.koky.interpreter.expr;

import com.jgranados.koky.interpreter.excepcions.ExceptionOfValue;
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
    private AmbitEnum ambit;
    private Token tableToken;

    public Expr(int operator, Expr left, Expr right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
        this.ambit = AmbitEnum.GLOBAL;
    }

    public Expr(String literalValue) {
        this.literalValue = Integer.valueOf(literalValue);
        this.ambit = AmbitEnum.GLOBAL;
    }

    public Expr(Token id, SymbolsTable table) {
        this.table = table;
        this.id = id;
        this.ambit = AmbitEnum.GLOBAL;
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
                try {
                    return getValue();
                } catch (ExceptionOfValue e) {
                    e.addError();
                    return literalValue;
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
    
    private int calculateValue() throws ExceptionOfValue {
        Integer value = (Integer) table.getIdValue(id);
        if (value!=null) {
            return value;
        } else {
            throw new ExceptionOfValue("El Valor no Existe",id,table.getErrorsList());
        }
    
    }

    private int getValue() throws ExceptionOfValue{
        if (id != null) {
            if (this.getAmbit()==null || this.getAmbit()==AmbitEnum.GLOBAL) {
                return calculateValue();
            } else if (this.getAmbit()==AmbitEnum.LOCAL) {
                if (tableToken != null) {
                    SymbolsTable sym = (SymbolsTable) table.getIdValue(tableToken);
                    if (sym.getIdValue(id)!=null) {
                        return (Integer) sym.getIdValue(id);   
                    } else {
                        return calculateValue();
                    }
                } else {
                    return literalValue;
                }
            }
        }
        return literalValue;
    }

    public AmbitEnum getAmbit() {
        return ambit;
    }

    public void setAmbit(AmbitEnum ambit) {
        this.ambit = ambit;
    }

    
    public Token getTableToken() {
        return tableToken;
    }

    public void setTableToken(Token tableToken) {
        this.tableToken = tableToken;
    }

    
    
}
