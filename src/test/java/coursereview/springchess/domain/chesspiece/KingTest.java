package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.ChessPosition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KingTest {

    @Test
    void checkRule() {
        ChessPiece king = new King();

        assertThat(king.checkRule(ChessPosition.D4, ChessPosition.D5, true)).isTrue();
        assertThat(king.checkRule(ChessPosition.D4, ChessPosition.E5, true)).isTrue();
        assertThat(king.checkRule(ChessPosition.D4, ChessPosition.E4, true)).isTrue();
        assertThat(king.checkRule(ChessPosition.D4, ChessPosition.E3, true)).isTrue();
        assertThat(king.checkRule(ChessPosition.D4, ChessPosition.D3, true)).isTrue();
        assertThat(king.checkRule(ChessPosition.D4, ChessPosition.C3, true)).isTrue();
        assertThat(king.checkRule(ChessPosition.D4, ChessPosition.C4, true)).isTrue();
        assertThat(king.checkRule(ChessPosition.D4, ChessPosition.C5, true)).isTrue();

        assertThat(king.checkRule(ChessPosition.D4, ChessPosition.D8, true)).isFalse();
    }
}