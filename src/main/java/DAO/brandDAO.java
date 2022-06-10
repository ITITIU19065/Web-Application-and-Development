package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import entity.Brand;


public class brandDAO {
	public List<Brand> getAllBrand(){
		List<Brand> brand = new ArrayList<Brand>();
		try {
			String query ="select * from brand";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Brand row = new Brand();
				row.setBrandID(rs.getInt("brandID"));
				row.setBrandName(rs.getString("brandName"));
				brand.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return brand;
	}
	public String InsertNewBrand(String brand) {
		String result="";
		try {
			String query="insert into brand(brandName) value (?)";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, brand);
			pst.executeUpdate();
			result ="successfully";
		}catch(Exception e){
			e.printStackTrace();
			result ="failed";
		}
		return result;
	}
	public String DeleteBrand(String id) {
		String result="";
		ConnectionProvider con = new ConnectionProvider();
		try {
			String turnOff = "SET FOREIGN_KEY_CHECKS = 0";
			PreparedStatement pstOff = con.getConnection().prepareStatement(turnOff);
			pstOff.executeUpdate();
			String query="delete from brand where brandID = ?";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, id);
			pst.executeUpdate();
			String turnOn = "SET FOREIGN_KEY_CHECKS = 1";
			PreparedStatement pstOn = con.getConnection().prepareStatement(turnOff);
			pstOn.executeUpdate();
			result ="successfully";
		}catch(Exception e){
			e.printStackTrace();
			result ="failed";
		}
		return result;
	}
}
