package tn.itbs.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.itbs.DAO.FeedbackDAOImp;
import tn.itbs.DAO.UserDAOImp;
import tn.itbs.entity.Evenment;
import tn.itbs.entity.Feedback;
import tn.itbs.entity.User;




/**
 * Servlet implementation class CommentaireController
 */
@WebServlet("/CommentaireController")
public class CommentaireController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	Statement st;
	ResultSet rs;
	String idEvn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentaireController() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tpbd","root","0000");
			st = con.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idEvn = request.getParameter("ide");
		request.setAttribute("idev", idEvn);
		request.getRequestDispatcher("./feedback.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emUser=(String) session.getAttribute("login");
		String idev = idEvn;
		int idEvn=Integer.parseInt(idev);  
		String feedback = request.getParameter("Feedback");
		String sqlidAdmin= "SELECT * FROM user where email = '"+emUser+"'";
		try {
			rs = st.executeQuery(sqlidAdmin);
			if(rs.next()) {
				int id_usr  = rs.getInt(1);
				String sql ="insert into feedback (feedback,idevn,iduse) values ('"+feedback+"','"+idEvn+"','"+id_usr+"')";
				 try {
						int rs2=st.executeUpdate(sql);
						if( rs2!=0) {
							request.getRequestDispatcher("./feedback.jsp").forward(request, response);
						}else {
							request.getRequestDispatcher("./feedback.jsp").forward(request, response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
