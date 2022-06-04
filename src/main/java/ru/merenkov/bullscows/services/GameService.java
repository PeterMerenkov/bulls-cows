package ru.merenkov.bullscows.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<Integer> generateUniqueSeq() {
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

}
