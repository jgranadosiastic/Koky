/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.koky.components;

import java.io.File;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author anclenius
 */
public class Tab extends JScrollPane{
    
    private String name;
    private File origin;
    private JTextArea editor;
    public Tab(String name, File origin) {
        super(new JTextArea());
        this.name = name;
        this.origin = origin;
        this.editor = (JTextArea)super.getViewport().getView();
    }
    
    public Tab(String name) {
        super(new JTextArea());
        this.name = name;
        this.origin = null;
        this.editor = (JTextArea)super.getViewport().getView();
    }
    
    public JTextArea getTextArea() {
        return editor;
    }
    
    public String getText() {
        return editor.getText();
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
}
