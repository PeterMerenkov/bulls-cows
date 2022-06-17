package ru.merenkov.bullscows.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.merenkov.bullscows.domains.Game;

import java.util.List;

public interface GameJpaRepo extends JpaRepository<Game, Long> {

    List<Game> findByUsername(String username);
}
