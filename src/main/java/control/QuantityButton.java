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
 * Servlet implementation class QuantityButton
 */
@WebServlet("/QuantityButton")
public class QuantityButton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuantityButton() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");
		String pid = request.getParameter("pid");
		try {
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			int product_id = Integer.parseInt(pid);
			
			productDAO dao = new productDAO();
			int productInStock = dao.getQuantityInStockById(product_id);
			
			if(action != null && product_id >= 1) {
				if(action.equals("ins")) {
					for(Cart c:cart_list) {
						if(c.getProductID() == product_id) {
							if(c.getQuantityOrder() < productInStock) {
								int quantity = c.getQuantityOrder();
								quantity++;
								c.setQuantityOrder(quantity);
								request.getRequestDispatcher("cart.jsp").forward(request, response);
							}else {
								session.setAttribute("message", "over");
								response.sendRedirect("cart.jsp");
							}
						}
					}
				}
				if(action.equals("dec")) {
					for(Cart c:cart_list) {
						if(c.getProductID() == product_id) {
							int quantity = c.getQuantityOrder();
							quantity--;
							if(quantity <= 0) {
								cart_list.remove(cart_list.indexOf(c));
								break;
							}else {
								c.setQuantityOrder(quantity);
								break;
							}
						}
					}
					response.sendRedirect("cart.jsp");
				}
			}else {
				response.sendRedirect("cart.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
