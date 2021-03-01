package es.codeurjc.gameweb.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.codeurjc.gameweb.models.*;

@Controller
public class NavigationController{
    @Autowired
    private CommonFunctions commonFunctions;
    @GetMapping("/")
    public String showIndex(Model model) {
        commonFunctions.getSession(model);
        return "index";
    }
    @GetMapping("/adminUpdates")
    public String showAdminGamesPage(Model model) {
        commonFunctions.getSession(model);
        return "adminUpdates";
    }
    @GetMapping("/RegisterPage") 
        public String showRegister() {
        return "RegisterPage";
    }
    @GetMapping("/addGame")
    public String addGame(Model model) {
        commonFunctions.getSession(model);
        return "newGame";
    }
    @RequestMapping("/GamePage/{name}") 
    public String showGame(Model model, @PathVariable String name) {
        model.addAttribute("name", name);
        commonFunctions.getSession(model);
        return "GamePage";
    }
    @RequestMapping("/Profile/{name}") 
    public String showProfile(Model model, @PathVariable String name) {
        model.addAttribute("name", name);
        model.addAttribute("password", "12345");
        commonFunctions.getSession(model);
        return "Profile";
    }

    @RequestMapping("/Profile/{name}/Suscripciones") 
    public String showSuscriptions(Model model, @PathVariable String name) {
        model.addAttribute("name", name);
        commonFunctions.getSession(model);
        return "Suscripciones";
    }

    @GetMapping("/Sesion+Cerrada")
    public String SignOff(Model model) {
        commonFunctions.getU().setLogged(false);
        commonFunctions.getSession(model);
        return "index";
    }
    @GetMapping("/LogInPage") 
    public String showLogIn() {
        return "LogInPage";
    }
    @RequestMapping("/listPosts/{name}")
    public String showListPost(Model model,@PathVariable String name) {
        ArrayList<UpdatePost> myPosts= new ArrayList<UpdatePost>();
        myPosts.add(new UpdatePost("Primero", null, null, null, null,"este es el primer texto"));
        myPosts.add(new UpdatePost("Segundo", null, null, null, null,"este es el sec texto"));
        myPosts.add(new UpdatePost("Tercero", null, null, null, null,"este es el third texto"));
        model.addAttribute("name",name);
        model.addAttribute("lista", myPosts);
        commonFunctions.getSession(model);
        return "listPosts";
    }
    @RequestMapping("/expandedPost/{titlePost}")
    public String showExpandedPost(Model model,@PathVariable String titlePost) {
        model.addAttribute("titlePost",titlePost);
        commonFunctions.getSession(model);
        return "expandedPost";
    }
    @GetMapping("/Juegos")
    public String showListGames(Model model) {
        commonFunctions.getSession(model);
        return "gameList";
    }
    
}