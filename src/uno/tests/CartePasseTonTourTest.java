package uno.tests;

import uno.Uno;
import uno.cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Fichier test de la classe CartePasseTonTour
 *
 * @author Hugo Iopeti
 */

class CartePasseTonTourTest {
    Uno uno;
    CarteChiffre carChiffre;
    CarteChiffre carChiffre2;
    CarteJoker carJoker;
    CartePlus2 carPlus2;
    CartePlus2 carPlus2Bis;
    CarteChangementDeSens carCDS;
    CarteChangementDeSens carCDS2;
    CartePlus4 carPlus4;
    CartePasseTonTour carPTT;
    CartePasseTonTour carPTT2;

    @BeforeEach
    void setUp() {
        uno = new Uno();
        carChiffre = new CarteChiffre(uno, Couleur.ROUGE, 6);
        carChiffre2 = new CarteChiffre(uno, Couleur.BLEU, 2);
        carJoker = new CarteJoker(uno);
        carPlus2 = new CartePlus2(uno, Couleur.ROUGE);
        carPlus2Bis = new CartePlus2(uno, Couleur.BLEU);
        carCDS = new CarteChangementDeSens(uno, Couleur.ROUGE);
        carCDS2 = new CarteChangementDeSens(uno, Couleur.BLEU);
        carPlus4 = new CartePlus4(uno);
        carPTT = new CartePasseTonTour(uno, Couleur.ROUGE);
        carPTT2 = new CartePasseTonTour(uno, Couleur.BLEU);
    }

    @Test
    void peutEtreRecouverte() {
        assertTrue(carChiffre.peutEtreRecouverte(carPTT));
        assertTrue(carChiffre2.peutEtreRecouverte(carPTT2));
        assertFalse(carChiffre2.peutEtreRecouverte(carPTT));
        assertFalse(carChiffre.peutEtreRecouverte(carPTT2));
        assertTrue(carCDS.peutEtreRecouverte(carPTT));
        assertTrue(carCDS2.peutEtreRecouverte(carPTT2));
        assertFalse(carCDS2.peutEtreRecouverte(carPTT));
        assertFalse(carCDS.peutEtreRecouverte(carPTT2));
        assertFalse(carJoker.peutEtreRecouverte(carPTT));   //Code à refaire quand je referai les sans-couleurs
        assertFalse(carJoker.peutEtreRecouverte(carPTT2));
        assertTrue(carPTT.peutEtreRecouverte(carPTT));
        assertTrue(carPTT2.peutEtreRecouverte(carPTT2));
        assertTrue(carPTT2.peutEtreRecouverte(carPTT));
        assertTrue(carPTT.peutEtreRecouverte(carPTT2));
        assertTrue(carPlus2.peutEtreRecouverte(carPTT));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carPTT2));
        assertFalse(carPlus2Bis.peutEtreRecouverte(carPTT));
        assertFalse(carPlus2.peutEtreRecouverte(carPTT2));
        assertFalse(carPlus4.peutEtreRecouverte(carPTT));   //Code à refaire quand je referai les sans-couleurs
        assertFalse(carPlus4.peutEtreRecouverte(carPTT2));
    }

    @Test
    void getValeur() {
        assertEquals(carPTT.getValeur(),20);
        assertEquals(carPTT2.getValeur(),20);
    }

    @Test
    void effet() {
        assertEquals(carPTT.effet(),5);
        assertEquals(carPTT2.effet(),5);
    }

    @Test
    void peutEtrePoseeSur() {
        assertTrue(carPTT.peutEtrePoseeSur(carChiffre));
        assertTrue(carPTT2.peutEtrePoseeSur(carChiffre2));
        assertFalse(carPTT.peutEtrePoseeSur(carChiffre2));
        assertFalse(carPTT2.peutEtrePoseeSur(carChiffre));
    }

    @Test
    void testPeutEtrePoseeSur() {
        assertTrue(carPTT.peutEtrePoseeSur(carCDS));
        assertTrue(carPTT2.peutEtrePoseeSur(carCDS2));
        assertFalse(carPTT.peutEtrePoseeSur(carCDS2));
        assertFalse(carPTT2.peutEtrePoseeSur(carCDS));
    }

    @Test
    void testPeutEtrePoseeSur1() {
        assertFalse(carPTT.peutEtrePoseeSur(carJoker));   //Code à refaire quand je referai les sans-couleurs
        assertFalse(carPTT2.peutEtrePoseeSur(carJoker));
    }

    @Test
    void testPeutEtrePoseeSur2() {
        assertTrue(carPTT.peutEtrePoseeSur(carPTT));
        assertTrue(carPTT2.peutEtrePoseeSur(carPTT2));
        assertTrue(carPTT.peutEtrePoseeSur(carPTT2));
        assertTrue(carPTT2.peutEtrePoseeSur(carPTT));
    }

    @Test
    void testPeutEtrePoseeSur3() {
        assertTrue(carPTT.peutEtrePoseeSur(carPlus2));
        assertTrue(carPTT2.peutEtrePoseeSur(carPlus2Bis));
        assertFalse(carPTT.peutEtrePoseeSur(carPlus2Bis));
        assertFalse(carPTT2.peutEtrePoseeSur(carPlus2));
    }

    @Test
    void testPeutEtrePoseeSur4() {
        assertFalse(carPTT.peutEtrePoseeSur(carPlus4));   //Code à refaire quand je referai les sans-couleurs
        assertFalse(carPTT2.peutEtrePoseeSur(carPlus4));
    }
}