package coursereview.springchess.domain.chessplayer;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.position.ChessPosition;

import java.util.EnumMap;
import java.util.Map;

public class ChessPlayer {

    protected final Map<ChessPosition, ChessPiece> pieces = new EnumMap<>(ChessPosition.class);

    public Map<ChessPosition, ChessPiece> getPieces() {
        return pieces;
    }
}
