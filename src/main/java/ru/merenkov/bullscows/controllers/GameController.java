package ru.merenkov.bullscows.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.merenkov.bullscows.domains.Game;
import ru.merenkov.bullscows.domains.GameStep;
import ru.merenkov.bullscows.services.GameService;

import java.time.LocalTime;

@Controller
public class GameController {

    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping("/new")
    public String getNewGameForm(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("stepLimit", GameService.STEP_LIMIT);
        return "new-game-form";
    }

    @PostMapping("/new")
    public String createNewGame(@ModelAttribute("game") Game game) {
        gameService.createNewGame(game);
        return "redirect:/game/" + game.getId();
    }

    @GetMapping("/game/{id}")
    public String getGameInfo(Model model, @PathVariable("id") Long id) {
        Game game = gameService.getGameById(id);
        model.addAttribute("id", id);
        model.addAttribute("game", game);
        model.addAttribute("steps", game.getSteps());
        model.addAttribute("gameStep", new GameStep());
        model.addAttribute("stepLimit", GameService.STEP_LIMIT);

        if (game.isGameOver() && !game.isWin()) {
            model.addAttribute("userGames", gameService.getGamesByUsername(game.getUsername()));
            model.addAttribute("number", game.getGameNumber());
            model.addAttribute("time", LocalTime.MIN.plusSeconds(game.getTime()).toString());
            return "defeat";
        }

        if (game.isGameOver() && game.isWin()) {
            model.addAttribute("userGames", gameService.getGamesByUsername(game.getUsername()));
            model.addAttribute("number", game.getGameNumber());
            model.addAttribute("time", LocalTime.MIN.plusSeconds(game.getTime()).toString());
            return "win";
        }

        return "game-info";
    }

    @PostMapping("/game/{id}")
    public String makeGameStep(@ModelAttribute("game") Game game,
                               @ModelAttribute("gameStep") GameStep gameStep,
                               @PathVariable("id") Long id) {
        gameService.makeGameStep(id, gameStep);
        return "redirect:/game/" + id;
    }

    @GetMapping("/defeat/{id}")
    public String defeat(Model model, @PathVariable("id") Long id){
        Game game = gameService.getGameById(id);

        model.addAttribute("userGames", gameService.getGamesByUsername(game.getUsername()));
        model.addAttribute("number", game.getGameNumber());
        model.addAttribute("time", LocalTime.MIN.plusSeconds(game.getTime()).toString());

        return "defeat";
    }

    @GetMapping("/win")
    public String win(){
        return "win";
    }
}
