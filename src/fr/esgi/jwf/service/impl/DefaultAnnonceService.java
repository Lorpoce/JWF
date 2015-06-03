package fr.esgi.jwf.service.impl;

import java.util.List;

import fr.esgi.jwf.persistance.dao.AnnonceDao;
import fr.esgi.jwf.persistance.dao.impl.DefaultAnnonceDao;
import fr.esgi.jwf.persistance.entite.Annonce;
import fr.esgi.jwf.service.AnnonceService;
import fr.esgi.jwf.utils.StringUtils;

public class DefaultAnnonceService implements AnnonceService {

	@Override
	public List<Annonce> recupererAnnonces() {
		AnnonceDao annonceDao = new DefaultAnnonceDao();
		return annonceDao.recupererAnnonces();
	}

	@Override
	public void sauvegarder(String titre, String pseudo, String annonce) {
		Annonce a = new Annonce();
		a.setTitre(!StringUtils.isNullOrEmpty(titre) ? titre
				: "Annonce sans titre");
		a.setPseudo(!StringUtils.isNullOrEmpty(pseudo) ? pseudo : "anon");
		a.setAnnonce(annonce);

		AnnonceDao annonceDao = new DefaultAnnonceDao();
		annonceDao.sauvegarder(a);
	}

}
