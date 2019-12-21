package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.position.ChessPosition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BishopTest {

    @Test
    void checkRule() {
        ChessPiece bishop = new Bishop();

        assertThat(bishop.checkRule(ChessPosition.D4, ChessPosition.H8, true)).isTrue();
        assertThat(bishop.checkRule(ChessPosition.D4, ChessPosition.G1, true)).isTrue();
        assertThat(bishop.checkRule(ChessPosition.D4, ChessPosition.A1, true)).isTrue();
        assertThat(bishop.checkRule(ChessPosition.D4, ChessPosition.A7, true)).isTrue();
    }
}