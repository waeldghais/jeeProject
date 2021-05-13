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
	String idev;
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
		
		Evenment ev = new Evenment();
		HttpSession session = request.getSession();
		if(request.getParameter("action").equals("goToAddEvn")) {
			
			request.getRequestDispatcher("./addEven.jsp").forward(request, response);
		}
		if(request.getParameter("action").equals("goToUpEvn")) {
			idev=request.getParameter("idev");
			session.setAttribute("Sidevn", idev);
			System.out.println(idev);
			request.getRequestDispatcher("./UpdEven.jsp").forward(request, response);
		}
		if(request.getParameter("action").equals("UpdateEv")) {
			     
				String Ename=request.getParameter("Ename");
				String Edescr=request.getParameter("Edescr");
				String Edate=request.getParameter("Edate");
				
			
				System.out.println(idev);
				evImp.UpdateEven(idev,Ename,Edescr,Edate);
			
			request.getRequestDispatcher("./DashbordAdmin.jsp").forward(request, response);
		}
		if(request.getParameter("action").equals("delEven")) {
			String idEvn = request.getParameter("idevn");
			int evid=Integer.parseInt(idEvn); 
			evImp.deleteEven(evid);
			request.getRequestDispatcher("./DashbordAdmin.jsp").forward(request, response);
		}
		if(request.getParameter("action").equals("addEven")) {
			

		
				String Ename=request.getParameter("Ename");
				String Edescr=request.getParameter("Edescr");
				String Edate=request.getParameter("Edate");
				String Eimage=request.getParameter("Eimage");
				ev.setDateEvn(Edate);
				ev.setName(Ename);
				ev.setDescription(Edescr);
				ev.setImgEvn(Eimage);
			
				
				evImp.addEven(ev);
			
			
			request.getRequestDispatcher("./DashbordAdmin.jsp").forward(request, response);
		}
	}

}
