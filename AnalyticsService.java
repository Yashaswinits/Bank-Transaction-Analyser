import java.util.List;

public class AnalyticsService{

	    public void calculateTotals(List<Transaction> transactions) {

	        double deposit = 0;
	        double withdraw = 0;

	        for (Transaction t : transactions) {

	            if (t.getType().equalsIgnoreCase("DEPOSIT"))
	                deposit += t.getAmount();
	            else
	                withdraw += t.getAmount();
	        }

	        System.out.println("Total Deposit: " + deposit);
	        System.out.println("Total Withdraw: " + withdraw);
	    }
	}

