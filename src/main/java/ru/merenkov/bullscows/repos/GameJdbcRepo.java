package ru.merenkov.bullscows.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.merenkov.bullscows.domains.Game;
import ru.merenkov.bullscows.repos.utils.GameRowMapper;

import java.util.List;

@Repository
public class GameJdbcRepo {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public GameJdbcRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Game> findAll() {
        return jdbcTemplate.query("select * from game", new GameRowMapper());
    }

    public Game findById(int id) {
        return jdbcTemplate.queryForObject("select * from game where id=?", new Object[] { id },
                new BeanPropertyRowMapper<Game>(Game.class));
    }

    public List<Game> findByUsername(String username) {
        return jdbcTemplate.query("select * from game where username=?",
                new Object[] { username },
                new GameRowMapper());
    }

    public int insert(Game game) {
        return jdbcTemplate.update("insert into game (id, username, time, steps, isTimeLimit, isStepLimit, isWin) "
                        + "values(?, ?, ?, ?, ?, ?, ?)",
                game.getId(),
                game.getUsername(),
                game.getTime(),
                game.getSteps(),
                game.isTimeLimit(),
                game.isStepLimit(),
                game.isWin());
    }
}
