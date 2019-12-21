package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.position.ChessPosition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RookTest {

    @Test
    void checkRule() {
        ChessPiece rook = new Rook();

        assertThat(rook.checkRule(ChessPosition.D4, ChessPosition.D8, true)).isTrue();
        assertThat(rook.checkRule(ChessPosition.D4, ChessPosition.H4, true)).isTrue();
        assertThat(rook.checkRule(ChessPosition.D4, ChessPosition.D1, true)).isTrue();
        assertThat(rook.checkRule(ChessPosition.D4, ChessPosition.A4, true)).isTrue();

        assertThat(rook.checkRule(ChessPosition.D4, ChessPosition.E5, true)).isFalse();
    }
}