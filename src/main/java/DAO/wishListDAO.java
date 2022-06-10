package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import entity.Product;

public class wishListDAO {
	public String insertWishList(String product_id, int userId) {
		String result = "";
		try {
			String query="insert into wishlist(productId,userId) value(?,?)";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, product_id);
			pst.setInt(2, userId);
			pst.executeUpdate();
			result ="successfully";
		}catch(Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	public String CheckingExistProduct(String product_id, int userId) {
		String result = "empty";
		try {
			String query="select * from wishlist where productId = ? and userId = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, product_id);
			pst.setInt(2, userId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				result ="exist";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Product> getInWishListByUserId(int userId){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select d.productID,d.cateID,d.brandId,d.productName,d.status,d.image,d.price,d.discount,d.desciption,d.quantity,(d.price - ((d.price/100)*d.discount)) as disPrice from productdetail as d join wishlist as w on d.productID = w.productId where w.userId = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Product row = new Product();
				row.setProductID(rs.getInt("d.productID"));
				row.setCateID(rs.getInt("d.cateID"));
				row.setBrandID(rs.getInt("d.brandId"));
				row.setProductName(rs.getString("d.productName"));
				row.setStatus(rs.getBoolean("d.status"));
				row.setImage(rs.getString("d.image"));
				row.setPrice(rs.getDouble("d.price"));
				row.setDiscount(rs.getInt("d.discount"));
				row.setDesciption(rs.getNString("d.desciption"));
				row.setQuantity(rs.getInt("d.quantity"));
				row.setDisPrice(rs.getDouble("disPrice"));
				product.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	public String DeleteWishListByProductId(String pid, int userId) {
		String result = "";
		ConnectionProvider con = new ConnectionProvider();
		try {
			String turnOff = "SET FOREIGN_KEY_CHECKS = 0";
			PreparedStatement pstOff = con.getConnection().prepareStatement(turnOff);
			pstOff.executeUpdate();
			String query="delete from wishlist where productID = ? and userId = ?";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, pid);
			pst.setInt(2, userId);
			pst.executeUpdate();
			String turnOn = "SET FOREIGN_KEY_CHECKS = 1";
			PreparedStatement pstOn = con.getConnection().prepareStatement(turnOn);
			pstOn.executeUpdate();
			result ="successfully";
		}catch(Exception e){
			e.printStackTrace();
			result ="failed";
		}
		return result;
	}
}
