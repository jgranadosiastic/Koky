/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.koky.instructions.logic;

import com.jgranados.koky.colors.ColorEnum;
import com.jgranados.koky.interpreter.expr.Expr;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author richard
 */
public class Messages {
    private String messageReturn = "";
    
    //backward
    private final String BACK_SPANISH = "Retrocedi %d pasos";
    private final String BACK_ENGLISH = "Backed off %d steps";
    private final String BACK_KICHE = "KICHE KICHE %d KICHE";
    
    //forward
    private final String FD_SPANISH = "Avance %d pasos";
    private final String FD_ENGLISH = "Advance %d steps";
    private final String FD_KICHE = "KICHE KICHE %d KICHE";
    
    //clears
    private final String CLEAR_SPANISH = "He limpiado la pantalla.";
    private final String CLEAR_ENGLISH = "I have cleaned the screen.";
    private final String CLEAR_KICHE = "KICHE KICHE KICHE";
    
    //color
    private final String COLOR_SPANISH = "Dibujaré con color %s";
    private final String COLOR_ENGLISH = "I will draw with color %s";
    private final String COLOR_KICHE = "KICHE KICHE KICHE %s";
    //color error
    private final String COLOR_ERROR_SPANISH = "El color '%d' no es correcto. Prueba uno entre 0 y 9.";
    private final String COLOR_ERROR_ENGLISH = "The color '%d' is not correct. Try one in between 0 y 9.";
    private final String COLOR_ERROR_KICHE = "KICHE El color '%d' no es correcto. Prueba uno entre 0 y 9.";
    
    //left
    private final String LEFT_SPANISH = "Gire %d grados a la izquierda.";
    private final String LEFT_ENGLISH = "Turn %d degrees to the left.";
    private final String LEFT_KICHE = "KICHE %d KICHE KICHE";
    //right
    private final String RIGHT_SPANISH = "Gire %d grados a la derecha.";
    private final String RIGHT_ENGLISH = "Turn %d degrees to the right.";
    private final String RIGHT_KICHE = "KICHE %d KICHE KICHE";
    //position
    private final String POS_SPANISH = "Me movi a la posicion ( %d , %d )";
    private final String POS_ENGLISH = "I moved to the position ( %d , %d )";
    private final String POS_KICHE = "KICHE KICHE ( %d , %d )";
    //center
    private final String CENTER_SPANISH = "Me moví al centro.";
    private final String CENTER_ENGLISH = "I moved downtown.";
    private final String CENTER_KICHE = "KICHE KICHE KICHE";
    //width
    private final String WIDTH_SPANISH = "Dibujaré con pincel de tamaño %d";
    private final String WIDTH_ENGLISH = "I will draw with size brush %d";
    private final String WIDTH_KICHE = "KICHE KICHE KICHE %d";
    //errorWidth
    private final String WIDTH_ERROR_SPANISH = "El Tamaño '%d' no es correcto. Prueba uno entre 1 y 15.";
    private final String WIDTH_ERROR_ENGLISH = "Size '%d' is not correct. Try one between 1 and 15.";
    private final String WIDTH_ERROR_KICHE = "KICHE %d KICHE KICHE";
    //LEXERS
    //lexerAll
    private final String ERROR_LEXER_ALL = "I don't understand the text %s in the instruction. Delete it and try again.";
    //lexer
    private final String ERROR_LEXER_ENGLISH = "I don't understand the text %s in the instruction. Delete it and try again.";
    //lexerEs
    private final String ERROR_LEXER_SPANISH = "No entiendo el texto %s en la instruccion. Borralo e intenta de nuevo.";
    //lexerKiche
    private final String ERROR_LEXER_KICHE = "Ayi’ Ch’ob’o are tzij %s en are Cholajil. Kchuputaj e intenta de K’ak’.";
    //CUP        
    //lexerAll
    private final String ERROR_CUP_ALL = "I don't understand what to do with '%s'. Try again with a valid instruction. ";
    //lexer
    private final String ERROR_CUP_ENGLISH = "I don't understand what to do with '%s'. Try again with a valid instruction. ";
    //lexerEs
    private final String ERROR_CUP_SPANISH = "No entiendo que hacer con '%s'. Intenta de nuevo con una instruccion válida.";
    //lexerKiche
    private final String ERROR_CUP_KICHE = "KICHE KICHE KICHE KICHE '%s'. KICHE KICHE KICHE KICHE KICHE KICHE KICHE KICHE.";
        
    //messages for change of languages
    private final String LANGUAGE_ALL = "HA CAMBIADO A LENGUAJE UNIVERSAL";
    private final String LANGUAGE_ENGLISH = "CHANGE LANGUAGE TO ENGLISH";
    private final String LANGUAGE_SPANISH = "HA CAMBIADO A IDIOMA ESPA;OL";
    private final String LANGUAGE_KICHE = "IDIOMA KICHE";
    List<String> infoMes = new ArrayList<>();
    
    //report error
    private final String REPORT_ERROR = "Error sintactico: Lexema: %s - Linea: %d - Columna: %d";
    
    //messages for backward 
    public String bkMessage(Expr steps){
        return methodIfWithExpr(BACK_SPANISH,BACK_ENGLISH,BACK_KICHE, steps);
    }
    
    //messages for forward
    public String fdMessage(Expr steps){
        return methodIfWithExpr(FD_SPANISH,FD_ENGLISH,FD_KICHE, steps);
    }
       
    //messages for left instruction (degrees)
    public String leftMessage(Expr angle){
        return methodIfWithExpr(LEFT_SPANISH,LEFT_ENGLISH,LEFT_KICHE, angle);
    }
    
    //messages for right instruction (degrees)
    public String rightMessage(Expr angle){
        return methodIfWithExpr(RIGHT_SPANISH,RIGHT_ENGLISH,RIGHT_KICHE, angle);
    }
    
    //messages for clears
    public String clearsMessage(){
        return methodIfClean(CLEAR_SPANISH,CLEAR_ENGLISH,CLEAR_KICHE);
    }
    
    //messages for instruction to center
    public String centerMessage(){
        return methodIfClean(CENTER_SPANISH,CENTER_ENGLISH,CENTER_KICHE);
    }
    
    //messages for instruction to center
    public String widthMessage(int pluma){
        return methodIfWithInt(WIDTH_SPANISH,WIDTH_ENGLISH,WIDTH_SPANISH,WIDTH_KICHE,pluma);
    }
    
    //messages for instruction to center
    public String widthErrorMessage(int pluma){
        return methodIfWithInt(WIDTH_ERROR_SPANISH,WIDTH_ERROR_ENGLISH,WIDTH_ERROR_SPANISH,WIDTH_ERROR_KICHE,pluma);
    }
    //messages for color
    public String colorMessage(ColorEnum color){
        if (Languages.ALL.getTypeLanguage()==true) {
           messageReturn= String.format(COLOR_SPANISH, color.toString());
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
            messageReturn= String.format(COLOR_ENGLISH, color.toString());
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
           messageReturn= String.format(COLOR_SPANISH, color.toString());
        }else if (Languages.KICHE.getTypeLanguage()==true) {
            messageReturn= String.format(COLOR_KICHE, color.toString());
        }
        return messageReturn;
    }
    //messages for error color
    public String colorErrorMessage(int color){
        if (Languages.ALL.getTypeLanguage()==true) {
           messageReturn= String.format(COLOR_ERROR_SPANISH, color);
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
            messageReturn= String.format(COLOR_ERROR_ENGLISH, color);
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
           messageReturn= String.format(COLOR_ERROR_SPANISH, color);
        }else if (Languages.KICHE.getTypeLanguage()==true) {
            messageReturn= String.format(COLOR_ERROR_KICHE, color);
        }
        return messageReturn;
    }  
    //messages for position xy, x and y
    public String positionMessage(Integer x, Integer y){
        if (Languages.ALL.getTypeLanguage()==true) {
           messageReturn = String.format(POS_SPANISH, x,y);
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
            messageReturn = String.format(POS_ENGLISH, x,y);
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
           messageReturn = String.format(POS_SPANISH, x,y);
        }else if (Languages.KICHE.getTypeLanguage()==true) {
            messageReturn = String.format(POS_KICHE, x,y);
        }
        return messageReturn;
    }
           
    //messages for errors in lexer
    //lexer with all languages
    public String errorLexer(String lexeme){
        return methodIfWithString(ERROR_LEXER_ALL,ERROR_LEXER_ENGLISH,ERROR_LEXER_SPANISH,ERROR_LEXER_KICHE,lexeme);
    }
    //messages for errors in cup
    //cup with all languages
    public String errorCup(String token){
        return methodIfWithString(ERROR_CUP_ALL,ERROR_CUP_ENGLISH,ERROR_CUP_SPANISH,ERROR_CUP_KICHE,token);
    }
    
    //messages for the change of language
    public List<String> changeMessage(){
        if (Languages.ALL.getTypeLanguage()==true) {
            infoMes.add(LANGUAGE_ALL);
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
            infoMes.add(LANGUAGE_ENGLISH);
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
            infoMes.add(LANGUAGE_SPANISH);
        }else if (Languages.KICHE.getTypeLanguage()==true) {
            infoMes.add(LANGUAGE_KICHE);
        }
       return infoMes;
    }
    
    public String reportError(String lexema, int linea, int columna){
        messageReturn = String.format(REPORT_ERROR, lexema, linea, columna);
        return messageReturn;
    }
    //auxiliary methods
    private String methodIfWithExpr(String spanishC, String englishC, String kicheC, Expr expr){
        if (Languages.ALL.getTypeLanguage()==true) {
           messageReturn = String.format(spanishC, expr.operate());
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
           messageReturn = String.format(englishC, expr.operate());
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
           messageReturn = String.format(spanishC, expr.operate());
        }else if (Languages.KICHE.getTypeLanguage()==true) {
           messageReturn = String.format(kicheC, expr.operate());
        }
        return messageReturn;
    }
    private String methodIfClean(String spanishC, String englishC, String kicheC){
        if (Languages.ALL.getTypeLanguage()==true) {
           messageReturn = String.format(spanishC);
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
           messageReturn = String.format(englishC);
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
           messageReturn = String.format(spanishC);
        }else if (Languages.KICHE.getTypeLanguage()==true) {
           messageReturn = String.format(kicheC);
        }
        return messageReturn;
    }
    private String methodIfWithString(String allC, String spanishC, String englishC, String kicheC, String string){
        if (Languages.ALL.getTypeLanguage()==true) {
           messageReturn = String.format(allC, string);
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
            messageReturn = String.format(spanishC, string);
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
           messageReturn = String.format(englishC, string);
        }else if (Languages.KICHE.getTypeLanguage()==true) {
           messageReturn = String.format(kicheC, string);
        }
        return messageReturn;
    }
    private String methodIfWithInt(String allC, String spanishC, String englishC, String kicheC, int pluma){
        if (Languages.ALL.getTypeLanguage()==true) {
           messageReturn = String.format(allC, pluma);
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
            messageReturn = String.format(spanishC, pluma);
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
           messageReturn = String.format(englishC, pluma);
        }else if (Languages.KICHE.getTypeLanguage()==true) {
           messageReturn = String.format(kicheC, pluma);
        }
        return messageReturn;
    }
}
