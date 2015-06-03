package fr.esgi.jwf.persistance.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Commentaire {

	@Id
	@GeneratedValue
	private long id;

	private String pseudo;

	@Column(length = 10000)
	private String commentaire;

	@ManyToOne
	private Annonce annonce;

	public Commentaire() {

	}

}
