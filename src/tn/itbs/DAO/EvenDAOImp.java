package tn.itbs.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import tn.itbs.entity.Admin;
import tn.itbs.entity.Evenment;

public class EvenDAOImp implements EvenDAO {
	
	private Session session;
	public EvenDAOImp() {
	SessionFactory sessionFactory = new Configuration()
             .configure("/hbernate.cfg.xml")
             .buildSessionFactory();
     session = sessionFactory.openSession();
	}
	
	@Override
	public void addEven(Evenment ev,String ad) {
		session.beginTransaction();
		Query query = session.createQuery("from Admin a where a.Email=:email");
	     query.setParameter("email", ad);
	     
	     Admin adm=(Admin) query.list().get(0);
	     
		ev.setIdAdm(adm);
		session.save(ev);
		session.getTransaction().commit();
		
	}

	@Override
	public void deleteEven(int id) {
			session.beginTransaction();
			Evenment et = session.get(Evenment.class, id); // et est persistant
			session.delete(et);  //et est non persistant
			session.getTransaction().commit();
		
	}

}
