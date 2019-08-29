package com.jgranados.koky.ui;
import com.jgranados.koky.challengeshistory.HistoryHandler;
import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.instructions.logic.Languages;
import com.jgranados.koky.interpreter.lexer.Lexer;
import com.jgranados.koky.interpreter.lexer.languages.LexerAll;
import com.jgranados.koky.interpreter.lexer.languages.LexerEs;
import com.jgranados.koky.interpreter.lexer.languages.LexerKiche;
import com.jgranados.koky.interpreter.parser.Parser;
import com.jgranados.koky.interpreter.symbolstable.SymbolsTable;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java_cup.runtime.Scanner;
import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author anclenius
 */
public class KFrame extends javax.swing.JFrame {
    
    
    protected static final String ICON_URL = "/com/jgranados/koky/ui/images/kok_pointer.png";
    protected static final String KOK_EXTENSION = "kok";
    protected static final String KOK_EXTENSION_DESC = "Archivos Kok";
    protected static final String JPG_FILE_EXTENSION = "jpg";
    protected static final String JPG__DOT_FILE_EXTENSION = ".jpg";
    protected static final String CLEARS = "clears";
    protected static final String LINE = "\n";
    protected static final String BR = "<br>";
    protected static final int NUM_SUBSTRING = 2;
    private PanelDraw panelDraw;
    private int instructionsMade = 0;
    private Boolean coutingSteps = false;
    private HistoryHandler challengeHistoryHandler = new HistoryHandler();
    private Scanner sc;
    protected Lexer lexerEn;
    protected LexerAll lexerAll;
    protected LexerEs lexerSp;
    protected LexerKiche lexerKi;
    protected Lexer myLexer;
    protected Parser myParser;
    protected SymbolsTable instructionsSymTable;
    protected String lastInput;
    protected ArrayList<String> historyInput = new ArrayList<>();
    protected int history = 0;
    protected JEditorPane txtMessages;
    protected boolean isFile;
    
    protected KFrame(boolean isFile) {
        this.typeLanguage();
        txtMessages = new JEditorPane();
        myLexer = new Lexer(new StringReader(""));
        instructionsSymTable = new SymbolsTable(myLexer.getErrorsList());
        
        this.isFile = isFile;
        if(isFile) {
            myLexer.setAnalyzingFile(true);
        }
    }
    
    protected JEditorPane getEditorPane() {
        return this.txtMessages;
    }
    
    protected void parseInstruction(String instruction, PanelDraw panelDraw) {
        if(isFile) {
            instructionsSymTable.cleanAll();
            txtMessages.setText("");
        }
        if (Languages.ALL.getTypeLanguage()==true) {
            lexerAll(lexerAll, instruction, panelDraw);
        }else if (Languages.SPANISH.getTypeLanguage()==true) {
            lexerSpanish(lexerSp, instruction, panelDraw);
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
            lexerEnglish(lexerEn, instruction, panelDraw);
        }else if (Languages.KICHE.getTypeLanguage()==true) {
            lexerKiche(lexerKi, instruction, panelDraw);
        }
    }
    
    protected void addSuccessMessages(List<String> messages) {
        addMessages(messages);
    }
    
    protected void addErrorMessages(List<String> messages) {
        List<String> errorMessages = messages
                .stream()
                .map(message -> "<font color=\"red\">" + message + "</font>")
                .collect(Collectors.toList());
        addMessages(errorMessages);
        messages.clear();
    }
    
    protected void addMessages(List<String> messages) {
        if (!messages.isEmpty()) {
            HTMLDocument doc = (HTMLDocument) txtMessages.getDocument();
            try {
                doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()), String.join(BR, messages) + BR);
            } catch (BadLocationException | IOException ex) {
                Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtMessages.setCaretPosition(doc.getLength());
        }
    }
    
    protected void addMessagesInfo(List<String> messages) {
            List<String> errorMessages = messages
                    .stream()
                    .map(message -> "<font color=\"red\">" + message + "</font>")
                    .collect(Collectors.toList());
            addMessages(errorMessages);
            messages.clear();       
    }
    
    //type of lexer to execute
    private void lexerAll(LexerAll lexer, String instruction,PanelDraw panelDraw){
        lexer.yyreset(new StringReader(instruction + LINE));
            try {
                List<Instruction> instructions = (List<Instruction>) this.myParser.parse().value;
                if (lexer.getErrorsList().isEmpty()) {
                    List<String> executionDescriptions = panelDraw.runInstructions(instructions);
                    addSuccessMessages(executionDescriptions);
                }
            } catch (Exception ex) {
                Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void lexerSpanish(LexerEs lexer, String instruction,PanelDraw panelDraw){
        lexer.yyreset(new StringReader(instruction + LINE));
            try {
                List<Instruction> instructions = (List<Instruction>) this.myParser.parse().value;
                if (lexer.getErrorsList().isEmpty()) {
                    List<String> executionDescriptions = panelDraw.runInstructions(instructions);
                    addSuccessMessages(executionDescriptions);
                }
            } catch (Exception ex) {
                Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void lexerEnglish(Lexer lexer, String instruction,PanelDraw panelDraw){
        lexer.yyreset(new StringReader(instruction + LINE));
            try {
                List<Instruction> instructions = (List<Instruction>) this.myParser.parse().value;
                if (lexer.getErrorsList().isEmpty()) {
                    List<String> executionDescriptions = panelDraw.runInstructions(instructions);
                    addSuccessMessages(executionDescriptions);
                }
            } catch (Exception ex) {
                Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void lexerKiche(LexerKiche lexer, String instruction,PanelDraw panelDraw){
        lexer.yyreset(new StringReader(instruction + LINE));
            try {
                List<Instruction> instructions = (List<Instruction>) this.myParser.parse().value;
                if (lexer.getErrorsList().isEmpty()) {
                    List<String> executionDescriptions = panelDraw.runInstructions(instructions);
                    addSuccessMessages(executionDescriptions);
                }
            } catch (Exception ex) {
                Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    protected void typeLanguage(){
        if(Languages.ALL.getTypeLanguage() == true){
            lexerAll = new LexerAll(new StringReader(""));
            sc = lexerAll;
            instructionsSymTable = new SymbolsTable(lexerAll.getErrorsList());
            typeParser(sc, instructionsSymTable);    
        }else if (Languages.SPANISH.getTypeLanguage() == true) {
            lexerSp = new LexerEs(new StringReader(""));
            sc = lexerSp;
            instructionsSymTable = new SymbolsTable(lexerSp.getErrorsList());
            typeParser(sc, instructionsSymTable);         
        }else if (Languages.ENGLISH.getTypeLanguage()==true) {
            lexerEn = new Lexer(new StringReader(""));
            sc = lexerEn;
            instructionsSymTable = new SymbolsTable(lexerEn.getErrorsList());
            typeParser(sc, instructionsSymTable);
         
        }else if (Languages.KICHE.getTypeLanguage()==true) {
            lexerKi = new LexerKiche(new StringReader(""));
            sc = lexerKi;
            instructionsSymTable = new SymbolsTable(lexerKi.getErrorsList());
            typeParser(sc, instructionsSymTable);   
        }
        
    }
    
    protected void typeParser(Scanner sc, SymbolsTable symbols){
        myParser = new Parser(sc, symbols);
    }
}
