package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.ChessPosition;

public class WhitePawn implements ChessPiece {

    private static final String NAME = "P";

    @Override
    public boolean checkRule(final ChessPosition source, final ChessPosition target, final boolean isEnemyOnTarget) {
        // TODO: 21/12/2019 check rule
        return false;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
