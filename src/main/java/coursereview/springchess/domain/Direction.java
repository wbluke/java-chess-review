package coursereview.springchess.domain;

import coursereview.springchess.domain.exception.DirectionNotFoundException;

import java.util.Arrays;

public enum Direction {
    N(0, 1),
    NE(1, 1),
    E(1, 0),
    SE(1, -1),
    S(0, -1),
    SW(-1, -1),
    W(-1, 0),
    NW(-1, 1),

    NNE(1, 2),
    NNW(-1, 2),
    SSE(1, -2),
    SSW(-1, -2),
    EEN(2, 1),
    EES(2, -1),
    WWN(-2, 1),
    WWS(-2, -1);

    private final int xDegree;
    private final int yDegree;

    Direction(final int xDegree, final int yDegree) {
        this.xDegree = xDegree;
        this.yDegree = yDegree;
    }

    public static Direction find(final int xDegree, final int yDegree) {
        return Arrays.stream(values())
                .filter(direction -> direction.xDegree == xDegree)
                .filter(direction -> direction.yDegree == yDegree)
                .findFirst()
                .orElseThrow(DirectionNotFoundException::new);
    }

    public int getXDegree() {
        return xDegree;
    }

    public int getYDegree() {
        return yDegree;
    }
}
