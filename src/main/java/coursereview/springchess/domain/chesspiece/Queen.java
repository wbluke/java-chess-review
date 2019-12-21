package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.exception.DirectionNotFoundException;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.Direction;

import java.util.Arrays;
import java.util.List;

public class Queen implements ChessPiece {

    private static final List<Direction> DIRECTIONS = Arrays.asList(Direction.N, Direction.NE, Direction.E, Direction.SE
            , Direction.S, Direction.SW, Direction.W, Direction.NW);
    private static final String NAME = "Q";

    @Override
    public boolean checkRule(final ChessPosition source, final ChessPosition target, final boolean isEnemyOnTarget) {
        try {
            Direction direction = source.calculateDirectionTo(target);
            return DIRECTIONS.contains(direction);
        } catch (DirectionNotFoundException e) {
            return false;
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}
