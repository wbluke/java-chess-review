package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.ChessPosition;
import coursereview.springchess.domain.Direction;

import java.util.Arrays;
import java.util.List;

public class Knight implements ChessPiece {

    private static final List<Direction> DIRECTIONS
            = Arrays.asList(Direction.NNE, Direction.EEN, Direction.EES, Direction.SSE
            , Direction.SSW, Direction.WWS, Direction.WWN, Direction.NNW);

    @Override
    public boolean checkRule(final ChessPosition source, final ChessPosition target, final boolean isEnemyOnTarget) {
        Direction direction = source.calculateDirectionTo(target);
        return source.isTargetAdjacent(target) && DIRECTIONS.contains(direction);
    }
}
