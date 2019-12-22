package coursereview.springchess.domain.chessplayer;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.chesspiece.Rook;
import coursereview.springchess.domain.exception.IllegalChessMovementException;
import coursereview.springchess.domain.exception.SourcePieceNotFoundException;
import coursereview.springchess.domain.position.ChessPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChessPlayerTest {

    private Map<ChessPosition, ChessPiece> whitePieces;
    private Map<ChessPosition, ChessPiece> blackPieces;

    @BeforeEach
    void setUp() {
        whitePieces = new EnumMap<>(ChessPosition.class);
        whitePieces.put(ChessPosition.D4, new Rook());
        whitePieces.put(ChessPosition.F4, new Rook());

        blackPieces = new EnumMap<>(ChessPosition.class);
        blackPieces.put(ChessPosition.D6, new Rook());
    }

    @Test
    void move() {
        ChessPlayer whitePlayer = new WhitePlayer(whitePieces);
        ChessPlayer blackPlayer = new BlackPlayer(blackPieces);

        assertDoesNotThrow(() -> whitePlayer.move(ChessPosition.D4, ChessPosition.D5, blackPlayer));
    }

    @Test
    @DisplayName("source에 현재 차례 플레이어의 말이 없는 경우")
    void move_SourcePieceNotFoundException() {
        ChessPlayer whitePlayer = new WhitePlayer(whitePieces);
        ChessPlayer blackPlayer = new BlackPlayer(blackPieces);

        Exception exception = assertThrows(SourcePieceNotFoundException.class, () -> whitePlayer.move(ChessPosition.D3, ChessPosition.D5, blackPlayer));
        assertThat(exception.getMessage()).isEqualTo(SourcePieceNotFoundException.SOURCE_PIECE_NOT_FOUND_MESSAGE);
    }

    @Test
    @DisplayName("이동 경로 중간에 장애물이 있는 경우")
    void move_IllegalChessMovementException() {
        ChessPlayer whitePlayer = new WhitePlayer(whitePieces);
        ChessPlayer blackPlayer = new BlackPlayer(blackPieces);

        assertThrows(IllegalChessMovementException.class, () -> whitePlayer.move(ChessPosition.D4, ChessPosition.H4, blackPlayer));
        Exception exception = assertThrows(IllegalChessMovementException.class, () -> whitePlayer.move(ChessPosition.D4, ChessPosition.D8, blackPlayer));
        assertThat(exception.getMessage()).isEqualTo(IllegalChessMovementException.ILLEGAL_CHESS_MOVEMENT_MESSAGE);
    }

    @Test
    @DisplayName("target에 장애물(같은 팀)이 있는 경우")
    void move_IllegalChessMovementException2() {
        ChessPlayer whitePlayer = new WhitePlayer(whitePieces);
        ChessPlayer blackPlayer = new BlackPlayer(blackPieces);

        Exception exception = assertThrows(IllegalChessMovementException.class, () -> whitePlayer.move(ChessPosition.D4, ChessPosition.F4, blackPlayer));
        assertThat(exception.getMessage()).isEqualTo(IllegalChessMovementException.ILLEGAL_CHESS_MOVEMENT_MESSAGE);
    }
}