package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.ChessPosition;
import coursereview.springchess.domain.Direction;

import java.util.Arrays;
import java.util.List;

public class Rook implements ChessPiece {

    private static final List<Direction> DIRECTIONS = Arrays.asList(Direction.N, Direction.E, Direction.S, Direction.W);

    @Override
    public boolean checkRule(final ChessPosition source, final ChessPosition target, final boolean isEnemyOnTarget) {
        Direction direction = source.calculateDirectionTo(target);
        return DIRECTIONS.contains(direction);
    }
}
