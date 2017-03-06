package com.javaWebExam.repositories;

import com.javaWebExam.entities.game.Game;
import com.javaWebExam.repositories.interfaces.GameRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Stateless

public class GameRepositoryImpl implements GameRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persist(Game game) {
        this.entityManager.persist(game);
    }

    @Override
    public Game getGameById(Long id) {
        Query query = this.entityManager.createQuery("SELECT g FROM Game AS g WHERE g.id = :id");
        query.setParameter("id", id);
        List<Game> articles = query.getResultList();

        return articles.stream().findFirst().orElse(null);
    }

    @Override
    public Set<Game> getAllGame() {
        Query query = this.entityManager.createQuery("SELECT g FROM Game AS g");

        List<Game> games = query.getResultList();

        Set<Game> gameSet = new LinkedHashSet<>();
        gameSet.addAll(games);
        return gameSet;
    }

    @Override
    public void updateGame(Game game) {
        this.entityManager.merge(game);
    }

    @Override
    public void deleteGameById(Long id) {
        Query query = this.entityManager.createQuery("DELETE Game as g where g.id=:id");
        query.setParameter("id",id);

        query.executeUpdate();
    }
}
