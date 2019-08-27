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
    public static boolean isOutOfRange(int endX, int endY) {
        return isXOutOfRange(endX) || isYOutOfRange(endY);
    }

    private static boolean isXOutOfRange(int axisX) {
        return isXDownOfRange(axisX) || isXUpOfRange(axisX);
    }

    private static boolean isYOutOfRange(int axisY) {
        return isYDownOfRange(axisY) || isYUpOfRange(axisY);
    }

    private static boolean isXDownOfRange(int axisX) {
        return axisX < TranslationUtils.MINIMUN_RANGE_X;
    }

    private static boolean isXUpOfRange(int axisX) {
        return axisX > PanelDraw.PANEL_WIDTH;
    }

    private static boolean isYDownOfRange(int axisY) {
        return axisY < TranslationUtils.MINIMUN_RANGE_Y;
    }

    private static boolean isYUpOfRange(int axisY) {
        return axisY > PanelDraw.PANEL_HEIGHT;
    }

    public static EndPosition getEndPosition(KokyPointer actualPoint) {
        EndPosition endPosition = new EndPosition(actualPoint.getPosX(), actualPoint.getPosY());
        double translationX = getTranslation(actualPoint.getPosX(), actualPoint.getOutPosX());
        double translationY = getTranslation(actualPoint.getPosY(), actualPoint.getOutPosY());
        double slope = 0;
        if (translationX != 0) {
            slope = getSlope(translationX, translationY);
        }
        if (isXDownOfRange(actualPoint.getOutPosX())) {
            endPosition.setPosXY(TranslationUtils.MINIMUN_RANGE_X, getAxisY(endPosition, slope, TranslationUtils.MINIMUN_RANGE_X));
            return endPosition;
        } else if (isXUpOfRange(actualPoint.getOutPosX())) {
            endPosition.setPosXY(PanelDraw.PANEL_WIDTH, getAxisY(endPosition, slope, PanelDraw.PANEL_WIDTH));
            return endPosition;
        } else if (isYDownOfRange(actualPoint.getOutPosY())) {
            if (slope != 0) {
                endPosition.setPosXY(getAxisX(endPosition, slope, TranslationUtils.MINIMUN_RANGE_Y), TranslationUtils.MINIMUN_RANGE_Y);
            } else {
                endPosition.setPosXY(actualPoint.getOutPosX(), TranslationUtils.MINIMUN_RANGE_Y);
            }
            return endPosition;
        } else if (isYUpOfRange(actualPoint.getOutPosY())) {
            if (slope != 0) {
                endPosition.setPosXY(getAxisX(endPosition, slope, PanelDraw.PANEL_HEIGHT), PanelDraw.PANEL_HEIGHT);
            } else {
                endPosition.setPosXY(actualPoint.getOutPosX(), PanelDraw.PANEL_HEIGHT);
            }
            return endPosition;
        }
        return null;
    }

    public static EndPosition getOutPosition(KokyPointer actualPointer) {
        EndPosition endPosition = new EndPosition();
        if (isXDownOfRange(actualPointer.getOutPosX())) {
            endPosition.setPosXY(0, actualPointer.getPosY());
            return endPosition;
        } else if (isXUpOfRange(actualPointer.getOutPosX())) {
            endPosition.setPosXY(PanelDraw.PANEL_WIDTH, actualPointer.getOutPosY());
            return endPosition;
        } else if (isYDownOfRange(actualPointer.getOutPosY())) {
            endPosition.setPosXY(actualPointer.getOutPosX(), TranslationUtils.MINIMUN_RANGE_Y);
            return endPosition;
        } else if (isYUpOfRange(actualPointer.getOutPosY())) {
            endPosition.setPosXY(actualPointer.getOutPosX(), PanelDraw.PANEL_HEIGHT);
            return endPosition;
        }
        return null;
    }

    private static int getAxisY(EndPosition endPosition, double slope, int posX) {
        return (int) (Math.round((slope * (posX - endPosition.getPosX())) + endPosition.getPosY()));
    }

    private static int getAxisX(EndPosition endPosition, double slope, int posY) {
        return (int) (Math.round(((posY - endPosition.getPosY()) / slope) + endPosition.getPosX()));
    }

    private static double getTranslation(int point1, int point2) {
        return new Double(point1 - point2);
    }

    private static double getSlope(double translationX, double translationY) {
        return (translationY / translationX);
    }

}
