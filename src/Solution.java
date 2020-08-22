import java.util.List;

public class Solution {

    private List<Cell> cells;

    public Solution(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public void print() {
        Board board = new Board(cells.size());
        for (Cell cell : cells) {
            board.insertInPosition(cell.getX(), cell.getY());
        }

        board.print();
        System.out.println("\n\t================");
    }
}
