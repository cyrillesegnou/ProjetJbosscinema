package org.antislashn.cinema.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.antislashn.cinema.entities.Film;

@Singleton
@Interceptors({FilmDaoInterceptor.class})
public class FilmDao extends AbstractDao<Film, Long>{
	@PersistenceContext(name="cinema") private EntityManager em;
	
	public FilmDao() {
		super(Film.class);
	}
	
	public List<Film> findAll(){
		return em.createNamedQuery("Film.findAll", Film.class)
									.getResultList();
	}
	
	public List<Film> findByYear(int year){
		return em.createNamedQuery("Film.findByYear", Film.class)
									.setParameter("year", year)
									.getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}


}
