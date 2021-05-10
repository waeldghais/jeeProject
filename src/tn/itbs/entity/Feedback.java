package tn.itbs.entity;

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
public class Feedback {
	
	private int idCom;
	private User user;
	private Evenment even;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idevn")
	public Evenment getEven() {
		return even;
	}
	public void setEven(Evenment even) {
		this.even = even;
	}
	@Column(name = "feedback")
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	
	

	
	
	
	
}
