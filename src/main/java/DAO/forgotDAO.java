package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import entity.User;
import entity.UserDetail;

public class forgotDAO {
	public List<User> getInforUser(){
		List<User> user = new ArrayList<User>();
		try {
			String query = "select * from user";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				User row = new User();
				row.setUserName(rs.getString("userName"));
				row.setUserPass(rs.getString("userPass"));
				user.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public List<UserDetail> getInforUserDetail(){
		List<UserDetail> userDetail = new ArrayList<UserDetail>();
		try {
			String query = "select * from UserDetail";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				UserDetail row = new UserDetail();
				row.setQuestionID(rs.getInt("questionID"));
				row.setAnswer(rs.getString("answer"));
				userDetail.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userDetail;
	}
	public String updatePassword(String userName,String pass) {
		String result = "failed";
		ConnectionProvider con =  new ConnectionProvider();
		String query ="update user set userPass = ? where userName = ?";
		try {
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, pass );
			pst.setString(2, userName);
			pst.executeUpdate();
			result ="successfully";
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
}
