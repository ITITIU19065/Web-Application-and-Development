package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.cartDAO;
import DAO.orderDAO;
import DAO.orderDetailDAO;
import DAO.productDAO;
import DAO.userDAO;
import DAO.userDetailDAO;
import entity.Cart;
import entity.UserDetail;

/**
 * Servlet implementation class ConfirmAnotherServelt
 */
@WebServlet("/ConfirmAnother")
public class ConfirmAnotherServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String type = request.getParameter("type");
		String note = request.getParameter("note");
		String phone = request.getParameter("phone");
		
		if(fname.length() == 0 || lname.length() == 0 || address.length() == 0 || city.length() == 0 || phone.length() == 0) {
			request.setAttribute("message", "empty");
			request.getRequestDispatcher("checkOut.jsp").forward(request, response);
		}else {
			String userName = (String) session.getAttribute("user");
	     	userDAO daoUser = new userDAO();
	     	int userID = daoUser.getUserIdByName(userName);
	     	userDetailDAO userDetail = new userDetailDAO();
	     	UserDetail detail = userDetail.getDetailUser(userID);
	     	
	     	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	     	Date date = new Date();
	     	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	     	
	     	String dateOrder = formatter.format(date);
	     	cartDAO daoCart = new cartDAO();
	     	List<Cart> cartProduct = daoCart.getCartProduct(cart_list);
	     // insert order table
	     	orderDAO daoOrder = new orderDAO();
			String result =  daoOrder.CreateOrderByUserId(userID, dateOrder,address , city, fname, lname, phone, note, type);
			
			
			if(cartProduct != null) {
	     		for(Cart c:cartProduct) {
	     			
	     	     	
	     			
	     			// insert orderDetail table
	     			int orderId = daoOrder.selectOrderId();
	     	     	orderDetailDAO daoOrderDetail = new orderDetailDAO();
	     	     	String resultDetail = daoOrderDetail.createOrderDetail(orderId, c.getProductID(), c.getQuantityOrder(), c.getProductName(), c.getDisPrice(), 10, c.getSize());
	     	     	
	     	     	// decreasing quantity instock of product in productdetail table
	     	     	productDAO daoProduct = new productDAO();
	     	     	int quantityInstock = daoProduct.getQuantityInStockById(c.getProductID());
	     	     	out.print("quantityInstock: "+quantityInstock);
	     	     	int remain = quantityInstock - c.getQuantityOrder();
	     	     	out.print("remain: "+remain);
	     	     	
	     	     	// set Active of product  = false if remain <= 0
	     	     	if(remain <=0) {
	     	     		String resultActive = daoProduct.setActiveAfterOrder(c.getProductID());
	     	     	}
	     	     	String resultQuantity = daoProduct.decreasingQuantityAfterOrder(c.getProductID(), remain);
	     	     	
	     	     	// delete product in cart list
	     	     	for(Cart p:cart_list) {
	     	     		if(p.getProductID() == c.getProductID()) {
	     	     			cart_list.remove(cart_list.indexOf(p));
	    					break;
	     	     		}
	     	     	}	
	     		}
	     		response.sendRedirect("index.jsp");
	     	}
		}
		
	}

}
