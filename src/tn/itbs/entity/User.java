package tn.itbs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;
	public int getIdAdm() {
		return idUser;
	}

	public void setIdAdm(int idAdm) {
		this.idUser = idAdm;
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
	

}
