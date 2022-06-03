package ru.merenkov.bullscows.domains;

public class Game {
    int id;
    String username;
    long time;
    int steps;
    boolean isTimeLimit;
    boolean isStepLimit;
    boolean isWin;

    public Game() {
    }

    public Game(int id,
                String username,
                long time,
                int steps,
                boolean isTimeLimit,
                boolean isStepLimit,
                boolean isWin) {
        this.id = id;
        this.username = username;
        this.time = time;
        this.steps = steps;
        this.isTimeLimit = isTimeLimit;
        this.isStepLimit = isStepLimit;
        this.isWin = isWin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public boolean isTimeLimit() {
        return isTimeLimit;
    }

    public void setTimeLimit(boolean timeLimit) {
        isTimeLimit = timeLimit;
    }

    public boolean isStepLimit() {
        return isStepLimit;
    }

    public void setStepLimit(boolean stepLimit) {
        isStepLimit = stepLimit;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }
}
