package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import entity.Cart;
import entity.Product;

public class cartDAO {
	public List<Cart> getCartProduct(ArrayList<Cart> cartList){
		List<Cart> products = new ArrayList<Cart>();
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					String query = "select productID,cateID,brandId,productName,status,image,price,discount,desciption,quantity,(price - ((price/100)*discount)) as disPrice from productdetail where productID = ? and status = 1";
					ConnectionProvider con = new ConnectionProvider();
					PreparedStatement pst = con.getConnection().prepareStatement(query);
					pst.setInt(1, item.getProductID());
					ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						double sub;
						Cart row = new Cart();
						row.setProductID(rs.getInt("productID"));
						row.setCateID(rs.getInt("cateID"));
						row.setBrandID(rs.getInt("brandId"));
						row.setProductName(rs.getString("productName"));
						row.setStatus(rs.getBoolean("status"));
						row.setImage(rs.getString("image"));
						row.setPrice(rs.getDouble("price"));
						row.setDiscount(rs.getInt("discount"));
						row.setDesciption(rs.getString("desciption"));
						row.setQuantity(rs.getInt("quantity"));
						row.setDisPrice(rs.getDouble("disPrice"));
						row.setQuantityOrder(item.getQuantityOrder());
						row.setSize(item.getSize());
						sub = item.getQuantityOrder()*rs.getDouble("disPrice");
						row.setSubTotal(sub);
						products.add(row);
						
					}
				}
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return products;
	}
	public Double getTotalPayment(ArrayList<Cart> cartList){
		double total_payment = 0;
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					String query="select (price - ((price/100)*discount)) as disPrice from productdetail where productID = ? and status = 1";
					ConnectionProvider con = new ConnectionProvider();
					PreparedStatement pst = con.getConnection().prepareStatement(query);
					pst.setInt(1, item.getProductID());
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						total_payment += rs.getDouble("disPrice")*item.getQuantityOrder();
					}
				}
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return total_payment;
	}
	public Double getPaymentVAT(double payment) {
		double totalVATPayment = 0;
		
		totalVATPayment = ((payment/100)*10);
		
		return totalVATPayment;
		
	}
	public Double getTotalPaymentAndVAT(double payment, double vat) {
		double total = 0;
		total = payment + vat;
		return total;
		
	}
}
