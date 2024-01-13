package Main.Pieces;

import java.util.ArrayList;


/**
 * Pawn piece, extends the Piece superclass
 */
public class Rook extends Piece {
    
    // Constructor
    public Rook(Piece.Team team, int x, int y) {
        super(team);
        setPosition(x, y);
    }
    
    
    @Override
    public ArrayList<Move> getAvailableMoves() {
        
        return null;
    }
    
    
    @Override
    public String getName() {
        return "Rook";
    }
}