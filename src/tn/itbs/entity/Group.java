package tn.itbs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="groupe")
public class Group implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@OneToMany
	@JoinColumn(name="fil")
	private List<Etudiant> listeE= new ArrayList<Etudiant>();

	public List<Etudiant> getListeE() {
		return listeE;
	}

	public void setListeE(List<Etudiant> listeE) {
		this.listeE = listeE;
	}
	
	
}
