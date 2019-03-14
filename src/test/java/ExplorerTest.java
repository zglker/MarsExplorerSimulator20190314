import simulator.Explorer;
import org.junit.Assert;
import org.junit.Test;
import simulator.Position;

public class ExplorerTest {
    @Test
    public void testExplorer(){
        Explorer explorer = new Explorer(new Position(0,0));
        Assert.assertFalse(explorer.isOnMars());
        Assert.assertEquals(0, explorer.getPosition().getX());
        Assert.assertEquals(0, explorer.getPosition().getY());

        explorer.setPosition(new Position(5,5));
        Assert.assertEquals(5, explorer.getPosition().getX());
        Assert.assertEquals(5, explorer.getPosition().getY());

        explorer.setOnMars(true);
        Assert.assertTrue(explorer.isOnMars());

        Position targetPosition = new Position(3,4);
        explorer.move(targetPosition);
        Assert.assertEquals(5, explorer.getPosition().getX());
        Assert.assertEquals(4, explorer.getPosition().getY());

        explorer.move(targetPosition);
        Assert.assertEquals(4, explorer.getPosition().getX());
        Assert.assertEquals(4, explorer.getPosition().getY());

        explorer.move(targetPosition);
        Assert.assertEquals(3, explorer.getPosition().getX());
        Assert.assertEquals(4, explorer.getPosition().getY());

    }
}
