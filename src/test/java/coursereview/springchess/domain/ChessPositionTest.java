package coursereview.springchess.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChessPositionTest {

    @Test
    void calculateDirection() {
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.D8)).isEqualByComparingTo(Direction.N);
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.H4)).isEqualByComparingTo(Direction.E);
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.D1)).isEqualByComparingTo(Direction.S);
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.A4)).isEqualByComparingTo(Direction.W);

        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.H8)).isEqualByComparingTo(Direction.NE);
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.G1)).isEqualByComparingTo(Direction.SE);
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.A1)).isEqualByComparingTo(Direction.SW);
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.A7)).isEqualByComparingTo(Direction.NW);

        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.E6)).isEqualByComparingTo(Direction.NNE);
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.F5)).isEqualByComparingTo(Direction.EEN);
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.F3)).isEqualByComparingTo(Direction.EES);
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.E2)).isEqualByComparingTo(Direction.SSE);
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.C2)).isEqualByComparingTo(Direction.SSW);
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.B3)).isEqualByComparingTo(Direction.WWS);
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.B5)).isEqualByComparingTo(Direction.WWN);
        assertThat(ChessPosition.D4.calculateDirectionTo(ChessPosition.C6)).isEqualByComparingTo(Direction.NNW);
    }
}