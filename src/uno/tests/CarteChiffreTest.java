package uno.tests;

import uno.Uno;
import uno.cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Fichier test de la classe CarteChiffre
 *
 * @author Hugo Iopeti
 */

class CarteChiffreTest {
    Uno uno;
    CarteChiffre carChiffre;
    CarteChiffre carChiffre2;
    CarteChiffre carChiffre3;
    CarteChiffre carChiffre4;
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
        carChiffre2 = new CarteChiffre(uno, Couleur.ROUGE, 2);
        carChiffre3 = new CarteChiffre(uno, Couleur.BLEU, 6);
        carChiffre4 = new CarteChiffre(uno, Couleur.JAUNE, 4);
        carJoker = new CarteJoker(uno);
        carPlus2 = new CartePlus2(uno, Couleur.BLEU);
        carPlus2Bis = new CartePlus2(uno, Couleur.JAUNE);
        carCDS = new CarteChangementDeSens(uno, Couleur.BLEU);
        carCDS2 = new CarteChangementDeSens(uno, Couleur.JAUNE);
        carPlus4 = new CartePlus4(uno);
        carPTT = new CartePasseTonTour(uno, Couleur.BLEU);
        carPTT2 = new CartePasseTonTour(uno, Couleur.JAUNE);
    }

    @Test
    void peutEtreRecouverte() {
        assertTrue(carChiffre.peutEtreRecouverte(carChiffre));
        assertTrue(carChiffre2.peutEtreRecouverte(carChiffre));
        assertTrue(carChiffre3.peutEtreRecouverte(carChiffre));
        assertFalse(carChiffre4.peutEtreRecouverte(carChiffre));
        assertFalse(carChiffre3.peutEtreRecouverte(carChiffre2));
        assertFalse(carChiffre4.peutEtreRecouverte(carChiffre2));
        assertFalse(carChiffre4.peutEtreRecouverte(carChiffre3));
        assertTrue(carCDS.peutEtreRecouverte(carChiffre3));
        assertTrue(carCDS2.peutEtreRecouverte(carChiffre4));
        assertFalse(carCDS.peutEtreRecouverte(carChiffre));
        assertFalse(carCDS2.peutEtreRecouverte(carChiffre));
        assertFalse(carCDS.peutEtreRecouverte(carChiffre2));
        assertFalse(carCDS2.peutEtreRecouverte(carChiffre2));
        assertFalse(carCDS.peutEtreRecouverte(carChiffre4));
        assertFalse(carCDS2.peutEtreRecouverte(carChiffre3));
        assertFalse(carJoker.peutEtreRecouverte(carChiffre));
        assertFalse(carJoker.peutEtreRecouverte(carChiffre2));
        assertFalse(carJoker.peutEtreRecouverte(carChiffre3));
        assertFalse(carJoker.peutEtreRecouverte(carChiffre4));
        assertTrue(carPTT.peutEtreRecouverte(carChiffre3));
        assertTrue(carPTT2.peutEtreRecouverte(carChiffre4));
        assertFalse(carPTT.peutEtreRecouverte(carChiffre));
        assertFalse(carPTT2.peutEtreRecouverte(carChiffre));
        assertFalse(carPTT.peutEtreRecouverte(carChiffre2));
        assertFalse(carPTT2.peutEtreRecouverte(carChiffre2));
        assertFalse(carPTT.peutEtreRecouverte(carChiffre4));
        assertFalse(carPTT2.peutEtreRecouverte(carChiffre3));
        assertTrue(carPlus2.peutEtreRecouverte(carChiffre3));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carChiffre4));
        assertFalse(carPlus2.peutEtreRecouverte(carChiffre));
        assertFalse(carPlus2Bis.peutEtreRecouverte(carChiffre));
        assertFalse(carPlus2.peutEtreRecouverte(carChiffre2));
        assertFalse(carPlus2Bis.peutEtreRecouverte(carChiffre2));
        assertFalse(carPlus2.peutEtreRecouverte(carChiffre4));
        assertFalse(carPlus2Bis.peutEtreRecouverte(carChiffre3));
        assertFalse(carPlus4.peutEtreRecouverte(carChiffre));
        assertFalse(carPlus4.peutEtreRecouverte(carChiffre2));
        assertFalse(carPlus4.peutEtreRecouverte(carChiffre3));
        assertFalse(carPlus4.peutEtreRecouverte(carChiffre4));
    }

    @Test
    void getValeur() {
        assertEquals(carChiffre.getValeur(),6);
        assertEquals(carChiffre2.getValeur(),2);
        assertEquals(carChiffre3.getValeur(),6);
        assertEquals(carChiffre4.getValeur(),4);
    }

    @Test
    void effet() {
        assertEquals(carChiffre.effet(),0);
        assertEquals(carChiffre2.effet(),0);
        assertEquals(carChiffre3.effet(),0);
        assertEquals(carChiffre4.effet(),0);
    }

    @Test
    void peutEtrePoseeSur() {
        assertTrue(carChiffre.peutEtrePoseeSur(carChiffre));
        assertTrue(carChiffre.peutEtrePoseeSur(carChiffre2));
        assertTrue(carChiffre.peutEtrePoseeSur(carChiffre3));
        assertFalse(carChiffre.peutEtrePoseeSur(carChiffre4));
        assertFalse(carChiffre2.peutEtrePoseeSur(carChiffre3));
        assertFalse(carChiffre2.peutEtrePoseeSur(carChiffre4));
        assertFalse(carChiffre3.peutEtrePoseeSur(carChiffre4));
    }

    @Test
    void testPeutEtrePoseeSur() {
        assertTrue(carChiffre3.peutEtrePoseeSur(carCDS));
        assertTrue(carChiffre4.peutEtrePoseeSur(carCDS2));
        assertFalse(carChiffre.peutEtrePoseeSur(carCDS));
        assertFalse(carChiffre.peutEtrePoseeSur(carCDS2));
        assertFalse(carChiffre2.peutEtrePoseeSur(carCDS));
        assertFalse(carChiffre2.peutEtrePoseeSur(carCDS2));
        assertFalse(carChiffre4.peutEtrePoseeSur(carCDS));
        assertFalse(carChiffre3.peutEtrePoseeSur(carCDS2));
    }

    @Test
    void testPeutEtrePoseeSur1() {
        assertFalse(carChiffre.peutEtrePoseeSur(carJoker)); //Code à refaire quand je referai les sans-couleurs
        assertFalse(carChiffre2.peutEtrePoseeSur(carJoker));
        assertFalse(carChiffre3.peutEtrePoseeSur(carJoker));
        assertFalse(carChiffre4.peutEtrePoseeSur(carJoker));
    }

    @Test
    void testPeutEtrePoseeSur2() {
        assertTrue(carChiffre3.peutEtrePoseeSur(carPTT));
        assertTrue(carChiffre4.peutEtrePoseeSur(carPTT2));
        assertFalse(carChiffre.peutEtrePoseeSur(carPTT));
        assertFalse(carChiffre.peutEtrePoseeSur(carPTT2));
        assertFalse(carChiffre2.peutEtrePoseeSur(carPTT));
        assertFalse(carChiffre2.peutEtrePoseeSur(carPTT2));
        assertFalse(carChiffre4.peutEtrePoseeSur(carPTT));
        assertFalse(carChiffre3.peutEtrePoseeSur(carPTT2));
    }

    @Test
    void testPeutEtrePoseeSur3() {
        assertTrue(carChiffre3.peutEtrePoseeSur(carPlus2));
        assertTrue(carChiffre4.peutEtrePoseeSur(carPlus2Bis));
        assertFalse(carChiffre.peutEtrePoseeSur(carPlus2));
        assertFalse(carChiffre.peutEtrePoseeSur(carPlus2Bis));
        assertFalse(carChiffre2.peutEtrePoseeSur(carPlus2));
        assertFalse(carChiffre2.peutEtrePoseeSur(carPlus2Bis));
        assertFalse(carChiffre4.peutEtrePoseeSur(carPlus2));
        assertFalse(carChiffre3.peutEtrePoseeSur(carPlus2Bis));
    }

    @Test
    void testPeutEtrePoseeSur4() {
        assertFalse(carChiffre.peutEtrePoseeSur(carPlus4));  //Code à refaire quand je referai les sans-couleurs
        assertFalse(carChiffre2.peutEtrePoseeSur(carPlus4));
        assertFalse(carChiffre3.peutEtrePoseeSur(carPlus4));
        assertFalse(carChiffre4.peutEtrePoseeSur(carPlus4));
    }

    @Test
    void setChiffre() {
        //On ne test pas les setter
    }
}