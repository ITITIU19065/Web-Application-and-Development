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

import DAO.searchDAO;
import entity.Product;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String searchKey = request.getParameter("search");
		String cateChecking = searchKey;
		searchDAO dao = new searchDAO();
		List<Product> list = dao.searchProductByName(searchKey);
		request.setAttribute("listC", list);
		request.setAttribute("cateChecking", cateChecking);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
