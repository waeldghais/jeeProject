package tn.itbs.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import tn.itbs.entity.Etudiant;

public class EtudiantDAOImpl implements EtudiantDAO {

	
	
		private Session session;
		public EtudiantDAOImpl() {
		SessionFactory sessionFactory = new Configuration()
	             .configure("/hbernate.cfg.xml")
	             .buildSessionFactory();
	     session = sessionFactory.openSession();
		}
		@Override
		public void ajouter(Etudiant et) {
			session.beginTransaction();
			session.save(et);
			session.getTransaction().commit();	
		}
		@Override
		public void finedAndModyfName(int id, String name) {
			session.beginTransaction();
			Etudiant et =session.get(Etudiant.class, id);
			et.setName("salah");
			session.getTransaction().commit();
			
		}
		@Override
		public void deletByid(int id) {
			Etudiant et =session.get(Etudiant.class, id);
			session.delete(et);
			
		}
		@Override
		public List<Etudiant> findAll() {
			Query q = session.createQuery("from Etudiant");
			List<Etudiant> listEt=q.list();
			return listEt;
		}
		@Override
		public List<Etudiant> findbynote(int note) {
			Query q = session.createQuery("from Etudiant e where e.note >:note");
			q.setParameter("note", note);
			List<Etudiant> listEt=q.list();
			return listEt;
		}
		@Override
		public List<Etudiant> findbyname(String name) {
			Query q = session.createQuery("from Etudiant e where e.name >:name");
			q.setParameter("name", name);
			List<Etudiant> listEt=q.list();
			return listEt;
		}
		
	

}
