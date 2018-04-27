package com.iliass.games.tictactoe.dao;

import com.iliass.games.tictactoe.model.TicTacToe;

public interface gameDao {

    void newGame(int size);
    void play(int x, int y, TicTacToe.Cell player);
    void restartGame();
}
