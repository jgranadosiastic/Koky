package com.jgranados.koky.ui.input;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Garfenter
 */
public interface FileProcessor {

    public StringBuilder processInputFile(File file) throws IOException;
}
