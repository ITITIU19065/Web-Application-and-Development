package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Context.ConnectionProvider;
import entity.User;

public class userDAO {
	public int getUserIdByName(String name) {
		int id = 0;
		try {
			String query ="select userID from user where userName = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				id = rs.getInt("userID");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return id; 
	}
}
