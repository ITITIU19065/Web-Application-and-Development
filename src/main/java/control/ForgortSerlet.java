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

import DAO.forgotDAO;
import entity.User;
import entity.UserDetail;

/**
 * Servlet implementation class ForgortSerlet
 */
@WebServlet("/ForgortSerlet")
public class ForgortSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =UTF-8");
		PrintWriter out = response.getWriter();
		out.print("Forgort Servlet");
		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String newPass = request.getParameter("pass");
		String reNewPass = request.getParameter("rePass");
		String question = request.getParameter("sercurity");
		String answer = request.getParameter("answer");
		String forgotCheck = "";
		if(userName.length() == 0 || newPass.length() == 0 || reNewPass.length() == 0 || answer.length() == 0) {
			forgotCheck ="empty";
			session.setAttribute("forgotCheck", forgotCheck);
			response.sendRedirect("forgot.jsp");
		}else{
			if("admin@admin".equals(userName)) {
				forgotCheck = "invalid";
				session.setAttribute("forgotCheck", forgotCheck);
				response.sendRedirect("forgot.jsp");
			}else {
				if(newPass.equals(reNewPass)) {
					try {
						int question_id = Integer.parseInt(question);
						forgotDAO forgot = new forgotDAO();
						List<User> user = forgot.getInforUser();
						List<UserDetail> userDetail = forgot.getInforUserDetail();
						if(!user.isEmpty()) {
							for(User u:user) {
								if(u.getUserName().equals(userName)) {
									for(UserDetail d:userDetail) {
										if(d.getQuestionID() == question_id && d.getAnswer().equals(answer)) {
											String result = forgot.updatePassword(userName,newPass);
											if("successfully".equals(result)) {
												forgotCheck = "successfully";
												session.setAttribute("forgotCheck", forgotCheck);
												response.sendRedirect("forgot.jsp");
											}else {
												forgotCheck = "failed";
												session.setAttribute("forgotCheck", forgotCheck);
												response.sendRedirect("forgot.jsp");
											}
										}else {
											forgotCheck = "wrong";
											session.setAttribute("forgotCheck", forgotCheck);
											response.sendRedirect("forgot.jsp");
										}
									}
								}else {
									forgotCheck = "notExist";
									session.setAttribute("forgotCheck", forgotCheck);
									response.sendRedirect("forgot.jsp");
								}
							}
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					forgotCheck = "notMatch";
					session.setAttribute("forgotCheck", forgotCheck);
					response.sendRedirect("forgot.jsp");
				}
			}
		}
	}

}
