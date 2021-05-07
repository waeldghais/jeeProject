package tn.itbs.DAO;

import java.util.List;

import tn.itbs.entity.Etudiant;

public interface EtudiantDAO {
	void ajouter(Etudiant et);
	void finedAndModyfName(int id,String name);
	void deletByid(int id);
	List<Etudiant> findAll();
	List<Etudiant> findbynote(int note);
	List<Etudiant> findbyname(String name);
}
