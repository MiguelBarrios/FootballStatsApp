package com.miguelbarrios.cfbapp.repositories;

import com.miguelbarrios.cfbapp.entities.Team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer > {
	
	Team findByName(String name);

	
}
