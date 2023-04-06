package tictactoe;

public class LevelMedium extends Computer{
    String piece = "";

    @Override
    public String getPlayingPiece() {
        return piece;
    }

    @Override
    public void setPiece(String playingPiece) {
        this.piece = playingPiece;
    }

    @Override
    public void move(Table table){
        System.out.println("Making move level \"medium\"");
        int[] coordinate = findWinningCoordinatesSeq(table) != null ? findWinningCoordinatesSeq(table) : randomMove(table);
        table.setBoard(coordinate, table.getPiece(true));

    }
}
