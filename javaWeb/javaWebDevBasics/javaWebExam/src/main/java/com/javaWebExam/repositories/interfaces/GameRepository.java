package com.javaWebExam.repositories.interfaces;

import com.javaWebExam.entities.game.Game;

import javax.transaction.Transactional;
import java.util.Set;
public interface GameRepository {
    void persist(Game game);

    Game getGameById(Long id);

    Set<Game> getAllGame();

    void updateGame(Game game);

    void deleteGameById(Long id);

}
