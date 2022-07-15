package com.miguelbarrios.cfbapp.services;

import java.util.List;
import java.util.Map;

import com.miguelbarrios.cfbapp.entities.Player;
import com.miguelbarrios.cfbapp.entities.Team;

public interface TeamService {

	List<Team> index();

	Team findTeamById(Integer id);

	List<Player> getTeamPlayersByPositionGroup(String teamName, String position);

	List<Player> getTeamRoster(String teamName);

	Team findTeamByName(String teamName);

	Map<String, List<Player>> compareTeams(String teamA, String teamB);

	Map<String, List<Player>> compareTeamsByPosition(String teamA, String teamB, String position);

}
