package tests;

import cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Fichier test de la classe CartePlus2
 *
 * @author Hugo Iopeti
 */

class CartePlus2Test {
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
        assertTrue(carChiffre.peutEtreRecouverte(carPlus2));
        assertTrue(carChiffre2.peutEtreRecouverte(carPlus2Bis));
        assertFalse(carChiffre2.peutEtreRecouverte(carPlus2));
        assertFalse(carChiffre.peutEtreRecouverte(carPlus2Bis));
        assertTrue(carCDS.peutEtreRecouverte(carPlus2));
        assertTrue(carCDS2.peutEtreRecouverte(carPlus2Bis));
        assertFalse(carCDS2.peutEtreRecouverte(carPlus2));
        assertFalse(carCDS.peutEtreRecouverte(carPlus2Bis));
        assertFalse(carJoker.peutEtreRecouverte(carPlus2));
        assertFalse(carJoker.peutEtreRecouverte(carPlus2Bis));
        assertTrue(carPTT.peutEtreRecouverte(carPlus2));
        assertTrue(carPTT2.peutEtreRecouverte(carPlus2Bis));
        assertFalse(carPTT2.peutEtreRecouverte(carPlus2));
        assertFalse(carPTT.peutEtreRecouverte(carPlus2Bis));
        assertTrue(carPlus2.peutEtreRecouverte(carPlus2));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carPlus2Bis));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carPlus2));
        assertTrue(carPlus2.peutEtreRecouverte(carPlus2Bis));
        assertFalse(carPlus4.peutEtreRecouverte(carPlus2));
        assertFalse(carPlus4.peutEtreRecouverte(carPlus2Bis));
    }

    @Test
    void getValeur() {
        assertEquals(carPlus2.getValeur(),20);
        assertEquals(carPlus2Bis.getValeur(),20);
    }

    @Test
    void effet() {
        assertEquals(carPlus2.effet(),2);
        assertEquals(carPlus2Bis.effet(),2);
    }

    @Test
    void peutEtrePoseeSur() {
        assertTrue(carPlus2.peutEtrePoseeSur(carChiffre));
        assertTrue(carPlus2Bis.peutEtrePoseeSur(carChiffre2));
        assertFalse(carPlus2.peutEtrePoseeSur(carChiffre2));
        assertFalse(carPlus2Bis.peutEtrePoseeSur(carChiffre));
    }

    @Test
    void testPeutEtrePoseeSur() {
        assertTrue(carPlus2.peutEtrePoseeSur(carCDS));
        assertTrue(carPlus2Bis.peutEtrePoseeSur(carCDS2));
        assertFalse(carPlus2.peutEtrePoseeSur(carCDS2));
        assertFalse(carPlus2Bis.peutEtrePoseeSur(carCDS));
    }

    @Test
    void testPeutEtrePoseeSur1() {
        assertFalse(carPlus2.peutEtrePoseeSur(carJoker));   //Code à refaire quand je referai les sans-couleurs
        assertFalse(carPlus2Bis.peutEtrePoseeSur(carJoker));
    }

    @Test
    void testPeutEtrePoseeSur2() {
        assertTrue(carPlus2.peutEtrePoseeSur(carPTT));
        assertTrue(carPlus2Bis.peutEtrePoseeSur(carPTT2));
        assertFalse(carPlus2.peutEtrePoseeSur(carPTT2));
        assertFalse(carPlus2Bis.peutEtrePoseeSur(carPTT));
    }

    @Test
    void testPeutEtrePoseeSur3() {
        assertTrue(carPlus2.peutEtrePoseeSur(carPlus2));
        assertTrue(carPlus2Bis.peutEtrePoseeSur(carPlus2Bis));
        assertTrue(carPlus2.peutEtrePoseeSur(carPlus2Bis));
        assertTrue(carPlus2Bis.peutEtrePoseeSur(carPlus2));
    }

    @Test
    void testPeutEtrePoseeSur4() {
        assertFalse(carPlus2.peutEtrePoseeSur(carPlus4));   //Code à refaire quand je referai les sans-couleurs
        assertFalse(carPlus2Bis.peutEtrePoseeSur(carPlus4));
    }
}