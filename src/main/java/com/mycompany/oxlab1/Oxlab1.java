/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oxlab1;

import java.util.Scanner;

/**
 *
 * @author minnie
 */
public class Oxlab1 {

public int row;
    public int col;
    Scanner kb = new Scanner(System.in);
    public boolean play = false;
    public String start;
    public boolean end;
    public String turn;
    public String[][] board = {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};

    public void startGame() {
        System.out.println("WELCOME OX GAME 👀");
        System.out.print("Start Game ➤➤ (y/n): ");
        start = kb.nextLine().toLowerCase();
        while (!start.equals("n") && !start.equals("y")) {
            System.out.print("Start Game ➤➤ (y/n): ");
            start = kb.nextLine().toLowerCase();
        }
        if (start.equals("n")) {
            play = false;
        } else {
            play = true;
        }

    }

    public void inputRowAndCol() {
        System.out.print("Input row ➤ ");
        row = kb.nextInt();
        System.out.print("Input column ➤ ");
        col = kb.nextInt();
        if (((row > 0 && row < 4) && (col > 0 && col < 4))) {

            if (board[row - 1][col - 1].equals("_")) {

                board[row - 1][col - 1] = turn.toUpperCase();
                checkWin();
                nextTurn();

            } else {

                while ((!(row > 0 && row < 4) && !(col > 0 && col < 4)) && !(board[row - 1][col - 1].equals("_"))) {

                    System.out.println("Please Input Again.");
                    System.out.print("Input row ➤ ");
                    row = kb.nextInt();
                    System.out.print("Input column ➤");
                    col = kb.nextInt();

                }

                return;
            }

        } else {
            return;
        }
    }

    public void nextTurn() {
        if (turn.equals("x")) {
            turn = "o";
        } else {
            turn = "x";
        }

    }

    public boolean checkDraw() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("_")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void checkWin() {
        if (checkRows() || checkColumns() || checkDiagonals()) {

            System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
            System.out.println("  "+ turn + " Win 🏆");
            System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
            if (endGame()) {
                reset();
            } else {
                play = false;

            }
        } if(play == true) {
            if (checkDraw()) {
                System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                System.out.println("     Draw     ");
                System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                if (endGame()) {
                    reset();
                } else {
                    play = false;

                }
            }
        }
    }

    public boolean checkRows() {
        for (int j = 0; j < board[row - 1].length; j++) {
            if (!board[row - 1][j].toLowerCase().equals(turn)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonals() {
        if (board[0][0].toLowerCase().equals(turn) && board[1][1].toLowerCase().equals(turn) && board[2][2].toLowerCase().equals(turn)) {
            return true;
        }

        if (board[0][2].toLowerCase().equals(turn) && board[1][1].toLowerCase().equals(turn) && board[2][0].toLowerCase().equals(turn)) {
            return true;
        }

        return false;
    }

    public boolean checkColumns() {
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j].toLowerCase().equals(turn) && board[1][j].toLowerCase().equals(turn) && board[2][j].toLowerCase().equals(turn)) {
                return true;
            }
        }
        return false;
    }

    public void showBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println();

        }

    }

    public boolean endGame() {
        String tor = kb.nextLine().toLowerCase();

        while (!tor.equals("n") && !tor.equals("y")) {

            System.out.print("| Do you want to Exit 🚪 | (y/n): ");
            tor = kb.nextLine().toLowerCase();
        }
        if (tor.equals("y")) {
            return false;
        }
        return true;

    }

    public void reset() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "_";
            }
        }
        turn = "o";
    }

    public void showTurn() {
        System.out.println("_________________________");
        System.out.println("Next Turn ➤➤ " + turn.toUpperCase());

    }

    public void then() {
        showBoard();
        showTurn();
        inputRowAndCol();

    }

    public static void main(String[] args) {

         Oxlab1 project = new  Oxlab1();
        Scanner kb = new Scanner(System.in);
        project.startGame();
        if (project.play == false) {
            System.out.println("---- BYE BYE SEE YAAA 👋🏻 ----");
            return;
        }

        project.turn = "x";
        while (project.play) {
            project.then();
        }
    }
    
   
}
