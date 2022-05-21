
package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unipd.mtss.model.Discount1000;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.EItem.ItemType;
import it.unipd.mtss.model.exception.DiscountException;

public class Discount1000Test {

    Discount1000 discount;

    public List<EItem> listItems;

    @Before
    public void setup() {

        discount = new Discount1000();

        listItems = new ArrayList<EItem>();

        listItems.add(new EItem(ItemType.KEYBOARD, "KEYBOARD1", 100));
        listItems.add(new EItem(ItemType.KEYBOARD, "KEYBOARD2", 15));
        listItems.add(new EItem(ItemType.MOUSE, "MOUSE", 300));
        listItems.add(new EItem(ItemType.MOTHERBOARD, "MOTHERBOARD1", 200));
        listItems.add(new EItem(ItemType.MOTHERBOARD, "MOTHERBOARD2", 50));
        listItems.add(new EItem(ItemType.KEYBOARD, "KEYBOARD3", 100));
        listItems.add(new EItem(ItemType.MOTHERBOARD, "MOTHERBOARD3", 150));
        listItems.add(new EItem(ItemType.PROCESSOR, "PROCESSOR1", 300));

    }

    @Test
    public void testGetDiscount() throws DiscountException {
        assertEquals(121.5, discount.getDiscount(listItems), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListNull() throws DiscountException {
        assertEquals(121.5, discount.getDiscount(null), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotEnoughItems() throws DiscountException {
        listItems.removeAll(listItems);
        assertEquals(121.5, discount.getDiscount(listItems), 0.01);
    }

    @Test(expected = DiscountException.class)
    public void testNotEnoughEuro() throws DiscountException {
        listItems.remove(0);
        listItems.remove(2);
        listItems.remove(3);
        assertEquals(121.5, discount.getDiscount(listItems), 0.01);
    }
}