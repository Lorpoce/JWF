package fr.esgi.jwf.persistance.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.esgi.jwf.persistance.HibernateUtil;
import fr.esgi.jwf.persistance.dao.CommentaireDao;
import fr.esgi.jwf.persistance.entite.Commentaire;

public class DefaultCommentaireDao implements CommentaireDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Commentaire> recupererParIdAnnonce(long idAnnonce) {

		StringBuilder sb = new StringBuilder();
		sb.append(" select c ");
		sb.append(" from ");
		sb.append(Commentaire.class.getCanonicalName());
		sb.append(" c ");
		sb.append(" where c.annonce.id = :idAnnonce ");
		sb.append(" order by c.id asc ");

		Query query = HibernateUtil.getSessionFactory().openSession()
				.createQuery(sb.toString());

		query.setParameter("idAnnonce", idAnnonce);

		return query.list();
	}

	@Override
	public void sauvegarder(Commentaire commentaire) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(commentaire);
		transaction.commit();
		session.close();
	}

}
