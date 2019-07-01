import java.util.Arrays;
import java.util.function.UnaryOperator;

public class Board {
    public static final int SIZE = 8;
    private final int[][] field = new int[SIZE][SIZE];
    public static final UnaryOperator<Integer> PLACE = x -> x + 1;
    public static final UnaryOperator<Integer> REMOVE = x -> x - 1;
    public static final int UNOCCUPIED = 0;

    public void changeDamselStatus(Coordinate coordinate, UnaryOperator<Integer> op) {
        if (get(coordinate) != UNOCCUPIED) {
            throw new RuntimeException("field is threatened");
        }
        markRow(coordinate, op);
        markCol(coordinate, op);
        markUpDiagonal(coordinate, op);
        markDownDiagonal(coordinate, op);
    }

    int get(Coordinate coordinate) {
        return field[coordinate.getRow()][coordinate.getCol()];
    }

    private void modify(Coordinate coordinate, UnaryOperator<Integer> op) {
        field[coordinate.getRow()][coordinate.getCol()] = op.apply(field[coordinate.getRow()][coordinate.getCol()]);
    }

    private void markCol(Coordinate coordinate, UnaryOperator<Integer> op) {
        Coordinate up = new Coordinate(coordinate);
        while (up.moveUp()) {
            modify(up, op);
        }
        Coordinate down = new Coordinate(coordinate);
        while (down.moveDown()) {
            modify(down, op);
        }
    }

    private void markRow(Coordinate coordinate, UnaryOperator<Integer> op) {
        Coordinate left = new Coordinate(coordinate);
        while (left.moveLeftDown()) {
            modify(left, op);
        }

        Coordinate right = new Coordinate(coordinate);
        while (right.moveRight()) {
            modify(right, op);
        }
    }

    private void markDownDiagonal(Coordinate coordinate, UnaryOperator<Integer> op) {
        Coordinate rightDown = new Coordinate(coordinate);
        while (rightDown.moveRightDown()) {
            modify(rightDown, op);
        }
        Coordinate leftUp = new Coordinate(coordinate);
        while (leftUp.moveLeftUp()) {
            modify(leftUp, op);
        }
    }

    private void markUpDiagonal(Coordinate coordinate, UnaryOperator<Integer> op) {
        Coordinate rightUp = new Coordinate(coordinate);
        while (rightUp.moveRightUp()) {
            modify(rightUp, op);
        }

        Coordinate leftDown = new Coordinate(coordinate);
        while (leftDown.moveLeftDown()) {
            modify(leftDown, op);
        }
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (int row = 0; row < SIZE; ++row) {
            for (int col = 0; col < SIZE; ++col) {
                buf.append(field[row][col] + " ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }
}
