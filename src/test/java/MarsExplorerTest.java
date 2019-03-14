import exception.IgnoreException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import simulator.Explorer;
import simulator.Mars;

public class MarsExplorerTest {

    final int ROWS = 5;
    final int COLUMNS = 5;
    @Rule
    public org.junit.rules.ExpectedException thrown = ExpectedException.none();
    @Test
    public void testMarsExplorer() throws IgnoreException {

        Mars mars = new Mars(ROWS, COLUMNS);
        Explorer explorer = new Explorer();
        MarsExplorer marsExplorer = new MarsExplorer(mars, explorer);
        Assert.assertEquals("" ,marsExplorer.getCommand("PLACE 1,1"));
        Assert.assertEquals("M: (1,1) (1,2) (1,3) (2,3) (3,3)" ,marsExplorer.getCommand("MOVE 3,3"));
        Assert.assertEquals("M: (3,3) (3,2) (3,1) (2,1)" ,marsExplorer.getCommand("MOVE 2,1"));
        Assert.assertEquals("M: (2,1) (1,1)" ,marsExplorer.getCommand("MOVE 1,1"));
        Assert.assertEquals("P: (1,1)" ,marsExplorer.getCommand("REPORT"));

    }

    @Test
    public void testMarsExplorerException() throws IgnoreException {
        Mars mars = new Mars(ROWS, COLUMNS);
        Explorer explorer = new Explorer();
        MarsExplorer marsExplorer = new MarsExplorer(mars, explorer);
        thrown.expect(IgnoreException.class);
        marsExplorer.getCommand("");
        thrown.expect(IgnoreException.class);
        marsExplorer.getCommand("PLACE 0,");
        thrown.expect(IgnoreException.class);
        marsExplorer.getCommand("PLACE 7,8");
        thrown.expect(IgnoreException.class);
        marsExplorer.getCommand("MOVE 1,2");

        marsExplorer.getCommand("PLACE 5,5");
        thrown.expect(IgnoreException.class);
        marsExplorer.getCommand("PLACE 7,8");
        thrown.expect(IgnoreException.class);
        marsExplorer.getCommand("MOVE 7,8");


    }

}
