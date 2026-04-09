package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {

	private Village village;
	private Chef chef;
	
	@BeforeEach
	void setUp() throws Exception {
		this.village = new Village("ICI", 10, 10);
		this.chef = new Chef("Patron", 100000, village);
		this.village.setChef(chef);
	}
	
	@Test
	void testIsVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 15);
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
		assertFalse(controlLibererEtal.isVendeur("Patron"));
		assertFalse(controlLibererEtal.isVendeur("personne"));
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testControlLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 15);
		controlAcheterProduit.acheterProduit("Bonemine", 10);
		String[] actual = controlLibererEtal.libererEtal("Bonemine");
		String[] expected = {String.valueOf(true), "Bonemine", "fleurs", "15", "10"};
		for(int i=0; i<5; i++) {
			assertTrue(actual[i].equals(expected[i]));
		}
		assertTrue(controlLibererEtal.libererEtal("personnes")[0].equals(String.valueOf(false)));
	}
}
