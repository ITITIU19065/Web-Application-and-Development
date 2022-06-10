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
 * Servlet implementation class SelectCategoryServlet
 */
@WebServlet("/SelectCategory")
public class SelectCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String cateID = request.getParameter("selectCate");
		productDAO dao = new productDAO();
		List<Product> product = dao.getProductByCateIDAdmin(cateID);
		request.setAttribute("listC", product);
		request.getRequestDispatcher("AdminEdit.jsp").forward(request, response);
	}

}
