package com.iliass.games.tictactoe.dao;

import com.iliass.games.tictactoe.model.TicTacToe;

import java.util.UUID;

public interface GameDao {

    void newGame(int size);
    void play(int x, int y);
    void restartGame();
}
