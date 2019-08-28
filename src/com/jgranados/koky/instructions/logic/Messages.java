
package com.jgranados.koky.instructions.logic;

import com.jgranados.koky.colors.ColorEnum;
import com.jgranados.koky.interpreter.expr.Expr;
import com.jgranados.koky.ui.KokyFrame;
import java.util.List;

/**
 *
 * @author richard
 */
public class Messages {
    
    //backward
    private static final String BACK_SPANISH = "Retrocedi %d pasos";
    private static final String BACK_ENGLISH = "Backed off %d steps";
    private static final String BACK_KICHE = "Xintzalij %d.";
    
    //forward
    private static final String FD_SPANISH = "Avance %d pasos";
    private static final String FD_ENGLISH = "Advance %d steps";
    private static final String FD_KICHE = "Cholaj %d katb'inik.";
    
    //clears
    private static final String CLEAR_SPANISH = "He limpiado la pantalla.";
    private static final String CLEAR_ENGLISH = "I have cleaned the screen.";
    private static final String CLEAR_KICHE = "Insu'm uwachib'al";
    
    //color
    private static final String COLOR_SPANISH = "Dibujaré con color %s";
    private static final String COLOR_ENGLISH = "I will draw with color %s";
    private static final String COLOR_KICHE = "Utz kinjuch'un ruk' tz'ajib'al %s";
    //color hexadecimal
    private static final String COLORH_SPANISH = "Dibujaré con color hexadecimal";
    private static final String COLORH_ENGLISH = "I will draw with color hexadecimal.";
    private static final String COLORH_KICHE = "Utz kinjuch'un ruk' tz'ajib'al hexadecimal.";
    //color error
    private static final String COLOR_ERROR_SPANISH = "El color '%d' no es correcto. Prueba uno entre 0 y 9.";
    private static final String COLOR_ERROR_ENGLISH = "The color '%d' is not correct. Try one in between 0 y 9.";
    private static final String COLOR_ERROR_KICHE = "Man are ta le tz'ajib'al le' %d'. 0 y 9.";
    
    //left
    private static final String LEFT_SPANISH = "Gire %d grados a la izquierda.";
    private static final String LEFT_ENGLISH = "Turn %d degrees to the left.";
    private static final String LEFT_KICHE = "Chasutij %d pa moxq'ab'.";
    //right
    private static final String RIGHT_SPANISH = "Gire %d grados a la derecha.";
    private static final String RIGHT_ENGLISH = "Turn %d degrees to the right.";
    private static final String RIGHT_KICHE = "Chasutij %d pa k'iq'ab'.";
    //position
    private static final String POS_SPANISH = "Me movi a la posicion ( %d , %d )";
    private static final String POS_ENGLISH = "I moved to the position ( %d , %d )";
    private static final String POS_KICHE = "Xinb'e pa k'olib'al ( %d , %d )";
    //center
    private static final String CENTER_SPANISH = "Me moví al centro.";
    private static final String CENTER_ENGLISH = "I moved downtown.";
    private static final String CENTER_KICHE = "Xinb'e pa nik'aj rech.";
    //width
    private static final String WIDTH_SPANISH = "Dibujaré con pincel de tamaño %d";
    private static final String WIDTH_ENGLISH = "I will draw with size brush %d";
    private static final String WIDTH_KICHE = "Kintz'ajon ruk' tz'ajib'al ri unimal %d";
    //errorWidth
    private static final String WIDTH_ERROR_SPANISH = "El Tamaño '%d' no es correcto. Prueba uno entre 1 y 15.";
    private static final String WIDTH_ERROR_ENGLISH = "Size '%d' is not correct. Try one between 1 and 15.";
    private static final String WIDTH_ERROR_KICHE = "Ri unimal %d man are taj. Chawila' junchike ri 15 k'olik.";
    //toggle true
    private static final String TOGGLE_TRUE_SPANISH = "He vuelto para dibujar.";
    private static final String TOGGLE_TRUE_ENGLISH = "I'm back to draw.";
    private static final String TOGGLE_TRUE_KICHE = "KICHE KICHE KICHE";
     //toggle false
    private static final String TOGGLE_FALSE_SPANISH = "Descansare por un momento. (Puedo dibujar)";
    private static final String TOGGLE_FALSE_ENGLISH = "I will rest for a moment (I can draw)";
    private static final String TOGGLE_FALSE_KICHE = "KICHE KICHE KICHE";
    //toggle for PEN true
    private static final String TOGGLE_PEN_TRUE_SPANISH = "Listo para dibujar.";
    private static final String TOGGLE_PEN_TRUE_ENGLISH = "I'm ready to draw";
    private static final String TOGGLE_PEN_TRUE_KICHE = "KICHE KICHE KICHE";
     //toggle fot PEN false
    private static final String TOGGLE_PEN_FALSE_SPANISH = "Descansare por un momento. (No hago trazos)";
    private static final String TOGGLE_PEN_FALSE_ENGLISH = "I will rest for a moment. (I don't make strokes)";
    private static final String TOGGLE_PEN_FALSE_KICHE = "KICHE KICHE KICHE";
    //toggle for PEN true
    private static final String ERASE_TRUE_SPANISH = "Borrador activado.";
    private static final String ERASE_TRUE_ENGLISH = "Draft activated";
    private static final String ERASE_TRUE_KICHE = "KICHE KICHE KICHE";
     //toggle fot PEN false
    private static final String ERASE_FALSE_SPANISH = "Borrador desactivado";
    private static final String ERASE_FALSE_ENGLISH = "Draft deactivated";
    private static final String ERASE_FALSE_KICHE = "KICHE KICHE KICHE";
     //REPEAT
    private static final String REPEAT_SPANISH = "Instruccion repetir";
    private static final String REPEAT_ENGLISH = "Repeat instruction";
    private static final String REPEAT_KICHE = "KICHE KICHE KICHE";
    //NEW VARIABLE
    private static final String VAR_SPANISH = "NUEVA VARIABLE";
    private static final String VAR_ENGLISH = "NEW VARIABLE";
    private static final String VAR_KICHE = "KICHE KICHE KICHE";
    //ERRORS IN VARIABLES
    //error creating
    private static final String ERROR_CREATE_VAR_SPANISH = "La variable '%s' no se ha creado en el area de instrucciones. Ingrese una instrucción para crear la variable.";
    private static final String ERROR_CREATE_VAR_ENGLISH = "The variable '%s' was not created in the instruction area. Enter an instruction to create the variable.";
    private static final String ERROR_CREATE_VAR_KICHE = "KICHE KICHE KICHE";
    //error of double variable
    private static final String ERROR_DOUBLE_VAR_SPANISH = "La variable '%s' que intenta declar ya fue declarada anteriormente en el area de instrucciones.";
    private static final String ERROR_DOUBLE_VAR_ENGLISH = "The variable '%s' that you are trying to declare has already been declared previously in the instruction area.";
    private static final String ERROR_DOUBLE_VAR_KICHE = "KICHE KICHE KICHE";
    //messages for new assignment
    private static final String NEW_ASSIGNMENT_SPANISH = "Nueva asignacion de valores";
    private static final String NEW_ASSIGNMENT_ENGLISH = "New value assignment.";
    private static final String NEW_ASSIGNMENT_KICHE = "Nueva asignacion de valores";
    
    //LEXERS
    //lexerAll
    private static final String ERROR_LEXER_ALL = "I don't understand the text %s in the instruction. Delete it and try again.";
    //lexer
    private static final String ERROR_LEXER_ENGLISH = "I don't understand the text %s in the instruction. Delete it and try again.";
    //lexerEs
    private static final String ERROR_LEXER_SPANISH = "No entiendo el texto %s en la instruccion. Borralo e intenta de nuevo.";
    //lexerKiche
    private static final String ERROR_LEXER_KICHE = "Man kinch'ob' taj %s jas kubij ri wuj. Chachupu tek'uri' kab'an jutij chik.";
    //CUP        
    //lexerAll
    private static final String ERROR_CUP_ALL = "I don't understand what to do with '%s'. Try again with a valid instruction. ";
    //lexer
    private static final String ERROR_CUP_ENGLISH = "I don't understand what to do with '%s'. Try again with a valid instruction. ";
    //lexerEs
    private static final String ERROR_CUP_SPANISH = "No entiendo que hacer con '%s'. Intenta de nuevo con una instruccion válida.";
    //lexerKiche
    private static final String ERROR_CUP_KICHE = "Man kinch'ob' taj jas kinb'an ruk' '%s'. Chab'ana' jutij chik ruk' jun taqanik ri toqal che.";
        
    //messages for change of languages
    private static final String LANGUAGE_ALL = "HA CAMBIADO A LENGUAJE UNIVERSAL";
    private static final String LANGUAGE_ENGLISH = "CHANGE LANGUAGE TO ENGLISH";
    private static final String LANGUAGE_SPANISH = "HA CAMBIADO A IDIOMA ESPAÑOL";
    private static final String LANGUAGE_KICHE = "Atk'o pa ri ch'ab'al K'ICHE";
  
    
    //report error
    private static final String REPORT_ERROR = "Error sintactico: Lexema: %s - Linea: %d - Columna: %d";
    
    //messages for backward 
    public static String bkMessage(Expr steps){
        return methodIfWithExpr(BACK_SPANISH,BACK_ENGLISH,BACK_KICHE, steps);
    }
    
    //messages for forward
    public static String fdMessage(Expr steps){
        return methodIfWithExpr(FD_SPANISH,FD_ENGLISH,FD_KICHE, steps);
    }
       
    //messages for left instruction (degrees)
    public static String leftMessage(Expr angle){
        return methodIfWithExpr(LEFT_SPANISH,LEFT_ENGLISH,LEFT_KICHE, angle);
    }
    
    //messages for right instruction (degrees)
    public static String rightMessage(Expr angle){
        return methodIfWithExpr(RIGHT_SPANISH,RIGHT_ENGLISH,RIGHT_KICHE, angle);
    }
    
    //messages for clears
    public static String clearsMessage(){
        return methodIfClean(CLEAR_SPANISH,CLEAR_ENGLISH,CLEAR_KICHE);
    }
    
    //messages for instruction to center
    public static String centerMessage(){
        return methodIfClean(CENTER_SPANISH,CENTER_ENGLISH,CENTER_KICHE);
    }
    
    //messages for instruction to center
    public static String widthMessage(int pluma){
        return methodIfWithInt(WIDTH_SPANISH,WIDTH_SPANISH,WIDTH_ENGLISH,WIDTH_KICHE,pluma);
    }
    
    //messages for instruction to center
    public static String widthErrorMessage(int pluma){
        return methodIfWithInt(WIDTH_ERROR_SPANISH,WIDTH_ERROR_SPANISH,WIDTH_ERROR_ENGLISH,WIDTH_ERROR_KICHE,pluma);
    }
    //messages for color
    public static String colorMessage(ColorEnum color){
        if (Languages.ALL.getTypeLanguage()==true) {
           return String.format(COLOR_SPANISH, color.toString());
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
            return String.format(COLOR_ENGLISH, color.toString());
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
           return String.format(COLOR_SPANISH, color.toString());
        }else if (Languages.KICHE.getTypeLanguage()==true) {
           return String.format(COLOR_KICHE, color.toString());
        }
        return "";
    }
    //color hexadecimal
    public static String colorHMessage(){
        return methodIfClean(COLORH_SPANISH, COLORH_ENGLISH,COLORH_KICHE);
    }
    //messages for error color
    public static String colorErrorMessage(int color){
        return methodIfWithInt(COLOR_ERROR_SPANISH, COLOR_ERROR_SPANISH,COLOR_ERROR_ENGLISH, COLOR_ERROR_KICHE, color);
    }  
    //messages for position xy, x and y
    public static String positionMessage(Integer x, Integer y){
        if (Languages.ALL.getTypeLanguage()==true) {
           return String.format(POS_SPANISH, x,y);
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
           return String.format(POS_ENGLISH, x,y);
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
           return String.format(POS_SPANISH, x,y);
        }else if (Languages.KICHE.getTypeLanguage()==true) {
           return String.format(POS_KICHE, x,y);
        }
        return "";
    }
    
    //messages for toggle turtle 
    //true
    public static String toggleTrueTurtle(){
        return methodIfClean(TOGGLE_TRUE_SPANISH,TOGGLE_TRUE_ENGLISH,TOGGLE_TRUE_KICHE);
    }
    //false
    public static String toggleFalseTurtle(){
        return methodIfClean(TOGGLE_FALSE_SPANISH,TOGGLE_FALSE_ENGLISH,TOGGLE_FALSE_KICHE);
    }  
    
    //messages for instruction repeat
    public static String repeatInstruction(){
        return methodIfClean(REPEAT_SPANISH,REPEAT_ENGLISH,REPEAT_KICHE);
    }
    
    //messages for toggle pen turtle
    //true
    public static String togglePenTrueTurtle(){
        return methodIfClean(TOGGLE_PEN_TRUE_SPANISH,TOGGLE_PEN_TRUE_ENGLISH,TOGGLE_PEN_TRUE_KICHE);
    }
    //false
    public static String togglePenFalseTurtle(){
        return methodIfClean(TOGGLE_PEN_FALSE_SPANISH,TOGGLE_PEN_FALSE_ENGLISH,TOGGLE_PEN_FALSE_KICHE);
    }    
    
    //messages for erase
    //true
    public static String eraseTrue(){
        return methodIfClean(ERASE_TRUE_SPANISH,ERASE_TRUE_ENGLISH,ERASE_TRUE_KICHE);
    }
    //false
    public static String eraseFalse(){
        return methodIfClean(ERASE_FALSE_SPANISH,ERASE_FALSE_ENGLISH,ERASE_FALSE_KICHE);
    }
    
    //message for a new asignation
    public static String newVariable(){
        return methodIfClean(VAR_SPANISH,VAR_ENGLISH,VAR_KICHE);
    }
    
    //messages for errors variables
    //error creating
    public static String errorCreatingVar(String lexeme){
        return methodIfWithString(ERROR_CREATE_VAR_SPANISH,ERROR_CREATE_VAR_SPANISH,ERROR_CREATE_VAR_ENGLISH,ERROR_CREATE_VAR_KICHE,lexeme);
    }
    //error double var
    public static String errorDoubleVar(String lexeme){
        return methodIfWithString(ERROR_DOUBLE_VAR_SPANISH,ERROR_DOUBLE_VAR_SPANISH,ERROR_DOUBLE_VAR_ENGLISH,ERROR_DOUBLE_VAR_KICHE,lexeme);
    }
    
    //messages for new assignment
    public static String newAssignment(){
        return methodIfClean(NEW_ASSIGNMENT_SPANISH,NEW_ASSIGNMENT_ENGLISH,NEW_ASSIGNMENT_KICHE);
    }
    //messages for errors in lexer
    //lexer with all languages
    public static String errorLexer(String lexeme){
        return methodIfWithString(ERROR_LEXER_ALL,ERROR_LEXER_SPANISH,ERROR_LEXER_ENGLISH,ERROR_LEXER_KICHE,lexeme);
    }
    //messages for errors in cup
    //cup with all languages
    public static String errorCup(String token){
        return methodIfWithString(ERROR_CUP_ALL,ERROR_CUP_SPANISH,ERROR_CUP_ENGLISH,ERROR_CUP_KICHE,token);
    }
    
    //messages for the change of language
    public static List<String> changeMessage(){
        if (Languages.ALL.getTypeLanguage()==true) {
            KokyFrame.infoMes.add(LANGUAGE_ALL);
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
            KokyFrame.infoMes.add(LANGUAGE_ENGLISH);
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
            KokyFrame.infoMes.add(LANGUAGE_SPANISH);
        }else if (Languages.KICHE.getTypeLanguage()==true) {
            KokyFrame.infoMes.add(LANGUAGE_KICHE);
        }
       return KokyFrame.infoMes;
    }
    
    public static String reportError(String lexema, int linea, int columna){
        return String.format(REPORT_ERROR, lexema, linea, columna);
    }
    //auxiliary methods
    private static String methodIfWithExpr(String spanishC, String englishC, String kicheC, Expr expr){
        if (Languages.ALL.getTypeLanguage()==true) {
           return String.format(spanishC, expr.operate());
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
           return String.format(englishC, expr.operate());
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
           return String.format(spanishC, expr.operate());
        }else if (Languages.KICHE.getTypeLanguage()==true) {
           return String.format(kicheC, expr.operate());
        }
        return "";
    }
    private static String methodIfClean(String spanishC, String englishC, String kicheC){
        if (Languages.ALL.getTypeLanguage()==true) {
           return String.format(spanishC);
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
           return String.format(englishC);
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
           return String.format(spanishC);
        }else if (Languages.KICHE.getTypeLanguage()==true) {
           return String.format(kicheC);
        }
        return "";
    }
    private static String methodIfWithString(String allC, String spanishC, String englishC, String kicheC, String string){
        if (Languages.ALL.getTypeLanguage()==true) {
           return String.format(allC, string);
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
           return String.format(englishC, string);
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
           return String.format(spanishC, string);
        }else if (Languages.KICHE.getTypeLanguage()==true) {
           return String.format(kicheC, string);
        }
        return "";
    }
    private static String methodIfWithInt(String allC, String spanishC, String englishC, String kicheC, int pluma){
        if (Languages.ALL.getTypeLanguage()==true) {
           return String.format(allC, pluma);
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
           return String.format(englishC, pluma);
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
           return String.format(spanishC, pluma);
        }else if (Languages.KICHE.getTypeLanguage()==true) {
           return String.format(kicheC, pluma);
        }
         return "";
    }
}
