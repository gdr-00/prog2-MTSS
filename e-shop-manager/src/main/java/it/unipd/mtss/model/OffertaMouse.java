////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import java.util.List;

import it.unipd.mtss.model.EItem.ItemType;
import it.unipd.mtss.model.exception.DiscountException;

public class OffertaMouse implements Discount {

    public double getDiscount(List<EItem> items) throws DiscountException, IllegalArgumentException {

        if (items == null) {
            throw new IllegalArgumentException("La lista non può essere nulla");
        }

        if (items.size() < 10) {
            throw new IllegalArgumentException("La lista non può avere meno di 10 elementi per un offertamouse");
        }

        int M_number = 0;
        double min_price_m = 0;

        for (EItem item : items) {
            if (item.getType() == ItemType.MOUSE) {
                if (M_number == 0) {
                    min_price_m = item.getPrice();
                }

                if (min_price_m > item.getPrice()) {
                    min_price_m = item.getPrice();
                }

                M_number++;
            }
        }

        if (M_number >= 10) {
            return min_price_m;
        }

        throw new DiscountException("Sconto non applicabile, meno di 10 mouse nell'ordine");
    }

}