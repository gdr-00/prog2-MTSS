////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model.exception;

public class DiscountException extends Exception {

    private static final long serialVersionUID = 3593092773689303182L; // Generato autmaticamente
    private final String msg;

    public DiscountException(String error) {
        msg = error;
    }

    public String toString() { return "DiscountException thrown: ".concat(msg); }
}