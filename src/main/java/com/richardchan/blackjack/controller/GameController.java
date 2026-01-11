package com.richardchan.blackjack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richardchan.blackjack.model.Game;
import com.richardchan.blackjack.service.GameManagementService;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameManagementService service;

    public GameController(GameManagementService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Blackjack api is running";
    }

    @GetMapping("/")
    public ResponseEntity<Collection<Game>> getGames() {
        return ResponseEntity.ok().body(service.getGames());
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable String gameId) {
        return ResponseEntity.ok().body(service.getGame(gameId));
    }

    @PostMapping("/")
    public ResponseEntity<Game> createGame() {
        Game game = service.createGame();
        URI gameLocation = URI.create(String.format("/games/%s", game.getGameId()));
        return ResponseEntity.created(gameLocation).body(game);
    }

    @PostMapping("/{gameId}/hit")
    public ResponseEntity<Game> postHit(@PathVariable String gameId) {
        service.hitGame(gameId);
        return ResponseEntity.ok().body(service.getGame(gameId));
    }

    @PostMapping("/{gameId}/stand")
    public ResponseEntity<Game> postStand(@PathVariable String gameId) {
        service.standGame(gameId);
        return ResponseEntity.ok().body(service.getGame(gameId));
    }
}
