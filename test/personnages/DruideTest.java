package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DruideTest {

	@Test
	void testDruide() {
		Druide druide = new Druide("lui", 1, 5, 10);
		assertNotNull(druide);
	}
	
	@Test
	void testPreparerPotion() {
		Druide druide = new Druide("lui", 1, 5, 10);
		for(int i=0; i<10; i++) {
			druide.preparerPotion();
		}
	}
	
	@Test
	void testBooster() {
		Druide druide = new Druide("lui", 1, 5, 10);
		druide.booster(new Gaulois("Obélix", 10));
		druide.booster(new Gaulois("Astérix", 45));
	}
	
	@Test
	void testPrendreParole() {
		Druide druide = new Druide("lui", 1, 5, 10);
		assertTrue(druide.prendreParole().equals("Le druide lui : "));
	}

}
