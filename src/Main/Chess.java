package Main;

import java.util.ArrayList;
import Main.Pieces.*;
import Main.Pieces.Piece.*;

/**
 * Chess Class, logic functionality of the Program, should be declared statically
 */
public abstract class Chess {

    // Field
    private static Piece[][] positions; // Set Private so only the proper methods can be used


    // Start the Game of Chess
    public static void start() {
        positions = new Piece[8][8];
        setStartingPosition(Team.White, 0);
        setStartingPosition(Team.Black, 7);
    }


    /**
     * Moves a piece on the board to the desired position
     * @param piece         : Piece Object, the piece that is moving
     * @param moveToMake    : Move Object, the move for the piece to make
     * 
     * @return Weither or not the piece moved to the location
     */
    public static boolean move(Piece piece, Move moveToMake) {
        if (piece == null || moveToMake == null) return false;

        // Check if the move is possible
        ArrayList<Move> availableMoves = piece.getAvailableMoves();
        for (Move move : availableMoves) 
            if (move == moveToMake) {
                piece.setPosition(moveToMake.x, moveToMake.y);
                return true;
            };
        return false;
    }


    /**
     * Obtain the Piece at desired Position, checks bounds
     * 
     * @param x     :   Desired X Location
     * @param y     :   Desired Y Location
     * @return Piece at positions[x][y] ***returns null if space is empty or if its out of bounds
     */
    public static Piece getPosition(int x, int y) {
        if (!checkBounds(x, y)) return null; 
        return positions[x][y];
    }


    /**
     * Set the Piece at the desired Position, checks bounds
     * 
     * @param piece     :   Piece to set
     * @param x         :   X Position
     * @param y         :   Y Position
     * @return wheither or not the placement was successful
     */
    public static boolean setPosition(Piece piece, int x, int y) {
        if (!checkBounds(x, y)) return false;
        positions[x][y] = piece;
        return true;
    }
    

    /**
     * positions[x][y] | Bounds checking for Piece[8][8] positions Multilayered Array
     * 
     * @param x
     * @param y
     * 
     * @return False if out of Bounds, True if within bounds
     */
    public static boolean checkBounds(int x, int y) {
        if (x < 0 || y < 0) return false;
        if (x >= positions.length || y >= positions.length) return false;
        return true;
    }


    /**
     * Set the Positions of the Starting pieces for the given team
     * @param team  :   White/Black
     * @param backRank  :   0/7
     */
    private static void setStartingPosition(Team team, int backRank) {
        // Pawns
        int mod = (team == Team.White) ? 1 : -1; // get pawn rank
        for (int i = 0; i < 8; i++) 
            new Pawn(team, backRank+mod, i);

        // High Material
        new Rook(team, backRank, 0);
        new Knight(team, backRank, 1);
        new Bishop(team, backRank, 2);
        new Queen(team, backRank, 3);
        new King(team, backRank, 4);
        new Bishop(team, backRank, 5);
        new Knight(team, backRank, 6);
        new Rook(team, backRank, 7);
    }
}