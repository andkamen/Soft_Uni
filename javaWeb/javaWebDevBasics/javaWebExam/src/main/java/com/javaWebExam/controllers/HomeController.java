package com.javaWebExam.controllers;

import com.javaWebExam.services.interfaces.GameService;
import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.models.Model;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Controller
public class HomeController {

    @Inject
    private GameService gameService;

    @GetMapping("/")
    public String getHomePage(Model model) {

        model.addAttribute("games", this.gameService.getAllGames());
        model.addAttribute("title", "Home");
        model.addAttribute("view", "templates/home.jsp");

        return "WEB-INF/base-layout";
    }

}
