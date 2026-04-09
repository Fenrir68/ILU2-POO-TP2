package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	Village village;
	Chef chef;
	
	@BeforeEach
	void initSituatiuon() {
		System.out.println("Initialisation...");
		village = new Village("Le village", 10, 5);
		chef = new Chef("Patron", 666, village);
		village.setChef(chef);
	}
	
	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertTrue(controlEmmenager.isHabitant("Patron"));
		controlEmmenager.ajouterGaulois("Obélix", 15);
		assertTrue(controlEmmenager.isHabitant("Obélix"));
		assertFalse(controlEmmenager.isHabitant("Pas habitant"));
		controlEmmenager.ajouterDruide("Pano", 2, 0, 5);
		assertTrue(controlEmmenager.isHabitant("Pano"));
	}
	
	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Pano", 2, 0, 5);
		assertTrue(controlEmmenager.isHabitant("Pano"));
	}
	
	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Obélix", 15);
		assertTrue(controlEmmenager.isHabitant("Obélix"));
	}
	@Test
	void testAjouterBeaucoupDeGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		for (int i = 0; i < 100; i++) {
			controlEmmenager.ajouterGaulois("GAULOIS_" + i, 10);
		}
		for (int i = 0; i < 100; i++) {
			if (i < 10) {
				assertTrue(controlEmmenager.isHabitant("GAULOIS_" + i));
			} else {
				assertFalse(controlEmmenager.isHabitant("GAULOIS_" + i));
			}
		}
	}
}
