package transactions;

import java.util.Calendar;

/**
 * This class represents a simple financial transaction. A transaction is
 * defined by a transaction id, an amount and a transaction date.
 *
 * Transaction is intended to be an <strong>immutable</strong> type, i.e.,
 * instances of Transaction should be not changeable after they have
 * been created.
 *
 * @author Sathish Gopalakrishnan
 */
public class Transaction {

    /*
       a class variable to generate new transaction identifiers when new
       transaction objects are created. This variable keeps track of the most
       recent transaction created.
     */
    static private int recentTransactionId = 0;

    /*
        object fields for transaction amount, transaction date and transaction
        identifier. All fields are final because they are never changed after the
        object is created.
     */
    private final int amount;
    private final Calendar date;
    private final int transactionId;

    /**
     * Create a new Transaction with a given amount and date
     *
     * @param amount The transaction amount
     * @param date   The date of the transaction
     */
    public Transaction(int amount, Calendar date) {
        this.amount = amount;
        this.date = date;
        this.transactionId = recentTransactionId++;

        // This is only to demonstrate how static fields work.
        // Normally constructors should not have print statements.
        System.out.println("Created Transaction #" + transactionId);
    }

    public static int getRecentTransactionId() {
        return Transaction.recentTransactionId;
    }

    /**
     * Create a new transaction with the same amount as a given transaction but
     * set the date of the new transaction to be one month later.
     * <p>
     * This is a static method or class method.
     *
     * @param t the transaction to use as template
     * @return a new transaction for the same amount as the input transaction
     * but with date one month later
     */
    public static Transaction getNextMonthTransaction(Transaction t) {
        Calendar d = t.getDate();
        d.add(Calendar.MONTH, 1);
        return new Transaction(t.getAmount(), d);
    }

    /**
     * A method to get the transaction amount
     *
     * @return transaction amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * A method to get the transaction date
     *
     * @return transaction date
     */
    public Calendar getDate() {
        return date;
    }
}
