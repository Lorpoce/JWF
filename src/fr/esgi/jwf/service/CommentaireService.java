package fr.esgi.jwf.service;

import java.util.List;

import fr.esgi.jwf.persistance.entite.Commentaire;

public interface CommentaireService {

	List<Commentaire> recupererParIdAnnonce(long idAnnonce);

	void sauvegarder(long idAnnonce, String pseudo, String commentaire);

}
