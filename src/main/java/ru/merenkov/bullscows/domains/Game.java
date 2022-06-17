package ru.merenkov.bullscows.domains;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Game {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String gameNumber;
    LocalTime startTime;
    long time;
    int stepsCount;
    boolean isTimeLimit;
    boolean isStepLimit;
    boolean isGameOver;
    boolean isWin;
    @ElementCollection(fetch = FetchType.EAGER)
    List<GameStep> steps = new LinkedList<>();

    public Game() {
    }

    public Game(Long id,
                String username,
                String gameNumber,
                LocalTime startTime,
                long time,
                int stepsCount,
                boolean isTimeLimit,
                boolean isStepLimit,
                boolean isGameOver,
                boolean isWin) {
        this.id = id;
        this.username = username;
        this.gameNumber = gameNumber;
        this.startTime = startTime;
        this.time = time;
        this.stepsCount = stepsCount;
        this.isTimeLimit = isTimeLimit;
        this.isStepLimit = isStepLimit;
        this.isGameOver = isGameOver;
        this.isWin = isWin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(String gameNumber) {
        this.gameNumber = gameNumber;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getStepsCount() {
        return stepsCount;
    }

    public void setStepsCount(int stepsCount) {
        this.stepsCount = stepsCount;
    }

    public boolean getIsTimeLimit() {
        return isTimeLimit;
    }

    public void setIsTimeLimit(boolean timeLimit) {
        isTimeLimit = timeLimit;
    }

    public boolean getIsStepLimit() {
        return isStepLimit;
    }

    public void setIsStepLimit(boolean stepLimit) {
        isStepLimit = stepLimit;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public List<GameStep> getSteps() {
        return steps;
    }

    public void setSteps(List<GameStep> steps) {
        this.steps = steps;
    }

    public void addStepCount() {
        this.stepsCount++;
    }

    public void addStepTime(LocalTime endTime) {
        this.time += Duration.between(this.startTime, endTime).getSeconds();
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gameNumber='" + gameNumber + '\'' +
                ", time=" + time +
                ", stepsCount=" + stepsCount +
                ", isTimeLimit=" + isTimeLimit +
                ", isStepLimit=" + isStepLimit +
                ", isGameOver=" + isGameOver +
                ", isWin=" + isWin +
                ", steps=" + steps +
                '}';
    }
}
