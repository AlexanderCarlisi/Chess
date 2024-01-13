package Main.Pieces;

import java.util.ArrayList;


/**
 * Pawn piece, extends the Piece superclass
 */
public class Bishop extends Piece {
    
    // Constructor
    public Bishop(Piece.Team team, int x, int y) {
        super(team);
        setPosition(x, y);
    }
    
    
    @Override
    public ArrayList<Move> getAvailableMoves() {
        
        return null;
    }
    
    
    @Override
    public String getName() {
        return "Bishop";
    }
}