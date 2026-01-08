package com.richardchan.blackjack.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import com.richardchan.blackjack.model.Game;
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
        String gameId = UUID.randomUUID().toString();
        Game game = new Game(gameId);
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
        return game;
    }

    public Collection<Game> getGames() {
        return games.values();
    }

}
