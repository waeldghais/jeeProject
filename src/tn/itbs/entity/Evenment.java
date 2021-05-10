package tn.itbs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="evenment")
public class Evenment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEvn;
	public int getIdEvn() {
		return idEvn;
	}

	public void setIdEvn(int idEvn) {
		this.idEvn = idEvn;
	}
	@Column(name="name")
	private String name ;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="description")
	private String description;	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="imgEvn")
	private String imgEvn;
	public String getImgEvn() {
		return imgEvn;
	}

	public void setImgEvn(String imgEvn) {
		this.imgEvn = imgEvn;
	}
	
	@Column(name="dateEvn")
	private Date dateEvn ;
	public Date getDateEvn() {
		return dateEvn;
	}

	public void setDateEvn(Date dateEvn) {
		this.dateEvn = dateEvn;
	}
	
	@ManyToOne
	@JoinColumn(name="idAdm")
	private Admin idAdm;


	
	public Admin getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(Admin idAdm) {
		this.idAdm = idAdm;
	}

	@OneToMany(mappedBy = "even")
	List<Feedback> ListE = new ArrayList<Feedback>();
	public List<Feedback> getListE() {
		return ListE;
	}

	public void setListE(List<Feedback> listE) {
		ListE = listE;
	}
	
	
    
	
	
}
