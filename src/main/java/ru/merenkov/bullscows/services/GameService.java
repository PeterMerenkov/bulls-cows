package ru.merenkov.bullscows.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.merenkov.bullscows.domains.Game;
import ru.merenkov.bullscows.domains.GameStep;
import ru.merenkov.bullscows.repos.GameJpaRepo;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@Service
public class GameService {
    public static final int STEP_LIMIT = 10;

    GameJpaRepo repo;

    @Autowired
    public GameService(GameJpaRepo repo) {
        this.repo = repo;
    }

    private String generateUniqueSeq() {
        String uniqueNum = "";

        Random random = new Random();
        for (int i = 0; i < 4;) {
            int randNum = random.nextInt(10);
            String randNumStr = "";
            randNumStr += randNum;
            random.nextInt(10);
            if (!uniqueNum.contains(randNumStr)) {
                uniqueNum += randNum;
                i++;
            }
        }

        return uniqueNum;
    }

    public int countBulls(String gameNum, String userNum) {
        int bullsCounter = 0;

        for (int i = 0; i < 4; i++) {
            if (gameNum.charAt(i) == (userNum.charAt(i))) {
                bullsCounter++;
            }
        }

        return bullsCounter;
    }

    public int countSims(String gameNum, String userNum) {
        int containsCounter = 0;

        for (int i = 0; i < 4; i++) {
            if (gameNum.indexOf((userNum.charAt(i))) != -1) {
                containsCounter++;
            }
        }

        return containsCounter;
    }


    public Game getGameById(Long id) {
        return repo.findById(id).get();
    }

    public void createNewGame(Game game) {
        /*game.setGameNumber("1234");*/
        game.setGameNumber(generateUniqueSeq());
        game.setStartTime(LocalTime.now());
        repo.save(game);
    }

    @Transactional
    public void makeGameStep(Long id, GameStep gameStep) {

        Game game = repo.findById(id).get();

        game.addStepCount();

        game.addStepTime(LocalTime.now());

        gameStep.setStep(game.getStepsCount());

        gameStep.setBulls(countBulls(game.getGameNumber(), gameStep.getUserNum()));
        gameStep.setCows(countSims(game.getGameNumber(),
                gameStep.getUserNum()) - countBulls(game.getGameNumber(), gameStep.getUserNum()));

        game.getSteps().add(gameStep);

        if (gameStep.getBulls() == 4) {
            game.setGameOver(true);
            game.setWin(true);
            return;
        }

        if (game.getIsStepLimit() && game.getStepsCount() == STEP_LIMIT) {
            game.setGameOver(true);
            game.setWin(false);
        }
    }

    public List<Game> getGamesByUsername(String username) {
        return repo.findByUsername(username);
    }
}
