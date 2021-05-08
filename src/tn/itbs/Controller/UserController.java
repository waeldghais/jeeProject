package tn.itbs.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.itbs.DAO.UserDAOImp;
import tn.itbs.entity.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDAOImp usimp=new UserDAOImp();
		if(request.getParameter("action").equals("RegisterUser")) {
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			User us =new User();
			
			us.setFname(fname);
			us.setLname(lname);
			us.setEmail(email);
			us.setPasssword(password);
			usimp.registerUser(us);
			session.setAttribute("login", email);
			request.getRequestDispatcher("./home.jsp").forward(request, response);
		}
		if(request.getParameter("action").equals("LoginUser")) {
			String email=request.getParameter("email");
			String passsword=request.getParameter("passsword");
			if (usimp.loginUser(email, passsword)) {
				session.setAttribute("login", email);
				request.getRequestDispatcher("./home.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("./login.jsp").forward(request, response);
			}
		}
		if (request.getParameter("action").equals("LogoutUser")) {
			
			session.removeAttribute("login");
			request.getRequestDispatcher("./home.jsp").forward(request, response);
		}
	}

}
