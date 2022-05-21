////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import java.util.List;
import java.time.LocalTime;
import java.util.Random;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.DiscountProcessori;
import it.unipd.mtss.model.Discount1000;
import it.unipd.mtss.model.OffertaMouse;
import it.unipd.mtss.model.OffertaMouseTastiere;

public class BillCalculator implements Bill {
    private double total;
    private int regali = 10;

    public double getOrderPrice(List<EItem> itemsOrdered, User user)
            throws BillException,IllegalArgumentException {

        if (itemsOrdered == null) {
            throw new IllegalArgumentException("La lista non può essere nulla");
        }
        if (itemsOrdered.isEmpty()) {
            throw new IllegalArgumentException("La lista non può essere vuota");
        }
        if (itemsOrdered.size() > 30) {
            throw new BillException("Non si possono ordinare più di 30 Componenti");
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

        if (total < 10) {
            total += 2;
        }

        EItem last = itemsOrdered.get(itemsOrdered.size() - 1);

        if (isFree(last, user)) {
            total = 0;
            regali--;
        }

        return total;
    }
    public boolean isFree(EItem item, User user) {
        return item.isDuringWinningTime() && user.isWinner() && regali > 0;
    }
}
