package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherMarcheTest {

	private Village village;
	private Chef chef;
	
	@BeforeEach
	void init() {
		this.village = new Village("ICI", 10, 5);
		this.chef = new Chef("PATRON", 666, village);
		this.village.setChef(chef);
	}
	
	@Test
	void testControlAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche);
	}
	
	@Test
	void testDonnerInfoMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		String[] noms = {"Bonemine", "Panoramix", "Thermomix"};
		String[] objs = {"fleurs", "potions", "mixeurs"};
		int[] nbs = {10, 3, 5};
		for(int i=0; i<3; i++) {
			controlEmmenager.ajouterGaulois(noms[i], 10);
			controlPrendreEtal.prendreEtal(noms[i], objs[i], nbs[i]);
		}
		String[] actual = controlAfficherMarche.donnerInfoMarche();
		for(int i=0; i<3; i++) {
			assertTrue(actual[3*i].equals(noms[i]));
			assertTrue(actual[3*i+1].equals(""+nbs[i]));
			assertTrue(actual[3*i+2].equals(objs[i]));
		}
	}

}
