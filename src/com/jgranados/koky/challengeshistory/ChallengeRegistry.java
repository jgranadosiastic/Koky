package com.jgranados.koky.challengeshistory;

import java.io.Serializable;
import javax.swing.ImageIcon;


public class ChallengeRegistry implements Serializable, Comparable<ChallengeRegistry> {
    
    private String userName;
    private int totalSeconds;
    private int totalInstructions;
    private String identifierRegistry;
    private String challengeDescription;

    public ChallengeRegistry(String userName, int totalSeconds, int totalInstructions, String identifierRegistry, String challengeDescription) {
        this.userName = userName;
        this.totalSeconds = totalSeconds;
        this.totalInstructions = totalInstructions;
        this.identifierRegistry = identifierRegistry;
        this.challengeDescription = challengeDescription;
    }

    public String getChallengeDescription() {
        return challengeDescription;
    }

    public void setChallengeDescription(String challengeDescription) {
        this.challengeDescription = challengeDescription;
    }

    public String getIdentifierRegistry() {
        return identifierRegistry;
    }

    public void setIdentifierRegistry(String identifierRegistry) {
        this.identifierRegistry = identifierRegistry;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }

    public void setTotalSeconds(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    public int getTotalInstructions() {
        return totalInstructions;
    }

    public void setTotalInstructions(int totalInstructions) {
        this.totalInstructions = totalInstructions;
    }

    @Override
    public int compareTo(ChallengeRegistry o) {
        return userName.compareTo(o.getUserName());
    }
    
}
