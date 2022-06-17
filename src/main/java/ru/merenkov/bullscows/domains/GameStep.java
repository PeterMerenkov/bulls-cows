package ru.merenkov.bullscows.domains;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class GameStep implements Serializable {

    int step;
    int bulls;
    int cows;
    String userNum;

    public GameStep() {
    }

    public GameStep(int step, int bulls, int cows, String userNum) {
        this.step = step;
        this.bulls = bulls;
        this.cows = cows;
        this.userNum = userNum;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getBulls() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    public int getCows() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    @Override
    public String toString() {
        return "GameStep{" +
                "step=" + step +
                ", bulls=" + bulls +
                ", cows=" + cows +
                ", userNum=" + userNum +
                '}';
    }
}
