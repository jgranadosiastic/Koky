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
    private int posX;
    private int posY;
    private int angle;
    private boolean hidden;
    private boolean isPenUp;
    private boolean isErasing;
    private BufferedImage image;
    private Color penColor;
    private PanelDraw panelToDraw;
    private double accumulationX;
    private double accumulationY;

    public KokyPointer(int posX, int posY, int angle, PanelDraw panelToDraw) {
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
    }

    public void resetAngle() {
        this.angle = 0;
    }

    public void resetLocation() {
        this.posX = this.getPanelDrawWidth() / 2;
        this.posY = this.getPanelDrawHeight() / 2;
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
