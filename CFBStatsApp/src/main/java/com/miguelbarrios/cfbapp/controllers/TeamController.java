package com.miguelbarrios.cfbapp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost" })
public class TeamController {

	@GetMapping("players/index")
	public void getAllPlayers() {
		System.out.println("success");
	}
}
