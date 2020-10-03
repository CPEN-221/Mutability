package transactions;

import transactions.Transaction;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    /*
        We would like to test the correctness of the Transaction type.

        However, notice that the Transaction that t1 refers to is modified
        when we try to get a new Transaction for the next month using the
        Transaction.getNextMonthTransaction(Transaction t) method.

        Such behaviour violates the immutability that we desire for the
        Transaction type.
     */

    public static void main(String[] args) {
        Calendar d = new GregorianCalendar();
        int amount = 100;

        Transaction t1 = new Transaction(amount, d);
        System.out.printf("Month of Transaction t1 is %s\n", t1.getDate().get(Calendar.MONTH));

        Transaction t2 = Transaction.getNextMonthTransaction(t1);
        System.out.printf("Month of Transaction t1 is %s\n", t1.getDate().get(Calendar.MONTH));
        System.out.printf("Month of Transaction t2 is %s\n", t1.getDate().get(Calendar.MONTH));
    }
}
