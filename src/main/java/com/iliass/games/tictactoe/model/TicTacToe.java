package com.iliass.games.tictactoe.model;


/*
* April 26, 2018
* @author Iliass <tiiliass@gmail.com>
* */

import java.util.Random;
import java.util.Scanner;

import static com.iliass.games.tictactoe.model.TicTacToe.Cell.O;
import static com.iliass.games.tictactoe.model.TicTacToe.Cell.X;

public class TicTacToe {

    public enum Cell {E, X, O}; // Empty, player X, player O

    private int size ;
    private Cell[][] board;
    private int[] col;
    private int[] row;
    private int diagonal;
    private int antiDiag;

    public Scanner scan = new Scanner(System.in);

    public TicTacToe(int size) {
        this.size = size;
        row = new int[size];
        col = new int[size];
        board = new Cell[size][size];

        // Initialize board
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = Cell.E;
            }
        }
    }

    public void play(){

        System.out.println("Would you like to take the first turn? 1 = Y/ 2 = N");
        Random rn = new Random();
        String input = scan.next();
        Cell player = X;
        if(input.toLowerCase().equals("n")) player = O;

        System.out.println("Player: "+player);

        boolean playing = true;

        while (playing) {
            System.out.println("Enter x and y coordinates:");
            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;

            playing =  move(x,y,player);

            print();

            if (player == X) player = O;
            if (player == O) player = X;

            x = rn.nextInt(3);
            y = rn.nextInt(3);

            System.out.println("Computer played "+x+" "+y);

            playing =  move(x,y,player);

            print();
        }
    }

    public boolean move(int x, int y, Cell player) {
        if(x < 0 || y < 0 || x > size || y > size ){
            throw new IndexOutOfBoundsException();
        }

        if(board[x][y] != Cell.E){
            System.out.println("Cell not free. play different position");
            return false;
        }
        board[x][y] = player;
        print();
        int turn = 1;
        if (player.toString().equals("O")) turn = -1;
        boolean state = hasWon(x,y,turn);
        if (state) System.out.println("Player "+player+" wins");
        return state;

    }


    public boolean hasWon(int x, int y, int position){

        row[x] += position;
        col[y] += position;

        if(x == y) diagonal += position;
        if(x == size - 1 - y) antiDiag += position;

        if (Math.abs(row[x]) == size || Math.abs(col[y]) == size ||
                Math.abs(diagonal) == size || Math.abs(antiDiag) == size){

            return true;
        }
        return false;
    }


    public String printBoard(Cell[][] board) {
        String result = "";
        for(int i = 0; i < size ; i++){

            for(int j = 0; j < size; j++){
                result += board[i][j];
            }
            result += "\n";
        }
        return result;
    }

    public void print(){
        printBoard(this.board);
    }

    public static  void main(String args[]){
        TicTacToe game = new TicTacToe(3);
        game.play();
        game.print();
    }
}
