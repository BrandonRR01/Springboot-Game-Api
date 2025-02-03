package com.proyectos.game_service.controller.impl;

import com.proyectos.game_service.controller.GameApi;
import com.proyectos.game_service.entity.Game;
import com.proyectos.game_service.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameController implements GameApi {

    private final GameService gameService;

    @Override
    public ResponseEntity<Game> saveGame(String userId, Game gameRequest) {

        Game created = this.gameService.saveGame(gameRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Override
    public ResponseEntity<Game> getGameById(Long id) {
        return ResponseEntity.ok(this.gameService.getGameById(id));
    }

    @Override
    public ResponseEntity<List<Game>> getGames() {
        return ResponseEntity.ok(this.gameService.findAll());
    }

    @Override
    public ResponseEntity<Game> updateGame(Game gameRequest) {

        Game updated = this.gameService.updateGame(gameRequest);
        return ResponseEntity.ok(updated);
    }

    @Override
    public ResponseEntity<Void> deleteGameById(Long id) {

        this.gameService.deleteGameById(id);
        return ResponseEntity.noContent().build();
    }
}
