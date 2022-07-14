package com.miguelbarrios.cfbapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.miguelbarrios.cfbapp.entities.Player;
import com.miguelbarrios.cfbapp.entities.Team;
import com.miguelbarrios.cfbapp.services.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost" })
public class TeamController {
	
	@Autowired
	private TeamService teamService;

	@GetMapping("teams")
	public List<Team> getAllPlayers() {
		return teamService.index();
	}
	
	@GetMapping("teams/{teamId}")
	public Team getTeamById(@PathVariable Integer teamId, HttpServletResponse response) {
		Team team = teamService.findTeamById(teamId);
		if(team == null) {
			response.setStatus(404);
		}
		return team;
	}
	
	
	@GetMapping("teams/{teamId}/players")
	public List<Player> getTeamPlayers(@PathVariable Integer teamId){
		return teamService.getTeamRoster(teamId);
	}
	
}
