////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business.exception;

import it.unipd.mtss.business.exception.BillException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BillExceptionTest {
    @Test
    public void testExceptionMessage() {
        BillException exception = new BillException("error");
        assertEquals("BillException thrown: error", exception.toString());
    }
}