package com.javaWebExam.repositories;

import com.javaWebExam.entities.cart.Cart;
import com.javaWebExam.entities.game.Game;
import com.javaWebExam.repositories.interfaces.CartRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Stateless

public class CartRepositoryImpl implements CartRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public int getCartCount() {
        Query query = this.entityManager.createQuery("SELECT c From Cart AS c");

        List<Cart> carts = query.getResultList();

        return carts.size();
    }

    @Override
    public void persist(Cart cart) {
        this.entityManager.persist(cart);
    }

    @Override
    public void merge(Cart cart) {
        this.entityManager.merge(cart);
    }

    @Override
    public Set<Game> getGamesList() {
        Query query = this.entityManager.createQuery(
                "select c.games from Cart as c inner join c.games");

        List<Game> games = query.getResultList();

        Set<Game> gameSet = new LinkedHashSet<>();

        gameSet.addAll(games);

        return gameSet;
    }

    @Override
    public Cart getCart() {
        Query query = this.entityManager.createQuery("SELECT c FROM Cart AS c ");
        List<Cart> carts = query.getResultList();

        return carts.stream().findFirst().orElse(null);
    }
}
