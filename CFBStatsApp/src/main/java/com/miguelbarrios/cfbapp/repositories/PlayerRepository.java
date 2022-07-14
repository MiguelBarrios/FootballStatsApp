package com.miguelbarrios.cfbapp.repositories;

import java.util.List;

import com.miguelbarrios.cfbapp.entities.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
	
	@Query("SELECT p FROM Player p  WHERE p.team.id = :teamId")
	List<Player> getPlayerByTeam(@Param("teamId") Integer teamId);
}
