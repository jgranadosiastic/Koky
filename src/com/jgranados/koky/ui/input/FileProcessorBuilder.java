package com.jgranados.koky.ui.input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author Garfenter
 */
public class FileProcessorBuilder {

    public static FileProcessor build(File file) throws IOException {
        String mimeType = Files.probeContentType(file.toPath());
        if (mimeType != null && mimeType.equalsIgnoreCase("image/jpeg")) {
            return new ImageFileProcessor();
        } else {
            return new KokyFileProcessor();
        }
    }
}
