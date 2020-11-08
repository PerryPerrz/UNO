package tests;

import cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Fichier test de la classe CartePlus4
 *
 * @author Hugo Iopeti
 */

class CartePlus4Test {
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
        assertTrue(carChiffre.peutEtreRecouverte(carPlus4));
        assertTrue(carChiffre2.peutEtreRecouverte(carPlus4));
        assertTrue(carCDS.peutEtreRecouverte(carPlus4));
        assertTrue(carCDS2.peutEtreRecouverte(carPlus4));
        assertTrue(carJoker.peutEtreRecouverte(carPlus4));   //Code à refaire quand je referai les sans-couleurs
        assertTrue(carPTT.peutEtreRecouverte(carPlus4));
        assertTrue(carPTT2.peutEtreRecouverte(carPlus4));
        assertTrue(carPlus2.peutEtreRecouverte(carPlus4));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carPlus4));
        assertTrue(carPlus4.peutEtreRecouverte(carPlus4));   //Code à refaire quand je referai les sans-couleurs
    }

    @Test
    void getValeur() {
        assertEquals(carPlus4.getValeur(),50);
    }

    @Test
    void effet() {
        assertEquals(carPlus4.effet(),4);
    }

    @Test
    void peutEtrePoseeSur() {
        assertTrue(carPlus4.peutEtrePoseeSur(carChiffre));
        assertTrue(carPlus4.peutEtrePoseeSur(carChiffre2));
    }

    @Test
    void testPeutEtrePoseeSur() {
        assertTrue(carPlus4.peutEtrePoseeSur(carCDS));
        assertTrue(carPlus4.peutEtrePoseeSur(carCDS2));
    }

    @Test
    void testPeutEtrePoseeSur1() {
        assertTrue(carPlus4.peutEtrePoseeSur(carJoker));   //Code à refaire quand je referai les sans-couleurs
    }

    @Test
    void testPeutEtrePoseeSur2() {
        assertTrue(carPlus4.peutEtrePoseeSur(carPTT));
        assertTrue(carPlus4.peutEtrePoseeSur(carPTT2));
    }

    @Test
    void testPeutEtrePoseeSur3() {
        assertTrue(carPlus4.peutEtrePoseeSur(carPlus2));
        assertTrue(carPlus4.peutEtrePoseeSur(carPlus2Bis));
    }

    @Test
    void testPeutEtrePoseeSur4() {
        assertTrue(carPlus4.peutEtrePoseeSur(carPlus4));   //Code à refaire quand je referai les sans-couleurs
    }
}