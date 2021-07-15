package com.example.wyzwanielesswaste;

import android.app.ListActivity;

public class ChallengeHelper {
    int score1, score2, score3, score4, score5, score6, score7;
    boolean isActive1, isActive2, isActive3, isActive4, isActive5, isActive6, isActive7, isAvailable,
            summaryPerformed1, summaryPerformed2, summaryPerformed3, summaryPerformed4, summaryPerformed5, summaryPerformed6, summaryPerformed7;
    long wasPerformed;



    public ChallengeHelper() {
    }

    public ChallengeHelper(int score1, int score2, int score3, int score4, int score5, int score6, int score7, boolean isActive1,
                           boolean isActive2,  boolean isActive3,  boolean isActive4,  boolean isActive5,  boolean isActive6,  boolean isActive7,
                           long wasPerformed, boolean isAvailable,
                           boolean summaryPerformed1, boolean summaryPerformed2, boolean summaryPerformed3, boolean summaryPerformed4,
                           boolean summaryPerformed5, boolean summaryPerformed6, boolean summaryPerformed7) {
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.score5 = score5;
        this.score6 = score6;
        this.score7 = score7;
        this.wasPerformed = wasPerformed;
        this.isAvailable = isAvailable;
        this.isActive1 = isActive1;
        this.isActive2 = isActive2;
        this.isActive3 = isActive3;
        this.isActive4 = isActive4;
        this.isActive5 = isActive5;
        this.isActive6 = isActive6;
        this.isActive7 = isActive7;
        this.summaryPerformed1 = summaryPerformed1;
        this.summaryPerformed2 = summaryPerformed2;
        this.summaryPerformed3 = summaryPerformed3;
        this.summaryPerformed4 = summaryPerformed4;
        this.summaryPerformed5 = summaryPerformed5;
        this.summaryPerformed6 = summaryPerformed6;
        this.summaryPerformed7 = summaryPerformed7;
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

    public boolean isActive1() {
        return isActive1;
    }

    public void setActive1(boolean active1) {
        isActive1 = active1;
    }

    public boolean isActive2() {
        return isActive2;
    }

    public void setActive2(boolean active2) {
        isActive2 = active2;
    }

    public boolean isActive3() {
        return isActive3;
    }

    public void setActive3(boolean active3) {
        isActive3 = active3;
    }

    public boolean isActive4() {
        return isActive4;
    }

    public void setActive4(boolean active4) {
        isActive4 = active4;
    }

    public boolean isActive5() {
        return isActive5;
    }

    public void setActive5(boolean active5) {
        isActive5 = active5;
    }

    public boolean isActive6() {
        return isActive6;
    }

    public void setActive6(boolean active6) {
        isActive6 = active6;
    }

    public boolean isActive7() {
        return isActive7;
    }

    public void setActive7(boolean active7) {
        isActive7 = active7;
    }


    public boolean isSummaryPerformed1() {
        return summaryPerformed1;
    }

    public void setSummaryPerformed1(boolean summaryPerformed1) {
        this.summaryPerformed1 = summaryPerformed1;
    }

    public boolean isSummaryPerformed2() {
        return summaryPerformed2;
    }

    public void setSummaryPerformed2(boolean summaryPerformed2) {
        this.summaryPerformed2 = summaryPerformed2;
    }

    public boolean isSummaryPerformed3() {
        return summaryPerformed3;
    }

    public void setSummaryPerformed3(boolean summaryPerformed3) {
        this.summaryPerformed3 = summaryPerformed3;
    }

    public boolean isSummaryPerformed4() {
        return summaryPerformed4;
    }

    public void setSummaryPerformed4(boolean summaryPerformed4) {
        this.summaryPerformed4 = summaryPerformed4;
    }

    public boolean isSummaryPerformed5() {
        return summaryPerformed5;
    }

    public void setSummaryPerformed5(boolean summaryPerformed5) {
        this.summaryPerformed5 = summaryPerformed5;
    }

    public boolean isSummaryPerformed6() {
        return summaryPerformed6;
    }

    public void setSummaryPerformed6(boolean summaryPerformed6) {
        this.summaryPerformed6 = summaryPerformed6;
    }

    public boolean isSummaryPerformed7() {
        return summaryPerformed7;
    }

    public void setSummaryPerformed7(boolean summaryPerformed7) {
        this.summaryPerformed7 = summaryPerformed7;
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

    public long isWasPerformed() {
        return wasPerformed;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setWasPerformed(long wasPerformed) {
        this.wasPerformed = wasPerformed;
    }
}
