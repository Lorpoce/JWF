package fr.esgi.jwf.persistance.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.esgi.jwf.persistance.HibernateUtil;
import fr.esgi.jwf.persistance.dao.AnnonceDao;
import fr.esgi.jwf.persistance.entite.Annonce;

public class DefaultAnnonceDao implements AnnonceDao {

	public DefaultAnnonceDao() {
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Annonce> recupererAnnonces() {

		StringBuilder sb = new StringBuilder();
		sb.append(" select a ");
		sb.append(" from ");
		sb.append(Annonce.class.getCanonicalName());
		sb.append(" a ");
		sb.append(" order by a.id desc ");

		Query query = HibernateUtil.getSessionFactory().openSession()
				.createQuery(sb.toString());

		return query.list();
	}

	@Override
	public void sauvegarder(Annonce annonce) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(annonce);
		transaction.commit();
		session.close();
	}
}
