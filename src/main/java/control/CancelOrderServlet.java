package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.orderDAO;
import DAO.orderDetailDAO;

/**
 * Servlet implementation class CancelOrderServlet
 */
@WebServlet("/CancelOrder")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String oid = request.getParameter("oid");
		orderDAO daoOrder = new orderDAO();
		orderDetailDAO daoDetail = new orderDetailDAO();
		
		String resultDetail = daoDetail.DeleteOrderDetailByID(oid);
		String getResult = daoOrder.DeleteOrderByID(oid);
		response.sendRedirect("account.jsp");
}

	

}
