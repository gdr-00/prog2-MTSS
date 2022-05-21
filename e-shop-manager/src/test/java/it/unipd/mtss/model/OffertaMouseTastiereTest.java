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

import it.unipd.mtss.model.OffertaMouseTastiere;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.EItem.ItemType;
import it.unipd.mtss.model.exception.DiscountException;

public class OffertaMouseTastiereTest {

    OffertaMouseTastiere discount;

    public List<EItem> listItems;

    @Before
    public void setup() {

        discount = new OffertaMouseTastiere();

        listItems = new ArrayList<EItem>();

        listItems.add(new EItem(ItemType.MOUSE, "razer", 80.00));
        listItems.add(new EItem(ItemType.KEYBOARD, "logitech", 150.00));
    }

    @Test
    public void testGetOfferMouseLessexpensive() throws DiscountException {
        assertEquals(80.0, discount.getDiscount(listItems), 0.01);
    }

    @Test
    public void testGetOfferKeyboardLessexpensive() throws DiscountException {
        listItems = new ArrayList<EItem>();
        listItems.add(new EItem(ItemType.MOUSE, "razer", 180.00));
        listItems.add(new EItem(ItemType.KEYBOARD, "logitech", 150.00));
        assertEquals(150.0, discount.getDiscount(listItems), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullList() throws DiscountException {
        assertEquals(100.05, discount.getDiscount(null), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotEnoughItems() throws DiscountException {
        listItems.remove(0);
        assertEquals(1.50, discount.getDiscount(listItems), 0.01);
    }

    @Test(expected = DiscountException.class)
    public void testNotEnoughMouseOrKeyboard() throws DiscountException {
        listItems.remove(0);
        listItems.add(new EItem(ItemType.MOUSE, "logitech p40", 45.12));
        listItems.add(new EItem(ItemType.KEYBOARD, "tasiteraNuova", 100.00));
        assertEquals(100.00, discount.getDiscount(listItems), 0.01);
    }

}