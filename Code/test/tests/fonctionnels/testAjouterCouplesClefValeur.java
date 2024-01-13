package tests.fonctionnels;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import testEtat.Conteneur;
import testEtat.ErreurConteneur;

class testAjouterCouplesClefValeur {

	private Conteneur CVide, CPlein, CNonVideNonPlein;
	private Object A1, A2, B1, B2;
	private Object A_NonPresent, B_NonPresent;

	@BeforeEach
	void setUp() throws ErreurConteneur {
		A_NonPresent = new String("clé x");
		B_NonPresent = new String("valeur x");

		A1 = new String("clé 1");
		A2 = 2; // = new Integer(2)
		B1 = new String("valeur 1");
		B2 = 3;

		// Conteneur vide
		CVide = new Conteneur(10);

		// Conteneur non vide et non plein
		CNonVideNonPlein = new Conteneur(5);
		CNonVideNonPlein.ajouter(A1, B1);
		CNonVideNonPlein.ajouter(A2, B2);

		// Conteneur plein
		CPlein = new Conteneur(2);
		CPlein.ajouter(A1, B1);
		CPlein.ajouter(A2, B2);
	}

	@AfterEach
	void tearDown() {
		CVide = CNonVideNonPlein = CPlein = null;
	}

	@Test
	void TestCpresentOvalideEtConteneurPlein() {
		Assertions.assertThrows(testEtat.DebordementConteneur.class, () -> CPlein.ajouter(A1, B1));
	}

	@Test
	void TestCpresentOvalideEtConteneurNonVideNonPlein() {
		Assertions.assertDoesNotThrow(() -> CNonVideNonPlein.ajouter(A1, B2));
	}

	@Test
	void TestCpresentOvideEtConteneurPlein() {
		Assertions.assertThrows(testEtat.DebordementConteneur.class, () -> CPlein.ajouter(A1, null));
	}

	@Test
	void TestCpresentOvideEtConteneurNonVideNonPlein() {
		Assertions.assertDoesNotThrow(() -> CNonVideNonPlein.ajouter(A1, null));
	}

	@Test
	void TestCpresentONonPresentEtConteneurPlein() {
		Assertions.assertThrows(testEtat.DebordementConteneur.class, () -> CPlein.ajouter(A1, B_NonPresent));
	}

	@Test
	void TestCpresentONonPresentEtConteneurNonVideNonPlein() {
		Assertions.assertDoesNotThrow(() -> CNonVideNonPlein.ajouter(A1, B_NonPresent));
	}

	@Test
	void TestClefInconnueOValideEtConteneurPlein() {
		Assertions.assertDoesNotThrow(() -> CNonVideNonPlein.ajouter(A_NonPresent, B1));
	}

	@Test
	void TestClefInconnueOValideEtConteneurVide() {
		Assertions.assertDoesNotThrow(() -> CVide.ajouter(A1, B1));
	}

	@Test
	void TestClefInconnueOValaideEtConteneurNonVideNonPlein() {
		Assertions.assertDoesNotThrow(() -> CNonVideNonPlein.ajouter(A_NonPresent, B1));
	}

	@Test
	void TestClefInconnueOVideEtConteneurPlein() {
		Assertions.assertThrows(testEtat.DebordementConteneur.class, () -> CPlein.ajouter(A_NonPresent, null));
	}

	@Test
	void TestClefInconnueOVideEtConteneurVide() {
		Assertions.assertDoesNotThrow(() -> CVide.ajouter(A_NonPresent, null));
	}

	@Test
	void TestClefInconnueOVideEtConteneurNonVideNonPlein() {
		Assertions.assertDoesNotThrow(() -> CNonVideNonPlein.ajouter(A_NonPresent, null));
	}

	@Test
	void TestClefInconnueONonPresentEtConteneurPlein() {
		Assertions.assertThrows(testEtat.DebordementConteneur.class, () -> CPlein.ajouter(A_NonPresent, B_NonPresent));
	}

	@Test
	void TestClefInconnueONonPresentEtConteneurVide() {
		Assertions.assertDoesNotThrow(() -> CVide.ajouter(A_NonPresent, B_NonPresent));
	}

	@Test
	void TestClefInconnueONonPresentEtConteneurNonVideNonPlein() {
		Assertions.assertDoesNotThrow(() -> CNonVideNonPlein.ajouter(A_NonPresent, B_NonPresent));
	}

	@Test
	void TestCvideOValideEtConteneurPlein() {
		Assertions.assertThrows(testEtat.DebordementConteneur.class, () -> CPlein.ajouter(null, B1));
	}

	@Test
	void TestCvideOValideEtConteneurVide() {
		Assertions.assertDoesNotThrow(() -> CVide.ajouter(null, B1));
	}

	@Test
	void TestCvideOValideEtConteneurNonVideNonPlein() {
		Assertions.assertDoesNotThrow(() -> CNonVideNonPlein.ajouter(null, B2));
	}

	@Test
	void TestCvideOvideEtConteneurPlein() {
		Assertions.assertThrows(testEtat.DebordementConteneur.class, () -> CPlein.ajouter(null, null));
	}

	@Test
	void TestCvideOvideEtConteneurVide() {
		Assertions.assertDoesNotThrow(() -> CVide.ajouter(null, null));
	}

	@Test
	void TestCvideOvideEtConteneurNonVideNonPlein() {
		Assertions.assertDoesNotThrow(() -> CNonVideNonPlein.ajouter(null, null));
	}

	@Test
	void TestCvideONonPresentEtConteneurPlein() {
		Assertions.assertThrows(testEtat.DebordementConteneur.class, () -> CPlein.ajouter(null, B_NonPresent));
	}

	@Test
	void TestCvideONonPresentEtConteneurVide() {
		Assertions.assertDoesNotThrow(() -> CVide.ajouter(null, B1));
	}

	@Test
	void TestCvideONonPresentEtConteneurNonVideNonPlein() {
		Assertions.assertDoesNotThrow(() -> CNonVideNonPlein.ajouter(null, B_NonPresent));
	}
}
