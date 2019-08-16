/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.koky.components;

import com.jgranados.koky.instructions.Instruction;
import com.jgranados.koky.interpreter.lexer.Lexer;
import com.jgranados.koky.interpreter.parser.Parser;
import com.jgranados.koky.interpreter.symbolstable.SymbolsTable;
import com.jgranados.koky.ui.KokyFrame;
import com.jgranados.koky.ui.PanelDraw;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author anclenius
 */
public class OutputTab extends JScrollPane{
    private static final String KOK_EXTENSION = "kok";
    private static final String KOK_EXTENSION_DESC = "Archivos Kok";

    private static final String CLEARS = "clears";
    private static final String LINE = "\n";
    private static final String BR = "<br>";
    
    private String name;
    private String instructions;
    private PanelDraw panelDraw;
    private Lexer myLexer;
    private Parser myParser;
    private SymbolsTable instructionsSymTable;
    private JEditorPane txtMessages;
    
    public OutputTab(String name,String instructions,JEditorPane txtMessages) {
        super();
        this.name = name;
        this.instructions = instructions;
        this.panelDraw = new PanelDraw();
        super.setViewportView(panelDraw);
        this.txtMessages = txtMessages;
        myLexer = new Lexer(new StringReader(""));
        instructionsSymTable = new SymbolsTable(myLexer.getErrorsList());
        myParser = new Parser(myLexer, instructionsSymTable);
    }
    
    public void run() {
        parseInstruction(instructions);
        addErrorMessages(this.myLexer.getErrorsList());
    }
    
    private void parseInstruction(String instruction) {
        this.myLexer.yyreset(new StringReader(instruction + LINE));
        try {
            List<Instruction> instructions = (List<Instruction>) this.myParser.parse().value;
            if (this.myLexer.getErrorsList().isEmpty()) {
                panelDraw.runInstructions(instructions);
                
            }
        } catch (Exception ex) {
            Logger.getLogger(KokyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void addErrorMessages(List<String> messages) {
        List<String> errorMessages = messages
                .stream()
                .map(message -> "<font color=\"red\">" + message + "</font>")
                .collect(Collectors.toList());
        addMessages(errorMessages);
        messages.clear();
    }
    
    public void addMessages(List<String> messages) {
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
    
    public String getName() {
        return this.name;
    }
    
}
