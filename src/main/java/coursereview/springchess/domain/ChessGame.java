package coursereview.springchess.domain;

import coursereview.springchess.domain.chessplayer.BlackPlayer;
import coursereview.springchess.domain.chessplayer.WhitePlayer;

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
}
