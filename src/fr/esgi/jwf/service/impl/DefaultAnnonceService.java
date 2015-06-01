package fr.esgi.jwf.service.impl;

import java.util.List;

import fr.esgi.jwf.persistance.dao.AnnonceDao;
import fr.esgi.jwf.persistance.dao.impl.DefaultAnnonceDao;
import fr.esgi.jwf.persistance.entite.Annonce;
import fr.esgi.jwf.service.AnnonceService;

public class DefaultAnnonceService implements AnnonceService {

	@Override
	public List<Annonce> recupererAnnonces() {
		AnnonceDao annonceDao = new DefaultAnnonceDao();
		return annonceDao.recupererAnnonces();
	}

	@Override
	public void sauvegarder(String titre, String annonce) {
		Annonce a = new Annonce();
		a.setTitre(titre);
		a.setAnnonce(annonce);

		AnnonceDao annonceDao = new DefaultAnnonceDao();
		annonceDao.sauvegarder(a);
	}

}
