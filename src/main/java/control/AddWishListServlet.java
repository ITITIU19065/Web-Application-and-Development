package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.userDAO;
import DAO.wishListDAO;
import entity.Cart;
import entity.Product;

/**
 * Servlet implementation class AddWishListServlet
 */
@WebServlet("/AddWishList")
public class AddWishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String pid = request.getParameter("pid");
		
		String userName = (String) session.getAttribute("user");
		
		userDAO dao = new userDAO();
		int userId = dao.getUserIdByName(userName);
		
		
		wishListDAO daoWish = new wishListDAO();
		String checking = daoWish.CheckingExistProduct(pid, userId);
		if("empty".equals(checking)) {
			String result = daoWish.insertWishList(pid, userId);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			session.setAttribute("message", "exist");
			response.sendRedirect("wishList.jsp");
		}
	}

}
