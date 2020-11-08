package tests;

import cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Fichier test de la classe CarteChangementDeSens
 *
 * @author Hugo Iopeti
 */

class CarteChangementDeSensTest {
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
        assertTrue(carChiffre.peutEtreRecouverte(carCDS));
        assertTrue(carChiffre2.peutEtreRecouverte(carCDS2));
        assertFalse(carChiffre2.peutEtreRecouverte(carCDS));
        assertFalse(carChiffre.peutEtreRecouverte(carCDS2));
        assertTrue(carCDS.peutEtreRecouverte(carCDS));
        assertTrue(carCDS2.peutEtreRecouverte(carCDS2));
        assertTrue(carCDS2.peutEtreRecouverte(carCDS));
        assertTrue(carCDS.peutEtreRecouverte(carCDS2));
        assertFalse(carJoker.peutEtreRecouverte(carCDS));
        assertFalse(carJoker.peutEtreRecouverte(carCDS2));
        assertTrue(carPTT.peutEtreRecouverte(carCDS));
        assertTrue(carPTT2.peutEtreRecouverte(carCDS2));
        assertFalse(carPTT2.peutEtreRecouverte(carCDS));
        assertFalse(carPTT.peutEtreRecouverte(carCDS2));
        assertTrue(carPlus2.peutEtreRecouverte(carCDS));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carCDS2));
        assertFalse(carPlus2Bis.peutEtreRecouverte(carCDS));
        assertFalse(carPlus2.peutEtreRecouverte(carCDS2));
        assertFalse(carPlus4.peutEtreRecouverte(carCDS));
        assertFalse(carPlus4.peutEtreRecouverte(carCDS2));
    }

    @Test
    void getValeur() {
        assertEquals(carCDS.getValeur(),20);
        assertEquals(carCDS.getValeur(),20);
    }

    @Test
    void effet() {
        assertEquals(carCDS.effet(),3);
        assertEquals(carCDS.effet(),3);
    }

    @Test
    void peutEtrePoseeSur() {
        assertTrue(carCDS.peutEtrePoseeSur(carChiffre));
        assertTrue(carCDS2.peutEtrePoseeSur(carChiffre2));
        assertFalse(carCDS.peutEtrePoseeSur(carChiffre2));
        assertFalse(carCDS2.peutEtrePoseeSur(carChiffre));
    }

    @Test
    void testPeutEtrePoseeSur() {
        assertTrue(carCDS.peutEtrePoseeSur(carCDS));
        assertTrue(carCDS2.peutEtrePoseeSur(carCDS2));
        assertTrue(carCDS.peutEtrePoseeSur(carCDS2));
        assertTrue(carCDS2.peutEtrePoseeSur(carCDS));
    }

    @Test
    void testPeutEtrePoseeSur1() {
        assertFalse(carCDS.peutEtrePoseeSur(carJoker));   //Code à refaire quand je referai les sans-couleurs
        assertFalse(carCDS2.peutEtrePoseeSur(carJoker));
    }

    @Test
    void testPeutEtrePoseeSur2() {
        assertTrue(carCDS.peutEtrePoseeSur(carPTT));
        assertTrue(carCDS2.peutEtrePoseeSur(carPTT2));
        assertFalse(carCDS.peutEtrePoseeSur(carPTT2));
        assertFalse(carCDS2.peutEtrePoseeSur(carPTT));
    }

    @Test
    void testPeutEtrePoseeSur3() {
        assertTrue(carCDS.peutEtrePoseeSur(carPlus2));
        assertTrue(carCDS2.peutEtrePoseeSur(carPlus2Bis));
        assertFalse(carCDS.peutEtrePoseeSur(carPlus2Bis));
        assertFalse(carCDS2.peutEtrePoseeSur(carPlus2));
    }

    @Test
    void testPeutEtrePoseeSur4() {
        assertFalse(carCDS.peutEtrePoseeSur(carPlus4));   //Code à refaire quand je referai les sans-couleurs
        assertFalse(carCDS2.peutEtrePoseeSur(carPlus4));
    }
}