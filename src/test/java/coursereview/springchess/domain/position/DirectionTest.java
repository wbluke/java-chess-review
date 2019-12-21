package coursereview.springchess.domain.position;

import coursereview.springchess.domain.exception.DirectionNotFoundException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DirectionTest {

    @Test
    void find() {
        assertThat(Direction.find(0, 1)).isEqualByComparingTo(Direction.N);
        assertThat(Direction.find(1, 1)).isEqualByComparingTo(Direction.NE);
        assertThat(Direction.find(1, 0)).isEqualByComparingTo(Direction.E);
        assertThat(Direction.find(1, -1)).isEqualByComparingTo(Direction.SE);
        assertThat(Direction.find(0, -1)).isEqualByComparingTo(Direction.S);
        assertThat(Direction.find(-1, -1)).isEqualByComparingTo(Direction.SW);
        assertThat(Direction.find(-1, 0)).isEqualByComparingTo(Direction.W);
        assertThat(Direction.find(-1, 1)).isEqualByComparingTo(Direction.NW);

        assertThat(Direction.find(1, 2)).isEqualByComparingTo(Direction.NNE);
        assertThat(Direction.find(-1, 2)).isEqualByComparingTo(Direction.NNW);
        assertThat(Direction.find(1, -2)).isEqualByComparingTo(Direction.SSE);
        assertThat(Direction.find(-1, -2)).isEqualByComparingTo(Direction.SSW);
        assertThat(Direction.find(2, 1)).isEqualByComparingTo(Direction.EEN);
        assertThat(Direction.find(2, -1)).isEqualByComparingTo(Direction.EES);
        assertThat(Direction.find(-2, 1)).isEqualByComparingTo(Direction.WWN);
        assertThat(Direction.find(-2, -1)).isEqualByComparingTo(Direction.WWS);
    }

    @Test
    void find_DirectionNotFoundException() {
        Exception exception = assertThrows(DirectionNotFoundException.class, () -> Direction.find(0, 0));

        assertThat(exception.getMessage()).isEqualTo(DirectionNotFoundException.DIRECTION_NOT_FOUND_MESSAGE);
    }
}