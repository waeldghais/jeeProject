package tn.itbs.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback implements Serializable{

	private int idCom;
	private User iduse;
	private Evenment idevn;
	private String feedback;
	
	@Id
    @GeneratedValue
    @Column(name = "idCom") 
	public int getIdCom() {
		return idCom;
	}
	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iduse") 
	public User getIduse() {
		return iduse;
	}
	public void setIduse(User iduse) {
		this.iduse = iduse;
	}
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idevn")
	public Evenment getIdevn() {
		return idevn;
	}
	public void setIdevn(Evenment idevn) {
		this.idevn = idevn;
	}
	
	@Column(name = "feedback")
	public String getFeedback() {
		return feedback;
	}
	
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
