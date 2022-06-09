package ru.merenkov.bullscows.repos.utils;

import org.springframework.jdbc.core.RowMapper;
import ru.merenkov.bullscows.domains.Game;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameRowMapper implements RowMapper<Game> {
    @Override
    public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setId(rs.getLong("id"));
        game.setUsername(rs.getString("username"));
        game.setTime(rs.getLong("time"));
        game.setSteps(rs.getInt("steps"));
        game.setStepLimit(rs.getBoolean("step-limit"));
        game.setTimeLimit(rs.getBoolean("time-limit"));
        game.setWin(rs.getBoolean("win"));
        return game;
    }
}
