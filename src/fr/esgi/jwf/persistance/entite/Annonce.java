package fr.esgi.jwf.persistance.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Annonce {

	@Id
	@GeneratedValue
	private long id;

	private String titre;

	private String annonce;

	public Annonce() {

	}
}
