////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import java.util.List;

import it.unipd.mtss.model.EItem.ItemType;
import it.unipd.mtss.model.exception.DiscountException;

public class OffertaMouseTastiere implements Discount {

    public double getDiscount(List<EItem> items) throws DiscountException, IllegalArgumentException {

        if (items == null) {
            throw new IllegalArgumentException("La lista non può essere nulla");
        }

        int M_number = 0;
        int K_number = 0;
        double min_price_p = 0;

        for (EItem item : items) {
            if (item.getType() == ItemType.MOUSE) {
                if (M_number == 0) {
                    min_price_p = item.getPrice();
                }

                if (min_price_p > item.getPrice()) {
                    min_price_p = item.getPrice();
                }

                M_number++;
            }

            if (item.getType() == ItemType.KEYBOARD) {
                if (K_number == 0) {
                    min_price_p = item.getPrice();
                }

                if (min_price_p > item.getPrice()) {
                    min_price_p = item.getPrice();
                }

                K_number++;
            }
        }

        if (K_number == M_number) {
            return min_price_p;
        }

        throw new DiscountException("Articolo non in regalo con numero mouse e tastiere diverso ");
    }

}