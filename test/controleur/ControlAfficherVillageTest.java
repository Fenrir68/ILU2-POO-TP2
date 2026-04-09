package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {

	private Village village;
	private Chef chef;
	
	@BeforeEach
	void setUp() {
		this.village = new Village("ICI", 10, 13);
		this.chef = new Chef("Patron", 666666, village);
		this.village.setChef(chef);
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage);
	}
	
	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		String[] nomsGaulois = {"Bonemine", "Thermomix", "IXIXIXIX"};
		String[] nomsDruide = {"Panoramix", "Pafinix"};
		for(int i=0; i<3; i++) {
			controlEmmenager.ajouterGaulois(nomsGaulois[i], 10);
		}
		for(int i=0; i<2; i++) {
			controlEmmenager.ajouterDruide(nomsDruide[i], 1, 2, 3);
		}
		String[] actual = controlAfficherVillage.donnerNomsVillageois();
		int i;
		
		assertTrue(actual[0].equals("Patron"));
		for(i=1; i<4; i++) {
			assertTrue(actual[i].equals(nomsGaulois[i-1]));
		}
		for(i=4; i<6; i++) {
			assertTrue(actual[i].equals("le druide "+nomsDruide[i-4]));
		}
	}
	
	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertTrue(controlAfficherVillage.donnerNomVillage().equals("ICI"));
	}
	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertTrue(controlAfficherVillage.donnerNbEtals()==13);
	}
}
