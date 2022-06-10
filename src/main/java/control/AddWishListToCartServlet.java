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
 * Servlet implementation class AddWishListToCartServlet
 */
@WebServlet("/AddWishListToCart")
public class AddWishListToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		try{
			ArrayList<Cart> cartList = new ArrayList<>();
			int id = Integer.parseInt(request.getParameter("pid"));
			Cart cm = new Cart();
			cm.setProductID(id);
			cm.setSize("X");
			cm.setQuantityOrder(1);
			
			productDAO dao = new productDAO();
			int productInStock = dao.getQuantityInStockById(id);

			
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		
			if(cart_list == null) {
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);
				request.getRequestDispatcher("cart.jsp").forward(request, response);
			}else {
				cartList = cart_list;
				boolean exist = false;
				for(Cart c:cart_list) {
					if(c.getProductID() == id) {
						exist =true;
							session.setAttribute("message", "exist");
							response.sendRedirect("cart.jsp");
					}
				}
				if(!exist) {
					cartList.add(cm);
//					response.sendRedirect("index.jsp");
					request.getRequestDispatcher("cart.jsp").forward(request, response);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
