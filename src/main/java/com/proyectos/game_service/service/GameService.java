package com.proyectos.game_service.service;

import com.proyectos.game_service.entity.Game;

import java.util.List;

public interface GameService {

    List<Game> findAll();

    Game saveGame (Game gameRequest);

    Game getGameById(Long id);

    Game updateGame (Game gameRequest);

    void deleteGameById(Long id);


}
