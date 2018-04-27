package com.iliass.games.tictactoe.services;

import com.iliass.games.tictactoe.dao.GameDao;
import com.iliass.games.tictactoe.model.Position;
import com.iliass.games.tictactoe.model.TicTacToe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GameServices {

    public GameServices(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    private final GameDao gameDao;

    @Autowired
    public void newGame(int size) {
        gameDao.newGame(size);
    }

    @Autowired
    public void play(Position position ) {
        gameDao.play(position.getX(), position.getY());
    }

    @Autowired
    public void restartGame() {

    }

}
