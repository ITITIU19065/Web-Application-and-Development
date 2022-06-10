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
import DAO.userDetailDAO;

/**
 * Servlet implementation class UpdateAccountServlet
 */
@WebServlet("/UpdateAccountServlet")
public class UpdateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String userName = (String) session.getAttribute("user");
		String gender = request.getParameter("id_gender");
		String fname = request.getParameter("first-name");
		String lname = request.getParameter("last-name");
		String phone = request.getParameter("phone");
		String age = request.getParameter("age");
		String address= request.getParameter("address");
		String city = request.getParameter("city");
		String checking ="";
	
		if(gender == null || fname == null || lname == null || phone == null || age == null || address == null || city == null) {
			checking  = "empty";
			session.setAttribute("checkingAcc", checking);
			request.getRequestDispatcher("account.jsp").forward(request, response);
		}else {
			
			userDAO dao = new userDAO();
			int userID = dao.getUserIdByName(userName);
			userDetailDAO detail = new userDetailDAO();
			String result = detail.InsertDetailById(userID, fname, lname, phone, age, gender, address, city);
			if("successfully".equals(result)) {
				checking  = "successfully";
				session.setAttribute("checkingAcc", checking);
				request.getRequestDispatcher("account.jsp").forward(request, response);
			}else {
				checking  = "failed";
				session.setAttribute("checkingAcc", checking);
				request.getRequestDispatcher("account.jsp").forward(request, response);
			}
		}
		
	}

}
