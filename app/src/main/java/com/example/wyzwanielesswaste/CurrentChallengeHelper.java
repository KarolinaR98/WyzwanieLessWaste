package com.example.wyzwanielesswaste;

public class CurrentChallengeHelper {

    int numOfActiveChallenge, numOfChallengeDay;

    public CurrentChallengeHelper(int numOfActiveChallenge, int numOfChallengeDay) {
        this.numOfActiveChallenge = numOfActiveChallenge;
        this.numOfChallengeDay = numOfChallengeDay;
    }


    public CurrentChallengeHelper() {
    }


    public int getNumOfActiveChallenge() {
        return numOfActiveChallenge;
    }

    public void setNumOfActiveChallenge(int numOfActiveChallenge) {
        this.numOfActiveChallenge = numOfActiveChallenge;
    }

    public int getNumOfChallengeDay() {
        return numOfChallengeDay;
    }

    public void setNumOfChallengeDay(int numOfChallengeDay) {
        this.numOfChallengeDay = numOfChallengeDay;
    }
}
