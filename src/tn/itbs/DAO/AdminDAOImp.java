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
	public boolean loginAdmin(String email, String password) {
		Query q = session.createQuery("from Admin u where u.Email>:email and u.passsword>:passsword");
		q.setParameter("email", email);
		q.setParameter("passsword", password);
		if(q != null) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Admin findAdbyEmail(String ad) {
		Query query = session.createQuery("from Admin a where a.Email=:email");
	     query.setParameter("email", ad);
	     Admin adm=(Admin) query.list().get(0);
		return adm;
	}

}
