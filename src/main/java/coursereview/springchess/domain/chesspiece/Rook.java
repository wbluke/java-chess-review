package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.ChessPosition;
import coursereview.springchess.domain.Direction;
import coursereview.springchess.domain.exception.DirectionNotFoundException;

import java.util.Arrays;
import java.util.List;

public class Rook implements ChessPiece {

    private static final List<Direction> DIRECTIONS = Arrays.asList(Direction.N, Direction.E, Direction.S, Direction.W);
    private static final String NAME = "R";

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
