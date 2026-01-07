package com.richardchan.blackjack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richardchan.blackjack.model.Game;
import com.richardchan.blackjack.service.GameService;

import java.util.Collection;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Blackjack api is running";
    }

    @GetMapping("/")
    public ResponseEntity<Collection<Game>> getGames() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getGames());
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable String gameId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getGame(gameId));
    }

    @PostMapping("/")
    public ResponseEntity<Game> createGame() {
        Game game = service.createGame();
        return ResponseEntity.status(HttpStatus.CREATED).body(game);
    }
}
