package com.miguelbarrios.cfbapp.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Team
 *
 */
@Entity

public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String team_url;
	
	private String logo_url;
	
	
	public Team() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam_url() {
		return team_url;
	}

	public void setTeam_url(String team_url) {
		this.team_url = team_url;
	}

	public String getLogo_url() {
		return logo_url;
	}

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}


	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", team_url=" + team_url + ", logo_url=" + logo_url
				+ "]";
	}
   
}
