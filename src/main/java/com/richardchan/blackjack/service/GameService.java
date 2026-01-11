package com.richardchan.blackjack.service;

import org.springframework.stereotype.Service;

import com.richardchan.blackjack.model.Deck;
import com.richardchan.blackjack.model.Game;
import com.richardchan.blackjack.model.GameResult;

@Service
public class GameService {
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

    public Game hit(Game game) {
        game.addPlayerCard(game.getDeck().drawCard());

        int score = calculator.calculateCardValues(game.getPlayerCards());
        game.setPlayerTotal(score);
        if (calculator.isBust(score)) {
            game.setGameOver(true);
            game.setResult(GameResult.BUST);
        }
        return game;
    }

    public Game stand(Game game) {
        game.setGameOver(true);
        int dealerTotal = game.getDealerTotal();
        while (dealerTotal < 17) {
            game.addDealerCard(game.getDeck().drawCard());
            int newDeckTotal = calculator.calculateCardValues(game.getDealerCards());
            game.setDealerTotal(newDeckTotal);
            dealerTotal = newDeckTotal;
        }
        if (calculator.isBust(dealerTotal)) {
            game.setResult(GameResult.WIN);
        } else {
            int playerTotal = game.getPlayerTotal();
            game.setResult(calculator.getWinner(dealerTotal, playerTotal));
        }
        return game;
    }
}
