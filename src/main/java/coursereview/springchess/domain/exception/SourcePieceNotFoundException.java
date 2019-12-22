package coursereview.springchess.domain.exception;

public class SourcePieceNotFoundException extends IllegalArgumentException {

    public static final String SOURCE_PIECE_NOT_FOUND_MESSAGE = "움직일 수 있는 말이 없습니다.";

    public SourcePieceNotFoundException() {
        super(SOURCE_PIECE_NOT_FOUND_MESSAGE);
    }
}
