package tests;

import cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Fichier test de la classe Joker
 *
 * @author Hugo Iopeti
 */

class CarteJokerTest {
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
        assertTrue(carChiffre.peutEtreRecouverte(carJoker));
        assertTrue(carChiffre2.peutEtreRecouverte(carJoker));
        assertTrue(carCDS.peutEtreRecouverte(carJoker));
        assertTrue(carCDS2.peutEtreRecouverte(carJoker));
        assertTrue(carJoker.peutEtreRecouverte(carJoker));   //Code à refaire quand je referai les sans-couleurs
        assertTrue(carPTT.peutEtreRecouverte(carJoker));
        assertTrue(carPTT2.peutEtreRecouverte(carJoker));
        assertTrue(carPlus2.peutEtreRecouverte(carJoker));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carJoker));
        assertTrue(carPlus4.peutEtreRecouverte(carJoker));   //Code à refaire quand je referai les sans-couleurs
    }

    @Test
    void getValeur() {
        assertEquals(carJoker.getValeur(),50);
    }

    @Test
    void effet() {
        assertEquals(carJoker.effet(),1);
    }

    @Test
    void peutEtrePoseeSur() {
        assertTrue(carJoker.peutEtrePoseeSur(carChiffre));
        assertTrue(carJoker.peutEtrePoseeSur(carChiffre2));
    }

    @Test
    void testPeutEtrePoseeSur() {
        assertTrue(carJoker.peutEtrePoseeSur(carCDS));
        assertTrue(carJoker.peutEtrePoseeSur(carCDS2));
    }

    @Test
    void testPeutEtrePoseeSur1() {
        assertTrue(carJoker.peutEtrePoseeSur(carJoker));   //Code à refaire quand je referai les sans-couleurs
    }

    @Test
    void testPeutEtrePoseeSur2() {
        assertTrue(carJoker.peutEtrePoseeSur(carPTT));
        assertTrue(carJoker.peutEtrePoseeSur(carPTT2));
    }

    @Test
    void testPeutEtrePoseeSur3() {
        assertTrue(carJoker.peutEtrePoseeSur(carPlus2));
        assertTrue(carJoker.peutEtrePoseeSur(carPlus2Bis));
    }

    @Test
    void testPeutEtrePoseeSur4() {
        assertTrue(carJoker.peutEtrePoseeSur(carPlus4));   //Code à refaire quand je referai les sans-couleurs
    }
}