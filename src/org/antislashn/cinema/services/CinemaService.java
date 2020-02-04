package org.antislashn.cinema.services;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import org.antislashn.cinema.dao.FilmDao;
import org.antislashn.cinema.entities.Film;

@Singleton
public class CinemaService {
	@EJB private FilmDao dao;
	
	public List<Film> findAllFilms(){
		return dao.findAll();
	}
	
	public Optional<Film> findFilmById(long id) {
		return Optional.ofNullable(dao.findById(id));
	}
}
