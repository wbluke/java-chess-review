package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.ChessPosition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KnightTest {

    @Test
    void checkRule() {
        ChessPiece knight = new Knight();

        assertThat(knight.checkRule(ChessPosition.D4, ChessPosition.E6, true)).isTrue();
        assertThat(knight.checkRule(ChessPosition.D4, ChessPosition.F5, true)).isTrue();
        assertThat(knight.checkRule(ChessPosition.D4, ChessPosition.F3, true)).isTrue();
        assertThat(knight.checkRule(ChessPosition.D4, ChessPosition.E2, true)).isTrue();
        assertThat(knight.checkRule(ChessPosition.D4, ChessPosition.C2, true)).isTrue();
        assertThat(knight.checkRule(ChessPosition.D4, ChessPosition.B3, true)).isTrue();
        assertThat(knight.checkRule(ChessPosition.D4, ChessPosition.B5, true)).isTrue();
        assertThat(knight.checkRule(ChessPosition.D4, ChessPosition.C6, true)).isTrue();

        assertThat(knight.checkRule(ChessPosition.D4, ChessPosition.F8, true)).isFalse();
    }
}