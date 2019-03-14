import simulator.Mars;
import org.junit.Assert;
import org.junit.Test;
import simulator.Position;

public class MarsTest {
    @Test
    public void testMars(){
        Mars mars = new Mars(5,5);
        Position positionTest1 = new Position(0,0);
        Assert.assertTrue(mars.isValidPosition(positionTest1));

        Position positionTest2 = new Position(5,5);
        Assert.assertTrue(mars.isValidPosition(positionTest2));

        Position positionTest3 = new Position(5,6);
        Assert.assertFalse(mars.isValidPosition(positionTest3));

        Position positionTest4 = new Position(-1,0);
        Assert.assertFalse(mars.isValidPosition(positionTest4));

    }
}
