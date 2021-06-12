package com.example.wyzwanielesswaste;

public class ChallengeHelper {
    int score1, score2, score3, score4, score5, score6, score7;
    boolean isSummaryActive, wasPerformed, isAvailable;


    public ChallengeHelper() {
    }

    public ChallengeHelper(int score1, int score2, int score3, int score4, int score5, int score6, int score7, boolean isSummaryActive, boolean wasPerformed, boolean isAvailable) {
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.score5 = score5;
        this.score6 = score6;
        this.score7 = score7;
        this.isSummaryActive = isSummaryActive;
        this.wasPerformed = wasPerformed;
        this.isAvailable = isAvailable;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getScore3() {
        return score3;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    public int getScore4() {
        return score4;
    }

    public void setScore4(int score4) {
        this.score4 = score4;
    }

    public int getScore5() {
        return score5;
    }

    public void setScore5(int score5) {
        this.score5 = score5;
    }

    public int getScore6() {
        return score6;
    }

    public void setScore6(int score6) {
        this.score6 = score6;
    }

    public int getScore7() {
        return score7;
    }

    public void setScore7(int score7) {
        this.score7 = score7;
    }

    public boolean isSummaryActive() {
        return isSummaryActive;
    }

    public void setSummaryActive(boolean summaryActive) {
        isSummaryActive = summaryActive;
    }

    public boolean isWasPerformed() {
        return wasPerformed;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setWasPerformed(boolean wasPerformed) {
        this.wasPerformed = wasPerformed;
    }
}
