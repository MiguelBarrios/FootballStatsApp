package com.miguelbarrios.cfbapp.services;

import java.util.List;

import com.miguelbarrios.cfbapp.entities.Player;
import com.miguelbarrios.cfbapp.entities.Team;

public interface TeamService {

	List<Team> index();

	Team findTeamById(Integer id);

	List<Player> getTeamRoster(Integer teamId);

	List<Player> getTeamPlayersByPositionGroup(Integer teamId, String position);

}
