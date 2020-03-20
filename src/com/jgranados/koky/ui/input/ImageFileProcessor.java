package com.jgranados.koky.ui.input;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Garfenter
 */
public class ImageFileProcessor implements FileProcessor {

    private static final int MAX_WIDTH = 15;
    private static final String CMD_PENUP = "wa'lijik";
    private static final String CMD_PENDOWN = "qajik";
    private static final String CMD_FORWRAD = "b'inik";
    private static final String CMD_WIDTH = "uwach";
    private static final String CMD_RIGHT = "k'iq'ab'";
    private static final String CMD_POSITIONXY = "kriqtajxy ";
    private static final String CMD_COLOR = "kayb'alil ";

    @Override
    public StringBuilder processInputFile(File file) throws IOException {
        BufferedImage image = scale(ImageIO.read(file), 400, 400);
        int width = image.getWidth();
        int height = image.getHeight();
        StringBuilder builder = new StringBuilder();
        builder.append(CMD_PENUP).append(System.lineSeparator());
        builder.append(CMD_POSITIONXY).append(-width / 2).append(",").append(height / 2).append(System.lineSeparator());
        builder.append(CMD_PENDOWN).append(System.lineSeparator());
        builder.append(CMD_WIDTH + " 15").append(System.lineSeparator());
        builder.append(CMD_RIGHT + " 90").append(System.lineSeparator());
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int color = averageColor(j, i, image);
                if (color != 0) {
                    builder.append(CMD_COLOR).append(String.format("#%06X", (0xFFFFFF & color))).append(System.lineSeparator());
                }
                builder.append(CMD_FORWRAD + " 15").append(System.lineSeparator());
                j += 15;
            }
            i += 14;
            builder.append(CMD_PENUP).append(System.lineSeparator());
            builder.append(CMD_POSITIONXY).append(-width / 2).append(",").append((height / 2) - i).append(System.lineSeparator());
            builder.append(CMD_PENDOWN).append(System.lineSeparator());
        }
        return builder;
    }

    /**
     * Returns average color from x to x + 15 and y to y + 15
     *
     * @param x position in X
     * @param y position in Y
     * @return average color
     */
    private int averageColor(int x, int y, BufferedImage image) {
        int endX = image.getWidth() > x + MAX_WIDTH ? x + MAX_WIDTH : image.getWidth();
        int endY = image.getHeight() > y + MAX_WIDTH ? y + MAX_WIDTH : image.getHeight();
        int count = 0;
        int sumR = 0;
        int sumG = 0;
        int sumB = 0;
        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                Color color = new Color(image.getRGB(i, j));
                sumR += color.getRed();
                sumG += color.getGreen();
                sumB += color.getBlue();
                count++;
            }
        }
        return count > 0 ? new Color(sumR / count, sumG / count, sumB / count).getRGB() : 0;
    }

    public static BufferedImage scale(BufferedImage imageToScale, int dWidth, int dHeight) {
        BufferedImage scaledImage = null;
        if (imageToScale != null) {
            scaledImage = new BufferedImage(dWidth, dHeight, imageToScale.getType());
            Graphics2D graphics2D = scaledImage.createGraphics();
            graphics2D.drawImage(imageToScale, 0, 0, dWidth, dHeight, null);
            graphics2D.dispose();
        }
        return scaledImage;
    }

}
