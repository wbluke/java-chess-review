package coursereview.springchess.domain.position;

import coursereview.springchess.domain.chessplayer.ChessPlayer;

import java.util.*;

public class MovablePositions {

    private final Map<ChessPosition, List<ChessPosition>> posistions = new HashMap<>();

    public MovablePositions(final ChessPlayer currentPlayer, final ChessPlayer oppositePlayer) {
        Arrays.stream(ChessPosition.values())
                .map(chessPosition -> currentPlayer.findPieceOn(chessPosition))
                .filter(Objects::nonNull);

        List<ChessPosition> movablePositions = currentPlayer.temp(oppositePlayer);
    }
}
