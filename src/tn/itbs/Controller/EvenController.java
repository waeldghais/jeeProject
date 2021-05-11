package tn.itbs.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.itbs.DAO.AdminDAOImp;
import tn.itbs.DAO.EvenDAOImp;
import tn.itbs.entity.Admin;
import tn.itbs.entity.Evenment;

/**
 * Servlet implementation class EvenController
 */
@WebServlet("/EvenController")
public class EvenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EvenController() {
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
		EvenDAOImp evImp = new EvenDAOImp();
		AdminDAOImp adi= new AdminDAOImp();
		Evenment ev = new Evenment();
		
		if(request.getParameter("action").equals("goToAddEvn")) {
			request.getRequestDispatcher("./addEven.jsp").forward(request, response);
		}
		if(request.getParameter("action").equals("delEven")) {
			String idEvn = request.getParameter("idevn");
			int evid=Integer.parseInt(idEvn); 
			evImp.deleteEven(evid);
			request.getRequestDispatcher("./DashbordAdmin.jsp").forward(request, response);
		}
		if(request.getParameter("action").equals("addEven")) {
			HttpSession session = request.getSession();
			String emAdmin=(String) session.getAttribute("loginAdmin");
			
			
			Date datee;
			try {
				String Ename=request.getParameter("Ename");
				String Edescr=request.getParameter("Edescr");
				String Edate=request.getParameter("Edate");
				String Eimage=request.getParameter("Eimage");
				SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");   
				datee = formatter1.parse(Edate);
				ev.setDateEvn(datee);
				ev.setName(Ename);
				ev.setDescription(Edescr);
				ev.setImgEvn(Eimage);
			
				
				evImp.addEven(ev,emAdmin);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("./DashbordAdmin.jsp").forward(request, response);
		}
	}

}
