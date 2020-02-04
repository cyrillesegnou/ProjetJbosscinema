package org.antislashn.cinema.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"resume"},includeFieldNames = false)

@Entity @Table(name="films")
@SecondaryTable(name = "resumes",pkJoinColumns = @PrimaryKeyJoinColumn(name="fk_film"))
@NamedQuery(name="Film.findAll",
			query = "SELECT f FROM Film f")
@NamedQuery(name="Film.findByYear",
			query = "SELECT f FROM Film f WHERE YEAR(f.dateSortie) = :year")
public class Film implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_film")
	private long id;
	private String titre;
	private double prixHT;
	private int duree;
	@Column(name = "date_sortie")
	private LocalDate dateSortie;
	@Column(table = "resumes",name = "resume")
	private String resume;

	
	public Film() {}
	
	public Film(String titre, int duree) {
		this.titre = titre;
		this.duree = duree;
	}
	
}
