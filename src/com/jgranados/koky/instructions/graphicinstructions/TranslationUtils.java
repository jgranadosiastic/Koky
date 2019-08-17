package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.ui.EndPosition;
import com.jgranados.koky.ui.KokyPointer;
import com.jgranados.koky.ui.PanelDraw;

/**
 *
 * @author jose
 */
public final class TranslationUtils {
    
    public static final int MINIMUN_RANGE_X = 0;
    public static final int MINIMUN_RANGE_Y = 0;
    public static final int RAISED_TO = 2;
    
    private TranslationUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Not supporter");
    }
    
    public static int calculateXDimension(int angle, int steps, double accumulate) {
        return Long.valueOf(Math.round(calculateXDimentionRaw(angle, steps, accumulate))).intValue();
    }
    
    public static int calculateYDimension(int angle, int steps, double accumulate) {
        return Long.valueOf(Math.round(calculateYDimentionRaw(angle, steps, accumulate))).intValue();
    }
    
    public static double calculateAccumulationX(int angle, int steps, double currentAccumulation) {
        double val = calculateXDimentionRaw(angle, steps, currentAccumulation);
        long rounded = Math.round(val);
        return val - rounded;
    }
    
    public static double calculateAccumulationY(int angle, int steps, double currentAccumulation) {
        double val = calculateYDimentionRaw(angle, steps, currentAccumulation);
        long rounded = Math.round(val);
        return val - rounded;
    }
    
    private static double calculateXDimentionRaw(int angle, int steps) {
        return steps * Math.sin(Math.toRadians(angle));
    }
    
    private static double calculateXDimentionRaw(int angle, int steps, double accumulate) {
        return calculateXDimentionRaw(angle, steps) + accumulate;
    }
    
    private static double calculateYDimentionRaw(int angle, int steps) {
        return steps * Math.cos(Math.toRadians(angle));
    }
    
    private static double calculateYDimentionRaw(int angle, int steps, double accumulate) {
        return calculateYDimentionRaw(angle, steps) + accumulate;
    }
    
    //Return true if point position is out of range
    public static boolean isOutOfRange(int endX, int endY){
        if(endX < TranslationUtils.MINIMUN_RANGE_X || endX > PanelDraw.PANEL_WIDTH)
            return true;
        if(endY < TranslationUtils.MINIMUN_RANGE_Y || endY > PanelDraw.PANEL_HEIGHT)
            return true;
        return false;
    }
    
    public static EndPosition getEndPosition(EndPosition endPos, KokyPointer kp){
        EndPosition ep = new EndPosition();
        if(endPos.getEndPosX() < TranslationUtils.MINIMUN_RANGE_X){
            ep.setPosXY(0, kp.getPosY() + getAxisY(kp.getAngle(), getHypotenuseWithX(kp.getAngle(), kp.getPosX())));
            return ep;
        } else if (endPos.getEndPosX() > PanelDraw.PANEL_WIDTH){
            ep.setPosXY(PanelDraw.PANEL_WIDTH, kp.getPosY() - getAxisY(kp.getAngle(), getHypotenuseWithX(kp.getAngle(), getDistance(PanelDraw.PANEL_WIDTH,kp.getPosX()))));
            return ep;
        } else if (endPos.getEndPosY() < TranslationUtils.MINIMUN_RANGE_Y){
            ep.setPosXY(kp.getPosX()+ getAxisX(kp.getAngle(), getHypotenuseWithY(kp.getAngle(), kp.getPosY())), 0);
            return ep;
        } else if (endPos.getEndPosY() > PanelDraw.PANEL_HEIGHT){
            ep.setPosXY(kp.getPosX()- getAxisX(kp.getAngle(), getHypotenuseWithY(kp.getAngle(), getDistance(PanelDraw.PANEL_HEIGHT,kp.getPosY()))),PanelDraw.PANEL_HEIGHT);
            return ep;
        }
        return null;
    }
    
    public static int getHypotenuseWithX(int angle, int x){
        return (int) (Math.round(x/(Math.sin(Math.toRadians(angle)))));
    }
    
    public static int getHypotenuseWithY(int angle, int y){
        return (int)(Math.round(y/(Math.cos(Math.toRadians(angle)))));
    }
    
    public static int getAxisY(int angle, int hypotenuse){
        return (int)(Math.round((Math.cos(Math.toRadians(angle)))*(hypotenuse)));
    }
    
    public static int getAxisX(int angle, int hypotenuse){
        return (int)(Math.round((Math.sin(Math.toRadians(angle)))*(hypotenuse)));
    }
    
    public static int getDistance(int firstPoint, int secontPoint){
        return (int)(Math.round(Math.sqrt(Math.pow(secontPoint - firstPoint, TranslationUtils.RAISED_TO))));
    }
    
}
