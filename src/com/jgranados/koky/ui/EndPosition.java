package com.jgranados.koky.ui;

/**
 *
 * @author fabricio
 */
public class EndPosition {

    private int endPosX;
    private int endPosY;
    private int hypotenuse;

    public EndPosition() {
    }
    
    public EndPosition(int endPosX, int endPosY) {
        this.endPosX = endPosX;
        this.endPosY = endPosY;
    }

    public int getEndPosX() {
        return endPosX;
    }

    public void setEndPosX(int endPosX) {
        this.endPosX = endPosX;
    }

    public int getEndPosY() {
        return endPosY;
    }

    public void setEndPosY(int endPosY) {
        this.endPosY = endPosY;
    }
    
    public void setPosXY(int endPosX, int endPosY){
        this.endPosX = endPosX;
        this.endPosY = endPosY;
    }

    public void setAll(int endPosx, int endPosY, int hypotenuse){
        this.endPosX = endPosY;
        this.endPosX = endPosx;
        this.hypotenuse = hypotenuse;
    }
    
    public int getHypotenuse() {
        return hypotenuse;
    }

    public void setHypotenuse(int hypotenuse) {
        this.hypotenuse = hypotenuse;
    }
    
}
