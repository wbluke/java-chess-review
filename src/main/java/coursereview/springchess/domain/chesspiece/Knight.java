package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.ChessPosition;
import coursereview.springchess.domain.Direction;
import coursereview.springchess.domain.exception.DirectionNotFoundException;

import java.util.Arrays;
import java.util.List;

public class Knight implements ChessPiece {

    private static final List<Direction> DIRECTIONS
            = Arrays.asList(Direction.NNE, Direction.EEN, Direction.EES, Direction.SSE
            , Direction.SSW, Direction.WWS, Direction.WWN, Direction.NNW);
    private static final String NAME = "N";

    @Override
    public boolean checkRule(final ChessPosition source, final ChessPosition target, final boolean isEnemyOnTarget) {
        try {
            Direction direction = source.calculateDirectionTo(target);
            return source.isTargetAdjacent(target) && DIRECTIONS.contains(direction);
        } catch (DirectionNotFoundException e) {
            return false;
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}
