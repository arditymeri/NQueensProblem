import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Board {

    private final Cell[][] cells;
    int n;
    private final List<Solution> solutions = new ArrayList<>();

    public Board(int n) {
        this.n = n;
        cells = generateCells(n);
    }

    public List<Solution> findSolutions() {
        findQueenPositionInRow(0);
        return this.solutions;
    }

    private Cell[][] generateCells(int n) {
        Cell[][] cells = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
        return cells;
    }

    public void findQueenPositionInRow(int rowIndex) {
        if (rowIndex == n) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!cells[rowIndex][i].isWatched()) {
                setIn(rowIndex, i);
                if (rowIndex == n - 1) {
                    storeCurrentSolution();
                } else {
                    findQueenPositionInRow(rowIndex + 1);
                }
                resetIn(rowIndex, i);
            }
        }
    }

    private void storeCurrentSolution() {
        List<Cell> currentSolution = Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .filter(Cell::isOccupied)
                .map(cell -> new Cell(cell.getX(), cell.getY(), true))
                .collect(Collectors.toList());
        Solution solution = new Solution(currentSolution);
        solutions.add(solution);

    }

    public void updateDiagonals(int x, int y, Consumer<Cell>consumer) {
        int i0 = Math.max(x-y, 0);
        int j0 = Math.max(y-x, 0);
        for (int i = i0, j = j0; i < n && j < n; i++, j++) {
            if (i != x) {
                consumer.accept(cells[i][j]);
            }
        }

        int i1 = Math.min(x + y, n - 1);
        int j1 = Math.max(y - (n-1-x), 0);
        for (int i = i1, j = j1; i >= 0 && j < n; i--, j++) {
            if (i != x) {
                consumer.accept(cells[i][j]);
            }
        }
    }

    public void updateRows(int x, int y, Consumer<Cell> cellConsumer) {
        for (int i = 0; i < n; i++) {
            if (i != y) {
                cellConsumer.accept(cells[x][i]);
            }
            if (i != x) {
                cellConsumer.accept(cells[i][y]);
            }
        }
    }

    public void setIn(int x, int y) {
        Cell cell = cells[x][y];
        cell.setOccupied();
        cell.setWatched();
        updateRows(x, y, Cell::setWatched);
        updateDiagonals(x, y, Cell::setWatched);
    }

    public void resetIn(int x, int y) {
        Cell cell = cells[x][y];
        cell.resetOccupied();
        cell.resetWatched();
        updateRows(x, y, Cell::resetWatched);
        updateDiagonals(x, y, Cell::resetWatched);
    }

    public void print() {

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.print("\t");
            for (int j = 0; j < n; j++) {
                if (cells[i][j].isOccupied()) {
                    System.out.print("X ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.print((n - i));
        }

        System.out.print("\n\t");
        char c = 'a';
        String prefix = "";
        for (int i = 0; i < n; i++) {
            if (i> 0 && i % 26 == 0) {
                c = 'a';
                prefix = "a";
            }
            System.out.print(prefix + c + " ");
            c++;
        }
    }
}
