package coursereview.springchess.service;

import coursereview.springchess.domain.ChessGame;
import coursereview.springchess.domain.chessplayer.BlackPlayer;
import coursereview.springchess.domain.chessplayer.WhitePlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.MovablePositions;
import coursereview.springchess.dto.ChessGameResponse;
import coursereview.springchess.dto.ChessMovablePositionResponse;
import org.springframework.stereotype.Service;

@Service
public class ChessService {

    private ChessGame chessGame;

    public ChessGameResponse initBoard() {
        this.chessGame = new ChessGame(new WhitePlayer(), new BlackPlayer(), true);
        return ChessAssembler.toGameResponse(chessGame);
    }

    public ChessGameResponse move(final String from, final String to) {
        ChessPosition source = ChessPosition.find(from);
        ChessPosition target = ChessPosition.find(to);

        chessGame.moveWith(source, target);
        return ChessAssembler.toGameResponse(chessGame);
    }

    public ChessMovablePositionResponse fetchMovablePosition() {
        MovablePositions movablePositions = chessGame.findCurrentMovablePositions();
        return ChessAssembler.toMovablePositionsResponse(movablePositions);
    }
}
