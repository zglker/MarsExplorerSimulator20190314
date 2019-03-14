package simulator;

public class Mars {
    int rows;
    int columns;
    public Mars(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    /**
     * check the position is valid
     * @param position
     * @return
     */
    public boolean isValidPosition(Position position) {
        return !(
                position.x > this.columns ||  position.x< 0 ||
                        position.y > this.rows || position.y < 0
        );
    }
}
