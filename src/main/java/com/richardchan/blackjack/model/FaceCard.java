package com.richardchan.blackjack.model;

public enum FaceCard {
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10);

    private final String symbol;
    private final int value;

    FaceCard(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    public static boolean isFaceCard(String card) {
        String rank = card.substring(0, card.length() - 1);
        return rank.equals("J") || rank.equals("Q") || rank.equals("K");
    }

    public static int getFaceCardValue() {
        return 10;
    }
}
