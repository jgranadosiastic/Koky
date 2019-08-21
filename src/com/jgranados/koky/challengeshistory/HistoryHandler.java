/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.koky.challengeshistory;
import com.jgranados.koky.challengeshistory.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class HistoryHandler implements Serializable {

    private ArrayList<ChallengeRegistry> challengesList = new ArrayList<>();
    private HistoryDataHandler historyDataHandler;  

    public HistoryHandler() {
        historyDataHandler = new HistoryDataHandler();
    }

    public void addChallengeRegistry(String userName, int totalSeconds, int intructionsMade, String identifier, String description) throws IOException {
        challengesList.add(new ChallengeRegistry(userName, totalSeconds, intructionsMade, identifier, description));
        historyDataHandler.saveHistoryArrayList(challengesList);
    }

    public List<ChallengeRegistry> returnAllRegistrys() {
        return challengesList;
    }

    public void uploadHistoryData() throws IOException{
    challengesList = historyDataHandler.uploadHistory();
    }
    
}
