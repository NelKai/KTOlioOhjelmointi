package kt_olioohjelmointi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatikkaaTest {

	// JUnit-harjoituksia

	@Test
	void testPotenssi() {
		assertEquals(27, Matikkaa.potenssi(3, 3));
	}
	
	@Test
	void testEkaSuurempiKuin() {
		assertTrue(Matikkaa.ekaSuurempiKuin(6, 2));
	}
	
	@Test
	void testPintaAla() {
		assertEquals(200, Matikkaa.pintaAla(10, 20));
		assertEquals(0, Matikkaa.pintaAla(-9, 2));
	}
}
