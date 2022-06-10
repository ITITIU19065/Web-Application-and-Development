package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import entity.OrderDetail;
import entity.Product;

public class orderDAO {
	public String CreateOrderByUserId(int userId,String date, String address, String city, String fname, String lname,String phone,String shippedNote,String paymentType) {
		String result = "";
		ConnectionProvider con = new ConnectionProvider();
		try {
			String turnOff = "SET FOREIGN_KEY_CHECKS = 0";
			PreparedStatement pstOff = con.getConnection().prepareStatement(turnOff);
			pstOff.executeUpdate();
			
			
			String query ="insert into orders(userID,orderCreated,shippedAddress,shippedCity,shippedFirstName,shippedLastName,shippedPhone,shippedNote,paymentType) value(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, userId);
			pst.setString(2, date);
			pst.setString(3, address);
			pst.setString(4, city);
			pst.setString(5, fname);
			pst.setString(6, lname);
			pst.setString(7, phone);
			pst.setString(8, shippedNote);
			pst.setString(9, paymentType);
			pst.executeUpdate();
			
			
			String turnOn = "SET FOREIGN_KEY_CHECKS = 1";
			PreparedStatement pstOn = con.getConnection().prepareStatement(turnOn);
			pstOn.executeUpdate();
			result ="successfully";
		}catch(Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result; 
		
	}
	public int selectOrderId() {
		int id = 0;
		try {
			String query="select orderID from orders order by orderID DESC limit 1";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrderID(rs.getInt("orderID"));
				id = rs.getInt("orderID");
			}
			
		}catch(Exception e){
			e.printStackTrace();

		}
		return id;
		
	}
	
	public String DeleteOrderByID(String id) {
		String result = "";
		ConnectionProvider con = new ConnectionProvider();
		try {
			
			String query="delete from orders where orderID = ? and shippedStatus = false";
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
	public List<OrderDetail> getOrderByUserID(int id) {
		List<OrderDetail> order = new ArrayList<OrderDetail>();
		ConnectionProvider con = new ConnectionProvider();
		try {
			String query="select orderID, shippedFirstName,shippedLastName,orderCreated,shippedAddress,shippedCity, shippedPhone,paymentType,shippedStatus from orders where userID = ?";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				OrderDetail row = new OrderDetail();
				row.setOrderID(rs.getInt("orderID"));
				row.setShippedFname(rs.getString("shippedFirstName"));
				row.setShippedLName(rs.getString("shippedLastName"));
				row.setOrderCreated(rs.getString("orderCreated"));
				row.setShippedAddress(rs.getString("shippedAddress"));
				row.setShippedCity(rs.getString("shippedCity"));
				row.setPaymentType(rs.getString("paymentType"));
				row.setShippedPhone(rs.getString("shippedPhone"));
				row.setShippedStatus(rs.getBoolean("shippedStatus"));
				order.add(row);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return order;
	}
	public List<OrderDetail> getProductByOrderID(String id){
		List<OrderDetail> order = new ArrayList<OrderDetail>();
		ConnectionProvider con = new ConnectionProvider();
		try {
			String query="select orderDetailID,orderID,productID,detailQuantity,detailSize,detailProductName,detailPrice,VAT, (detailQuantity*detailPrice) as subtotal,shippedStatus from orderdetail where orderID = ?";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				OrderDetail row = new OrderDetail();
				row.setOrderDetailID(rs.getInt("orderDetailID"));
				row.setOrderID(rs.getInt("orderID"));
				row.setProductID(rs.getInt("productID"));
				row.setDetailQuantity(rs.getInt("detailQuantity"));
				row.setSize(rs.getString("detailSize"));
				row.setDetailProductName(rs.getString("detailProductName"));
				row.setDetailPrice(rs.getDouble("detailPrice"));
				row.setVAT(rs.getInt("VAT"));
				row.setSubtotal(rs.getDouble("subtotal"));
				row.setShippedStatus(rs.getBoolean("shippedStatus"));
				order.add(row);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return order;
	}
	
	//========================================
	//Admin===================================
	//========================================
	public List<OrderDetail> getAllOrderByAdmin() {
		List<OrderDetail> order = new ArrayList<OrderDetail>();
		ConnectionProvider con = new ConnectionProvider();
		try {
			String query="select * from orders";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				OrderDetail row = new OrderDetail();
				row.setOrderID(rs.getInt("orderID"));
				row.setShippedFname(rs.getString("shippedFirstName"));
				row.setShippedLName(rs.getString("shippedLastName"));
				row.setOrderCreated(rs.getString("orderCreated"));
				row.setShippedAddress(rs.getString("shippedAddress"));
				row.setShippedCity(rs.getString("shippedCity"));
				row.setPaymentType(rs.getString("paymentType"));
				row.setShippedPhone(rs.getString("shippedPhone"));
				row.setShippedStatus(rs.getBoolean("shippedStatus"));
				order.add(row);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return order;
	}
	public String setShippedStatusForAdmin(String oid) {
		String result = "";
		try {
			String query = "update orders set shippedStatus = 1 where orderID = ?"; 
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, oid);
			pst.executeUpdate();
			result  = "successfully";
		}catch(Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
		
	}
	public String setShippedStatusDetailForAdmin(String oid) {
		String result = "";
		try {
			String query = "update orderdetail set shippedStatus = 1 where orderID = ?"; 
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, oid);
			pst.executeUpdate();
			result  = "successfully";
		}catch(Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
		
	}
}
