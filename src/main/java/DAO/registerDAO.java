package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Context.ConnectionProvider;
import entity.User;
import entity.UserDetail;



public class registerDAO {

	public String insert(User userRegister) throws ClassNotFoundException, SQLException {
		ConnectionProvider con = new ConnectionProvider();
		String result ="successfully";
		String query = "insert into user (userName,userPass)value(?,?)";
		try {
		PreparedStatement pst = con.getConnection().prepareStatement(query);
		pst.setString(1, userRegister.getUserName());
		pst.setString(2, userRegister.getUserPass());
		pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			result ="failed";
		}
		return result;	
	}
	public String insertSercurity(UserDetail detail) throws ClassNotFoundException, SQLException {
		ConnectionProvider con = new ConnectionProvider();
		String result ="successfully";
		String query = "insert into UserDetail (questionID,answer)value(?,?)";
		try {
		PreparedStatement pst = con.getConnection().prepareStatement(query);
		pst.setInt(1, detail.getQuestionID());
		pst.setString(2, detail.getAnswer());
		pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			result ="failed";
		}
		return result;	
	}
}