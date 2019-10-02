package com.jgranados.koky.ui;

import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.instructions.logic.Languages;
import com.jgranados.koky.interpreter.lexer.Lexer;
import com.jgranados.koky.interpreter.lexer.languages.Language;
import com.jgranados.koky.interpreter.lexer.languages.LexerAll;
import com.jgranados.koky.interpreter.lexer.languages.LexerEs;
import com.jgranados.koky.interpreter.lexer.languages.LexerKiche;
import com.jgranados.koky.interpreter.parser.Parser;
import com.jgranados.koky.interpreter.symbolstable.ProcedureTable;
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

    protected static final String KOK_EXTENSION = "kok";
    protected static final String KOK_EXTENSION_DESC = "Archivos Kok";
    protected static final String JPG_FILE_EXTENSION = "jpg";
    protected static final String JPG__DOT_FILE_EXTENSION = ".jpg";
    protected static final String LINE = "\n";
    protected static final String BR = "<br>";
    protected static final String USER_MANUAL_DOC_PATH = "Manual-de-Usuario-Koky.pdf";
    protected Scanner sc;
    protected Lexer lexerEn;
    protected LexerAll lexerAll;
    protected LexerEs lexerSp;
    protected LexerKiche lexerKi;
    protected Lexer myLexer;
    protected Parser myParser;
    protected SymbolsTable instructionsSymTable;
    protected ProcedureTable instructionsSymProcedureTable;
    protected JEditorPane txtMessages;
    protected boolean isFile;
    protected List<String> infoMesages = new ArrayList<>();
    protected Language language;
    private String cleanWord = "clears";

    public KFrame(boolean isFile) {
        this.typeLanguage();
        txtMessages = new JEditorPane();
        myLexer = new Lexer(new StringReader(""));

        this.isFile = isFile;
        if (isFile) {
            myLexer.setAnalyzingFile(true);
        }
    }

    protected JEditorPane getEditorPane() {
        return this.txtMessages;
    }

    protected void parseInstruction(String instruction, PanelDraw panelDraw) {
        if (isFile) {
            instructionsSymTable.cleanAll();
            instructionsSymProcedureTable.cleanAll();
            txtMessages.setText("");
        }
        if (Languages.ALL.getTypeLanguage() == true) {
            lexerAll(lexerAll, instruction, panelDraw);
        } else if (Languages.SPANISH.getTypeLanguage() == true) {
            lexerSpanish(lexerSp, instruction, panelDraw);
        } else if (Languages.ENGLISH.getTypeLanguage() == true) {
            lexerEnglish(lexerEn, instruction, panelDraw);
        } else if (Languages.KICHE.getTypeLanguage() == true) {
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
                .map(message -> "<font color=\"blue\">" + message + "</font>")
                .collect(Collectors.toList());
        addMessages(errorMessages);
        messages.clear();
    }

    protected void addMessageInfo(String message) {
        List<String> tempList = new ArrayList<>();
        tempList.add(message);
        addMessagesInfo(tempList);
    }

    protected void errorLanguage() {
        if (Languages.ALL.getTypeLanguage() == true) {
            addMessagesInfo(this.lexerAll.getErrorsList());
        } else if (Languages.ENGLISH.getTypeLanguage() == true) {
            addMessagesInfo(this.lexerEn.getErrorsList());
        } else if (Languages.SPANISH.getTypeLanguage() == true) {
            addMessagesInfo(this.lexerSp.getErrorsList());
        } else if (Languages.KICHE.getTypeLanguage() == true) {
            addMessagesInfo(this.lexerKi.getErrorsList());
        }
    }

    //type of lexer to execute
    private void lexerAll(LexerAll lexer, String instruction, PanelDraw panelDraw) {
        // TODO remove this kind of logic
        if (lexer == null) {
            lexer = new LexerAll(new StringReader(""));
        }
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

    private void lexerSpanish(LexerEs lexer, String instruction, PanelDraw panelDraw) {
        if (lexer == null) {
            lexer = new LexerEs(new StringReader(""));
        }
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

    private void lexerEnglish(Lexer lexer, String instruction, PanelDraw panelDraw) {
        if (lexer == null) {
            lexer = new Lexer(new StringReader(""));
        }
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

    private void lexerKiche(LexerKiche lexer, String instruction, PanelDraw panelDraw) {
        if (lexer == null) {
            lexer = new LexerKiche(new StringReader(""));
        }
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

    protected void typeLanguage() {
        if (Languages.ALL.getTypeLanguage() == true) {
            lexerAll = new LexerAll(new StringReader(""));
            sc = lexerAll;
            instructionsSymTable = new SymbolsTable(lexerAll.getErrorsList());
            instructionsSymProcedureTable = new ProcedureTable(lexerAll.getErrorsList());
            typeParser(sc, instructionsSymTable, instructionsSymProcedureTable);
            this.language = Language.Universal;
        } else if (Languages.SPANISH.getTypeLanguage() == true) {
            lexerSp = new LexerEs(new StringReader(""));
            sc = lexerSp;
            instructionsSymTable = new SymbolsTable(lexerSp.getErrorsList());
            instructionsSymProcedureTable = new ProcedureTable(lexerSp.getErrorsList());
            typeParser(sc, instructionsSymTable, instructionsSymProcedureTable);
            this.language = Language.Español;
        } else if (Languages.ENGLISH.getTypeLanguage() == true) {
            lexerEn = new Lexer(new StringReader(""));
            sc = lexerEn;
            instructionsSymTable = new SymbolsTable(lexerEn.getErrorsList());
            instructionsSymProcedureTable = new ProcedureTable(lexerEn.getErrorsList());
            typeParser(sc, instructionsSymTable, instructionsSymProcedureTable);
            this.language = Language.English;
        } else if (Languages.KICHE.getTypeLanguage() == true) {
            lexerKi = new LexerKiche(new StringReader(""));
            sc = lexerKi;
            instructionsSymTable = new SymbolsTable(lexerKi.getErrorsList());
            instructionsSymProcedureTable = new ProcedureTable(lexerKi.getErrorsList());
            typeParser(sc, instructionsSymTable, instructionsSymProcedureTable);
            this.language = Language.Kiche;
        }
    }

    protected void typeParser(Scanner sc, SymbolsTable symbols, ProcedureTable procedures) {
        myParser = new Parser(sc, symbols, procedures); //se agrego tambien la tabla de Procedures
        myParser.setLexersAnalyzingFile(true);
    }

    protected void selectLanguageAll() {
        cleanWord = "clears";
        Languages.ALL.setTypeLanguage(true);
        Languages.ENGLISH.setTypeLanguage(false);
        Languages.SPANISH.setTypeLanguage(false);
        Languages.KICHE.setTypeLanguage(false);
        typeLanguage();
    }

    protected void selectLanguageEnglish() {
        cleanWord = "clears";
        Languages.ALL.setTypeLanguage(false);
        Languages.ENGLISH.setTypeLanguage(true);
        Languages.SPANISH.setTypeLanguage(false);
        Languages.KICHE.setTypeLanguage(false);
        typeLanguage();
    }

    protected void selectLanguageSpanish() {
        cleanWord = "limpiar";
        Languages.ALL.setTypeLanguage(false);
        Languages.ENGLISH.setTypeLanguage(false);
        Languages.SPANISH.setTypeLanguage(true);
        Languages.KICHE.setTypeLanguage(false);
        typeLanguage();
    }

    protected void selectLanguageKiche() {
        cleanWord = "su'nik";
        Languages.ALL.setTypeLanguage(false);
        Languages.ENGLISH.setTypeLanguage(false);
        Languages.SPANISH.setTypeLanguage(false);
        Languages.KICHE.setTypeLanguage(true);
        typeLanguage();
    }

    protected String returnCleanLenguage() {
        return cleanWord;
    }

    protected void openInstructions() {
        PdfViewerFrame viewer = new PdfViewerFrame(USER_MANUAL_DOC_PATH);
        viewer.setVisible(true);
    }

}
