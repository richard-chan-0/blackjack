package com.richardchan.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String gameId;
    private List<String> playerCards;
    private int playerTotal;
    private List<String> dealerCards;
    private int dealerTotal;
    private GameResult result;
    private boolean isGameOver;

    public Game(String gameId) {
        this.gameId = gameId;
        playerCards = new ArrayList<>();
        dealerCards = new ArrayList<>();
        playerTotal = 0;
        dealerTotal = 0;
        result = GameResult.IN_PROGRESS;
        isGameOver = false;
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

    public void addCardToPlayerTotal(int card) {
        this.playerTotal += card;
    }

    public void addCardToDealerTotal(int card) {
        this.dealerTotal += card;
    }

    public void setResult(GameResult result) {
        this.result = result;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public void addPlayerCard(String card) {
        playerCards.add(card);
    }

    public void addDealerCard(String card) {
        dealerCards.add(card);
    }
}
