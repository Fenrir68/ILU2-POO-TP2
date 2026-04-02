package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	Village village;
	Chef chef;	
	ControlEmmenager controlEmmenager;
	
	@BeforeEach
	void init() {
		village = new Village("Le village", 10, 10);
		chef = new Chef("Patron", 1, village);
		village.setChef(chef);
	}
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite);
	}
	
	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("druide", 1,10, 20);
		controlEmmenager.ajouterGaulois("gaulois", 1);
		assertTrue(controlVerifierIdentite.verifierIdentite("druide"));
		assertTrue(controlVerifierIdentite.verifierIdentite("gaulois"));
		assertTrue(controlVerifierIdentite.verifierIdentite("Patron"));
		assertFalse(controlVerifierIdentite.verifierIdentite("personne"));
	}

}
