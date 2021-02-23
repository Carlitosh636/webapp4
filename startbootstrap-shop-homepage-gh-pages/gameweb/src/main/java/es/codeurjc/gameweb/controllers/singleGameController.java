package es.codeurjc.gameweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class SingleGameController {
    @Autowired
    private CommonFunctions commonFunctions;
    @RequestMapping("/GamePage/{name}") //se pide una url con un atributo
    public String showGame(Model model, @PathVariable String name) {
        model.addAttribute("name", name);
        commonFunctions.getSession(model);
        return "GamePage";
    }
}