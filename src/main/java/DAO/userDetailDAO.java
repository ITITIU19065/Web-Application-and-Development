package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Context.ConnectionProvider;
import entity.Product;
import entity.UserDetail;

public class userDetailDAO {
	public String checkingEmptyDetailById(int id) {
		String result = "";
		try {
			String query ="select * from user as u  join userdetail as d on u.userID = d.userID where u.userId = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				if( rs.getString("firstName") == null || rs.getString("lastName") == null || rs.getString("phone") == null || rs.getString("age") == null || rs.getString("gender") == null 
						|| rs.getString("address") == null || rs.getString("city") == null) {
					result = "empty";
				}else {
					result = "valid";
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;	
	}
	public String InsertDetailById(int id,String fname, String lname,String phone,String age,String gender,String adderss,String city) {
		String result = "";
		try {
			String query ="update userdetail set firstName = ?, lastName = ?, phone = ?, age = ?, gender= ?, address = ?, city = ? where userID = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, fname);
			pst.setString(2, lname);
			pst.setString(3, phone);
			pst.setString(4, age);
			pst.setString(5, gender);
			pst.setString(6, adderss);
			pst.setString(7, city);
			pst.setInt(8, id);
			pst.executeUpdate();
			result ="successfully";
		}catch(Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;	
	}
	public UserDetail getDetailUser(int id) {
		String query="select * from userdetail where userID = ?";
		try {
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				return new UserDetail(rs.getString("firstName"),rs.getString("lastName"),rs.getString("phone"),rs.getInt("age"),
						rs.getString("gender"),rs.getString("address"),rs.getString("city"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
