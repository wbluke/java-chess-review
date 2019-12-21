package coursereview.springchess.domain;

import coursereview.springchess.domain.exception.ChessPositionNotFoundException;

import java.math.BigInteger;
import java.util.Arrays;

public enum ChessPosition {
    A1("a1"), A2("a2"), A3("a3"), A4("a4"), A5("a5"), A6("a6"), A7("a7"), A8("a8"),
    B1("b1"), B2("b2"), B3("b3"), B4("b4"), B5("b5"), B6("b6"), B7("b7"), B8("b8"),
    C1("c1"), C2("c2"), C3("c3"), C4("c4"), C5("c5"), C6("c6"), C7("c7"), C8("c8"),
    D1("d1"), D2("d2"), D3("d3"), D4("d4"), D5("d5"), D6("d6"), D7("d7"), D8("d8"),
    E1("e1"), E2("e2"), E3("e3"), E4("e4"), E5("e5"), E6("e6"), E7("e7"), E8("e8"),
    F1("f1"), F2("f2"), F3("f3"), F4("f4"), F5("f5"), F6("f6"), F7("f7"), F8("f8"),
    G1("g1"), G2("g2"), G3("g3"), G4("g4"), G5("g5"), G6("g6"), G7("g7"), G8("g8"),
    H1("h1"), H2("h2"), H3("h3"), H4("h4"), H5("h5"), H6("h6"), H7("h7"), H8("h8");

    private static final int INDEX_OF_WIDTH_POSITION = 0;
    private static final int INDEX_OF_HEIGHT_POSITION = 1;

    private final String position;

    ChessPosition(final String position) {
        this.position = position;
    }

    public Direction calculateDirectionTo(final ChessPosition target) {
        final int xDifference = calculateDifference(target, INDEX_OF_WIDTH_POSITION);
        final int yDifference = calculateDifference(target, INDEX_OF_HEIGHT_POSITION);

        final int gcd = calculateGcd(xDifference, yDifference);
        final int xDegree = calculateUnitDegree(xDifference, gcd);
        final int yDegree = calculateUnitDegree(yDifference, gcd);

        return Direction.find(xDegree, yDegree);
    }

    private int calculateDifference(final ChessPosition target, final int indexOfPosition) {
        return target.position.charAt(indexOfPosition) - position.charAt(indexOfPosition);
    }

    private int calculateGcd(final int x, final int y) {
        final BigInteger bigIntegerOfX = BigInteger.valueOf(x);
        final BigInteger bigIntegerOfY = BigInteger.valueOf(y);

        final BigInteger gcd = bigIntegerOfX.gcd(bigIntegerOfY);
        return gcd.intValue();
    }

    private int calculateUnitDegree(final int number, final int gcd) {
        final int divider = (gcd == 0) ? Math.abs(number) : gcd;
        return number / divider;
    }

    public ChessPosition next(final Direction direction) {
        final char nextX = moveToNext(INDEX_OF_WIDTH_POSITION, direction.getXDegree());
        final char nextY = moveToNext(INDEX_OF_HEIGHT_POSITION, direction.getYDegree());

        final String positionName = String.valueOf(nextX) + nextY;
        return find(positionName);
    }

    private char moveToNext(final int indexOfPosition, final int degree) {
        return (char) (position.charAt(indexOfPosition) + degree);
    }

    public boolean isTargetAdjacent(final ChessPosition target) {
        Direction direction = calculateDirectionTo(target);
        ChessPosition nextPosition = next(direction);

        return nextPosition.equals(target);
    }

    public static ChessPosition find(final String position) {
        return Arrays.stream(values())
                .filter(chessPosition -> chessPosition.position.equalsIgnoreCase(position))
                .findFirst()
                .orElseThrow(ChessPositionNotFoundException::new);
    }

    public String getPosition() {
        return position;
    }
}