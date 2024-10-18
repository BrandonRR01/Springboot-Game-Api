package com.proyectos.game_service.service;

import com.proyectos.game_service.entity.Game;

public interface GameService {

    Game saveGame (Game gameRequest);

    Game getGameById(Long id);

    Game updateGame (Game gameRequest);

    void deleteGameById(Long id);


}
