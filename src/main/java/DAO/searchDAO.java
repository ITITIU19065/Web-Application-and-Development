package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import entity.Product;

public class searchDAO {
	public List<Product> searchProductByName(String name){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select productID,cateID,brandId,productName,status,image,price,discount,desciption,quantity,(price - ((price/100)*discount)) as disPrice from productdetail where status = 1 and productName like ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, "%"+name+"%");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Product row = new Product();
				row.setProductID(rs.getInt("productID"));
				row.setCateID(rs.getInt("cateID"));
				row.setBrandID(rs.getInt("brandId"));
				row.setProductName(rs.getString("productName"));
				row.setStatus(rs.getBoolean("status"));
				row.setImage(rs.getString("image"));
				row.setPrice(rs.getDouble("price"));
				row.setDiscount(rs.getInt("discount"));
				row.setDesciption(rs.getNString("desciption"));
				row.setQuantity(rs.getInt("quantity"));
				row.setDisPrice(rs.getDouble("disPrice"));
				product.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
}
