import java.util.List;

public class Solution {

    private final List<Cell> cells;

    public Solution(List<Cell> cells) {
        this.cells = cells;
    }

    public void print() {
        Board board = new Board(cells.size());
        for (Cell cell : cells) {
            board.setIn(cell.getX(), cell.getY());
        }

        board.print();
        System.out.println("\n\t================");
    }
}
