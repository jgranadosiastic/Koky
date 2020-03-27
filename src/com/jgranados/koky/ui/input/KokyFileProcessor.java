package com.jgranados.koky.ui.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Garfenter
 */
public class KokyFileProcessor implements FileProcessor {

    @Override
    public StringBuilder processInputFile(File file) throws IOException {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(new FileInputStream(file));
        while (scanner.hasNext()) {
            builder.append(scanner.nextLine());
            builder.append(System.lineSeparator());
        }
        return builder;
    }

}
