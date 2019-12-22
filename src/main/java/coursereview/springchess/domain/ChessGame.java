package coursereview.springchess.domain;

import coursereview.springchess.domain.chessplayer.BlackPlayer;
import coursereview.springchess.domain.chessplayer.ChessPlayer;
import coursereview.springchess.domain.chessplayer.WhitePlayer;
import coursereview.springchess.domain.exception.SourcePieceNotFoundException;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.Direction;

public class ChessGame {

    private final WhitePlayer whitePlayer;
    private final BlackPlayer blackPlayer;
    private boolean isWhiteTurn;

    public ChessGame(final WhitePlayer whitePlayer, final BlackPlayer blackPlayer, final boolean isWhiteTurn) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.isWhiteTurn = isWhiteTurn;
    }

    public WhitePlayer getWhitePlayer() {
        return whitePlayer;
    }

    public BlackPlayer getBlackPlayer() {
        return blackPlayer;
    }

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    public void moveWith(final ChessPosition source, final ChessPosition target) {
        ChessPlayer currentPlayer = getCurrentTurnPlayer();
        ChessPlayer oppositePlayer = getOppositeTurnPlayer();

        currentPlayer.move(source, target, oppositePlayer);
    }

    private ChessPlayer getCurrentTurnPlayer() {
        return isWhiteTurn ? whitePlayer : blackPlayer;
    }

    private ChessPlayer getOppositeTurnPlayer() {
        return isWhiteTurn ? blackPlayer : whitePlayer;
    }
}
