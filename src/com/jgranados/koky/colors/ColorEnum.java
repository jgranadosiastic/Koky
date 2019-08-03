package com.jgranados.koky.colors;

import java.awt.Color;

/**
 *
 * @author jose
 */
public enum ColorEnum {
    BLACK(0, Color.BLACK),
    BLUE(1, Color.BLUE),
    RED(2, Color.RED),
    YELLOW(3, Color.YELLOW),
    MAGENTA(4, Color.MAGENTA),
    GREEN(5, Color.GREEN),
    ORANGE(6, Color.ORANGE),
    PINK(7, Color.PINK),
    CYAN(8, Color.CYAN),
    GRAY(9, Color.GRAY);

    private int number;
    private Color color;

    private ColorEnum(int number, Color color) {
        this.number = number;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public Color getColor() {
        return color;
    }

    public static ColorEnum fromValue(int number) {
        switch (number) {
            case 0:
                return BLACK;
            case 1:
                return BLUE;
            case 2:
                return RED;
            case 3:
                return YELLOW;
            case 4:
                return MAGENTA;
            case 5:
                return GREEN;
            case 6:
                return ORANGE;
            case 7:
                return PINK;
            case 8:
                return CYAN;
            case 9:
                return GRAY;
            default:
                throw new IllegalArgumentException("No color with number " + number);
        }
    }

}
