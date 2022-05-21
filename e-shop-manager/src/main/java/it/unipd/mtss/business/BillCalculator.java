////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import java.util.List;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.DiscountProcessori;
import it.unipd.mtss.model.Discount1000;
import it.unipd.mtss.model.OffertaMouse;
import it.unipd.mtss.model.OffertaMouseTastiere;

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

        try {

            DiscountProcessori discountProcessori = new DiscountProcessori();
            total -= discountProcessori.getDiscount(itemsOrdered);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } try {
            OffertaMouse offertaMouse = new OffertaMouse();
            total -= offertaMouse.getDiscount(itemsOrdered);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } try {
            OffertaMouseTastiere offertaMouseTastiere = new OffertaMouseTastiere();
            total -= offertaMouseTastiere.getDiscount(itemsOrdered);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } try {
            Discount1000 Discount1000 = new Discount1000();
            total -= Discount1000.getDiscount(itemsOrdered);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return total;
    }
}
