package tictactoe;

import java.util.Objects;

public class Game {
    Player player1;
    Player player2;

    Game(String players) {
        String[] playersArr = players.split(" ");
        player1 = assignPlayer(playersArr[0]);
        player1.setPiece("X");
        player2 = assignPlayer(playersArr[1]);
        player2.setPiece("O");
    }

    void run() {
        Table table = new Table();
        while (true) {
            player1.move(table);
            if (checkGameState(table)) break;
            player2.move(table);
            if (checkGameState(table)) break;
        }
    }

    Player assignPlayer(String type) {
       if (Objects.equals(type, "user")) {
           return new User();
       } else if (Objects.equals(type, "easy")) {
           return new LevelEasy();
       } else if (Objects.equals(type, "medium")) {
           return new LevelMedium();
       } else if (Objects.equals(type, "hard")) {
           return new LevelHard();
       }
        return null;
    }

    boolean checkGameState(Table table) {
        table.display();
        return checkTableState(table);
    }

    boolean checkTableState(Table table) {
        boolean gameIsFinished = true;
        if (isWinning(player1.getPlayingPiece().repeat(3), table.getBoard())) {
            System.out.println("X wins\n");
            return gameIsFinished;
        } else if (isWinning(player2.getPlayingPiece().repeat(3), table.getBoard())) {
            System.out.println("O wins\n");
            return gameIsFinished;
        } else if (isDraw(table.getBoard())){
            System.out.println("Draw\n");
            return gameIsFinished;
        }
        return !gameIsFinished;
    }

    static boolean isWinning(String pattern, String[][] board) {
        // Horizontal
        return (board[0][0] + board[0][1] + board[0][2]).equals(pattern) ||
                (board[1][0] + board[1][1] + board[1][2]).equals(pattern) ||
                (board[2][0] + board[2][1] + board[2][2]).equals(pattern) ||
                // Vertical
                (board[0][0] + board[1][0] + board[2][0]).equals(pattern) ||
                (board[0][1] + board[1][1] + board[2][1]).equals(pattern) ||
                (board[0][2] + board[1][2] + board[2][2]).equals(pattern) ||
                // Diagonal
                (board[0][0] + board[1][1] + board[2][2]).equals(pattern) ||
                (board[2][0] + board[1][1] + board[0][2]).equals(pattern);
    }

    static boolean isDraw(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(board[i][j], " ")) {
                    return false;
                }
            }
        }
        return true;
    }

}
