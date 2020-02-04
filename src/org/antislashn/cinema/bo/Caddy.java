package org.antislashn.cinema.bo;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;

import org.antislashn.cinema.dao.FilmDaoInterceptor;
import org.antislashn.cinema.entities.Film;
@RequestScoped
@Named("caddy") // comme ecrit dans la jsp

public class Caddy implements Serializable{

	private Map<Film, Integer> films = new HashMap<Film, Integer>();
	
	private static final Logger LOG = Logger.getLogger(Caddy.class.getName());
	
	public Caddy () {
		
		LOG.info("===> Contructeur de " + this.getClass().getName());
	}
	
//	@PostConstruct
//	public void init () {
//		LOG.info("===> @PostConstruct de " + this.getClass().getName());
//		
//	}
//	
//	@PreDestroy
//	public void destroy () {
//		LOG.info("===> @PreDestroy de " + this.getClass().getName());
//		
//	}
	
	public void add(Film film) {
		if(films.containsKey(film)) {
			films.replace(film, films.get(film)+1);
		}else {
			films.put(film, 1);
		}
	}
	
	public void remove(Film film) {
		films.remove(film);
	}
	
	public void minus(Film film) {
		if(films.containsKey(film)) {
			int nb = films.get(film)-1;
			if(nb==0)
				films.remove(film);
			else
				films.replace(film, nb);
			
		}
	}
	
	public double getPrixTotalHT() {
		double total = 0;
		for(Entry<Film, Integer> entry : films.entrySet())
			total += entry.getKey().getPrixHT() * entry.getValue();
		return total;
	}
	
	public int getNombreArticles() {
		int total = 0;
		for(int nb : films.values())
			total += nb;
		return total;
	}

	public List<Film> getFilms() {
		return new ArrayList<Film>(films.keySet());
	}
	

	public void remove(long idFilm) {
		for(Entry<Film, Integer> entry : films.entrySet()) {
			if(entry.getKey().getId() == idFilm) {
				int nb = entry.getValue()-1;
				if(nb==0) {
					films.remove(entry.getKey());
				}else {
					films.replace(entry.getKey(), nb);
				}
			}
		}
	}
	
	public int quantity(Film film) {			
		return films.get(film);
	}
	
	public Film getFilmById(String idStr) {
		long id = Long.parseLong(idStr);
		for(Film f : films.keySet()) {
			if(f.getId()==id)
				return f;
		}
		return null;
	}
	
}
