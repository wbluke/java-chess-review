package coursereview.springchess.domain.chessplayer;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.exception.SourcePieceNotFoundException;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.Direction;

import java.util.EnumMap;
import java.util.Map;

public class ChessPlayer {

    protected Map<ChessPosition, ChessPiece> pieces;

    public ChessPlayer() {
        this.pieces = new EnumMap<>(ChessPosition.class);
    }

    public ChessPlayer(final Map<ChessPosition, ChessPiece> pieces) {
        this.pieces = pieces;
    }

    public Map<ChessPosition, ChessPiece> getPieces() {
        return pieces;
    }

    public ChessPiece findPieceOn(final ChessPosition position) {
        return pieces.get(position);
    }

    public boolean containsPieceOn(final ChessPosition chessPosition) {
        return pieces.containsKey(chessPosition);
    }

    public boolean doesNotContainPieceOn(final ChessPosition chessPosition) {
        return !containsPieceOn(chessPosition);
    }

    public void move(final ChessPosition source, final ChessPosition target, final ChessPlayer oppositePlayer) {
        if (doesNotContainPieceOn(source)) {
            throw new SourcePieceNotFoundException();
        }

        ChessPiece chessPieceOnSource = pieces.get(source);
        Direction direction = source.calculateDirectionTo(target);
        ChessPosition nextPosition = source.next(direction);
        while (doesNotReachOnTarget(target, nextPosition)) {
            // TODO: 22/12/2019
            // check our team

            // check opposite team
        }
    }

    private boolean doesNotReachOnTarget(final ChessPosition target, final ChessPosition nextPosition) {
        return !nextPosition.equals(target);
    }
}
