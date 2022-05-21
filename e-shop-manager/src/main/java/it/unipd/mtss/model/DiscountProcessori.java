////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import java.util.List;

import it.unipd.mtss.model.EItem.ItemType;
import it.unipd.mtss.model.exception.DiscountException;

public class DiscountProcessori implements Discount {

    public double getDiscount(List<EItem> items) throws DiscountException, IllegalArgumentException {

        if (items == null) {
            throw new IllegalArgumentException("La lista non può essere nulla per discount processori");
        }

        if (items.size() < 5) {
            throw new IllegalArgumentException("La lista non può avere meno di 5 elementi per discount processori");
        }

        int P_number = 0;
        double min_price_p = 0;

        for (EItem item : items) {
            if (item.getType() == ItemType.PROCESSOR) {
                if (P_number == 0) {
                    min_price_p = item.getPrice();
                }

                if (min_price_p > item.getPrice()) {
                    min_price_p = item.getPrice();
                }

                P_number++;
            }
        }

        if (P_number >= 5) {
            return min_price_p * 0.5;
        }

        throw new DiscountException("Sconto non applicabile, meno di 5 processori nell'ordine");
    }

}