package com.miguelbarrios.cfbapp.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.miguelbarrios.cfbapp.entities.Player;
import com.miguelbarrios.cfbapp.entities.Team;
import com.miguelbarrios.cfbapp.repositories.PlayerRepository;
import com.miguelbarrios.cfbapp.repositories.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService{

	@Autowired
	private TeamRepository teamRepo;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Override
	public List<Team> index(){
		return teamRepo.findAll();
	}
	
	@Override 
	public Team findTeamByName(String teamName) {
		Team team = teamRepo.findByName(teamName);
		return team;
	}
	
	@Override
	public Team findTeamById(Integer id) {
		Optional<Team> option = teamRepo.findById(id);
		return option.isPresent() ? option.get() : null;
	}
	
	@Override
	public List<Player> getTeamRoster(String teamName){
		List<Player> players = null;
		Team team = teamRepo.findByName(teamName);
		if(team != null)
			players = playerRepository.getPlayerByTeam(team.getId());
		
		return players;
	}
	
	@Override
	public List<Player> getTeamPlayersByPositionGroup(String teamName, String position){
		Team team = teamRepo.findByName(teamName);
		return playerRepository.getPlayerByTeamAndPositionGroup(team.getId(), position);
	}
	
	@Override
	public Map<String, List<Player>> compareTeams(String teamA, String teamB){
		List<Player> rosterA = getTeamRoster(teamA);
		List<Player> rosterB = getTeamRoster(teamB);
		if(rosterA == null || rosterB == null) {
			return null;
		}
		
		Map<String,List<Player>> map = new HashMap<>();
		map.put(teamA, rosterA);
		map.put(teamB, rosterB);
		return map;
	}
	
	@Override
	public Map<String, List<Player>> compareTeamsByPosition(String teamA, String teamB, String position){
		List<Player> rosterA = getTeamPlayersByPositionGroup(teamA, position);
		List<Player> rosterB = getTeamPlayersByPositionGroup(teamB, position);
		if(rosterA == null || rosterB == null) {
			return null;
		}
		
		Map<String, List<Player>> map =  new HashMap<>();
		map.put(teamA, rosterA);
		map.put(teamB, rosterB);
		return map;
	}
	
}
