package com.proyectos.game_service.controller;

import com.proyectos.game_service.commons.constants.ApiPathVariables;
import com.proyectos.game_service.entity.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE)
public interface GameApi {

    @PostMapping
    ResponseEntity<Game> saveGame(@RequestHeader("userIdRequest") String userId, @RequestBody Game gameRequest);

    @GetMapping("/{id}")
    ResponseEntity<Game> getGameById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<Game>> getGames();

    @PutMapping
    ResponseEntity<Game> updateGame(@RequestBody Game gameRequest);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteGameById(@PathVariable Long id);


}
