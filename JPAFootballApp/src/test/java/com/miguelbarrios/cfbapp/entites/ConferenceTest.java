package com.miguelbarrios.cfbapp.entites;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.miguelbarrios.cfbapp.entities.Conference;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConferenceTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Conference conference;

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
		conference = em.find(Conference.class, "ACC");
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		conference = null;
	}

	@Test
	@DisplayName("Initial Testing")
	void test1() {
		assertNotNull(conference);
		assertEquals("ACC", conference.getName());
		

	}

}
