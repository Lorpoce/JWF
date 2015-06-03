package fr.esgi.jwf.persistance.dao;

import java.util.List;

import fr.esgi.jwf.persistance.entite.Annonce;

public interface AnnonceDao {

	List<Annonce> recupererAnnonces();

	void sauvegarder(Annonce annonce);

	Annonce recupererAnnonce(long id);

}
