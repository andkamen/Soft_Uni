package com.javaWebExam.services.interfaces;

import com.javaWebExam.entities.cart.Cart;
import com.javaWebExam.entities.game.Game;

import java.util.Set;

public interface CartService {

    int getCartCount();

    void persist(Cart cart);

    Set<Game> getGamesList();

    void addGame(Long id);

    void removeGame(Long id);


}
