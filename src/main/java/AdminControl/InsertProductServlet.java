package AdminControl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.productDAO;

/**
 * Servlet implementation class InsertProduct
 */
@WebServlet("/InsertProduct")
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		
		String cate = request.getParameter("cate");
		String brand = request.getParameter("brand");
		String status = request.getParameter("status");
		String name = request.getParameter("name");
		String img = request.getParameter("img");
		String price = request.getParameter("price");
		String discount = request.getParameter("discount");
		String description = request.getParameter("description");
		String quantity = request.getParameter("quantity");
		String message = "";
	
		
		if(name.length() == 0 || img.length() == 0 || price.length() == 0 || discount.length() == 0 || description.length() == 0 || quantity.length() == 0) {
			message = "empty";
			session.setAttribute("message", message);
			response.sendRedirect("AdminIndex.jsp");
		}else {
			productDAO dao = new productDAO();
			String result = dao.InsertNewProduct(cate, brand, name, status, img, price, discount, description, quantity);
			if("successfully".equals(result)) {
				message = "successfully";
				session.setAttribute("message", message);
				response.sendRedirect("AdminIndex.jsp");
			}else {
				message = "failed";
				session.setAttribute("message", message);
				response.sendRedirect("AdminIndex.jsp");
			}
		}
	}

}
