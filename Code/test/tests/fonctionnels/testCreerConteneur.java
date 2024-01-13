package tests.fonctionnels;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testEtat.Conteneur;

class testCreerConteneur {

	@Test
	void testConstructeurConteneur() {
		Assertions.assertThrows(testEtat.ErreurConteneur.class, () -> new Conteneur(1));
	}

}
