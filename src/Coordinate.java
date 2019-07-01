class Coordinate {
    private int row;
    private int col;

    public Coordinate(Coordinate coordinate) {
        this.row = coordinate.row;
        this.col = coordinate.col;
    }
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean moveLeftDown() {
        if (col > 0 && row < Board.SIZE - 1) {
            --col;
            ++row;
            return true;
        }
        return false;
    }

    public boolean moveLeftUp() {
        if (col > 0 && row > 0) {
            --col;
            --row;
            return true;
        }
        return false;
    }

    public boolean moveRightDown() {
        if (col < Board.SIZE - 1 && row < Board.SIZE - 1) {
            ++col;
            ++row;
            return true;
        }
        return false;
    }

    public boolean moveRightUp() {
        if (col < Board.SIZE - 1 && row > 0) {
            ++col;
            --row;
            return true;
        }
        return false;
    }

    public boolean moveDown() {
        if (row < Board.SIZE - 1) {
            ++row;
            return true;
        }
        return false;
    }

    public boolean moveUp() {
        if (row > 0) {
            --row;
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        if (col > 0) {
            --col;
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        if (col < Board.SIZE - 1) {
            ++col;
            return true;
        }
        return false;
    }
}
