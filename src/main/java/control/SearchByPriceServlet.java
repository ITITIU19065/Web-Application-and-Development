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
 * Servlet implementation class SearchByPriceServlet
 */
@WebServlet("/SearchByPrice")
public class SearchByPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		out.print("search by price page <br>");
		String action = request.getParameter("action");
		out.print("action: "+action);
		String cateChecking = "Price";
		productDAO dao = new productDAO();
		if("1".equals(action)) {
			List<Product> listPrice = dao.SearchProductByPriceAction1();
			request.setAttribute("listC", listPrice);
			request.setAttribute("cateChecking", cateChecking);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if("2".equals(action)) {
			List<Product> listPrice = dao.SearchProductByPriceAction2();
			request.setAttribute("listC", listPrice);
			request.setAttribute("cateChecking", cateChecking);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if("3".equals(action)) {
			List<Product> listPrice = dao.SearchProductByPriceAction3();
			request.setAttribute("listC", listPrice);
			request.setAttribute("cateChecking", cateChecking);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if("4".equals(action)) {
			List<Product> listPrice = dao.SearchProductByPriceAction4();
			request.setAttribute("listC", listPrice);
			request.setAttribute("cateChecking", cateChecking);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}


}
