package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	Village village;
	Chef chef;	
	
	
	
	@BeforeEach
	void init() {
		village = new Village("Le village", 10, 10);
		chef = new Chef("Patron", 1, village);
		village.setChef(chef);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur);
	}
	
	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlEmmenager.ajouterDruide("Pano", 1, 1, 2);
		controlPrendreEtal.prendreEtal("Bonemine", "fleur", 10);
		controlPrendreEtal.prendreEtal("Pano", "potion", 5);
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine"));
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Pano"));
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Patron"));
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("personne"));
	}

}
