////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;
import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.assertFalse; 
import static org.junit.Assert.assertTrue;
 
import java.time.LocalTime; 
import java.util.ArrayList; 
import java.util.List;
 
import org.junit.Before; 
import org.junit.Test;
 
import it.unipd.mtss.business.exception.BillException; 
import it.unipd.mtss.model.EItem; 
import it.unipd.mtss.model.User; 
import it.unipd.mtss.model.EItem.ItemType;

public class BillCalculatorTest {

    List<EItem> listItems;
    User user;
    BillCalculator bill;

    @Before
    public void setup() {
        user = new User("pippo", 32);

        listItems = new ArrayList<EItem>();
        listItems.add(new EItem(ItemType.PROCESSOR, "Ryzen 9 5950x", 545.99));
        listItems.add(new EItem(ItemType.MOTHERBOARD, "asus rog z470", 200.12));
        listItems.add(new EItem(ItemType.MOUSE, "Glorius", 60.99));
        listItems.add(new EItem(ItemType.KEYBOARD, "Logitech", 150.99));

        bill = new BillCalculator();
    }

    @Test
    public void testGetOrderPrice() throws BillException {
        assertEquals(958.09, bill.getOrderPrice(listItems, user), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListNull() throws BillException {
        assertEquals(958.09, bill.getOrderPrice(null, user), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListEmpty() throws BillException {
        assertEquals(958.09, bill.getOrderPrice(new ArrayList<EItem>(), user), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUserNull() throws BillException {
        assertEquals(958.09, bill.getOrderPrice(listItems, null), 0.0001);
    }
}