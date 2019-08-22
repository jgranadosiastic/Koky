package com.jgranados.koky.challengeshistory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HistoryDataHandler {

    private static final String HISTORY_FILE = "Challenges.dat";

    public static void saveHistoryArrayList(ArrayList<ChallengeRegistry> historyArrayList) throws IOException, FileNotFoundException {
            ObjectOutputStream outputFile = new ObjectOutputStream(new FileOutputStream(HISTORY_FILE));
            outputFile.writeObject(historyArrayList);
            outputFile.flush();
            outputFile.close();
    }

    public static ArrayList<ChallengeRegistry> uploadHistory() throws IOException, FileNotFoundException {
        File inputFile = new File(HISTORY_FILE);
        if (inputFile.exists()) {
            FileInputStream historyInputFile = new FileInputStream(inputFile);
            ObjectInputStream inputData = new ObjectInputStream(historyInputFile);
            try {
                return (ArrayList<ChallengeRegistry>) inputData.readObject();
            } catch (ClassNotFoundException ex) {
                throw new IOException(ex);
            } finally {
                inputData.close();
            }
        } else {
            return new ArrayList<>();
        }
    }
}
