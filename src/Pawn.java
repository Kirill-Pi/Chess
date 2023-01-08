public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int deltaLine = toLine - line;
        int deltaColumn = toColumn - column;
        if (toLine >= 0 && toLine <= 7 && toColumn >= 0 && toColumn <= 7) {
            if (color.equals("White")) {
                if (deltaColumn == 0)
                    if (line == 1 && deltaLine == 2 && chessBoard.board[toLine][toColumn] == null && chessBoard.board[toLine-1][toColumn] == null)
                        return true;
                    else return deltaLine == 1 && chessBoard.board[toLine][toColumn] == null;
                else if (((deltaLine == 1 && deltaColumn == 1) || (deltaLine == 1 && deltaColumn == -1)) && chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals("Black") && ! (chessBoard.board[toLine][toColumn].getSymbol().equals("K")))
                    return true;
            }
                else if (color.equals("Black"))
                    if (deltaColumn == 0)
                        if (line == 6 && deltaLine == -2 && chessBoard.board[toLine][toColumn] == null && chessBoard.board[toLine+1][toColumn] == null)
                            return true;
                        else return deltaLine == -1 && chessBoard.board[toLine][toColumn] == null;
                    else if (((deltaLine == -1 && deltaColumn == 1 )|| (deltaLine == -1 && deltaColumn == -1)) && chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals("White") && ! (chessBoard.board[toLine][toColumn].getSymbol().equals("K")))
                        return true;
        }
        return false;
    }

    public String getSymbol() {
        return "P";
    }
}
