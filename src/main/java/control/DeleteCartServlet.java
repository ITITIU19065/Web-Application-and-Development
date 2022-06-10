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
 * Servlet implementation class DeleteCartServlet
 */
@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String pid = request.getParameter("pid");
		
		out.print("product_id"+pid+"<br>");
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		if(cart_list != null) {
			int product_id = Integer.parseInt(pid);
			for(Cart items:cart_list) {
				if(items.getProductID() == product_id ) {
					cart_list.remove(cart_list.indexOf(items));
					break;
				}
			}
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}else {
			response.sendRedirect("cart.jsp");
		}
	}



}
