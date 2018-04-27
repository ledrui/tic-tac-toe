package com.iliass.games.tictactoe;

import com.iliass.games.tictactoe.model.TicTacToe;
import com.iliass.games.tictactoe.model.TicTacToe.Cell;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TictactoeApplicationTests {

	TicTacToe game = new TicTacToe(3);


	@Test
	public void contextLoads() {
		System.out.println(game.toString());
	}

	@Test
	public void play() {
		game.play();
	}

	@Test
	public void  move() {
		Cell player = Cell.X;
		game.move(1,2,player);

	}

	@Test
	public void hasWon() {
		game.hasWon(1, 3, 1);
	}

}
