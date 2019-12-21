package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.ChessPosition;
import coursereview.springchess.domain.Direction;

import java.util.Arrays;
import java.util.List;

public class Bishop implements ChessPiece {

    private static final List<Direction> DIRECTIONS = Arrays.asList(Direction.NE, Direction.SE, Direction.SW, Direction.NW);

    @Override
    public boolean checkRule(final ChessPosition source, final ChessPosition target, final boolean isEnemyOnTarget) {
        Direction direction = source.calculateDirectionTo(target);
        return DIRECTIONS.contains(direction);
    }
}
