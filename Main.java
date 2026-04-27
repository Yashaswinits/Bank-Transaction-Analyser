import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		        Scanner sc = new Scanner(System.in);
		        AccountData accountDAO = new AccountData();
		        TransactDAO transactionDAO = new TransactDAO();
		        AnalyticsService analyticsService = new AnalyticsService();

		        System.out.print("Enter Account ID: ");
		        int accId = sc.nextInt();

		        Account account = accountDAO.getAccountById(accId);

		        if (account == null) {
		            System.out.println("Account not found.");
		            return;
		        }

		        System.out.println("Welcome " + account.getAccountHolder());

		        while (true) {

		            System.out.println("\n1.Deposit");
		            System.out.println("2.Withdraw");
		            System.out.println("3.View Transactions");
		            System.out.println("4.View Balance");
		            System.out.println("5.Analytics");
		            System.out.println("6.Exit");

		            System.out.print("Choose: ");
		            int choice = sc.nextInt();

		            switch (choice) {

		                case 1:
		                    System.out.print("Enter amount: ");
		                    transactionDAO.addTransaction(accId, "DEPOSIT", sc.nextDouble());
		                    break;

		                case 2:
		                    System.out.print("Enter amount: ");
		                    transactionDAO.addTransaction(accId, "WITHDRAW", sc.nextDouble());
		                    break;

		                case 3:
		                    System.out.println("Sort by amount/date?");
		                    String sort = sc.next();
		                    List<Transaction> list = transactionDAO.getTransactions(accId, sort);
		                    list.forEach(System.out::println);
		                    break;

		                case 4:
		                    Account updated = accountDAO.getAccountById(accId);
		                    System.out.println("Current Balance: " + updated.getBalance());
		                    break;

		                case 5:
		                    List<Transaction> tx = transactionDAO.getTransactions(accId, "date");
		                    analyticsService.calculateTotals(tx);
		                    break;

		                case 6:
		                    System.out.println("Goodbye");
		                    return;

		                default:
		                    System.out.println("Invalid choice");
		            }
		        }
		    }
	}
