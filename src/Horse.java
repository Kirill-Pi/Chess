public class Horse extends ChessPiece {

    public Horse(String color) {
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
        if (toLine >= 0 && toLine <= 7 && toColumn >= 0 && toColumn <= 7) {
            if ((deltaLine == 1 && deltaColumn == 2) || (deltaLine == 2 && deltaColumn == 1)) {
                if (chessBoard.board[toLine][toColumn] == null) return true;
                else if (chessBoard.board[toLine][toColumn].getColor().equals(tempColor) && !(chessBoard.board[toLine][toColumn].getSymbol().equals("K")))
                     return true;
               else return false;
            }
        }
        return false;
    }

    public String getSymbol() {
        return "H";
    }
}
