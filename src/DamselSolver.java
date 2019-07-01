import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DamselSolver {
    Board board = new Board();

    public static void main(String... args) {
        DamselSolver solver = new DamselSolver();
        System.out.println(solver.board);
        solver.solve(0);
        System.out.println(solver.board);
    }

    boolean solve(int row) {
        if (row >= Board.SIZE) {
            return true;
        }
        List<Coordinate> coordinates = freeColumns(row);
        if (coordinates.size() == 0) {
            return false;
        }
        for (Coordinate coordinate : coordinates) {
            board.changeDamselStatus(coordinate, Board.PLACE);
            boolean success = solve(row + 1);
            if (success) return success;
            board.changeDamselStatus(coordinate, Board.REMOVE);
        }
        return false;
    }

    List<Coordinate> freeColumns(int row) {
        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < Board.SIZE ; ++i) {
            if (board.get(new Coordinate(row, i)) == Board.UNOCCUPIED) {
                zeros.add(i);
            };
        }
        return zeros.stream()
                .map(x -> new Coordinate(row, x))
                .collect(Collectors.toList());
    }
}
