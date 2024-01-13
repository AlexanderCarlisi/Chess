package Main.Pieces;

import java.util.ArrayList;
import Main.Chess;
import Main.Chess.Move;
import Main.GUI;

/**
 * Piece superclass, used as a base for all Chess pieces
 */
public class Piece {
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
        Chess.positions[this.x][this.y] = null; // clear old position
        // Set new position
        this.x = x;
        this.y = y;
        GUI.setPosition((this.team == Team.White), this.getName(), this.x, this.y);
        Chess.positions[this.x][this.y] = this;
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