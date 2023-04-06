package tictactoe;

import java.util.Objects;
import java.util.Random;

public abstract class Computer implements Player{
    Random random = new Random();
    int[][][] winningCoordinatesSequence = {{{0, 0}, {0, 1}, {0, 2}}, {{1, 0}, {1, 1}, {1, 2}}, {{2, 0}, {2, 1}, {2, 2}}, // horizontal
            {{0, 0}, {1, 0}, {2, 0}}, {{0, 1}, {1, 1}, {2, 1}}, {{0, 2}, {1, 2}, {2, 2}}, // vertical
            {{0, 0}, {1, 1}, {2, 2}}, {{2, 0}, {1, 1}, {0, 2}}}; // diagonal

    int[] randomMove(Table table) {
         return table.getAvailableCells().get(random.nextInt(table.getAvailableCells().size()));
    }

    int[] findWinningCoordinatesSeq(Table table) {
        for (int i = 0; i < 8; i++) {
            if (table.getBoard()[winningCoordinatesSequence[i][0][0]][winningCoordinatesSequence[i][0][1]].charAt(0) +
                    table.getBoard()[winningCoordinatesSequence[i][1][0]][winningCoordinatesSequence[i][1][1]].charAt(0) +
                    table.getBoard()[winningCoordinatesSequence[i][2][0]][winningCoordinatesSequence[i][2][1]].charAt(0) == 208 ||
                    table.getBoard()[winningCoordinatesSequence[i][0][0]][winningCoordinatesSequence[i][0][1]].charAt(0) +
                            table.getBoard()[winningCoordinatesSequence[i][1][0]][winningCoordinatesSequence[i][1][1]].charAt(0) +
                            table.getBoard()[winningCoordinatesSequence[i][2][0]][winningCoordinatesSequence[i][2][1]].charAt(0) == 193) {
                return placeThird(winningCoordinatesSequence[i], table);
            }
        }
        return null;
    }

    int[] placeThird(int[][] winningSequence, Table table) {
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(table.getBoard()[winningSequence[i][0]][winningSequence[i][1]], " ")) {
                return winningSequence[i];
            }
        }
        return null;
    }


}
