package com.javaWebExam.services;

import com.javaWebExam.Utils.ModelParser;
import com.javaWebExam.entities.cart.Cart;
import com.javaWebExam.entities.game.Game;
import com.javaWebExam.repositories.interfaces.CartRepository;
import com.javaWebExam.repositories.interfaces.GameRepository;
import com.javaWebExam.services.interfaces.CartService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Set;

@Stateless

public class CartServiceImpl implements CartService {
    @Inject
    private CartRepository cartRepository;

    @Inject
    private GameRepository gameRepository;

    @Inject
    private ModelParser modelParser;

    @Override
    public int getCartCount() {
        return this.cartRepository.getCartCount();
    }

    @Override
    public void persist(Cart cart) {
        this.cartRepository.persist(cart);
    }

    @Override
    public Set<Game> getGamesList() {
        return this.cartRepository.getGamesList();
    }

    @Override
    public void addGame(Long id) {
        Cart cart = this.cartRepository.getCart();
        Game game = this.gameRepository.getGameById(id);

        cart.getGames().add(game);
        this.cartRepository.merge(cart);
    }

    @Override
    public void removeGame(Long id) {
        Cart cart = this.cartRepository.getCart();
        Game game = this.gameRepository.getGameById(id);

        cart.getGames().remove(game);

        this.cartRepository.merge(cart);
    }


}
