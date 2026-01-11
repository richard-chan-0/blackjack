package com.richardchan.blackjack.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.richardchan.blackjack.model.Deck;
import com.richardchan.blackjack.model.Game;
import com.richardchan.blackjack.exception.GameException;
import com.richardchan.blackjack.exception.GameNotFoundException;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;

@Service
public class GameManagementService {
    private Map<String, Game> games = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(GameManagementService.class);
    private GameService gameService;

    public GameManagementService(GameService service) {
        gameService = service;
    }

    public Game createGame() {
        logger.info("Setting up new game");
        String gameId = UUID.randomUUID().toString();
        Deck deck = new Deck();
        Game game = new Game(gameId, deck);
        gameService.dealInitialCards(game);
        games.put(gameId, game);
        return game;
    }

    public Game getGame(String gameId) {
        logger.info("Fetching game");
        Game game = games.get(gameId);
        if (game == null) {
            throw new GameNotFoundException("Game not found: " + gameId);
        }
        if (game.isGameOver()) {
            throw new GameException("game is over, no further moves allowed");
        }
        return game;
    }

    public Collection<Game> getGames() {
        return games.values();
    }

    public Game hitGame(String gameId) {
        Game game = this.getGame(gameId);
        gameService.hit(game);
        return game;
    }

    public Game standGame(String gameId) {
        Game game = this.getGame(gameId);
        gameService.stand(game);
        return game;
    }

    public void cleanGame(String gameId) {
        games.remove(gameId);
    }
}
