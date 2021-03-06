package com.jgranados.koky.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author jose
 */
public class KokyPointer {

    private static final String IMG_URL = "/com/jgranados/koky/ui/images/kok_pointer_32.png";
    public static final int IMG_SIZE = 32;
    public static final int BRUSH_WIDTH = 2;
    private int posX;
    private int outPosX;
    private int posY;
    private int outPosY;
    private int angle;
    private boolean hidden;
    private boolean isPenUp;
    private boolean isErasing;
    private BufferedImage image;
    private Color penColor;
    private PanelDraw panelToDraw;
    private double accumulationX;
    private double outAccumulationX;
    private double accumulationY;
    private double outAccumulationY;
    private int width;

    public KokyPointer(int posX, int posY, int angle, PanelDraw panelToDraw,int width) {
        this.posX = posX;
        this.posY = posY;
        this.angle = angle;
        try {
            image = ImageIO.read(getClass().getResource(IMG_URL));
        } catch (IOException e) {
            System.out.println("Error getting the image");
        }
        this.penColor = Color.BLACK;
        this.panelToDraw = panelToDraw;
        this.width = width;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setPosXY(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
    
    public int getAngle() {
        return angle;
    }

    public void addAngle(int angle) {
        this.angle = this.angle + angle;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isPenUp() {
        return isPenUp;
    }

    public void setIsPenUp(boolean isPenUp) {
        this.isPenUp = isPenUp;
    }

    public boolean isErasing() {
        return isErasing;
    }

    public void setIsErasing(boolean isErasing) {
        this.isErasing = isErasing;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Color getPenColor() {
        return penColor;
    }

    public void setPenColor(Color penColor) {
        this.penColor = penColor;
    }

    public int getPanelDrawWidth() {
        return this.panelToDraw.getWidth();
    }

    public int getPanelDrawHeight() {
        return this.panelToDraw.getHeight();
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }

    public void drawPointer(Graphics2D graphicsWithPointer) {
        if (!isHidden()) {
            double rotationRequired = Math.toRadians(angle);
            int locationX = IMG_SIZE / 2;
            int locationY = IMG_SIZE / 2;
            AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

            // Drawing the rotated image at the required drawing locations
            graphicsWithPointer.drawImage(op.filter(image, null), getPosX() - locationX, getPosY() - locationY, null);
        }
    }

    public void resetPosition() {
        resetLocation();
        resetAngle();
        resetWidth();
    }

    public void resetAngle() {
        this.angle = 0;
    }

    public void resetLocation() {
        this.posX = this.getPanelDrawWidth() / 2;
        this.outPosX = this.posX;
        this.posY = this.getPanelDrawHeight() / 2;
        this.outPosY = this.posY;
    }
    
    public void resetWidth() {
        this.width = BRUSH_WIDTH;
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

    public void setImage(String direccion) throws IOException {
        this.image = ImageIO.read(getClass().getResource(direccion));
    }

    public int getOutPosX() {
        return outPosX;
    }

    public void setOutPosX(int outPosX) {
        this.outPosX = outPosX;
    }

    public int getOutPosY() {
        return outPosY;
    }

    public void setOutPosY(int outPosY) {
        this.outPosY = outPosY;
    }

    public double getOutAccumulationX() {
        return outAccumulationX;
    }

    public void setOutAccumulationX(double outAccumulationX) {
        this.outAccumulationX = outAccumulationX;
    }

    public double getOutAccumulationY() {
        return outAccumulationY;
    }

    public void setOutAccumulationY(double outAccumulationY) {
        this.outAccumulationY = outAccumulationY;
    }

    public int getCoordinatePosX() {
        return getPosX() - getPanelDrawWidth() / 2;
    }

    public int getCoordinatePosY() {
        return getPanelDrawHeight() / 2 - getPosY();
    }
    
}
