import java.util.ArrayList;


public class Chess {

    private class Move {
        public int x;
        public int y;
        public Piece pieceAtNewPosition;

        public Move(int x, int y, Piece pieceAtNewPosition) {
            this.x = x;
            this.y = y;
            this.pieceAtNewPosition = pieceAtNewPosition;
        }
    }



    /**
     * Piece superclass, used as a base for all Chess pieces
     */
    private class Piece {
        public enum Team {
            White(),
            Black()
        }

        public Team team;
        public int x;
        public int y;


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
            positions[this.x][this.y] = null; // clear old position
            // Set new position
            this.x = x;
            this.y = y;
            GUI.setPosition((this.team == Team.White), this.getName(), this.x, this.y);
            positions[this.x][this.y] = this;
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



    /**
     * Pawn piece, extends the Piece superclass
     */
    private class Pawn extends Piece {
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
            if (positions[x+mod][y] == null) { // Space must be empty to move there
                moves.add(new Move(x+mod, y, null));

                // Check if the Pawn can move two spaces forward
                if (firstMove && positions[mod*2+x][y] == null)
                    moves.add(new Move(mod*2+x, y, null));
            }

            // Check if the Pawn can Take
            int posX = x + mod;
            int posY = y + 1;
            Piece piece = positions[posX][posY];
            if (piece != null) // space must be filled, and other team to take
                if (piece.team != this.team) moves.add(new Move(posX, posY, piece));
            
            posY = y - 1;
            piece = positions[posX][posY];
            if (piece != null) 
                if (piece.team != this.team) moves.add(new Move(posX, posY, piece));
            
            return moves;
        }


        @Override
        public String getName() {
            return "Pawn";
        }
    }



    // Field Variables
    private static Piece[][] positions;


    // Start the Game of Chess
    public static void start() {
        positions = new Piece[8][8];
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