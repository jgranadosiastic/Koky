/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.colors.ColorEnum;
import com.jgranados.koky.instructions.ExecutionDescribable;
import com.jgranados.koky.ui.KokyPointer;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author dntn
 */
public class WidthInstruction extends GraphicsInstruction implements ExecutionDescribable {
    
    private int width;
    
    public WidthInstruction(int width) {
        this.width = width;
    }
    
    @Override
    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer) {
        currentPointer.setWidth(this.width);
        return graphicsNoPointer;
    }
    
    @Override
    public String getExecutionDescription() {        
        return "Dibujaré con pincel de tamaño " + width;
    }
    
}
