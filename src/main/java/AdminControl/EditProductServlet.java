package AdminControl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.productDAO;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/EditProduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		

		String pid = request.getParameter("pid");
		String brand_id = request.getParameter("EditBrand");
		String cate_id = request.getParameter("EditCate");
		String status = request.getParameter("EditActive");
		String name = request.getParameter("EName");
		String price = request.getParameter("EPrice");
		String discount= request.getParameter("EDis");
		String quantity = request.getParameter("EQuan");
		String address = request.getParameter("EImg");
		String des = request.getParameter("EDes");
		
		String img = "./assets/img/product/"+address;
		String checking ="";
		
		
		productDAO dao = new productDAO();
		String result = dao.UpdateDetailProductlById(pid, cate_id, brand_id, name, status, img, price, discount, des, quantity);
		if("successfully".equals(result)) {
			checking  = "successfully";
			session.setAttribute("Update", checking);
			request.getRequestDispatcher("AdminEdit.jsp").forward(request, response);
		}else {
			checking  = "failed";
			session.setAttribute("Update", checking);
			request.getRequestDispatcher("AdminEdit.jsp").forward(request, response);
		}
	}

}
