package Main;
import Main.Pieces.Piece;
import Main.Pieces.Move;

public class App {

    public static void main(String[] args) throws Exception {
        GUI.setup();
        Chess.start();

        int posX = 1;
        int posY = 0;
        int moveToX = 2;
        int moveToY = 0;

        Piece pieceToMove = Chess.getPosition(posX, posY);
        Move move = new Move(moveToX, moveToY);

        Chess.move(pieceToMove, move);
    }
}
