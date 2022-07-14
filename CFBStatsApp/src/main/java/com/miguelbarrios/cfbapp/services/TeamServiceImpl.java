package com.miguelbarrios.cfbapp.services;

import java.util.List;

import com.miguelbarrios.cfbapp.entities.Team;
import com.miguelbarrios.cfbapp.repositories.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService{

	@Autowired
	private TeamRepository teamRepo;
	
	@Override
	public List<Team> index(){
		return teamRepo.findAll();
	}
}
