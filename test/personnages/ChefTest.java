package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ChefTest {

	private Village village;
	
	@BeforeEach
	void setUp(){
		village = new Village("ICI", 10, 10);
	}
	
	@Test
	void testChef() {
		Chef chef = new Chef("Patron", 100, village);
		assertNotNull(chef);
	}
	
	@Test
	void testPrendreParole() {
		Chef chef = new Chef("Patron", 100, village);
		String expected = "Le chef Patron du village ICI : ";
		assertTrue(expected.equals(chef.prendreParole()));
		chef.parler("oyé oyé brave gens");
	}

}
