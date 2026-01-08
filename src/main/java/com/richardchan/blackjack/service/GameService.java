package com.richardchan.blackjack.service;

import org.springframework.stereotype.Service;

import com.richardchan.blackjack.model.Deck;
import com.richardchan.blackjack.model.Game;

@Service
public class GameService {
    // start state deal cards to player and dealer - done
    // total up card values for player and dealer - done
    // hit or stand
    private CardCalculatorService calculator;

    public GameService(CardCalculatorService service) {
        calculator = service;
    }

    public void dealInitialCards(Game game) {
        Deck deck = game.getDeck();
        game.addPlayerCard(deck.drawCard());
        game.addDealerCard(deck.drawCard());
        game.addPlayerCard(deck.drawCard());
        game.addDealerCard(deck.drawCard());
        game.setPlayerTotal(calculator.calculateCardValues(game.getPlayerCards()));
    }
}
