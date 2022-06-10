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
import entity.OrderDetail;
import entity.UserDetail;

/**
 * Servlet implementation class ConfirmOrderDefaultServlet
 */
@WebServlet("/ConfirmDefault")
public class ConfirmOrderDefaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String type = request.getParameter("type");
		String note = request.getParameter("note");
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
		String result =  daoOrder.CreateOrderByUserId(userID, dateOrder, detail.getAddress(), detail.getCity(), detail.getFirstName(), detail.getLastName(), detail.getPhone(), note, type);
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
