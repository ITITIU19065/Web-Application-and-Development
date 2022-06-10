package AdminControl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.productDAO;
import entity.Product;

/**
 * Servlet implementation class SelectBrandServlet
 */
@WebServlet("/SelectBrand")
public class SelectBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String brandID = request.getParameter("selectBrand");
		out.print(brandID);
		productDAO dao = new productDAO();
		List<Product> product = dao.getProductByBrandIDAdmin(brandID);
		request.setAttribute("listC", product);
		request.getRequestDispatcher("AdminEdit.jsp").forward(request, response);
	}

}
