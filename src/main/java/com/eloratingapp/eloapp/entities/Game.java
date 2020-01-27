package com.eloratingapp.eloapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gameId;
    private int winnerId;
    private int loserId;
    private LocalDate date;
    private double winnerGained;
    private double loserLost;

    public Game() {
    }

    public Game(int winnerId, int loserId, double winnerGained, double loserLost) {
        this.winnerId = winnerId;
        this.loserId = loserId;
        this.date = LocalDate.now();
        this.winnerGained = winnerGained;
        this.loserLost = loserLost;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    public int getLoserId() {
        return loserId;
    }

    public void setLoserId(int loserId) {
        this.loserId = loserId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getWinnerGained() {
        return winnerGained;
    }

    public void setWinnerGained(double winnerGained) {
        this.winnerGained = winnerGained;
    }

    public double getLoserLost() {
        return loserLost;
    }

    public void setLoserLost(double loserLost) {
        this.loserLost = loserLost;
    }
}
