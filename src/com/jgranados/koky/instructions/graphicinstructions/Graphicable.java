package com.jgranados.koky.instructions.graphicinstructions;

import com.jgranados.koky.ui.KokyPointer;
import java.awt.Graphics2D;

/**
 *
 * @author jose
 */
public interface Graphicable {

    public Graphics2D execute(Graphics2D graphicsNoPointer, KokyPointer currentPointer);
}
