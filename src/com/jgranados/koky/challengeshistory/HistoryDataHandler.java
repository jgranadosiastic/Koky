/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.koky.challengeshistory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author jonycr
 */
public class HistoryDataHandler {

    private static final String HISTORY_FILE = "Challenges.dat";

    //Guarda la lista que manda a llamar este metodo
    public static void saveHistoryArrayList(ArrayList<ChallengeRegistry> historyArrayList) {
        String pathname = HISTORY_FILE;
        try {
            ObjectOutputStream outputFile = new ObjectOutputStream(new FileOutputStream(pathname));
            outputFile.writeObject(historyArrayList);
            outputFile.flush();
            outputFile.close();
        } catch (FileNotFoundException fnfe) {
        } catch (IOException ioe) {
        }
    }

    public ArrayList<ChallengeRegistry> uploadHistory() throws IOException {
        String pathname = HISTORY_FILE;
        File inputFile = new File(pathname);
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
