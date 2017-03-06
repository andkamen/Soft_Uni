package com.javaWebExam.repositories.interfaces;

import com.javaWebExam.entities.cart.Cart;
import com.javaWebExam.entities.game.Game;

import java.util.Set;
public interface CartRepository {

    int getCartCount();

    void persist(Cart cart);

    void merge(Cart cart);

    Set<Game> getGamesList();

    Cart getCart();
}
