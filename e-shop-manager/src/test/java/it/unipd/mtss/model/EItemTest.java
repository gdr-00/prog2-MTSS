////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.EItem.ItemType;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EItemTest {

    EItem item;

    ItemType type;
    String name;
    double price;

    @Before
    public void setup() {
        type=ItemType.KEYBOARD;
        name="Tastiera figa";
        price=150.99;

        item = new EItem(type, name, price);
    }

    @Test
    public void testGetType(){
        assertEquals(type, item.getType());
    }
    @Test
    public void testGetName(){
        assertEquals(name, item.getName());
    }
    @Test
    public void testGetPrice(){
        assertEquals(price, item.getPrice(), 0.0001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNullType() {
        new EItem(null, name, price);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNullName() {
        new EItem(type, null, price);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName() {
        new EItem(type, "", price);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrice() {
        new EItem(type, name, -1);
    }

}
