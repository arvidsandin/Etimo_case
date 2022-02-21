import static org.junit.Assert.assertEquals;
import org.junit.*;

public class TestStore {
    Store store;

    @Before
    public void setUp() {
         store = new Store();
    }

    @Test
    public void testProcure() {
        store.procure(1);
        assertEquals(1, store.getInventory());
        store.procure(2);
        assertEquals(3, store.getInventory());
        store.procure(3);
        assertEquals(6, store.getInventory());
    }

    @Test
    public void testSell() {
        store.procure(10);
        store.sell(1);
        assertEquals(9, store.getInventory());
        store.sell(2);
        assertEquals(7, store.getInventory());
        store.sell(3);
        assertEquals(4, store.getInventory());
    }

    @Test(expected = EmptyInventoryException.class)
    public void testSellEmptyInventory() {
        store.sell(1);
    }

    @Test(expected = EmptyInventoryException.class)
    public void testSellMoreThanInventory() {
        store.procure(10);
        store.sell(15);
    }
}
