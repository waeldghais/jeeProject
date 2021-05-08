package tn.itbs.DAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import tn.itbs.entity.User;

public class UserDAOImp implements UserDAO{

	private Session session;
	public UserDAOImp() {
	SessionFactory sessionFactory = new Configuration()
             .configure("/hbernate.cfg.xml")
             .buildSessionFactory();
     session = sessionFactory.openSession();
	}
	@Override
	public void registerUser(User us) {
		session.beginTransaction();
		session.save(us);
		session.getTransaction().commit();
	}
	@Override
	public boolean loginUser(String email, String passsword) {
		Query q = session.createQuery("from User u where u.Email>:email and u.passsword>:passsword");
		q.setParameter("email", email);
		q.setParameter("passsword", passsword);
		if(q != null) {
			return true;
		}else {
			return false;
		}
	}

}
