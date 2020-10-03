How Transactions Go Wrong
========

This is an example concerning mutability, and `static` fields and methods.

### Objectives of this Example
+ Understand mutability of objects (and when there is undesired mutation).
+ Understand the keyword `final` and also why it is not sufficient to prevent unwanted mutations.
+ Understand `static` class fields and `static` methods.

### The `Transaction` Class

The `Transaction` class in this example is a class that should allow us to record a simple financial transaction. A sketch of this class follows but the detailed source code is in `Transaction.java`.

```java
public class Transaction {
/* 
    A class variable to generate new transaction identifiers 
    when new transaction objects are created. This variable
    keeps track of the most recent transaction created.
*/
	static private int recentTransactionId;

/*
    Object fields for transaction amount, transaction date 
    and transaction identifier. All fields are final 
    because they are never changed after the object is created.
*/
	private final int amount;
	private final Calendar date;
	private final int transactionId;

	/**
	 * Create a new Transaction with a given amount and date
	 * 
         * @param amount
	 *            The transaction amount
	 * @param date
	 *            The date of the transaction
	 */
	public Transaction(int amount, Calendar date) {
		…
	}

	/**
	 * A method to get the transaction amount
	 * 
	 * @return transaction amount
	 */
	public int getAmount() {
		…
	}

	/**
	 * A method to get the transaction date
	 * 
	 * @return transaction date
	 */
	public Calendar getDate() {
		…
	}

	/**
	 * Create a new transaction with the same amount as a given transaction but
	 * set the date of the new transaction to be one month later.
	 * 
	 * This is a static method or class method.
	 * 
	 * @param t
	 *            the transaction to use as template
	 * @return a new transaction for the same amount as the input transaction
	 *         but with date one month later
	 */
	public static Transaction getNextMonthTransaction(Transaction t) {
		…
	}
}
```

### A Failed Test

The provided test will fail. 
+ Why does it fail? 
+ Is this really a failure or should this be appropriate behaviour for our code?

### Things to Ponder

+ Why were `date`, `amount` and `transactionId` in `Transaction` declared to be `final`?
+ Why did the use of the keyword `final` not help?
+ Why did we declare `recentTransactionId` in `Transaction` to be `static`? 
+ Is the declaration of `getNextMonthTransaction( )` as `static` a reasonable choice? What alternative approach could we have taken for this method?

### References
+ Read about the `static` and `final` keywords with the Oracle [Java tutorial](http://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html).
+ [More on Class Variables](http://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)
+ [Tutorial](http://www.vogella.com/tutorials/JUnit/article.html) on using `JUnit` for unit testing
+ Some of you may also want to look at the [`Calendar`](http://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html) class.