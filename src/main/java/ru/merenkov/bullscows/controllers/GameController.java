package ru.merenkov.bullscows.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.merenkov.bullscows.domains.Game;
import ru.merenkov.bullscows.services.GameService;

@Controller
public class GameController {
    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/new")
    public String getNewGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "newGameForm";
    }

    @PostMapping("/new")
    public String createNewGame(@ModelAttribute("game") Game game) {
        gameService.createNewGame(game);
        return "redirect:/game/" + gameService.getLastId();
    }

    @GetMapping("/game/{id}")
    public String getGameInfo(Model model, @PathVariable("id") Long id) {
        model.addAttribute("game", gameService.getGameById(id));
        return "getGameInfo";
    }
}
