package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.ChessPosition;
import coursereview.springchess.domain.Direction;
import coursereview.springchess.domain.exception.DirectionNotFoundException;

import java.util.Arrays;
import java.util.List;

public class King implements ChessPiece {

    private static final List<Direction> DIRECTIONS = Arrays.asList(Direction.N, Direction.NE, Direction.E, Direction.SE
            , Direction.S, Direction.SW, Direction.W, Direction.NW);

    @Override
    public boolean checkRule(final ChessPosition source, final ChessPosition target, final boolean isEnemyOnTarget) {
        try {
            Direction direction = source.calculateDirectionTo(target);
            return source.isTargetAdjacent(target) && DIRECTIONS.contains(direction);
        } catch (DirectionNotFoundException e) {
            return false;
        }
    }
}
