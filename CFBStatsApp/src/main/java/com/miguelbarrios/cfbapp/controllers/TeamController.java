package com.miguelbarrios.cfbapp.controllers;

import java.util.List;
import java.util.Map;

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
	
	@GetMapping("teams/{teamName}")
	public Team getTeamById(@PathVariable String teamName, HttpServletResponse response) {
		teamName = teamName.replace('-', ' ');
		Team team = teamService.findTeamByName(teamName);
		if(team == null)
			response.setStatus(404);
		return team;
	}
	
	
	@GetMapping("teams/{teamName}/players")
	public List<Player> getTeamRoster(@PathVariable String teamName, HttpServletResponse response){
		teamName = teamName.replace('-', ' ');
		List<Player> roster = teamService.getTeamRoster(teamName);
		
		if(roster == null) {
			response.setStatus(404);
		}
		
		return roster;
	}
	
	@GetMapping("teams/{teamName}/players/{position}")
	public List<Player> getTeamPlaersByPositionGroup(@PathVariable String teamName, @PathVariable String position){
		teamName = teamName.replace('-', ' ');
		return teamService.getTeamPlayersByPositionGroup(teamName, position);
	}
	
	@GetMapping("teams/compare/{team1}/{team2}")
	public Map<String, List<Player>> compareTeams(@PathVariable String team1, @PathVariable String team2, HttpServletResponse response){
		team1 = team1.replace('-', ' ');
		team2 = team2.replace('-', ' ');		
		Map<String, List<Player>> map = teamService.compareTeams(team1, team2);
		if(map == null) {
			response.setStatus(404);
		}
		return map;
	}
	
	
	@GetMapping("teams/compare/{team1}/{team2}/{position}")
	public Map<String, List<Player>> compareTeamsByPosition(@PathVariable String team1, @PathVariable String team2, @PathVariable String position, HttpServletResponse response){
		team1 = team1.replace('-', ' ');
		team2 = team2.replace('-',' ');
		Map<String, List<Player>> map = teamService.compareTeamsByPosition(team1, team2, position);
		if(map == null) {
			response.setStatus(404);
		}
		return map;
	}
	
	
}
