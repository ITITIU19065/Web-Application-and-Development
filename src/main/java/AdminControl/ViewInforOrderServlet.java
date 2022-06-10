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

import DAO.orderDAO;
import entity.OrderDetail;

/**
 * Servlet implementation class ViewInforOrderServlet
 */
@WebServlet("/ViewInforOrder")
public class ViewInforOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		
		String oid = request.getParameter("oid");
		
		orderDAO dao = new orderDAO();
		List<OrderDetail> order =  dao.getProductByOrderID(oid);
		if(!order.isEmpty()) {
			request.setAttribute("list", order);
			request.getRequestDispatcher("AdminOrderDetail.jsp").forward(request, response);
		}
	}



}
