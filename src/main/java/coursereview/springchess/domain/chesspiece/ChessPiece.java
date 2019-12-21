package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.ChessPosition;

public interface ChessPiece {
    boolean checkRule(ChessPosition source, ChessPosition target, boolean isEnemyOnTarget);
}