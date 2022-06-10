package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import entity.Category;

public class categoryDAO {
	public List<Category> getAllCategory(){
		List<Category> category = new ArrayList<Category>();
		try {
			String query ="select * from productcategory";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Category row = new Category();
				row.setCateID(rs.getInt("cateID"));
				row.setCateName(rs.getString("cateName"));
				category.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return category;
	}
	public String InsertNewCategory(String cate) {
		String result ="";
		try {
			String query="insert into productcategory(cateName) value (?)";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, cate);
			pst.executeUpdate();
			result ="successfully";
		}catch(Exception e) {
			e.printStackTrace();
			result ="failed";
		}
		return result;
	}
	public String DeleteCategoryById(String id ) {
		String result = "";
		ConnectionProvider con = new ConnectionProvider();
		try {
			String turnOff = "SET FOREIGN_KEY_CHECKS = 0";
			PreparedStatement pstOff = con.getConnection().prepareStatement(turnOff);
			pstOff.executeUpdate();
			String query="delete from productcategory where cateID = ?";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, id);
			pst.executeUpdate();
			String turnOn = "SET FOREIGN_KEY_CHECKS = 1";
			PreparedStatement pstOn = con.getConnection().prepareStatement(turnOff);
			pstOn.executeUpdate();
			result ="successfully";
		}catch(Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
		
	}
}

