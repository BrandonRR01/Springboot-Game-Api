package com.proyectos.game_service.service.impl;

import com.proyectos.game_service.commons.exceptions.GameException;
import com.proyectos.game_service.entity.Game;
import com.proyectos.game_service.repository.GameRepository;
import com.proyectos.game_service.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    public final GameRepository gameRepository;

    @Override
    public List<Game> findAll() {
        return this.gameRepository.findAll();
    }

    @Override
    public Game saveGame(Game gameRequest) {
        return this.gameRepository.save(gameRequest);
    }

    @Override
    public Game getGameById(Long id) {
        return this.gameRepository.findById(id)
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Error: game not found"));
    }

    @Override
    public Game updateGame(Game gameRequest) {
        return this.gameRepository.findById(gameRequest.getId())
                .map(existingGame -> {
                    existingGame.setName(gameRequest.getName());
                    return this.gameRepository.save(existingGame);
                })
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Error: game not found"));
    }

    @Override
    public void deleteGameById(Long id) {
        if(!this.gameRepository.existsById(id))
            throw new GameException(HttpStatus.NOT_FOUND, "Error: game not found");

        this.gameRepository.deleteById(id);
    }
}
