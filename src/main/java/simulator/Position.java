package simulator;

/**
 * position class *
 */
public class Position {
    int x;
    int y;

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void move(int x, int y)
    {
        this.x += x;
        this.y += y;
    }

    /**
     * get next position to move to targetPosition
     * @param targetPosition
     * @return next position which is one step on x/y from current position
     */
    public Position getNextPosition(Position targetPosition) {

        //move y first
        if(this.y < targetPosition.getY())
        {
            move(0,1);
        }else if(this.y > targetPosition.getY())
        {
            move(0,-1);
        }else if(this.x > targetPosition.getX())
        {
            move(-1,0);
        }else if(this.x < targetPosition.getX())
        {
            move(1,0);
        }
        return this;
    }

    public String toString(){

        return "(" + this.x + "," + this.y + ")";

    }


}
