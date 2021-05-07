package tn.itbs.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="etudiant")
public class Etudiant implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
	@Column(name="studentname")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="studentnickname")
	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Column(name="note")
	private int note;

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
	
	@ManyToOne
	@JoinColumn(name="idgroup")
	private Group fil;

	public Group getFil() {
		return fil;
	}

	public void setFil(Group fil) {
		this.fil = fil;
	}
	

}
