import simulator.Position;
import org.junit.Assert;
import org.junit.Test;
import simulator.Position;

public class PositionTest {
    @Test
    public void testPosition(){
        Position position = new Position(1,2);
        Assert.assertEquals("(1,2)", position.toString());
        Assert.assertEquals(1, position.getX());
        Assert.assertEquals(2, position.getY());

        position.move(0,1);
        Assert.assertEquals(1, position.getX());
        Assert.assertEquals(3, position.getY());

        Position newPosition = position.getNextPosition(new Position(2,2));
        Assert.assertEquals(1, position.getX());
        Assert.assertEquals(2, position.getY());
    }
}
