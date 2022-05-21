////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unipd.mtss.model.DiscountProcessori;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.EItem.ItemType;
import it.unipd.mtss.model.exception.DiscountException;

public class DiscountProcessoriTest {

    DiscountProcessori discount;

    public List<EItem> listItems;

    @Before
    public void setup() {

        discount = new DiscountProcessori();

        listItems = new ArrayList<EItem>();

        listItems.add(new EItem(ItemType.PROCESSOR, "Intel i5 5580u", 200.10));
        listItems.add(new EItem(ItemType.PROCESSOR, "intel i7 7700k", 308.12));
        listItems.add(new EItem(ItemType.PROCESSOR, "ryzen 5 5600x", 230.23));
        listItems.add(new EItem(ItemType.PROCESSOR, "ryzen 7 5800x", 370.99));
        listItems.add(new EItem(ItemType.PROCESSOR, "intel i9 9900", 699.99));
    }

    @Test
    public void testGetDiscount() throws DiscountException {
        assertEquals(100.05, discount.getDiscount(listItems), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullList() throws DiscountException {
        assertEquals(100.05, discount.getDiscount(null), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotEnoughItems() throws DiscountException {
        listItems.remove(0);
        assertEquals(100.05, discount.getDiscount(listItems), 0.01);
    }

    @Test(expected = DiscountException.class)
    public void testNotEnoughProcessors() throws DiscountException {
        listItems.remove(0);
        listItems.add(new EItem(ItemType.MOTHERBOARD, "asus aorus 3", 100.99));
        assertEquals(100.05, discount.getDiscount(listItems), 0.01);
    }

}