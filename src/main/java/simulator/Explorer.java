package simulator;

public class Explorer {
    private boolean onMars = false;
    private Position position;
    public Explorer() {
    }

    public Explorer(Position position) {
        this.position = position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isOnMars() {
        return onMars;
    }

    public Position getPosition() {
        return position;
    }

    public void setOnMars(boolean onMars) {
        this.onMars = onMars;
    }

    /**
     * simulate one step movement of the explorer
     * @param targetPosition
     * @return nex position of the explorer
     */
    public Position move(Position targetPosition) {
        position = position.getNextPosition(targetPosition);
        return position;
    }

}
