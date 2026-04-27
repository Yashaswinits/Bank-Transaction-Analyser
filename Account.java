public class Account {

	    private int id;
	    private String accountHolder;
	    private double balance;

	    public Account(int id, String accountHolder, double balance) {
	        this.id = id;
	        this.accountHolder = accountHolder;
	        this.balance = balance;
	    }

	    public int getId() { return id; }
	    public String getAccountHolder() { return accountHolder; }
	    public double getBalance() { return balance; }

	    @Override
	    public String toString() {
	        return id + " | " + accountHolder + " | Balance: " + balance;
	    }
	}

