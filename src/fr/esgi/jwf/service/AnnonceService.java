package fr.esgi.jwf.service;

import java.util.List;

import fr.esgi.jwf.persistance.entite.Annonce;

public interface AnnonceService {

	List<Annonce> recupererAnnonces();

	void sauvegarder(String titre, String annonce);

}
