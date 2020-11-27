package DB;
import java.sql.*;
public class userPanelDAO {
	
	
	public boolean checkMeterExist(String username) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		Connection con = connection.createConnection();
		Statement st = con.createStatement();
		String query ="SELECT * from user where username =\"" + username + "\"";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			flag = true;
		}
		return flag;
	}
public int getMeterId(String username) throws SQLException, ClassNotFoundException {
	Connection con = connection.createConnection();
	Statement st = con.createStatement();
	String query ="SELECT * from user where username =\"" + username + "\"";
	ResultSet rs = st.executeQuery(query);
	int meterId = 0;
	while(rs.next()) {
	 meterId = rs.getInt("meterId");  
	}
	return meterId;
}

public double getBillAmount(int meterID) throws SQLException, ClassNotFoundException {
	double amount = 0.0;
	Connection con = connection.createConnection();
	Statement st = con.createStatement();
	String meterIdinString =String.valueOf(meterID);
	String query ="SELECT * from user where meterId =" + meterIdinString ;
	ResultSet rs = st.executeQuery(query);
	while(rs.next()) {
	 amount = rs.getDouble("billAmount");
	}

	return amount;
	
}
public void insertUser(int meterId , String name , String username , String password , String email , String gender , String adhaar , String billAmount ) throws SQLException, ClassNotFoundException {
Connection con = connection.createConnection();
String query = "INSERT into user VALUES(" + meterId + "," +  name + "," + username + "," + password + "," + email + "," + gender + "," + adhaar + "," + billAmount+ ")" ;
PreparedStatement pt = con.prepareStatement(query);
pt.executeQuery();

}
public void readFromForgetPage(int meterId) throws SQLException, ClassNotFoundException {
		Connection con = connection.createConnection();
		String type = "Complaint";
		String status = "Pending";
		String remark = "Error in login";
	String query = "INSERT into feedback VALUES(" + meterId + "," +  type + "," + remark + "," + status + ")";
	PreparedStatement pt = con.prepareStatement(query);
	pt.executeQuery();
}
public void userComplaint(int meterId , String type , String remark) throws SQLException, ClassNotFoundException {
	Connection con = connection.createConnection();
		String status = "Pending";
		String query = "INSERT into feedback VALUES(" + meterId + "," +  type + "," + remark + "," + status + ")";
	PreparedStatement pt = con.prepareStatement(query);
	pt.executeQuery();
}
}