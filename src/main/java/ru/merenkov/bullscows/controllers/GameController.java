package ru.merenkov.bullscows.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.merenkov.bullscows.domains.Game;
import ru.merenkov.bullscows.services.GameService;

@Controller
public class GameController {
    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("{id}")
    public Game getGameInfo(@PathVariable("id") Integer id) {
        return gameService.getGameById(id);
    }
}
