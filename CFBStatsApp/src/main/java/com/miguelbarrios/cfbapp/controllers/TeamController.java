package com.miguelbarrios.cfbapp.controllers;

import java.util.List;

import com.miguelbarrios.cfbapp.entities.Team;
import com.miguelbarrios.cfbapp.services.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost" })
public class TeamController {
	
	@Autowired
	private TeamService teamService;

	@GetMapping("players/index")
	public List<Team> getAllPlayers() {
		return teamService.index();
	}
}
