////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import java.util.List;

import it.unipd.mtss.model.EItem.ItemType;
import it.unipd.mtss.model.exception.DiscountException;

public class Discount1000 implements Discount {

    public double getDiscount(List<EItem> items) throws DiscountException, IllegalArgumentException {

        if (items == null) {
            throw new IllegalArgumentException("La lista non può essere nulla");
        }

        if (items.isEmpty()) {
            throw new IllegalArgumentException("La lista non può essere vuota");
        }

        double total = 0;

        for (EItem item : items) {
            total += item.getPrice();
        }

        if (total >= 1000) {
            return total * 0.1;
        }

        throw new DiscountException("Sconto non applicabile, soglia di 1000 euro non raggiunta");
    }

}