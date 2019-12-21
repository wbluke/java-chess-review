package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.ChessPosition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueenTest {

    @Test
    void checkRule() {
        ChessPiece queen = new Queen();

        assertThat(queen.checkRule(ChessPosition.D4, ChessPosition.D8, true)).isTrue();
        assertThat(queen.checkRule(ChessPosition.D4, ChessPosition.H8, true)).isTrue();
        assertThat(queen.checkRule(ChessPosition.D4, ChessPosition.H4, true)).isTrue();
        assertThat(queen.checkRule(ChessPosition.D4, ChessPosition.G1, true)).isTrue();
        assertThat(queen.checkRule(ChessPosition.D4, ChessPosition.D1, true)).isTrue();
        assertThat(queen.checkRule(ChessPosition.D4, ChessPosition.A1, true)).isTrue();
        assertThat(queen.checkRule(ChessPosition.D4, ChessPosition.A4, true)).isTrue();
        assertThat(queen.checkRule(ChessPosition.D4, ChessPosition.A7, true)).isTrue();
    }
}