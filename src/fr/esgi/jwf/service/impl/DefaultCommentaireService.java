package fr.esgi.jwf.service.impl;

import java.util.List;

import fr.esgi.jwf.persistance.dao.AnnonceDao;
import fr.esgi.jwf.persistance.dao.CommentaireDao;
import fr.esgi.jwf.persistance.dao.impl.DefaultAnnonceDao;
import fr.esgi.jwf.persistance.dao.impl.DefaultCommentaireDao;
import fr.esgi.jwf.persistance.entite.Commentaire;
import fr.esgi.jwf.service.CommentaireService;

public class DefaultCommentaireService implements CommentaireService {

	@Override
	public List<Commentaire> recupererParIdAnnonce(long idAnnonce) {
		CommentaireDao dao = new DefaultCommentaireDao();
		return dao.recupererParIdAnnonce(idAnnonce);
	}

	@Override
	public void sauvegarder(long idAnnonce, String pseudo, String commentaire) {
		AnnonceDao annonceDao = new DefaultAnnonceDao();

		Commentaire com = new Commentaire();
		com.setPseudo(pseudo != null ? pseudo : "anon");
		com.setCommentaire(commentaire);
		com.setAnnonce(annonceDao.recupererAnnonce(idAnnonce));

		CommentaireDao dao = new DefaultCommentaireDao();
		dao.sauvegarder(com);
	}

}
