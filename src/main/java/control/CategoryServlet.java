package control;

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
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String cateID = request.getParameter("cateID");
		String cateChecking =  "Category";
		productDAO dao = new productDAO();
		List<Product> list = dao.getProductByCateID(cateID);
		request.setAttribute("listC", list);
		request.setAttribute("cateChecking", cateChecking);
		request.getRequestDispatcher("index.jsp").forward(request, response);
//		out.print(cateID);
//		session.setAttribute("cateID", cateID);
//		response.sendRedirect("index.jsp");
	}

	

}
