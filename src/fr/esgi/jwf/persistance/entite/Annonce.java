package fr.esgi.jwf.persistance.entite;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Annonce {

	@Id
	@GeneratedValue
	private long id;

	private String titre;

	private String pseudo;

	@Column(length = 10000)
	private String annonce;

	@OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL)
	private List<Commentaire> commentaire;

	public Annonce() {

	}
}
