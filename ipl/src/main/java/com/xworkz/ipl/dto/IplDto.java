package com.xworkz.ipl.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="ipl_table")
public class IplDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="team_name")
	private String name;
	@Column(name="team_captain")
	private String captain;
	@Column(name="no_of_players")
	private int noOfplayers;
	public IplDto(String name, String captain, int noOfplayers) {
		super();
		this.name = name;
		this.captain = captain;
		this.noOfplayers = noOfplayers;
	}
	
	
	
}
