package uno.tests;

import uno.Uno;
import uno.cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaquetDeCartesTest {
        CarteChiffre carChiffre;
        CarteJoker carJoker;
        CartePlus2 carPlus2;
        CarteChangementDeSens carCDC;
        CartePlus4 carPlus4;
        CartePasseTonTour carPTT;
        FabriqueCartes fabCartes;
        PaquetDeCartes pdc,pdc2,pdc3,pdc4,pdc5;
        Uno uno;

    @BeforeEach
    void setUp() {
        fabCartes = FabriqueCartes.getInstance();
        pdc = FabriqueCartes.getPaquetVide();
        pdc2 = FabriqueCartes.getPaquet1Vert();
        pdc3 = FabriqueCartes.getPaquet2Bleu();
        pdc4 = FabriqueCartes.getPaquet5Vert();
        pdc5 = FabriqueCartes.getPaquetUno();

        uno = new Uno();
        carChiffre = new CarteChiffre(uno,Couleur.ROUGE,6);
        carJoker = new CarteJoker(uno);
        carPlus2 = new CartePlus2(uno,Couleur.VERT);
        carCDC = new CarteChangementDeSens(uno,Couleur.BLEU);
        carPlus4 = new CartePlus4(uno);
        carPTT = new CartePasseTonTour(uno,Couleur.JAUNE);
    }

    @Test
    void ajouter() {
        pdc.ajouter(carChiffre);
        assertEquals(pdc.getNombreDeCartes(),1);
        pdc2.ajouter(carJoker);
        assertEquals(pdc2.getNombreDeCartes(),2);
        pdc3.ajouter(carPlus2);
        assertEquals(pdc3.getNombreDeCartes(),3);
        pdc4.ajouter(carCDC);
        assertEquals(pdc4.getNombreDeCartes(),6);
        pdc5.ajouter(carPlus4);
        assertEquals(pdc5.getNombreDeCartes(),109);
        pdc.ajouter(carPTT);
        assertEquals(pdc.getNombreDeCartes(),2);
    }

    @Test
    void getNombreDeCartes() {
        assertEquals(pdc.getNombreDeCartes(),0);
        assertEquals(pdc2.getNombreDeCartes(),1);
        assertEquals(pdc3.getNombreDeCartes(),2);
        assertEquals(pdc4.getNombreDeCartes(),5);
        assertEquals(pdc5.getNombreDeCartes(),108);
    }

    @Test
    void estVide() {
        assertTrue(pdc.estVide());
        assertFalse(pdc2.estVide());
        assertFalse(pdc3.estVide());
        assertFalse(pdc4.estVide());
        assertFalse(pdc5.estVide());
    }

    @Test
    void getValeur() {
        assertEquals(pdc.getValeur(),0);
        assertEquals(pdc2.getValeur(),6);
        assertEquals(pdc3.getValeur(),4);
        assertEquals(pdc4.getValeur(),15);
        assertEquals(pdc5.getValeur(),1240);
    }

    @Test
    void testToString() {
    }

    @Test
    void testAjouter() {
    }

    @Test
    void melanger() {
    }

    @Test
    void retourner() {
    }

    @Test
    void getSommet() {
        //assertEquals(pdc2.getSommet(),new CarteChiffre(uno, Couleur.VERT,6));
        //assertEquals(pdc5.getSommet(),new CarteChiffre(uno, Couleur.ROUGE,0));
    }

    @Test
    void piocher() {
        //assertEquals(pdc2.piocher(),new CarteChiffre(uno, Couleur.VERT,6));
    }

    @Test
    void ecrire(){
        //Test avec un paquet vide
        try {
            pdc.ecrire("TestAvecUnPaquetVide");
        } catch (ErreurFichier erreurFichier) {
            erreurFichier.printStackTrace();
        }

        //Test avec un paquet de une carte
        try {
            pdc2.ecrire("TestAvecUnPaquet1Carte");
        } catch (ErreurFichier erreurFichier) {
            erreurFichier.printStackTrace();
        }

        //Test avec un paquet de 5 uno.cartes
        try {
            pdc4.ecrire("TestAvecUnPaquet5Cartes");
        } catch (ErreurFichier erreurFichier) {
            erreurFichier.printStackTrace();
        }

        //Test avec un paquet de uno.Uno
        try {
            pdc5.ecrire("TestAvecUnPaquetDeUno");
        } catch (ErreurFichier erreurFichier) {
            erreurFichier.printStackTrace();
        }
    }

    @Test
    void lire(){
        //Test avec un paquet vide
        try {
            pdc.lire("TestAvecUnPaquetVide");
        } catch (ErreurFichier erreurFichier) {
            erreurFichier.printStackTrace();
        }
        assertEquals(pdc.getNombreDeCartes(),0);
        assertTrue(pdc.estVide());
        assertEquals(pdc.getValeur(),0);

        //Test avec un paquet de une carte
        try {
            pdc2.lire("TestAvecUnPaquet1CArte");
        } catch (ErreurFichier erreurFichier) {
            erreurFichier.printStackTrace();
        }
        assertEquals(pdc2.getNombreDeCartes(),1);
        assertFalse(pdc2.estVide());
        assertEquals(pdc2.getValeur(),6);

        //Test avec un paquet de 5 uno.cartes
        try {
            pdc4.lire("TestAvecUnPaquet5Cartes");
        } catch (ErreurFichier erreurFichier) {
            erreurFichier.printStackTrace();
        }
        assertEquals(pdc4.getNombreDeCartes(),5);
        assertFalse(pdc4.estVide());
        assertEquals(pdc4.getValeur(),15);

        //Test avec un paquet de uno.Uno
        try {
            pdc5.lire("TestAvecUnPaquetDeUno");
        } catch (ErreurFichier erreurFichier) {
            erreurFichier.printStackTrace();
        }
        assertEquals(pdc5.getNombreDeCartes(),108);
        assertFalse(pdc5.estVide());
        assertEquals(pdc5.getValeur(),1240);
    }
}