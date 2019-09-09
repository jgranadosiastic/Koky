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
            if (this.getAmbit() == AmbitEnum.LOCAL) {
                if (tableToken != null) {
                    try {
                        SymbolsTable sym = (SymbolsTable) table.getIdValue(tableToken);
                        if (sym !=null && sym.getIdValue(id) != null) {
                            return (Integer) sym.getIdValue(id);
                        }
                    } catch (ClassCastException e) {

                    }
                }

            }
            if (table.getIdValue(id) != null) {
                return (Integer) table.getIdValue(id);
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

    public void changeAmbit(AmbitEnum ambit) {
        if (left != null) {
            left.changeAmbit(ambit);
        }
        if (right != null) {
            right.changeAmbit(ambit);
        }

        this.setAmbit(ambit);
    }

    public void changeTableToken(Token tableToken) {
        if (left != null) {
            left.changeTableToken(tableToken);
        }
        if (right != null) {
            right.changeTableToken(tableToken);
        }

        this.setTableToken(tableToken);

    }
}



//            
//            if (this.getAmbit()==null || this.getAmbit()==AmbitEnum.GLOBAL) {
//                return (Integer) table.getIdValue(id);
//            } else if (this.getAmbit()==AmbitEnum.LOCAL) {
//                if (tableToken != null) {
//                    SymbolsTable sym = (SymbolsTable) table.getIdValue(tableToken);
//                    if (sym.getIdValue(id)!=null) {
//                        return (Integer) sym.getIdValue(id);   
//                    } else {
//                        return (Integer) table.getIdValue(id);
//                    }
//                } else {
//                    return literalValue;
//                }
//            }
//        }        