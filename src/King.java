public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        String tempColor = "White";
        if (this.color.equals("White")) tempColor = "Black";
        int deltaLine = Math.abs(toLine - line);
        int deltaColumn = Math.abs(toColumn - column);
        if ((deltaLine == 1 && deltaColumn == 0 || deltaLine == 0 && deltaColumn == 1) || (deltaLine == deltaColumn && deltaLine == 1))
            if (toLine >= 0 && toLine <= 7 && toColumn >= 0 && toColumn <= 7)
                if (chessBoard.board[toLine][toColumn] == null) return true;
                else if (chessBoard.board[toLine][toColumn].getColor().equals(tempColor) && !(chessBoard.board[toLine][toColumn].getSymbol().equals("K")))
                    return true;
        return false;
    }

    public String getSymbol() {
        return ("K");
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        String tempColor = "White";
        if (this.color.equals("White")) tempColor = "Black";
        boolean solution = false;
        String tempSymbol = " ";
        int i, j;
        if (board.board[line][column] != null)  tempSymbol= board.board[line][column].getSymbol();
        board.board[line][column] = new Queen(color);
        for ( i = 0; i < 7; i++){
            for ( j = 0; j < 7; j++){
                if (board.board[i][j] != null && board.board[i][j].getColor().equals(tempColor)){
                    solution = board.board[i][j].canMoveToPosition(board, i, j, line, column);
                    if (solution) {break;}
                }
            } if (solution) {break;}
        }switch (tempSymbol) {
            case " ":
                board.board[line][column] = null;
                break;
            case "P":
                board.board[line][column] = new Pawn(color);
                break;
            case "Q":
                board.board[line][column] = new Queen(color);
                break;
            case "R":
                board.board[line][column] = new Rook(color);
                break;
            case "H":
                board.board[line][column] = new Horse(color);
                break;
            case "B":
                board.board[line][column] = new Bishop(color);
                break;
            case "K":
                board.board[line][column] = new King(color);
                break;

        }return solution;
        }
}
