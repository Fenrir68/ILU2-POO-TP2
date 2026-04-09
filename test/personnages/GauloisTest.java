package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GauloisTest {

	@Test
	void testGaulois() {
		Gaulois gaulois = new Gaulois("ungaulois", 10);
		assertNotNull(gaulois);
		assertTrue(gaulois.getForce()==10);
	}
	
	@Test
	void testPrendreParole() {
		Gaulois gaulois = new Gaulois("ungaulois", 10);
		assertTrue(gaulois.prendreParole().equals("Le gaulois ungaulois : "));
	}
	
	@Test
	void testToString() {
		Gaulois gaulois = new Gaulois("ungaulois", 10);
		gaulois.boirePotion(20);
		String expected = "Gaulois [nom=ungaulois, force=10, effetPotion=20]";
		assertTrue(expected.equals(gaulois.toString()));
	}

}
