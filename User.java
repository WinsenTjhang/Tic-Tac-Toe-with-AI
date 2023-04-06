package tictactoe;

import java.util.Objects;
import java.util.Scanner;

public class User implements Player{
    Scanner scanner = new Scanner(System.in);
    int[] coordinates = new int[2];
    String piece = "";

    public String getPlayingPiece() {
        return piece;
    }

    public void setPiece(String playingPiece) {
        this.piece = playingPiece;
    }

    public void setCoordinates(int x, int y) {
        this.coordinates[0] = x;
        this.coordinates[1] = y;
    }

    @Override
    public void move(Table table) {
        boolean invalidCoordinates = true;
        while (invalidCoordinates) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();
            if (isValidInput(input)) {
                setCoordinates(Integer.parseInt(input.split(" ")[0]) - 1,
                        Integer.parseInt(input.split(" ")[1]) - 1);
                if (isNotOccupied(coordinates, table)) {
                    table.setBoard(coordinates, table.getPiece(true));
                    invalidCoordinates = false;
                }
            }
        }
    }

    static boolean isValidInput(String coordinates) {
        if (!coordinates.matches("\\d \\d")) {
            System.out.println("You should enter numbers!");
            return false;
        } else if (!coordinates.matches("[123] [123]")) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        return true;
    }

    static boolean isNotOccupied(int[] coordinate, Table table) {
        if (Objects.equals(table.getBoard()[coordinate[0]][coordinate[1]], " ")) {
            return true;
        }
        System.out.println("This cell is occupied! Choose another one!");
        return false;
    }

}
