package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.productDAO;
import entity.Cart;

/**
 * Servlet implementation class AddCartDetail
 */
@WebServlet("/AddCartDetail")
public class AddCartDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String pid = request.getParameter("product_id");
		String amount = request.getParameter("quantity");  
		out.print("add to cart detail <br>");
		out.print("product id : "+ pid+"<br>");
		out.print("quantity : "+ amount+"<br>");
		
		try{
			ArrayList<Cart> cartList = new ArrayList<>();
			int id = Integer.parseInt(pid);
			int NewQuantity = Integer.parseInt(amount);
			Cart cm = new Cart();
			cm.setProductID(id);
			cm.setSize("X");
			cm.setQuantityOrder(NewQuantity);
			
			productDAO dao = new productDAO();
			int productInStock = dao.getQuantityInStockById(id);
			
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		
			if(NewQuantity<=productInStock) {
				if(cart_list == null) {
					cartList.add(cm);
					session.setAttribute("cart-list", cartList);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else {
					cartList = cart_list;
					boolean exist = false;
					for(Cart c:cart_list) {
						if(c.getProductID() == id) {
							exist =true;
							if(c.getQuantityOrder() < productInStock) {
								int quantity = c.getQuantityOrder();
								quantity = quantity + NewQuantity;
								c.setQuantityOrder(quantity);
								request.getRequestDispatcher("cart.jsp").forward(request, response);
							}else {
								session.setAttribute("message", "over");
								response.sendRedirect("cart.jsp");
							}
						}
					}
					if(!exist) {
						cartList.add(cm);
//						response.sendRedirect("index.jsp");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				}
			}else {
				String result = "over";
				session.setAttribute("message",result );
				response.sendRedirect("cart.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
