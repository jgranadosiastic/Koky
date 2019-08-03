package com.jgranados.koky.instructions.graphicinstructions;

/**
 *
 * @author jose
 */
public final class TranslationUtils {
    
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
}
