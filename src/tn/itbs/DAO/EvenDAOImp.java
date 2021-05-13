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
	public void addEven(Evenment ev) {
		session.beginTransaction();
		
	     
		
		session.save(ev);
		session.getTransaction().commit();
		
	}

	@Override
	public void deleteEven(int id) {
			session.beginTransaction();
			Evenment ev = session.get(Evenment.class, id); // et est persistant
			session.delete(ev);  //et est non persistant
			session.getTransaction().commit();
		
	}

	@Override
	public void UpdateEven(String idS,String Ename,String Edescr,String Edate) {
		session.beginTransaction();
	    int id=Integer.parseInt(idS);  
		Evenment ev = session.get(Evenment.class, id); // et est persistant
		ev.setName(Ename);
		ev.setDescription(Edescr);
		ev.setDateEvn(Edate);
		session.getTransaction().commit();
	}

}
