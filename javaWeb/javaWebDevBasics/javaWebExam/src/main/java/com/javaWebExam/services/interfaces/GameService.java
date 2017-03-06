package com.javaWebExam.services.interfaces;

import com.javaWebExam.entities.game.Game;
import com.javaWebExam.models.bindingModels.RegisterGameModel;
import com.javaWebExam.models.viewModels.ViewGameModel;

import javax.transaction.Transactional;
import java.util.Set;

public interface GameService {

    void persist(RegisterGameModel registerGameModel);

    ViewGameModel getGameById(Long id);

    Set<Game> getAllGames();

    void updateGame(RegisterGameModel registerGameModel);

    void deleteGameById(Long id);

}
