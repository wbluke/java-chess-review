package coursereview.springchess.domain.exception;

public class IllegalChessMovementException extends IllegalArgumentException {

    public static final String ILLEGAL_CHESS_MOVEMENT_MESSAGE = "잘못된 이동 경로입니다.";

    public IllegalChessMovementException() {
        super(ILLEGAL_CHESS_MOVEMENT_MESSAGE);
    }
}
