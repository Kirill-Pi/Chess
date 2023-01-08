public class Rook extends ChessPiece {

    public Rook (String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int deltaLine = Math.abs(toLine - line);
        int deltaColumn = Math.abs(toColumn - column);
        String tempColor = "White";
        if (this.color.equals("White")) tempColor = "Black";
        if (toLine >= 0 && toLine <= 7 && toColumn >= 0 && toColumn <= 7) {
            if ((deltaLine == 0 && deltaColumn !=0)  || (deltaLine != 0 && deltaColumn == 0)){
                int signLine;
                int signColumn;
                if (deltaLine == 0) signLine = 0 ;
                else signLine = (toLine - line)/deltaLine;
                if (deltaColumn == 0) signColumn =0;
                else signColumn = (toColumn-column)/deltaColumn;
                for (int i = 1; i < deltaLine; i++) {
                    if (chessBoard.board[line + i * signLine][column + i * signColumn] != null) return false;
                }
                if (chessBoard.board[toLine][toColumn] == null) return true;
                else if (chessBoard.board[toLine][toColumn].getColor().equals(tempColor) && !(chessBoard.board[toLine][toColumn].getSymbol().equals("K")))
                    return true;
            }
        } return false;

    }

    public String getSymbol() {
        return "R";
    }
}