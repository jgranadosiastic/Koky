package com.jgranados.koky.ui;

import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.interpreter.lexer.Lexer;
import com.jgranados.koky.interpreter.parser.Parser;
import com.jgranados.koky.interpreter.symbolstable.SymbolsTable;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
    
    
    private Lexer myLexer;
    private Parser myParser;
    private SymbolsTable instructionsSymTable;
    private String lastInput;
    private ArrayList<String> historyInput = new ArrayList<>();
    private int history = 0;
    private JEditorPane txtMessages;
    private boolean isFile;
    
    protected KFrame(boolean isFile) {
        txtMessages = new JEditorPane();
        myLexer = new Lexer(new StringReader(""));
        instructionsSymTable = new SymbolsTable(myLexer.getErrorsList());
        myParser = new Parser(myLexer, instructionsSymTable);
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
        this.myLexer.yyreset(new StringReader(instruction + LINE));
        try {
            List<Instruction> instructions = (List<Instruction>) this.myParser.parse().value;
            //if (this.myLexer.getErrorsList().isEmpty()) {
                List<String> executionDescriptions = panelDraw.runInstructions(instructions);
                addSuccessMessages(executionDescriptions);
            //}
        } catch (Exception ex) {
            Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        addErrorMessages(this.myLexer.getErrorsList());
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
}
