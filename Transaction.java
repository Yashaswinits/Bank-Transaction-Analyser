import java.time.LocalDateTime;

public class Transaction {
	    private int id;
	    private int accountId;
	    private String type;
	    private double amount;
	    private LocalDateTime date;

	    public Transaction(int id, int accountId, String type, double amount, LocalDateTime date) {
	        this.id = id;
	        this.accountId = accountId;
	        this.type = type;
	        this.amount = amount;
	        this.date = date;
	    }

	    public int getAccountId() { return accountId; }
	    public String getType() { return type; }
	    public double getAmount() { return amount; }

	    @Override
	    public String toString() {
	        return id + " | " + type + " | " + amount + " | " + date;
	    }
	}
