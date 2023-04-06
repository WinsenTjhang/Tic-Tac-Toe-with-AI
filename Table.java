package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Table {
    String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    boolean toggle;

    Table() {
        display();
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(int[] coordinates, String symbol) {
        board[coordinates[0]][coordinates[1]] = symbol;
    }

    void display() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    List<int[]> getAvailableCells() {
        List<int[]> availableCells = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(board[i][j], " ")) {
                    availableCells.add(new int[]{i, j});
                }
            }
        return availableCells;
    }

    String getPiece(boolean switchTurn) {
        if (switchTurn) {
            toggle = !toggle;
        }
        return toggle ? "X" : "O";
    }

}
