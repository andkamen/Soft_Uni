package com.javaWebExam.services;

import com.javaWebExam.Utils.ModelParser;
import com.javaWebExam.entities.game.Game;
import com.javaWebExam.models.bindingModels.RegisterGameModel;
import com.javaWebExam.models.viewModels.ViewGameModel;
import com.javaWebExam.repositories.interfaces.GameRepository;
import com.javaWebExam.services.interfaces.GameService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Set;

@Stateless

public class GameServiceImpl implements GameService {

    @Inject
    private GameRepository gameRepository;

    @Inject
    private ModelParser modelParser;

    @Override
    public void persist(RegisterGameModel registerGameModel) {
        Game game = this.modelParser.getModelMapper().map(registerGameModel, Game.class);

        this.gameRepository.persist(game);
    }

    @Override
    public ViewGameModel getGameById(Long id) {
        Game game = this.gameRepository.getGameById(id);

        ViewGameModel viewGameModel = this.modelParser.getModelMapper().map(game, ViewGameModel.class);

        return viewGameModel;
    }

    @Override
    public Set<Game> getAllGames() {
        return this.gameRepository.getAllGame();
    }

    @Override
    public void updateGame(RegisterGameModel registerGameModel) {
        Game game = this.modelParser.getModelMapper().map(registerGameModel, Game.class);
        this.gameRepository.updateGame(game);
    }

    @Override
    public void deleteGameById(Long id) {
        this.gameRepository.deleteGameById(id);
    }
}
