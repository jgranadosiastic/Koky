package com.jgranados.koky.challengeshistory;
import com.jgranados.koky.challengeshistory.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class HistoryHandler implements Serializable {

    private ArrayList<ChallengeRegistry> challengesList = new ArrayList<>();

    public HistoryHandler() {
    }

    public void addChallengeRegistry(String userName, int totalSeconds, int intructionsMade, String identifier, String description, ArrayList<String> instructionsList) throws IOException {
        challengesList.add(new ChallengeRegistry(userName, totalSeconds, intructionsMade, identifier, description, instructionsList));
        HistoryDataHandler.saveHistoryArrayList(challengesList);
    }

    public List<ChallengeRegistry> returnAllRegistrys() {
        return challengesList;
    }

    public void uploadHistoryData() throws IOException{
    challengesList = HistoryDataHandler.uploadHistory();
    }
    
}
