////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import java.util.List;

import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;

public class BillCalculator implements Bill {
    private double total;

    public double getOrderPrice(List<EItem> itemsOrdered, User user)
            throws IllegalArgumentException {

        if (itemsOrdered == null) {
            throw new IllegalArgumentException("La lista non può essere nulla");
        }
        if (itemsOrdered.isEmpty()) {
            throw new IllegalArgumentException("La lista non può essere vuota");
        }
        if (user == null) {
            throw new IllegalArgumentException("L'utente non può essere nullo");
        }

        for (EItem item : itemsOrdered) {
            total += item.getPrice();
        }

        return total;
    }
}
