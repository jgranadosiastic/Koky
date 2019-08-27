package com.jgranados.koky.ui;

/**
 *
 * @author fabricio
 */
public class EndPosition {

    private int posX;
    private int posY;
    private double accumulationX;
    private double accumulationY;

    public EndPosition() {
    }
    
    public EndPosition(int endPosX, int endPosY) {
        this.posX = endPosX;
        this.posY = endPosY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int endPosX) {
        this.posX = endPosX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int endPosY) {
        this.posY = endPosY;
    }
    
    public void setPosXY(int endPosX, int endPosY){
        this.posX = endPosX;
        this.posY = endPosY;
    }

    public double getAccumulationX() {
        return accumulationX;
    }

    public void setAccumulationX(double accumulationX) {
        this.accumulationX = accumulationX;
    }

    public double getAccumulationY() {
        return accumulationY;
    }

    public void setAccumulationY(double accumulationY) {
        this.accumulationY = accumulationY;
    }
}
