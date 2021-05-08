package tn.itbs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="commentaire")
public class Commentaire implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCom;

	public int getIdCom() {
		return idCom;
	}

	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}
	
	@Column(name="commentaire")
	private String commentaire;

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	@ManyToOne
	@JoinColumn(name="iduser")
	private User iduser;

	public User getIduser() {
		return iduser;
	}

	public void setIduser(User iduser) {
		this.iduser = iduser;
	}
	@ManyToOne
	@JoinColumn(name="idevn")
	private Evenment idevn;

	public Evenment getIdevn() {
		return idevn;
	}

	public void setIdevn(Evenment idevn) {
		this.idevn = idevn;
	}
	

	
	
	
	
}
