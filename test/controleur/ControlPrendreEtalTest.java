package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	Village village;
	Chef chef;
	ControlEmmenager controlEmmenager;
	ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	void init() {
		village = new Village("levillage", 10, 3);
		chef = new Chef("Patron", 100, village);
		village.setChef(chef);
		controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlEmmenager.ajouterGaulois("pasBonemine", 10);
		controlEmmenager.ajouterDruide("Pano", 1, 1, 2);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}
	
	@Test
	void testControlPrendreEtal()
	{
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal);
	}
	
	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
		controlPrendreEtal.prendreEtal("Bonemine", "fleur", 1);
		controlPrendreEtal.prendreEtal("pasBonemine", "fleur", 1);
		assertTrue(controlPrendreEtal.resteEtals());
		controlPrendreEtal.prendreEtal("Pano", "potion", 1);
		assertFalse(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(0==controlPrendreEtal.prendreEtal("Bonemine", "fleur", 1));
		assertTrue(1==controlPrendreEtal.prendreEtal("pasBonemine", "fleur", 1));
		assertTrue(2==controlPrendreEtal.prendreEtal("Pano", "fleur", 1));
	}
	
	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("Bonemine", "fleur", 1);
		controlPrendreEtal.prendreEtal("pasBonemine", "fleur", 1);
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
		assertTrue(controlPrendreEtal.verifierIdentite("pasBonemine"));
		assertFalse(controlPrendreEtal.verifierIdentite("personne"));
		assertFalse(controlPrendreEtal.verifierIdentite(""));
		assertFalse(controlPrendreEtal.verifierIdentite("Bonemines"));
	}
}
