package Main.Pieces;

import java.util.ArrayList;
import Main.Chess;


/**
 * Pawn piece, extends the Piece superclass
 */
public class Knight extends Piece {
    
    // Constructor
    public Knight(Piece.Team team, int x, int y) {
        super(team);
        setPosition(x, y);
    }
    
    
    @Override
    public ArrayList<Move> getAvailableMoves() {
        
        return null;
    }
    
    
    @Override
    public String getName() {
        return "Knight";
    }
}