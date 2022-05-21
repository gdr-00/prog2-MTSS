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

import it.unipd.mtss.model.OffertaMouse;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.EItem.ItemType;
import it.unipd.mtss.model.exception.DiscountException;

public class OffertaMouseTest {

    OffertaMouse discount;

    public List<EItem> listItems;

    @Before
    public void setup() {

        discount = new OffertaMouse();

        listItems = new ArrayList<EItem>();

        listItems.add(new EItem(ItemType.MOUSE, "MOUSE al pistacchio", 12.99));
        listItems.add(new EItem(ItemType.MOUSE, "MOUSE al cioccolato", 50.99));
        listItems.add(new EItem(ItemType.MOUSE, "MOUSE alla fragola", 29.99));
        listItems.add(new EItem(ItemType.MOUSE, "MOUSE al limone", 77.99));
        listItems.add(new EItem(ItemType.MOUSE, "MOUSE al cocco", 35.99));
        listItems.add(new EItem(ItemType.MOUSE, "MOUSE al pistacchio", 120.98));
        listItems.add(new EItem(ItemType.MOUSE, "MOUSE al cioccolato", 56.69));
        listItems.add(new EItem(ItemType.MOUSE, "MOUSE alla fragola", 72.69));
        listItems.add(new EItem(ItemType.MOUSE, "MOUSE al limone", 79.99));
        listItems.add(new EItem(ItemType.MOUSE, "MOUSE al cocco", 34.99));
    }

    @Test
    public void testGetDiscount() throws DiscountException {
        assertEquals(12.99, discount.getDiscount(listItems), 0.01);
        assertEquals(12.99, discount.getDiscount(listItems), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullList() throws DiscountException {
        assertEquals(12.99, discount.getDiscount(null), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotEnoughItems() throws DiscountException {
        listItems.remove(0);
        assertEquals(12.99, discount.getDiscount(listItems), 0.01);
    }

    @Test(expected = DiscountException.class)
    public void testNotEnoughMouse() throws DiscountException {
        listItems.remove(0);
        listItems.add(new EItem(ItemType.KEYBOARD, "_name", 100.99));
        assertEquals(12.99, discount.getDiscount(listItems), 0.01);
    }

}