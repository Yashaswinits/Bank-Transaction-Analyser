import java.sql.*;

public class AccountData {

	    public Account getAccountById(int id) {

	        try (Connection conn = DBConnection.getConnection()) {

	            String sql = "SELECT * FROM accounts WHERE id=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, id);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                return new Account(
	                        rs.getInt("id"),
	                        rs.getString("account_holder"),
	                        rs.getDouble("balance")
	                );
	            }

	        } catch (Exception e) {
	            System.out.println("Error fetching account: " + e.getMessage());
	        }

	        return null;
	    }
	}
