package coursereview.springchess.domain;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.chesspiece.Rook;
import coursereview.springchess.domain.chessplayer.BlackPlayer;
import coursereview.springchess.domain.chessplayer.WhitePlayer;
import coursereview.springchess.domain.position.ChessPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ChessGameTest {

    private WhitePlayer whitePlayer;
    private BlackPlayer blackPlayer;

    @BeforeEach
    void setUp() {
        Map<ChessPosition, ChessPiece> whitePieces = new EnumMap<>(ChessPosition.class);
        whitePieces.put(ChessPosition.D4, new Rook());
        whitePieces.put(ChessPosition.F4, new Rook());
        whitePlayer = new WhitePlayer(whitePieces);

        Map<ChessPosition, ChessPiece> blackPieces = new EnumMap<>(ChessPosition.class);
        blackPieces.put(ChessPosition.D6, new Rook());
        blackPlayer = new BlackPlayer(blackPieces);
    }

    @Test
    void moveWith() {
        ChessGame chessGame = new ChessGame(whitePlayer, blackPlayer, true);

        assertDoesNotThrow(() -> chessGame.moveWith(ChessPosition.D4, ChessPosition.D5));
    }
}