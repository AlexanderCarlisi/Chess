import java.util.ArrayList;


public class Chess {

    private class Move {
        public int x;
        public int y;
        public Piece pieceAtNewPosition;

        public Move(int[] newPosition, Piece pieceAtNewPosition) {
            this.x = newPosition[0];
            this.y = newPosition[1];
            this.pieceAtNewPosition = pieceAtNewPosition;
        }
    }

    // Pieces
    private class Piece {
        public enum Team {
            White("White"),
            Black("Black");

            private String value;
            private Team(String value) {
                this.value = value;
            }
        }

        public Team team;
        public int[] position;

        public Piece(Team team) {
            this.team = team;
            position = new int[2];
        }

        /**
         * Sets the position of the piece on the GameBoard
         * @param x     : Array Chess.positions[x][y]
         * @param y     : Array Chess.positions[x][y]
         */
        public void setPosition(int x, int y) {
            int[] previousPosition = position;
            position = new int[] {x, y};
            GUI.setPosition((this.team == Team.White), this.toString(), x, y);
            positions[x][y] = this;
            positions[previousPosition[0]][previousPosition[1]] = null;
        }

        // Should be Overridden
        public boolean move(int[] newPosition, Piece pieceAtPosition) {return false;}
        public ArrayList<Move> getAvailableMoves() {return null;}
    }

    private class Pawn extends Piece {
        public Pawn(Piece.Team team, int x, int y) {
            super(team);
            setPosition(x, y);
        }

        private boolean firstMove = true;

        

        @Override
        public ArrayList<Move> getAvailableMoves() {
            ArrayList<Move> moves = new ArrayList<>();

            int x = this.position[0];
            int y = this.position[1];
            int mod = (this.team == Piece.Team.White) ? 1 : -1;

            // Check if the Pawn can move forward
            if (positions[x+mod][y] == null) {
                moves.add(new Move(new int[]{x+mod, y}, null));

                // Check if the Pawn can move two spaces forward
                if (firstMove && positions[mod*2+x][y] == null)
                    moves.add(new Move(new int[]{mod*2+x, y}, null));
            }

            // Check if the Pawn can Take
            Piece piece = positions[x+mod][y+1];
            if (piece != null) 
                if (piece.team != this.team) moves.add(new Move(piece.position, piece));
            
            piece = positions[x+mod][y-1];
            if (piece != null) 
                if (piece.team != this.team) moves.add(new Move(piece.position, piece));
            
            return moves;
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