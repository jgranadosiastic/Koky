package com.jgranados.koky.components;

import java.io.File;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class InputTab extends JScrollPane{
    
    private String name;
    private File origin;
    private JTextArea editor;
    private UndoManager undoManager;
    
    public InputTab(String name, File origin) {
        super(new JTextArea());
        this.name = name;
        this.origin = origin;
        this.editor = (JTextArea)super.getViewport().getView();
        undoManager  = new UndoManager();
        addUndoRedoFunctionality();
    }
    
    public InputTab(String name) {
        super(new JTextArea());
        this.name = name;
        this.origin = null;
        this.editor = (JTextArea)super.getViewport().getView();
        undoManager  = new UndoManager();
        addUndoRedoFunctionality();
    }
    
    public JTextArea getTextArea() {
        return editor;
    }
    
    public UndoManager getManager() {
        return undoManager;
    }
    
    public String getText() {
        return editor.getText();
    }
    
    public void setText(String text) {
        this.editor.setText(text);
    }
    
    public String getName() {
        return name;
    }
    
    public File getOrigin() {
        return origin;
    }
    
    public void setName() {
        this.name = name;
    }
    
    public void setOrigin() {
        this.origin = origin;
    }
    
    public void addUndoRedoFunctionality() {
        editor.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
    }
}
