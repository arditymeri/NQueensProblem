public class Cell {

    private boolean occupied;
    private boolean watched;
    private int watchCount = 0;
    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell(int x, int y, boolean occupied, boolean watched) {
        this(x, y);
        this.occupied = occupied;
        this.watched = watched;
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
        this.watched = true;
        watchCount++;
    }

    public void resetWatched() {
        this.watched = false;
        watchCount = Math.max(watchCount - 1, 0);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
