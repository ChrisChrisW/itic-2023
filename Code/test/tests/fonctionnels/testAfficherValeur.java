package tests.fonctionnels;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import testEtat.Conteneur;
import testEtat.ErreurConteneur;

class testAfficherValeur {

    private Conteneur CVide, CPlein, CNonVideNonPlein;
    private Object A1, A2, B1, B2;
    private Object A_NonPresent;
	
	@BeforeEach
	void setUp() throws ErreurConteneur {
		A_NonPresent = new String("clé x");
		
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
	void TestCpresentEtConteneurPlein() {
		Assertions.assertDoesNotThrow( 
				() -> CPlein.valeur(A1));
	}
	
	@Test
	void TestClefInconnueEtConteneurPlein() {
		Assertions.assertThrows(testEtat.ErreurConteneur.class, 
				() -> CPlein.valeur(null));
	}
	
	@Test
	void TestCvideEtConteneurPlein() {
		Assertions.assertThrows(testEtat.ErreurConteneur.class, 
				() -> CPlein.valeur(A_NonPresent));
	}

	@Test
	void TestClefInconnueEtConteneurVide() {
		Assertions.assertThrows(testEtat.ErreurConteneur.class, 
				() -> CVide.valeur(A1));
	}
	
	@Test
	void TestCvideEtConteneurVide() {
		Assertions.assertThrows(testEtat.ErreurConteneur.class, 
				() -> CVide.valeur(null)) ;
	}
	
	@Test
	void TestCpresentEtConteneurNonVideNonPlein() {
		Assertions.assertDoesNotThrow( 
				() -> CNonVideNonPlein.valeur(A2));
	}
	
	@Test
	void TestCinconnueEtConteneurNonVideNonPlein() {
		Assertions.assertThrows(testEtat.ErreurConteneur.class, 
				() -> CNonVideNonPlein.valeur(A_NonPresent));
	}
	
	@Test
	void TestCvideEtConteneurNonVideNonPlein() {
		Assertions.assertThrows(testEtat.ErreurConteneur.class, 
				() -> CNonVideNonPlein.valeur(null));
	}
}
