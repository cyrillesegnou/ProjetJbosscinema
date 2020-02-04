package org.antislashn.cinema.dto;

import java.time.LocalDate;

import org.antislashn.cinema.entities.Film;

import lombok.Getter;

@Getter
public class FilmDto {
	private long id;
	private String titre;
	private double prixHT;
	private int duree;
	private LocalDate dateSortie;
	private String resume;
	
	public FilmDto(Film film) {
		id = film.getId();
		titre = film.getTitre();
		prixHT = film.getPrixHT();
		duree = film.getDuree();
		dateSortie = film.getDateSortie();
		resume = film.getResume();
	}
}
