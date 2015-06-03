package fr.esgi.jwf.persistance.dao;

import java.util.List;

import fr.esgi.jwf.persistance.entite.Commentaire;

public interface CommentaireDao {

	List<Commentaire> recupererParIdAnnonce(long idAnnonce);

	void sauvegarder(Commentaire commentaire);

}
