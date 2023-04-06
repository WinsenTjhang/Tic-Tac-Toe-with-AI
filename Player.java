package tictactoe;

interface Player {

    void move(Table table);
    void setPiece(String playingPiece);
    String getPlayingPiece();
}
