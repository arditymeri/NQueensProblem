public class Cell {

    private boolean occupied;
    private int watchCount = 0;
    private final int x;
    private final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell(int x, int y, boolean occupied) {
        this(x, y);
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isWatched() {
        return watchCount > 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setOccupied() {
        this.occupied = true;
    }

    public void resetOccupied() {
        this.occupied = false;
    }

    public void setWatched() {
        watchCount++;
    }

    public void resetWatched() {
        watchCount = Math.max(watchCount - 1, 0);
    }
}
