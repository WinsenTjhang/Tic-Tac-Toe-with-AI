package tictactoe;

import java.util.Arrays;
import java.util.Objects;

import static tictactoe.Game.isDraw;
import static tictactoe.Game.isWinning;

public class LevelHard extends Computer {
    String playingPiece = "";
    String opponentPiece = "";

    @Override
    public String getPlayingPiece() {
        return playingPiece;
    }

    @Override
    public void setPiece(String piece) {
        this.playingPiece = piece;
        this.opponentPiece = Objects.equals(piece, "X") ? "O" : "X";
    }

    @Override
    public void move(Table table) {
        System.out.println("Making move level \"hard\"");
        String[][] newBoard = copy(table.getBoard());
        int[] coordinate = bestMove(newBoard);
        table.setBoard(coordinate, table.getPiece(true));
    }

    public String[][] copy(String[][] original) {
        String[][] duplicate = new String[3][3];
        for (int i = 0; i < original.length; i++) {
            duplicate[i] = Arrays.copyOf(original[i], 3);
        }
        return duplicate;
    }

    public int[] bestMove(String[][] board) {
        int bestScore = Integer.MIN_VALUE;
        int[] move = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(board[i][j], " ")) {
                    board[i][j] = playingPiece;
                    int score = minimax(board, true);
                    board[i][j] = " ";
                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = i;
                        move[1]= j;
                    }
                }
            }
        }
        return move;
    }

    public int minimax(String[][] board, boolean isOpponentTurn) {
        // check terminal state, or winning side
        if (isWinning(playingPiece.repeat(3), board)) {
            return 10;
        } else if (isWinning(opponentPiece.repeat(3), board)) {
            return -10;
        } else if (isDraw(board)) {
            return 0;
        }

        if (!isOpponentTurn) {
            int maxScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Objects.equals(board[i][j], " ")) {
                        board[i][j] = playingPiece;
                        int score = minimax(board, true);
                        board[i][j] = " ";
                        maxScore = Math.max(score, maxScore);
                    }
                }
            }
            return maxScore;
        } else {
            int minScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Objects.equals(board[i][j], " ")) {
                        board[i][j] = opponentPiece;
                        int score = minimax(board, false);
                        board[i][j] = " ";
                        minScore = Math.min(score, minScore);
                    }
                }
            }
            return minScore;
        }

    }
}