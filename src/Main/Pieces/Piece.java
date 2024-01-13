package Main.Pieces;

import java.util.ArrayList;
import Main.Chess;
import Main.GUI;

/**
 * Piece superclass, used as a base for all Chess pieces
 */
public class Piece {
    
    /**
     * Move class, used to keep track of the availableMoves() of each piece 
     */
    public class Move {
        // Field
        public int x;
        public int y;
        public Piece pieceAtNewPosition;
        public boolean illegal;
        
        
        // Constructor
        public Move(int x, int y, Piece pieceAtNewPosition) {
            this.x = x;
            this.y = y;
            this.pieceAtNewPosition = pieceAtNewPosition;
            
            illegal = !Chess.checkBounds(this.x, this.y);
            
            // if pieceAtNewPosition is not null, then update value readings
        }
    }
    
    
    // Field
    public enum Team {
        White(),
        Black()
    }
    public Team team;
    public int x;
    public int y;
    
    
    // Constructor
    public Piece(Team team) {
        this.team = team;
        x = 0;
        y = 0;
    }
    
    
    /**
     * Sets the position of the piece on the GameBoard.
     * Sets on the GUI and Chess.positions
     * 
     * @param x     : Array Chess.positions[x][y]
     * @param y     : Array Chess.positions[x][y]
     */
    public void setPosition(int x, int y) {
        Chess.setPosition(null, this.x, this.y); // clear old position
        // Set new position
        this.x = x;
        this.y = y;
        GUI.setPosition((this.team == Team.White), this.getName(), this.x, this.y);
        Chess.setPosition(this, this.x, this.y);
    }
    
    
    /**
     * Checks and clears List of all illegal moves. looks for checks and out of bounds moves
     * 
     * @param list  :    ArrayList of Move
     * @return ArrayList without illegal moves
     */
    public static ArrayList<Move> removeIllegalMoves(ArrayList<Move> list) {
        for (Move move : list)
        if (move.illegal) list.remove(move);
        return list;
    }
    
    
    /**
     * Get the Available moves of the respective Piece underclass
     * This method should look for checks to make sure no illegal moves are made.
     * 
     * Overridden by each Piece's class
     * @return an ArrayList of Move class, all moves are possible moves to make.
     * Default Piece.getAvailableMoves always returns null
     */
    public ArrayList<Move> getAvailableMoves() {return null;}
    
    
    /**
     * Overridden by each respective Piece class
     * @return the name of the Piece
     */
    public String getName() {return "";}
}