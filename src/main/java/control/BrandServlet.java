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
 * Servlet implementation class BrandServlet
 */
@WebServlet("/BrandServlet")
public class BrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String brandID = request.getParameter("brandID");
		String cateChecking = "Brand";
		productDAO dao = new productDAO();
		List<Product> list = dao.getProductByBrandID(brandID);
		request.setAttribute("listC", list);
		request.setAttribute("cateChecking", cateChecking);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
//		session.setAttribute("brandID", brandID);
//		response.sendRedirect("index.jsp");
	}

}
