package tn.itbs.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

}
