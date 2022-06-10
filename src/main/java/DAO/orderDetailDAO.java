package DAO;

import java.sql.PreparedStatement;

import Context.ConnectionProvider;

public class orderDetailDAO {
	public String createOrderDetail(int orderID, int productID, int detailQuantity, String detailProductName, double detailPrice, int VAT, String size ) {
		String result ="";
		
		try {
			String query ="insert into orderdetail(orderID,productID,detailQuantity,detailProductName,detailPrice,VAT,detailSize) value(?,?,?,?,?,?,?);";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, orderID);
			pst.setInt(2, productID);
			pst.setInt(3, detailQuantity);
			pst.setString(4, detailProductName);
			pst.setDouble(5, detailPrice);
			pst.setInt(6, VAT);
			pst.setString(7, size);
			pst.executeUpdate();
			result ="successfully";
		}catch(Exception e ) {
			e.printStackTrace();
			result ="failed";
		}
		return result;
		
	}
	public String DeleteOrderDetailByID(String id) {
		String result = "";
		ConnectionProvider con = new ConnectionProvider();
		try {
			
			String query="delete from orderdetail where orderID = ? and shippedStatus = false";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, id);
			pst.executeUpdate();
			result ="successfully";
		}catch(Exception e){
			e.printStackTrace();
			result ="failed";
		}
		return result;
	}
}
