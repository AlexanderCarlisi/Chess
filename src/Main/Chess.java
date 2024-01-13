package Main;

import java.util.ArrayList;
import Main.Pieces.Piece;

/**
 * Chess Class, logic functionality of the Program, should be declared statically
 */
public class Chess {

    /**
     * Move class, used to keep track of the availableMoves() of each piece 
     */
    public static class Move {
        // Field
        public int x;
        public int y;
        public Piece pieceAtNewPosition;


        // Constructor
        public Move(int x, int y, Piece pieceAtNewPosition) {
            this.x = x;
            this.y = y;
            this.pieceAtNewPosition = pieceAtNewPosition;

            // if pieceAtNewPosition is not null, then update value readings
        }
    }


    // Field
    public static Piece[][] positions;


    // Start the Game of Chess
    public static void start() {
        positions = new Piece[8][8];

        // // Set Starting Positions
        // Piece[] order = {

        // }
    }


    /**
     * Moves a piece on the board to the desired position
     * @param piece         : Piece Object, the piece that is moving
     * @param moveToMake    : Move Object, the move for the piece to make
     * 
     * @return Weither or not the piece moved to the location
     */
    public boolean move(Piece piece, Move moveToMake) {
        // Check if the move is possible
        ArrayList<Move> availableMoves = piece.getAvailableMoves();
        for (Move move : availableMoves) 
            if (move == moveToMake) {
                piece.setPosition(moveToMake.x, moveToMake.y);
                return true;
            };
        return false;
    }


    // public static boolean lookForCheck(int[][] positions) {

    // }
    
    // private void setStartingPositions() {
    //     Piece.Type[] order = {
    //         Piece.Type.Rook, Piece.Type.Knight, 
    //         Piece.Type.Bishop, Piece.Type.Queen, 
    //         Piece.Type.King, Piece.Type.Bishop, 
    //         Piece.Type.Knight, Piece.Type.Rook
    //     };
    //     for (int y = 0; y < 8; y++) {
    //         setPosition(new Piece(Piece.Team.White, order[y]), 0, y);
    //         setPosition(new Piece(Piece.Team.White, Piece.Type.Pawn), 1, y);
    //     }
    //     for (int y = 0; y < 8; y++) {
    //         setPosition(new Piece(Piece.Team.Black, order[y]), 7, y);
    //         setPosition(new Piece(Piece.Team.Black, Piece.Type.Pawn), 6, y);
    //     }
    // }

    // private void setPosition(Piece piece, int x, int y) {
    //     gui.setPosition((piece.team == Piece.Team.White), piece.type.value, x, y);
    //     positions[x][y] = piece;
    // }

    // private static int[][] getAvailablePositions(Piece piece, int x, int y) {}
}