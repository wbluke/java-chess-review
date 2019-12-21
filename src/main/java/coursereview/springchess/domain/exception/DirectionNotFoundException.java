package coursereview.springchess.domain.exception;

public class DirectionNotFoundException extends IllegalArgumentException {

    public static final String DIRECTION_NOT_FOUND_MESSAGE = "잘못된 방향 정보입니다.";

    public DirectionNotFoundException() {
        super(DIRECTION_NOT_FOUND_MESSAGE);
    }
}
