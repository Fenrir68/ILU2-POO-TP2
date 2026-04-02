package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	Village village;
	Chef chef;
	ControlVerifierIdentite controlVerifIndentite;
	ControlTrouverEtalVendeur controlTrouverEtal;
	ControlPrendreEtal controlPrendreEtal;
	ControlEmmenager controlEmmenager;
	
	@BeforeEach
	void initSituation() {
		village = new Village("Le village", 10, 5);
		chef = new Chef("Patron", 5, village);
		village.setChef(chef);
		controlVerifIndentite = new ControlVerifierIdentite(village);
		controlTrouverEtal = new ControlTrouverEtalVendeur(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifIndentite, village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlEmmenager.ajouterGaulois("pasBonemine", 10);
		controlEmmenager.ajouterDruide("Pano", 1, 1, 2);
		controlPrendreEtal.prendreEtal("Bonemine", "fleur", 10);
		controlPrendreEtal.prendreEtal("pasBonemine", "fleur", 1);
		controlPrendreEtal.prendreEtal("Pano", "potion", 5);
	}
	
	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifIndentite, controlTrouverEtal, village);
		assertNotNull(controlAcheterProduit, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testIsAcheteur() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifIndentite, controlTrouverEtal, village);
		assertFalse(controlAcheterProduit.isAcheteur("personne"));
		assertTrue(controlAcheterProduit.isAcheteur("Bonemine"));
		assertTrue(controlAcheterProduit.isAcheteur("Patron"));
	}
	
	private boolean isIn(String[] array, String elem) {
		boolean find = false;
		for(int i=0; i<array.length && !find; i++) {
			find = elem.equals(array[i]);
		}
		return find;
	}
	
	@Test
	void testTrouverEtalProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifIndentite, controlTrouverEtal, village);
		String[] res = controlAcheterProduit.trouverEtalProduit("fleur");
		assertNotNull(res);
		assertTrue(res.length==2);
		assertTrue(isIn(res, "Bonemine"));
		assertTrue(isIn(res, "pasBonemine"));
		res = controlAcheterProduit.trouverEtalProduit("potion");
		assertNotNull(res);
		assertTrue(res.length==1);
		assertTrue(res[0].equals("Pano"));
		res = controlAcheterProduit.trouverEtalProduit("rien");
		assertNotNull(res);
		assertTrue(res.length==0);
	}
	
	@Test
	void testAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifIndentite, controlTrouverEtal, village);
		assertTrue(controlAcheterProduit.acheterProduit("Bonemine", 5)==5);
		assertTrue(controlAcheterProduit.acheterProduit("pasBonemine", 1)==1);
		assertTrue(controlAcheterProduit.acheterProduit("Pano", 10)==5);
	}

}
