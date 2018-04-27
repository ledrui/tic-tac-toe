package com.iliass.games.tictactoe.dao;

import com.iliass.games.tictactoe.model.TicTacToe;

import java.util.Hashtable;
import java.util.Random;
import java.util.UUID;

public class GameDaoImpl implements GameDao {

    Hashtable<UUID, TicTacToe> db = new Hashtable<>();

    TicTacToe game;
    @Override
    public void newGame(int size) {
        UUID id = UUID.randomUUID();
        db.put(id, game);
    }

    @Override
    public void play(int x, int y) {
        game.move(x,y, null);
    }

    @Override
    public void restartGame() {

    }
}
