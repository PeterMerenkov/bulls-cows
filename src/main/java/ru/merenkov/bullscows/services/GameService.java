package ru.merenkov.bullscows.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.merenkov.bullscows.domains.Game;
import ru.merenkov.bullscows.repos.GameJdbcRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameService {
    GameJdbcRepo gameJdbcRepo;

    @Autowired
    public GameService(GameJdbcRepo gameJdbcRepo) {
        this.gameJdbcRepo = gameJdbcRepo;
    }

    private List<Integer> generateUniqueSeq() {
        List<Integer> arr = new ArrayList<>(4);

        Random random = new Random();
        for (int i = 0; i < 4;) {
            int randNum = random.nextInt(10);
            random.nextInt(10);
            if (!arr.contains(randNum)) {
                arr.add(randNum);
                i++;
            }
        }

        return arr;
    }

    public void game(List<Integer> uuuu) {

        List<Integer> cccc = generateUniqueSeq();

        int bullsCounter = 0;
        for (int i = 0; i < 4; i++) {
            if (cccc.get(i).equals(uuuu.get(i))) {
                bullsCounter++;
            }
        }

        int containsCounter = 0;
        for (int i = 0; i < 4; i++) {
            if (cccc.contains(uuuu.get(i))) {
                containsCounter++;
            }
        }
        int cowsCounter = containsCounter - bullsCounter;
    }

    public Game getGameById(Long id) {
        return gameJdbcRepo.findById(id);
    }

    @Transactional
    public void createNewGame(Game game) {
        gameJdbcRepo.insert(game);
    }

    public Long getLastId() {
        return gameJdbcRepo.getSequence();
    }
}
