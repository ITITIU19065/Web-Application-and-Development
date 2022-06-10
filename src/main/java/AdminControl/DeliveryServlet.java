package AdminControl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.orderDAO;

/**
 * Servlet implementation class DeliveryServlet
 */
@WebServlet("/DeliveryServlet")
public class DeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		out.print("delivery page for admin");
		
		String oid = request.getParameter("oid");
		out.print("oid: "+oid);
		
		orderDAO dao = new orderDAO();
		String result =  dao.setShippedStatusForAdmin(oid);
		String result2 = dao.setShippedStatusDetailForAdmin(oid);
		response.sendRedirect("AdminOrder.jsp");
	}


}
