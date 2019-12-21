package coursereview.springchess.domain;

import coursereview.springchess.domain.exception.ChessPositionNotFoundException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void next() {
        assertThat(ChessPosition.D4.next(Direction.N)).isEqualByComparingTo(ChessPosition.D5);
        assertThat(ChessPosition.D4.next(Direction.E)).isEqualByComparingTo(ChessPosition.E4);
        assertThat(ChessPosition.D4.next(Direction.S)).isEqualByComparingTo(ChessPosition.D3);
        assertThat(ChessPosition.D4.next(Direction.W)).isEqualByComparingTo(ChessPosition.C4);

        assertThat(ChessPosition.D4.next(Direction.NE)).isEqualByComparingTo(ChessPosition.E5);
        assertThat(ChessPosition.D4.next(Direction.SE)).isEqualByComparingTo(ChessPosition.E3);
        assertThat(ChessPosition.D4.next(Direction.SW)).isEqualByComparingTo(ChessPosition.C3);
        assertThat(ChessPosition.D4.next(Direction.NW)).isEqualByComparingTo(ChessPosition.C5);

        assertThat(ChessPosition.D4.next(Direction.NNE)).isEqualByComparingTo(ChessPosition.E6);
        assertThat(ChessPosition.D4.next(Direction.EEN)).isEqualByComparingTo(ChessPosition.F5);
        assertThat(ChessPosition.D4.next(Direction.EES)).isEqualByComparingTo(ChessPosition.F3);
        assertThat(ChessPosition.D4.next(Direction.SSE)).isEqualByComparingTo(ChessPosition.E2);
        assertThat(ChessPosition.D4.next(Direction.SSW)).isEqualByComparingTo(ChessPosition.C2);
        assertThat(ChessPosition.D4.next(Direction.WWS)).isEqualByComparingTo(ChessPosition.B3);
        assertThat(ChessPosition.D4.next(Direction.WWN)).isEqualByComparingTo(ChessPosition.B5);
        assertThat(ChessPosition.D4.next(Direction.NNW)).isEqualByComparingTo(ChessPosition.C6);
    }

    @Test
    void isTargetAdjacent() {
        assertThat(ChessPosition.D4.isTargetAdjacent(ChessPosition.D8)).isFalse();
        assertThat(ChessPosition.D4.isTargetAdjacent(ChessPosition.D5)).isTrue();

        assertThat(ChessPosition.D4.isTargetAdjacent(ChessPosition.H8)).isFalse();
        assertThat(ChessPosition.D4.isTargetAdjacent(ChessPosition.E5)).isTrue();

        assertThat(ChessPosition.D4.isTargetAdjacent(ChessPosition.E6)).isTrue();
        assertThat(ChessPosition.D4.isTargetAdjacent(ChessPosition.F8)).isFalse();
    }

    @Test
    void find() {
        assertThat(ChessPosition.find("a1")).isEqualByComparingTo(ChessPosition.A1);
        assertThat(ChessPosition.find("A1")).isEqualByComparingTo(ChessPosition.A1);
    }

    @Test
    void find_ChessPositionNotFoundException() {
        Exception exception = assertThrows(ChessPositionNotFoundException.class, () -> ChessPosition.find("i1"));

        assertThat(exception.getMessage()).isEqualTo(ChessPositionNotFoundException.CHESS_POSITION_NOT_FOUND_MESSAGE);
    }
}