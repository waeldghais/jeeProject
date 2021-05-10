package tn.itbs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;
	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	@Column(name="fname")
	private String fname;
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	@Column(name="lname")
	private String lname;
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Column(name="Email")
	private String Email;
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	@Column(name="passsword")
	private String passsword;
	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
	@OneToMany(mappedBy = "user")
	List<Feedback> ListU = new ArrayList<Feedback>();

	public List<Feedback> getListU() {
		return ListU;
	}

	public void setListU(List<Feedback> listU) {
		ListU = listU;
	}

	
	
	 
	
	

	

}
