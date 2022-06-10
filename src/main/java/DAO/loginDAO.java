package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Context.ConnectionProvider;
import entity.User;

public class loginDAO {
	public User login(String user,String pass) {
		User userResult = null;
		try {
		ConnectionProvider con = new ConnectionProvider();
		String query = "select * from user where userName= ? and userPass = ?";
		PreparedStatement pst = con.getConnection().prepareStatement(query);
		pst.setString(1, user);
		pst.setString(2, pass);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			userResult = new User();
			userResult.setUserName(rs.getString("userName"));
			userResult.setUserPass(rs.getString("userPass"));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userResult;
	}
}
