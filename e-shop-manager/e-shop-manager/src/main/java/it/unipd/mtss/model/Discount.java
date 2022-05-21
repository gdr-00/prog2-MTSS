////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.util.List;

import it.unipd.mtss.model.exception.DiscountException;

public interface Discount {

    public double getDiscount(List<EItem> items) throws DiscountException;

}