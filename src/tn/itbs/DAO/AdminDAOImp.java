package tn.itbs.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import tn.itbs.entity.Admin;

public class AdminDAOImp implements AdminDAO {
	private Session session;
	public AdminDAOImp() {
	SessionFactory sessionFactory = new Configuration()
             .configure("/hbernate.cfg.xml")
             .buildSessionFactory();
     session = sessionFactory.openSession();
	}
	
	@Override
	public Admin findAdbyEmail(String ad) {
		Query<Admin> query = session.createQuery("from Admin a where a.Email=:email");
	     query.setParameter("email", ad);
	     Admin adm=query.list().get(0);
		return adm;
	}
	@Override
	public boolean loginAdmin(String email, String password) {
		boolean stat=false;
		Query q = session.createQuery("from Admin u where u.Email=:email and u.password=:password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		if(q.getFirstResult()!=0) {
			stat=true;
		}
		return true;
	}
	/*@Override
	public long loginAdmin(String email, String password) {
		long status_id = -1;
		Query q = session.createQuery("from  Admin a where a.Email=:email and a.password=:password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		if(q.getFirstResult()!=0) {
			Admin ad = (Admin) q.list().get(0);
			status_id = ad.getIdAdm();
		}
		System.out.println(status_id);
		
		return status_id;
	}*/
	
	

}
