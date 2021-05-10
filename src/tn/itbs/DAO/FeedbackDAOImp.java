package tn.itbs.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tn.itbs.entity.Evenment;
import tn.itbs.entity.Feedback;
import tn.itbs.entity.User;

public class FeedbackDAOImp  implements FeedbackDAO{
	
	private Session session;
	public FeedbackDAOImp() {
	SessionFactory sessionFactory = new Configuration()
             .configure("/hbernate.cfg.xml")
             .buildSessionFactory();
     session = sessionFactory.openSession();
	}
	@Override
	public void AddComm(Feedback fe, User us, Evenment ev) {
		session.beginTransaction();
		fe.setUser(us);
		fe.setEven(ev);
		session.save(fe);
		session.getTransaction().commit();
		
	}

}
