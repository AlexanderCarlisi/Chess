package Main.Pieces;

import java.util.ArrayList;
import Main.Chess;
import Main.Chess.Move;


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
        
        // Check if the Pawn can move forward
        if (Chess.positions[x+mod][y] == null) { // Space must be empty to move there
            moves.add(new Move(x+mod, y, null));
            
            // Check if the Pawn can move two spaces forward
            if (firstMove && Chess.positions[mod*2+x][y] == null)
            moves.add(new Move(mod*2+x, y, null));
        }
        
        // Check if the Pawn can Take
        int posX = x + mod;
        int posY = y + 1;
        Piece piece = Chess.positions[posX][posY];
        if (piece != null) // space must be filled, and other team to take
        if (piece.team != this.team) moves.add(new Move(posX, posY, piece));
        
        posY = y - 1;
        piece = Chess.positions[posX][posY];
        if (piece != null) 
        if (piece.team != this.team) moves.add(new Move(posX, posY, piece));
        
        return moves;
    }
    
    
    @Override
    public String getName() {
        return "Pawn";
    }
}