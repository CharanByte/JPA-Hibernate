package com.xworkz.movie.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name="movie_table")
public class MovieDto {
	@Id
	private int id;
	private String heroName;
	private double budget;

}
