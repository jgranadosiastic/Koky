package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.ui.KokyPointer;
import com.jgranados.koky.ui.PanelDraw;

/**
 *
 * @author jose
 */
public final class TranslationUtils {

    public static final int MINIMUN_RANGE_X = 0;
    public static final int MINIMUN_RANGE_Y = 0;
    public static final String PLAIN_TEXT_WIDTH = "Ancho (min 900):";
    public static final String PLAIN_TEXT_HEIGHT = "Alto (min 450):";
    public static final int ARRAY_SIZE = 2;
    public static final int INIT_METHOD = 1;

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
    public static boolean isOutOfRange(int endX, int endY, KokyPointer actualPoint) {
        return isXOutOfRange(endX, actualPoint.getPanelDrawWidth()) || isYOutOfRange(endY, actualPoint.getPanelDrawHeight());
    }

    private static boolean isXOutOfRange(int axisX, int limitX) {
        return isXDownOfRange(axisX) || isXUpOfRange(axisX, limitX);
    }

    private static boolean isYOutOfRange(int axisY, int limitY) {
        return isYDownOfRange(axisY) || isYUpOfRange(axisY, limitY);
    }

    private static boolean isXDownOfRange(int axisX) {
        return axisX < TranslationUtils.MINIMUN_RANGE_X;
    }

    private static boolean isXUpOfRange(int axisX, int limitX) {
        return axisX > limitX;
    }

    private static boolean isYDownOfRange(int axisY) {
        return axisY < TranslationUtils.MINIMUN_RANGE_Y;
    }

    private static boolean isYUpOfRange(int axisY, int limitY) {
        return axisY > limitY;
    }

    public static int[] setEndPosition(KokyPointer actualPoint, int option) {
        int[] endPositions = new int[]{actualPoint.getPosX(), actualPoint.getPosY()};
        double translationX = getTranslation(actualPoint.getPosX(), actualPoint.getOutPosX());
        double translationY = getTranslation(actualPoint.getPosY(), actualPoint.getOutPosY());
        int finalX = 0;
        int finalY = 0;
        double slope = 0;
        if (translationX != 0) {
            slope = getSlope(translationX, translationY);
        }

        boolean isPointOutOfRange = (isXOutOfRange(actualPoint.getOutPosX(), actualPoint.getPanelDrawWidth())
                && isYOutOfRange(actualPoint.getOutPosY(), actualPoint.getPanelDrawHeight()));

        switch (option) {
            case 1:
                if (isXDownOfRange(actualPoint.getOutPosX())) {
                    finalY = getAxisY(endPositions, slope, MINIMUN_RANGE_X);
                    if (isPointOutOfRange) {
                        if (finalY > MINIMUN_RANGE_Y && finalY < actualPoint.getPanelDrawHeight()) {
                            endPositions[0] = MINIMUN_RANGE_X;
                            endPositions[1] = finalY;
                        } else {
                            return setEndPosition(actualPoint, ++option);
                        }
                    } else {
                        endPositions[0] = MINIMUN_RANGE_X;
                        endPositions[1] = finalY;
                    }
                } else {
                    return setEndPosition(actualPoint, ++option);
                }
                break;
            case 2:
                if (isXUpOfRange(actualPoint.getOutPosX(), actualPoint.getPanelDrawWidth())) {
                    if (slope != 0) {
                        finalX = getAxisX(endPositions, slope, actualPoint.getPanelDrawHeight());
                    } else {
                        finalX = actualPoint.getOutPosX();
                    }
                    finalY = getAxisY(endPositions, slope, actualPoint.getPanelDrawWidth());
                    if (isPointOutOfRange) {
                        if (finalY > MINIMUN_RANGE_Y && finalY < actualPoint.getPanelDrawHeight()) {
                            endPositions[0] = actualPoint.getPanelDrawWidth();
                            endPositions[1] = finalY;
                        } else {
                            return setEndPosition(actualPoint, ++option);
                        }
                    } else {
                        endPositions[0] = actualPoint.getPanelDrawWidth();
                        endPositions[1] = finalY;
                    }
                } else {
                    return setEndPosition(actualPoint, ++option);
                }
                break;
            case 3:
                if (isYDownOfRange(actualPoint.getOutPosY())) {
                    if (slope != 0) {
                        finalX = getAxisX(endPositions, slope, MINIMUN_RANGE_Y);
                    } else {
                        finalX = actualPoint.getOutPosX();
                    }
                    if (isPointOutOfRange) {
                        if (finalX > 0) {
                            endPositions[0] = finalX;
                            endPositions[1] = MINIMUN_RANGE_Y;
                        } else {
                            return setEndPosition(actualPoint, ++option);
                        }
                    } else {
                        endPositions[0] = finalX;
                        endPositions[1] = MINIMUN_RANGE_Y;
                    }
                } else {
                    return setEndPosition(actualPoint, ++option);
                }
                break;
            case 4:
                if (isYUpOfRange(actualPoint.getOutPosY(), actualPoint.getPanelDrawHeight())) {
                    if (slope != 0) {
                        finalX = getAxisX(endPositions, slope, actualPoint.getPanelDrawHeight());
                    } else {
                        finalX = actualPoint.getOutPosX();
                    }
                    if (isPointOutOfRange) {
                        if (finalX > 0) {
                            endPositions[0] = finalX;
                            endPositions[1] = actualPoint.getPanelDrawHeight();
                        } else {
                            return setEndPosition(actualPoint, ++option);
                        }
                    } else {
                        endPositions[0] = finalX;
                        endPositions[1] = actualPoint.getPanelDrawHeight();
                    }
                } else {
                    return setEndPosition(actualPoint, ++option);
                }
                break;
            default:
                return null;
        }
        verificatePosition(endPositions, actualPoint);
        return endPositions;
    }

    public static int[] setOutPosition(KokyPointer actualPointer) {
        int endPosition[] = new int[]{actualPointer.getPosX(), actualPointer.getPosY()};
        if (isXDownOfRange(actualPointer.getOutPosX())) {
            endPosition[0] = TranslationUtils.MINIMUN_RANGE_X;
        } else if (isXUpOfRange(actualPointer.getOutPosX(), actualPointer.getPanelDrawWidth())) {
            endPosition[0] = actualPointer.getPanelDrawWidth();
        }
        if (isYDownOfRange(actualPointer.getOutPosY())) {
            endPosition[1] = TranslationUtils.MINIMUN_RANGE_Y;
        } else if (isYUpOfRange(actualPointer.getOutPosY(), actualPointer.getPanelDrawHeight())) {
            endPosition[1] = actualPointer.getPanelDrawHeight();
        }
        return endPosition;
    }

    private static void verificatePosition(int endPosition[], KokyPointer actualPoint) {
        if (isXDownOfRange(endPosition[0])) {
            endPosition[0] = TranslationUtils.MINIMUN_RANGE_X;
        } else if (isXUpOfRange(endPosition[0], actualPoint.getPanelDrawWidth())) {
            endPosition[0] = actualPoint.getPanelDrawWidth();
        } else if (isYDownOfRange(endPosition[1])) {
            endPosition[1] = TranslationUtils.MINIMUN_RANGE_Y;
        } else if (isYUpOfRange(endPosition[1], actualPoint.getPanelDrawHeight())) {
            endPosition[1] = actualPoint.getPanelDrawHeight();
        }
    }

    private static int getAxisY(int endPosition[], double slope, int posX) {
        return (int) (Math.round((slope * (posX - endPosition[0])) + endPosition[1]));
    }

    private static int getAxisX(int endPosition[], double slope, int posY) {
        return (int) (Math.round(((posY - endPosition[1]) / slope) + endPosition[0]));
    }

    private static double getTranslation(int point1, int point2) {
        return new Double(point1 - point2);
    }

    private static double getSlope(double translationX, double translationY) {
        return (translationY / translationX);
    }

}
