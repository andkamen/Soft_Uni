package com.javaWebExam.controllers;


import com.javaWebExam.Utils.DataValidator;
import com.javaWebExam.entities.cart.Cart;
import com.javaWebExam.entities.game.Game;
import com.javaWebExam.entities.user.User;
import com.javaWebExam.models.bindingModels.RegisterGameModel;
import com.javaWebExam.models.viewModels.ViewGameModel;
import com.javaWebExam.services.interfaces.CartService;
import com.javaWebExam.services.interfaces.GameService;
import com.javaWebExam.services.interfaces.UserService;
import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.parameters.PathVariable;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashSet;
import java.util.Set;

@Stateless
@Controller
public class GameController {

    @Inject
    private GameService gameService;

    @Inject
    private CartService cartService;

    @Inject
    private UserService userService;

    @GetMapping("/admin/games")
    public String viewAdminGamesPage(Model model) {
        model.addAttribute("games", this.gameService.getAllGames());
        model.addAttribute("title", "All Games");
        model.addAttribute("view", "templates/admin-games.jsp");

        return "WEB-INF/base-layout";
    }

    @GetMapping("/admin/games/add")
    public String viewAdminAddGamePage(Model model) {

        model.addAttribute("title", "Add Game");
        model.addAttribute("view", "templates/admin-add.jsp");

        return "WEB-INF/base-layout";
    }

    @PostMapping("/admin/games/add")
    public String adminAddGame(@ModelAttribute RegisterGameModel registerGameModel, Model model) {
        Set<String> errors = DataValidator.validateData(registerGameModel);

        if (errors.size() > 0) {
            model.addAttribute("title", "Add Game");
            model.addAttribute("view", "templates/admin-add.jsp");
            model.addAttribute("errors", errors);

            return "WEB-INF/base-layout";
        }

        this.gameService.persist(registerGameModel);

        return "redirect:/admin/games";
    }

    @GetMapping("/admin/games/edit/{id}")
    public String viewAdminEditGamePage(@PathVariable("id") Long id, Model model) {

        //TODO validate id is correct redirect to games if not or sth
        ViewGameModel viewGameModel = this.gameService.getGameById(id);

        model.addAttribute("game", viewGameModel);
        model.addAttribute("title", "Edit Game");
        model.addAttribute("view", "templates/admin-edit.jsp");

        return "WEB-INF/base-layout";
    }

    @PostMapping("/admin/games/edit/{id}")
    public String editGame(@PathVariable("id") Long id, @ModelAttribute RegisterGameModel registerGameModel, Model model) {
        Set<String> errors = DataValidator.validateData(registerGameModel);

        //TODO validate id is correct redirect to games if not or sth
        if (errors.size() > 0) {
            model.addAttribute("title", "Edit Game");
            model.addAttribute("view", "templates/admin-edit.jsp");
            model.addAttribute("errors", errors);

            return "WEB-INF/base-layout";
        }

        this.gameService.updateGame(registerGameModel);

        return "redirect:/admin/games";
    }

    @GetMapping("/admin/games/delete/{id}")
    public String viewAdminDeleteGamePage(@PathVariable("id") Long id, Model model) {
        //TODO validate id is correct redirect to games if not or sth
        ViewGameModel viewGameModel = this.gameService.getGameById(id);

        model.addAttribute("game", viewGameModel);
        model.addAttribute("title", "Delete Game");
        model.addAttribute("view", "templates/admin-delete.jsp");

        return "WEB-INF/base-layout";
    }

    @PostMapping("/admin/games/delete/{id}")
    public String deleteGame(@PathVariable("id") Long id, Model model) {
        this.gameService.deleteGameById(id);
        return "redirect:/admin/games";
    }

    @GetMapping("/games/info/{id}")
    public String getGameInfoPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("game", this.gameService.getGameById(id));
        model.addAttribute("title", "Game Info");
        model.addAttribute("view", "templates/game-details.jsp");

        return "WEB-INF/base-layout";
    }

    @GetMapping("/games/cart")
    public String getCartPage(Model model) {

        if (this.cartService.getCartCount() == 0) {
            Cart cart = new Cart();
            this.cartService.persist(cart);
        }

        Set<Game> cartGames = this.cartService.getGamesList();

        double totalPrice = 0;

        for (Game cartGame : cartGames) {
            totalPrice += cartGame.getPrice();
        }


        model.addAttribute("games", cartGames);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("title", "Shopping cart");
        model.addAttribute("view", "templates/cart.jsp");

        return "WEB-INF/base-layout";
    }


    @GetMapping("/games/order/{id}")
    public String putGameInBasket(@PathVariable("id") Long id, Model model) {

        Set<Game> cartGames = this.cartService.getGamesList();

        Set<String> errors = new LinkedHashSet<>();

        for (Game cartGame : cartGames) {
            if (cartGame.getId() == id) {
                errors.add("Game is already in basket");
                break;
            }
        }

        if (errors.size() > 0) {
            model.addAttribute("errors", errors);
            model.addAttribute("games", this.gameService.getAllGames());
            model.addAttribute("title", "Home");
            model.addAttribute("view", "templates/home.jsp");

            return "WEB-INF/base-layout";
        }

        this.cartService.addGame(id);

        return "redirect:/games/cart";
    }

    @GetMapping("/games/remove/{id}")
    public String removeGameFromBasket(@PathVariable("id") Long id, Model model) {

        this.cartService.removeGame(id);


        return "redirect:/games/cart";
    }


    @PostMapping("/games/orderAll")
    public String orderAllBooks(Model model, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/login";
        }
        Set<Game> cartGames = cartService.getGamesList();

        user.getGames().addAll(cartGames);

        this.userService.saveUser(user);




        return "redirect:/";
    }

    @GetMapping("games/owned")
    public String getHomePageFilterOwnedGames(Model model, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("games", user.getGames());
        model.addAttribute("title", "Home");
        model.addAttribute("view", "templates/home.jsp");

        return "WEB-INF/base-layout";
    }

//    @PostMapping("/games/order/{id}")
//    public String putGameInCart(@PathVariable("id") Long id, Model model){
//
//        ViewGameModel game = this.gameService.getGameById(id);
//        List<Game> cartGames = this.cartService.getGamesList();
//
//        Set<String> errors =  new LinkedHashSet<>();
//
//        for (Game cartGame : cartGames) {
//            if(cartGame.getId()==id){
//                errors.add("Game is already in basket");
//                break;
//            }
//        }
//
//        if(errors.size()>0){
//            model.addAttribute("errors",errors);
//            model.addAttribute("games", this.gameService.getAllGames());
//            model.addAttribute("title", "Home");
//            model.addAttribute("view", "templates/home.jsp");
//
//            return "WEB-INF/base-layout";
//        }
//
//        this.cartService.addGame(game);
//
//
//        return "redirect:/cart";
//
//    }


}
