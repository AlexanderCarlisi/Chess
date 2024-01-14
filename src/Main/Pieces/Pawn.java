package Main.Pieces;

import java.util.ArrayList;
import Main.Chess;


/**
 * Pawn piece, extends the Piece superclass
 */
public class Pawn extends Piece {
    // Field
    private boolean firstMove = true;
    
    
    // Constructor
    public Pawn(Piece.Team team, int x, int y) {
        super(team);
        setPosition(x, y);
    }
    
    
    @Override
    public ArrayList<Move> getAvailableMoves() {
        ArrayList<Move> moves = new ArrayList<>();
        
        // White moves Up, Black moves Down
        int mod = (team == Piece.Team.White) ? 1 : -1;
        int posX = x + mod;
        int posY = y;

        // Check if the Pawn can move forward
        if (Chess.getPosition(posX, posY) == null) { // Space must be empty to move there
            moves.add(new Move(posX, posY));
            
            // Check if the Pawn can move two spaces forward
            posX = x + mod * 2;
            if (firstMove && Chess.getPosition(posX, posY) == null)
            moves.add(new Move(posX, posY));
        }
        
        // Check if the Pawn can Take
        posX = x + mod;
        posY = y + 1;
        Piece piece = Chess.getPosition(posX, posY);
        if (piece != null) // space must be filled, and other team to take
        if (piece.team != this.team) moves.add(new Move(posX, posY));
        
        posY = y - 1;
        piece = Chess.getPosition(posX, posY);
        if (piece != null) 
        if (piece.team != this.team) moves.add(new Move(posX, posY));
        
        return Piece.removeIllegalMoves(moves);
    }
    
    
    @Override
    public String getName() {
        return "Pawn";
    }
}