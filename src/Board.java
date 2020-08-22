import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private final Cell[][] cells;
    int n;
    private final List<Solution> solutions = new ArrayList<>();

    public Board() {
        this(8);
    }

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
                insertInPosition(rowIndex, i);
                if (rowIndex == n - 1) {
                    storeCurrentSolution();
                } else {
                    findQueenPositionInRow(rowIndex + 1);
                }
                resetPosition(rowIndex, i);
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

    public void insertInPosition(int x, int y) {
        Cell cell = cells[x][y];
        cell.setOccupied();
        cell.setWatched();
        for (int i = 0; i < n; i++) {
            if (i != y) {
                cells[x][i].setWatched();
            }
            if (i != x) {
                cells[i][y].setWatched();
            }
        }
        int i = x - 1, j = y - 1;
        while (i >= 0 && j >= 0) {
            cells[i][j].setWatched();
            i--;
            j--;
        }
        i = x + 1;
        j = y + 1;
        while (i < n && j < n) {
            cells[i][j].setWatched();
            i++;
            j++;
        }

        i = x + 1;
        j = y - 1;
        while (i < n && j >= 0) {
            cells[i][j].setWatched();
            i++;
            j--;
        }

        i = x - 1;
        j = y + 1;
        while (i >= 0 && j < n) {
            cells[i][j].setWatched();
            i--;
            j++;
        }
    }

    public void resetPosition(int x, int y) {
        Cell cell = cells[x][y];
        cell.resetOccupied();
        cell.resetWatched();
        for (int i = 0; i < n; i++) {
            if (i != y) {
                cells[x][i].resetWatched();
            }
            if (i != x) {
                cells[i][y].resetWatched();
            }
        }
        int i = x - 1, j = y - 1;
        while (i >= 0 && j >= 0) {
            cells[i][j].resetWatched();
            i--;
            j--;
        }
        i = x + 1;
        j = y + 1;
        while (i < n && j < n) {
            cells[i][j].resetWatched();
            i++;
            j++;
        }

        i = x + 1;
        j = y - 1;
        while (i < n && j >= 0) {
            cells[i][j].resetWatched();
            i++;
            j--;
        }

        i = x - 1;
        j = y + 1;
        while (i >= 0 && j < n) {
            cells[i][j].resetWatched();
            i--;
            j++;
        }
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
        System.out.print("\n\ta b c d e f g h");

    }
}
