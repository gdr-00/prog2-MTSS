////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business.exception;

public class BillException extends Exception {

    private static final long serialVersionUID = -6738592842440983810L; //autmatico
    private final String msg;

    public BillException(String error) {
        msg = error;
    }

    public String toString() {
        return "BillException thrown: ".concat(msg);
    }
}
