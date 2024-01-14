package Main.Pieces;
import Main.Chess;

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
    public Move(int x, int y) {
        this.x = x;
        this.y = y;
        this.pieceAtNewPosition = Chess.getPosition(this.x, this.y);
        
        illegal = !Chess.checkBounds(this.x, this.y);
        
        // if pieceAtNewPosition is not null, then update value readings
    }
}