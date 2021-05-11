package tn.itbs.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.itbs.DAO.AdminDAOImp;
import tn.itbs.DAO.UserDAOImp;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session.removeAttribute("loginAdmin");
		request.getRequestDispatcher("./home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 session = request.getSession();
		AdminDAOImp adimp=new AdminDAOImp();
		if(request.getParameter("action").equals("LoginAdmin")) {
			String email=request.getParameter("email");
			String passsword=request.getParameter("password");
			if (adimp.loginAdmin(email, passsword)) {
				session.setAttribute("loginAdmin", email);
				request.getRequestDispatcher("./DashbordAdmin.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("./loginAdmin.jsp").forward(request, response);
			}
		}
		
	}

}
