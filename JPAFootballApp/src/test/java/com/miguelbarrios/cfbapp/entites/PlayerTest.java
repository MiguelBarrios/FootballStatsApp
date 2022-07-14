package com.miguelbarrios.cfbapp.entites;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.miguelbarrios.cfbapp.entities.Conference;
import com.miguelbarrios.cfbapp.entities.Player;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Player player;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAFootballApp");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		player = em.find(Player.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		player = null;
	}

	@Test
	@DisplayName("Initial Testing")
	void test1() {
		assertNotNull(player);
		assertEquals("Keith Adams Jr.", player.getName());
	}
	
	@Test
	@DisplayName("MTO mapping to Team test")
	void mto_mapping_to_team() {
		assertNotNull(player);
		assertEquals("Clemson", player.getTeam().getName());
	}
}
