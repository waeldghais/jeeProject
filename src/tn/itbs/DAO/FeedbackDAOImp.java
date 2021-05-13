package tn.itbs.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
	public void AddComm(Feedback fe, String idEvn,String EmailUser) {
		session.beginTransaction();
		//get User
		Query query = session.createQuery("from User a where a.Email=:EmailUser");
	     query.setParameter("EmailUser", EmailUser);
	     User user= (User)  query.list().get(0);
	     
	     //get Evem
	     int id=Integer.parseInt(idEvn);  
	     Query query2 = session.createQuery("from Evenment a where a.idEvn=:id");
	     query2.setParameter("id", id);
	     Evenment evenment= (Evenment)  query.list().get(0);
	     fe.setIduse(user);
	     fe.setIdevn(evenment);
		session.save(fe);
		session.getTransaction().commit();
		
	}

}
