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

import entity.Cart;

/**
 * Servlet implementation class SizeServlet
 */
@WebServlet("/SizeServlet")
public class SizeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");
		String size = request.getParameter("size");
		int pid = Integer.parseInt(request.getParameter("pid"));
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		
		
		if("ins".equals(action)) {
			for(Cart c:cart_list) {
				if(c.getProductID() == pid) {
					String CurrentSize  = c.getSize(); 
					if("X".equals(CurrentSize)) {
						c.setSize("XL");
					}
					if("XL".equals(CurrentSize)) {
						c.setSize("XXL");
					}
					request.getRequestDispatcher("cart.jsp").forward(request, response);
				}
			}
		}
		if("des".equals(action)) {
			for(Cart c:cart_list) {
				if(c.getProductID() == pid) {
					String CurrentSize  = c.getSize(); 
					if("XXL".equals(CurrentSize)) {
						c.setSize("XL");
					}
					if("XL".equals(CurrentSize)) {
						c.setSize("X");
					}
					request.getRequestDispatcher("cart.jsp").forward(request, response);
				}
			}
		}
	}

	

}
