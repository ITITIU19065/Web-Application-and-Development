package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.userDAO;
import DAO.wishListDAO;

/**
 * Servlet implementation class DeteleWishListServlet
 */
@WebServlet("/DeteleWishList")
public class DeteleWishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.print("delete wish list page<br>");
		
		String pid = request.getParameter("pid");
		out.print("product id:"+pid);
		
		String userName = (String) session.getAttribute("user");
		userDAO dao = new userDAO();
		int userId = dao.getUserIdByName(userName);
		
		
		wishListDAO daoWish = new wishListDAO();
		String result = daoWish.DeleteWishListByProductId(pid, userId);
		response.sendRedirect("index.jsp");
	}



}
