package org.antislashn.cinema.dao;

import javax.persistence.EntityManager;

/**
 * 
 * DAO abstrait
 * 	implémentaion d'un CRUD de base
 * 	E  : type de l'entité
 *  ID : type de l'identifiant de l'entité
 */
public abstract class AbstractDao<E,ID> {
	private Class<E> entityClass;

	public AbstractDao(Class<E> entityClass) {
		this.entityClass = entityClass;
	}
	
	protected abstract EntityManager getEntityManager();
	
	public void create(E entity) {
		getEntityManager().persist(entity);
	}
	
	public E findById(ID id) {
		return getEntityManager().find(entityClass, id);
	}
	
	public E delete(ID id) {
		EntityManager em = getEntityManager();
		E entity = em.find(entityClass, id);
		em.remove(entity);	
		return entity;
	}
	
	public void update(E entity) {
		getEntityManager().merge(entity);	
	}

}
