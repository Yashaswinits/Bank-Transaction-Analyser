import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactDAO {

	    public void addTransaction(int accId, String type, double amount) {

	        if (amount <= 0) {
	            System.out.println("Amount must be positive.");
	            return;
	        }

	        try (Connection conn = DBConnection.getConnection()) {

	            CallableStatement cs = conn.prepareCall("{CALL add_transaction(?,?,?)}");

	            cs.setInt(1, accId);
	            cs.setString(2, type);
	            cs.setDouble(3, amount);

	            cs.execute();
	            System.out.println("Transaction successful.");

	        } catch (Exception e) {
	            System.out.println("Transaction failed: " + e.getMessage());
	        }
	    }

	    public List<Transaction> getTransactions(int accId, String sortBy) {

	        List<Transaction> list = new ArrayList<>();

	        try (Connection conn = DBConnection.getConnection()) {

	            String sql = "SELECT * FROM transactions WHERE account_id=? ORDER BY " + sortBy;
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, accId);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                list.add(new Transaction(
	                        rs.getInt("id"),
	                        rs.getInt("account_id"),
	                        rs.getString("type"),
	                        rs.getDouble("amount"),
	                        rs.getTimestamp("date").toLocalDateTime()
	                ));
	            }

	        } catch (Exception e) {
	            System.out.println("Error fetching transactions: " + e.getMessage());
	        }

	        return list;
	    }
}
