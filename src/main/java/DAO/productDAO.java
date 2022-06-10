package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import entity.Product;

public class productDAO {
	public List<Product> getAllProduct(){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select productID,cateID,brandId,productName,status,image,price,discount,desciption,quantity,(price - ((price/100)*discount)) as disPrice from productdetail where status = 1";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
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
	
	public List<Product> getNewProduct(){
		List<Product> productNew = new ArrayList<Product>();
		try {
			String query = "select productID,cateID,brandId,productName,status,image,price,discount,desciption,quantity,(price - ((price/100)*discount)) as disPrice from productdetail where status = 1 order by productID DESC Limit 4";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
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
				productNew.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return productNew;
	}
	public List<Product> getDiscountProduct(){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select productID,cateID,brandId,productName,status,image,price,discount,desciption,quantity,(price - ((price/100)*discount)) as disPrice from productdetail where discount > 0 and status = 1";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
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
	
	public List<Product> getProductByCateID(String id){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select productID,cateID,brandId,productName,status,image,price,discount,desciption,quantity,(price - ((price/100)*discount)) as disPrice from productdetail where cateID= ? and status = 1";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, id);
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
	
	public List<Product> getProductByBrandID(String id){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select productID,cateID,brandId,productName,status,image,price,discount,desciption,quantity,(price - ((price/100)*discount)) as disPrice from productdetail where brandId= ? and status = 1";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, id);
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
	public Product getDetailProduct(String id) {
		String query="select productID,cateID,brandId,productName,status,image,price,discount,desciption,quantity,(price - ((price/100)*discount)) as disPrice from productdetail where productID = ?";
		try {
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				return new Product(rs.getInt("productID"),
						rs.getInt("cateID"),
						rs.getInt("brandId"),
						rs.getString("productName"),
						rs.getBoolean("status"),
						rs.getString("image"),
						rs.getDouble("price"),
						rs.getInt("discount"),
						rs.getString("desciption"),
						rs.getInt("quantity"),
						rs.getDouble("disPrice"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getQuantityInStockById(int id) {
		int stock = 0;
		String query = "select quantity from productdetail where productID = ?";
		try {
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				stock = rs.getInt("quantity");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return stock;
		
	}
	public String decreasingQuantityAfterOrder(int pid, int remain_Quantity) {
		String result = "";
		try {
			String query="update productdetail set quantity = ? where productID = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, remain_Quantity);
			pst.setInt(2, pid);
			pst.executeUpdate();
			result = "successfully";
		}catch(Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
		
	}
	public String setActiveAfterOrder(int pid) {
		String result = "";
		try {
			String query="update productdetail set status = 0 where productID = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, pid);
			pst.executeUpdate();
			result = "successfully";
		}catch(Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	//==============================================================================================
	//Admin Page DAO ===============================================================================
	//==============================================================================================
	public int getNewestIdProduct() {
		int id = 0;
		String query ="select productID from productdetail order by productID DESC limit 1";
		try {
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				id = rs.getInt("productID");
				id += 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return id;
		
	}
	public String InsertNewProduct(String cate, String brand, String name, String status,
			String img, String price, String discount, String descrip, String quantity) {
		
		String result = "";
		String addressImg= "./assets/img/product/"+img;
		try {
			String query = "insert into productDetail (cateID,brandId,productName,status,image,price,discount,desciption,quantity) value (?,?,?,?,?,?,?,?,?)";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, cate);
			pst.setString(2, brand);
			pst.setString(3, name);
			pst.setString(4, status);
			pst.setString(5, addressImg);
			pst.setString(6, price);
			pst.setString(7, discount);
			pst.setString(8, descrip);
			pst.setString(9, quantity);
			pst.executeUpdate();
			result ="successfully";
			
		}catch(Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
		
	}
	public List<Product> ShowAllProductAdminPage(){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select * from productdetail as d join brand as b on d.brandId = b.brandID join productcategory as c on c.cateID = d.cateID order by productID ASC";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
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
				row.setBrandName(rs.getString("brandName"));
				row.setCategoryName(rs.getString("cateName"));
				product.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	public List<Product> ShowAllNewestProductAdminPage(){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select * from productdetail as d join brand as b on d.brandId = b.brandID join productcategory as c on c.cateID = d.cateID order by productID DESC";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
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
				row.setBrandName(rs.getString("brandName"));
				row.setCategoryName(rs.getString("cateName"));
				product.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	public List<Product> getProductByCateIDAdmin(String id){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select * from productdetail as d join brand as b on d.brandId = b.brandID join productcategory as c on c.cateID = d.cateID where d.cateID = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, id);
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
				row.setBrandName(rs.getString("brandName"));
				row.setCategoryName(rs.getString("cateName"));
				product.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	public List<Product> getProductByBrandIDAdmin(String id){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select * from productdetail as d join brand as b on d.brandId = b.brandID join productcategory as c on c.cateID = d.cateID where d.brandId = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, id);
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
				row.setBrandName(rs.getString("brandName"));
				row.setCategoryName(rs.getString("cateName"));
				product.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	public String DeleteProductByIdAdmin(String id) {
		String result = "";
		ConnectionProvider con = new ConnectionProvider();
		try {
			String turnOff = "SET FOREIGN_KEY_CHECKS = 0";
			PreparedStatement pstOff = con.getConnection().prepareStatement(turnOff);
			pstOff.executeUpdate();
			String query="delete from productdetail where productID = ?";
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
	public List<Product> getAllProductID(){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select * from productdetail";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Product row = new Product();
				row.setProductID(rs.getInt("productID"));
				product.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	public String UpdateDetailProductlById(String id, String cateId, String brandId,String name, String status,
			String img,String price,String discount, String des,String quanity) {
		String result = "";
		try {
			String query ="update productdetail set cateID = ?, brandId = ?, productName = ?, status = ?, image =  ?,price = ?, discount = ?, desciption = ?, quantity = ? where productID = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, cateId);
			pst.setNString(2, brandId);
			pst.setString(3, name);
			pst.setString(4, status);
			pst.setString(5, img);
			pst.setString(6, price);
			pst.setString(7, discount);
			pst.setString(8, des);
			pst.setString(9, quanity);
			pst.setString(10, id);
			pst.executeUpdate();
			result ="successfully";
		}catch(Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;	
	}
	public List<Product> SearchProductByPriceAction1(){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select productID,cateID,brandId,productName,status,image,price,discount,desciption,quantity,(price - ((price/100)*discount)) as disPrice from productdetail where status = 1 and price <=100";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
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
	public List<Product> SearchProductByPriceAction2(){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select productID,cateID,brandId,productName,status,image,price,discount,desciption,quantity,(price - ((price/100)*discount)) as disPrice from productdetail where status = 1 and price between 100 and 200";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
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
	public List<Product> SearchProductByPriceAction3(){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select productID,cateID,brandId,productName,status,image,price,discount,desciption,quantity,(price - ((price/100)*discount)) as disPrice from productdetail where status = 1 and price between 200 and 500";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
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
	public List<Product> SearchProductByPriceAction4(){
		List<Product> product = new ArrayList<Product>();
		try {
			String query = "select productID,cateID,brandId,productName,status,image,price,discount,desciption,quantity,(price - ((price/100)*discount)) as disPrice from productdetail where status = 1 and price >500";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
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
