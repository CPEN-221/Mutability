package transactions;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TransactionTest {

    @Test
    public void testGetNextMonthTransaction() {
        Calendar d = new GregorianCalendar();
        int amount = 100;
        Transaction t1 = new Transaction(amount, d);
        Transaction t2 = Transaction.getNextMonthTransaction(t1);

        d = new GregorianCalendar();

        assertEquals(t1.getDate().get(Calendar.MONTH), d.get(Calendar.MONTH));

        d.add(Calendar.MONTH, 1);
        assertEquals(t2.getAmount(), amount);
        assertEquals(t2.getDate().get(Calendar.MONTH), d.get(Calendar.MONTH));
    }
}
