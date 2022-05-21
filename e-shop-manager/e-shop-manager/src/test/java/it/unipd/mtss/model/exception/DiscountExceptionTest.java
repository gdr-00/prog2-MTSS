////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.unipd.mtss.model.exception.DiscountException;

public class DiscountExceptionTest {
    @Test
    public void testExceptionMessage() {
        DiscountException exception = new DiscountException("error");
        assertEquals("DiscountException thrown: error", exception.toString());
    }
}