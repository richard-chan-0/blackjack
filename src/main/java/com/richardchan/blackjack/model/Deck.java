package com.richardchan.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<String> cards;
    private final List<String> suites = new ArrayList<>(List.of("H", "S", "C", "D"));
    private final List<String> cardValues = new ArrayList<>(
            List.of("A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"));

    public Deck() {
        createDeck();
    }

    private void createDeck() {
        cards = new ArrayList<>();
        for (String suite : suites) {
            for (String card : cardValues) {
                cards.add(card + suite);
            }
        }
        Collections.shuffle(cards);
    }

    public String drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No cards left in deck");
        }
        return cards.remove(0);
    }
}
