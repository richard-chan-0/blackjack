package com.richardchan.blackjack.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Game {
    private String gameId;
    private List<String> playerCards;
    private int playerTotal;
    private List<String> dealerCards;
    private int dealerTotal;
    private GameResult result;
    private boolean isGameOver;

    @JsonIgnore
    private Deck deck;

    public Game(String gameId) {
        this.gameId = gameId;
        playerCards = new ArrayList<>();
        dealerCards = new ArrayList<>();
        playerTotal = 0;
        dealerTotal = 0;
        result = GameResult.IN_PROGRESS;
        isGameOver = false;
        deck = new Deck();
    }

    public String getGameId() {
        return gameId;
    }

    public List<String> getPlayerCards() {
        return playerCards;
    }

    public int getPlayerTotal() {
        return playerTotal;
    }

    public List<String> getDealerCards() {
        return dealerCards;
    }

    public int getDealerTotal() {
        return dealerTotal;
    }

    public GameResult getResult() {
        return result;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setResult(GameResult result) {
        this.result = result;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public void setPlayerTotal(int playerTotal) {
        this.playerTotal = playerTotal;
    }

    public void setDealerTotal(int dealerTotal) {
        this.dealerTotal = dealerTotal;
    }

    public void addPlayerCard(String card) {
        playerCards.add(card);
    }

    public void addDealerCard(String card) {
        dealerCards.add(card);
    }

    public Deck getDeck() {
        return deck;
    }

}
