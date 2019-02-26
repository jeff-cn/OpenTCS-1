package org.opentcs.guing.Dao;

import javax.persistence.EntityManager;

import org.opentcs.util.persistence.models.Model;

import com.google.inject.Inject;
public class BlockModelDao {

	protected EntityManager entityManager;

	@Inject
	public BlockModelDao(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void saveInNewTransaction(final Model object) {
		entityManager.getTransaction().begin();
		save(object);
		entityManager.getTransaction().commit();
	}

	public void save(final Model object) {
		entityManager.persist(object);
	}

	public Model getObject() {
		return entityManager.createQuery("select e from Model e ", Model.class).getSingleResult();
	}

}
