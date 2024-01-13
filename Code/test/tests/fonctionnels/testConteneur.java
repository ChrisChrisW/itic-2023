package tests.fonctionnels;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testEtat.Conteneur;

class testConteneur {

	private void verifierCreationConteneurLanceErreurConteneur(int capacite) {
		Assertions.assertThrows(testEtat.ErreurConteneur.class, () -> new Conteneur(capacite));
	}

	@Test
	void TestCapaciteSuperior1() {
		int n = 5;
		Assertions.assertDoesNotThrow(() -> new Conteneur(n));
	}

	@Test
	void TestCapaciteEquals1() {
		int n = 1;
		verifierCreationConteneurLanceErreurConteneur(n);
	}

	@Test
	void TestCapaciteLessThan1() {
		int n = -5;
		verifierCreationConteneurLanceErreurConteneur(n);
	}
}
