package uno.tests;

import uno.Uno;
import uno.cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Fichier test de la classe Carte
 *
 * @author Hugo Iopeti
 */

class CarteTest {
    Uno uno;
    CarteChiffre carChiffre, carChiffre2, carChiffre3;
    CarteJoker carJoker;
    CartePlus2 carPlus2, carPlus2Bis;
    CarteChangementDeSens carCDS, carCDS2;
    CartePlus4 carPlus4;
    CartePasseTonTour carPTT,carPTT2;

    @BeforeEach
    void setUp() {
        uno = new Uno();
        carChiffre = new CarteChiffre(uno, Couleur.ROUGE, 6);
        carChiffre2 = new CarteChiffre(uno, Couleur.BLEU, 2);
        carChiffre3 = new CarteChiffre(uno, Couleur.BLEU, 6);
        carJoker = new CarteJoker(uno);
        carPlus2 = new CartePlus2(uno, Couleur.VERT);
        carPlus2Bis = new CartePlus2(uno, Couleur.BLEU);
        carCDS = new CarteChangementDeSens(uno, Couleur.BLEU);
        carCDS2 = new CarteChangementDeSens(uno, Couleur.BLEU);
        carPlus4 = new CartePlus4(uno);
        carPTT = new CartePasseTonTour(uno, Couleur.JAUNE);
        carPTT2 = new CartePasseTonTour(uno, Couleur.BLEU);
    }

    @Test
    public void peutEtreRecouverte() {

        //Test avec la carte chiffre
        assertTrue(carChiffre.peutEtreRecouverte(carChiffre));
        assertFalse(carChiffre2.peutEtreRecouverte(carChiffre));
        assertTrue(carChiffre3.peutEtreRecouverte(carChiffre));
        assertFalse(carChiffre.peutEtreRecouverte(carChiffre2));
        assertTrue(carChiffre2.peutEtreRecouverte(carChiffre2));
        assertTrue(carChiffre3.peutEtreRecouverte(carChiffre2));
        assertTrue(carChiffre.peutEtreRecouverte(carChiffre3));
        assertTrue(carChiffre2.peutEtreRecouverte(carChiffre3));
        assertTrue(carChiffre3.peutEtreRecouverte(carChiffre3));
        assertFalse(carCDS.peutEtreRecouverte(carChiffre));
        assertFalse(carCDS2.peutEtreRecouverte(carChiffre));
        assertTrue(carCDS.peutEtreRecouverte(carChiffre2));
        assertTrue(carCDS2.peutEtreRecouverte(carChiffre2));
        assertTrue(carCDS.peutEtreRecouverte(carChiffre3));
        assertTrue(carCDS2.peutEtreRecouverte(carChiffre3));
        assertFalse(carJoker.peutEtreRecouverte(carChiffre));
        assertFalse(carJoker.peutEtreRecouverte(carChiffre2));
        assertFalse(carJoker.peutEtreRecouverte(carChiffre3));
        assertFalse(carJoker.peutEtreRecouverte(carChiffre));
        assertFalse(carJoker.peutEtreRecouverte(carChiffre2));
        assertFalse(carJoker.peutEtreRecouverte(carChiffre3));
        assertFalse(carPTT.peutEtreRecouverte(carChiffre));
        assertFalse(carPTT2.peutEtreRecouverte(carChiffre));
        assertFalse(carPTT.peutEtreRecouverte(carChiffre2));
        assertTrue(carPTT2.peutEtreRecouverte(carChiffre2));
        assertFalse(carPTT.peutEtreRecouverte(carChiffre3));
        assertTrue(carPTT2.peutEtreRecouverte(carChiffre3));
        assertFalse(carPlus2.peutEtreRecouverte(carChiffre));
        assertFalse(carPlus2Bis.peutEtreRecouverte(carChiffre));
        assertFalse(carPlus2.peutEtreRecouverte(carChiffre2));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carChiffre2));
        assertFalse(carPlus2.peutEtreRecouverte(carChiffre3));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carChiffre3));
        assertFalse(carPlus4.peutEtreRecouverte(carChiffre));
        assertFalse(carPlus4.peutEtreRecouverte(carChiffre2));
        assertFalse(carPlus4.peutEtreRecouverte(carChiffre3));

        //Test avec la carte joker
        assertTrue(carChiffre.peutEtreRecouverte(carJoker));
        assertTrue(carChiffre2.peutEtreRecouverte(carJoker));
        assertTrue(carCDS.peutEtreRecouverte(carJoker));
        assertTrue(carCDS2.peutEtreRecouverte(carJoker));
        assertTrue(carJoker.peutEtreRecouverte(carJoker));
        assertTrue(carJoker.peutEtreRecouverte(carJoker));
        assertTrue(carPTT.peutEtreRecouverte(carJoker));
        assertTrue(carPTT2.peutEtreRecouverte(carJoker));
        assertTrue(carPlus2.peutEtreRecouverte(carJoker));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carJoker));
        assertTrue(carPlus4.peutEtreRecouverte(carJoker));

        //Test avec la carte plus 2
        assertFalse(carChiffre.peutEtreRecouverte(carPlus2));
        assertTrue(carChiffre2.peutEtreRecouverte(carPlus2Bis));
        assertFalse(carChiffre2.peutEtreRecouverte(carPlus2));
        assertFalse(carChiffre.peutEtreRecouverte(carPlus2Bis));
        assertFalse(carCDS.peutEtreRecouverte(carPlus2));
        assertTrue(carCDS2.peutEtreRecouverte(carPlus2Bis));
        assertFalse(carCDS2.peutEtreRecouverte(carPlus2));
        assertTrue(carCDS.peutEtreRecouverte(carPlus2Bis));
        assertFalse(carJoker.peutEtreRecouverte(carPlus2));
        assertFalse(carJoker.peutEtreRecouverte(carPlus2Bis));
        assertFalse(carJoker.peutEtreRecouverte(carPlus2));
        assertFalse(carJoker.peutEtreRecouverte(carPlus2Bis));
        assertFalse(carPTT.peutEtreRecouverte(carPlus2));
        assertTrue(carPTT2.peutEtreRecouverte(carPlus2Bis));
        assertFalse(carPTT2.peutEtreRecouverte(carPlus2));
        assertFalse(carPTT.peutEtreRecouverte(carPlus2Bis));
        assertTrue(carPlus2.peutEtreRecouverte(carPlus2));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carPlus2Bis));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carPlus2));
        assertTrue(carPlus2.peutEtreRecouverte(carPlus2Bis));
        assertFalse(carPlus4.peutEtreRecouverte(carPlus2));
        assertFalse(carPlus4.peutEtreRecouverte(carPlus2Bis));

        //Test avec la carte changement de sens
        assertFalse(carChiffre.peutEtreRecouverte(carCDS));
        assertTrue(carChiffre2.peutEtreRecouverte(carCDS2));
        assertTrue(carChiffre2.peutEtreRecouverte(carCDS));
        assertFalse(carChiffre.peutEtreRecouverte(carCDS2));
        assertTrue(carCDS.peutEtreRecouverte(carCDS));
        assertTrue(carCDS2.peutEtreRecouverte(carCDS2));
        assertTrue(carCDS2.peutEtreRecouverte(carCDS));
        assertTrue(carCDS.peutEtreRecouverte(carCDS2));
        assertFalse(carJoker.peutEtreRecouverte(carCDS));
        assertFalse(carJoker.peutEtreRecouverte(carCDS2));
        assertFalse(carJoker.peutEtreRecouverte(carCDS));
        assertFalse(carJoker.peutEtreRecouverte(carCDS2));
        assertFalse(carPTT.peutEtreRecouverte(carCDS));
        assertTrue(carPTT2.peutEtreRecouverte(carCDS2));
        assertTrue(carPTT2.peutEtreRecouverte(carCDS));
        assertFalse(carPTT.peutEtreRecouverte(carCDS2));
        assertFalse(carPlus2.peutEtreRecouverte(carCDS));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carCDS2));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carCDS));
        assertFalse(carPlus2.peutEtreRecouverte(carCDS2));
        assertFalse(carPlus4.peutEtreRecouverte(carCDS));
        assertFalse(carPlus4.peutEtreRecouverte(carCDS2));

        //Test avec la carte plus 4
        assertTrue(carChiffre.peutEtreRecouverte(carPlus4));
        assertTrue(carChiffre2.peutEtreRecouverte(carPlus4));
        assertTrue(carCDS.peutEtreRecouverte(carPlus4));
        assertTrue(carCDS2.peutEtreRecouverte(carPlus4));
        assertTrue(carJoker.peutEtreRecouverte(carPlus4));
        assertTrue(carJoker.peutEtreRecouverte(carPlus4));
        assertTrue(carPTT.peutEtreRecouverte(carPlus4));
        assertTrue(carPTT2.peutEtreRecouverte(carPlus4));
        assertTrue(carPlus2.peutEtreRecouverte(carPlus4));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carPlus4));
        assertTrue(carPlus4.peutEtreRecouverte(carPlus4));

        //Test avec la carte passe ton tour
        assertFalse(carChiffre.peutEtreRecouverte(carPTT));
        assertTrue(carChiffre2.peutEtreRecouverte(carPTT2));
        assertFalse(carChiffre2.peutEtreRecouverte(carPTT));
        assertFalse(carChiffre.peutEtreRecouverte(carPTT2));
        assertFalse(carCDS.peutEtreRecouverte(carPTT));
        assertTrue(carCDS2.peutEtreRecouverte(carPTT2));
        assertFalse(carCDS2.peutEtreRecouverte(carPTT));
        assertTrue(carCDS.peutEtreRecouverte(carPTT2));
        assertFalse(carJoker.peutEtreRecouverte(carPTT));
        assertFalse(carJoker.peutEtreRecouverte(carPTT2));
        assertFalse(carJoker.peutEtreRecouverte(carPTT));
        assertFalse(carJoker.peutEtreRecouverte(carPTT2));
        assertTrue(carPTT.peutEtreRecouverte(carPTT));
        assertTrue(carPTT2.peutEtreRecouverte(carPTT2));
        assertTrue(carPTT2.peutEtreRecouverte(carPTT));
        assertTrue(carPTT.peutEtreRecouverte(carPTT2));
        assertFalse(carPlus2.peutEtreRecouverte(carPTT));
        assertTrue(carPlus2Bis.peutEtreRecouverte(carPTT2));
        assertFalse(carPlus2Bis.peutEtreRecouverte(carPTT));
        assertFalse(carPlus2.peutEtreRecouverte(carPTT2));
        assertFalse(carPlus4.peutEtreRecouverte(carPTT));
        assertFalse(carPlus4.peutEtreRecouverte(carPTT2));
    }

    @Test
    public void getValeur() {

        //Test avec la carte chiffre
        assertEquals(carChiffre.getValeur(),6);
        assertEquals(carChiffre2.getValeur(),2);
        assertEquals(carChiffre3.getValeur(),6);

        //Test avec la carte joker
        assertEquals(carJoker.getValeur(),50);

        //Test avec la carte plus 2
        assertEquals(carPlus2.getValeur(),20);
        assertEquals(carPlus2Bis.getValeur(),20);

        //Test avec la carte changement de sens
        assertEquals(carCDS.getValeur(),20);
        assertEquals(carCDS.getValeur(),20);

        //Test avec la carte plus 4
        assertEquals(carPlus4.getValeur(),50);

        //Test avec la carte passe ton tour
        assertEquals(carPTT.getValeur(),20);
        assertEquals(carPTT2.getValeur(),20);
    }

    @Test
    public void effet() {

        //Test avec la carte chiffre
        assertEquals(carChiffre.effet(),0);
        assertEquals(carChiffre2.effet(),0);
        assertEquals(carChiffre3.effet(),0);

        //Test avec la carte joker
        assertEquals(carJoker.effet(),1);

        //Test avec la carte plus 2
        assertEquals(carPlus2.effet(),2);
        assertEquals(carPlus2Bis.effet(),2);

        //Test avec la carte changement de sens
        assertEquals(carCDS.effet(),3);
        assertEquals(carCDS.effet(),3);

        //Test avec la carte plus 4
        assertEquals(carPlus4.effet(),4);

        //Test avec la carte passe ton tour
        assertEquals(carPTT.effet(),5);
        assertEquals(carPTT2.effet(),5);
    }

    @Test
    public void estSansCouleur() {

        //Cartes sans couleurs
        assertTrue(carJoker.estSansCouleur());
        assertTrue(carPlus4.estSansCouleur());

        //Cartes avec couleurs
        assertFalse(carChiffre.estSansCouleur());
        assertFalse(carPlus2.estSansCouleur());
        assertFalse(carCDS.estSansCouleur());
        assertFalse(carPTT.estSansCouleur());
        assertFalse(carChiffre2.estSansCouleur());
        assertFalse(carPlus2Bis.estSansCouleur());
        assertFalse(carCDS2.estSansCouleur());
        assertFalse(carPTT2.estSansCouleur());
    }

    @Test
    public void appliquerEffet() {
        //Je ne sais pas comment je doit m'y prendre
    }

    @Test
    public void estDeCouleurCompatible() {

        //Test avec la carte chiffre
        assertTrue(carChiffre.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carChiffre.estDeCouleurCompatible(Couleur.VERT));
        assertFalse(carChiffre.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carChiffre.estDeCouleurCompatible(Couleur.JAUNE));
        assertFalse(carChiffre2.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carChiffre2.estDeCouleurCompatible(Couleur.VERT));
        assertTrue(carChiffre2.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carChiffre2.estDeCouleurCompatible(Couleur.JAUNE));

        //Test avec la carte plus 2
        assertFalse(carPlus2.estDeCouleurCompatible(Couleur.ROUGE));
        assertTrue(carPlus2.estDeCouleurCompatible(Couleur.VERT));
        assertFalse(carPlus2.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carPlus2.estDeCouleurCompatible(Couleur.JAUNE));
        assertFalse(carPlus2Bis.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carPlus2Bis.estDeCouleurCompatible(Couleur.VERT));
        assertTrue(carPlus2Bis.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carPlus2Bis.estDeCouleurCompatible(Couleur.JAUNE));

        //Test avec la carte changement de sens
        assertFalse(carCDS.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carCDS.estDeCouleurCompatible(Couleur.VERT));
        assertTrue(carCDS.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carCDS.estDeCouleurCompatible(Couleur.JAUNE));
        assertFalse(carCDS2.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carCDS2.estDeCouleurCompatible(Couleur.VERT));
        assertTrue(carCDS2.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carCDS2.estDeCouleurCompatible(Couleur.JAUNE));

        //Test avec la carte pase ton tour
        assertFalse(carPTT.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carPTT.estDeCouleurCompatible(Couleur.VERT));
        assertFalse(carPTT.estDeCouleurCompatible(Couleur.BLEU));
        assertTrue(carPTT.estDeCouleurCompatible(Couleur.JAUNE));
        assertFalse(carPTT2.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carPTT2.estDeCouleurCompatible(Couleur.VERT));
        assertTrue(carPTT2.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carPTT2.estDeCouleurCompatible(Couleur.JAUNE));
    }

    @Test
    public void peutEtrePoseeSur() {

        //Test avec la carte chiffre
        assertTrue(carChiffre.peutEtrePoseeSur(carChiffre));
        assertFalse(carChiffre.peutEtrePoseeSur(carChiffre2));
        assertTrue(carChiffre.peutEtrePoseeSur(carChiffre3));
        assertFalse(carChiffre2.peutEtrePoseeSur(carChiffre));
        assertTrue(carChiffre2.peutEtrePoseeSur(carChiffre2));
        assertTrue(carChiffre2.peutEtrePoseeSur(carChiffre3));
        assertTrue(carChiffre3.peutEtrePoseeSur(carChiffre));
        assertTrue(carChiffre3.peutEtrePoseeSur(carChiffre2));
        assertTrue(carChiffre3.peutEtrePoseeSur(carChiffre3));

        //Test avec la carte joker
        assertTrue(carJoker.peutEtrePoseeSur(carChiffre));
        assertTrue(carJoker.peutEtrePoseeSur(carChiffre2));

        //Test avec la carte plus 2
        assertFalse(carPlus2.peutEtrePoseeSur(carChiffre));
        assertTrue(carPlus2Bis.peutEtrePoseeSur(carChiffre2));
        assertFalse(carPlus2.peutEtrePoseeSur(carChiffre2));
        assertFalse(carPlus2Bis.peutEtrePoseeSur(carChiffre));

        //Test avec la carte changement de sens
        assertFalse(carCDS.peutEtrePoseeSur(carChiffre));
        assertTrue(carCDS2.peutEtrePoseeSur(carChiffre2));
        assertTrue(carCDS.peutEtrePoseeSur(carChiffre2));
        assertFalse(carCDS2.peutEtrePoseeSur(carChiffre));

        //Test avec la carte plus 4
        assertTrue(carPlus4.peutEtrePoseeSur(carChiffre));
        assertTrue(carPlus4.peutEtrePoseeSur(carChiffre2));

        //Test avec la carte passe ton tour
        assertFalse(carPTT.peutEtrePoseeSur(carChiffre));
        assertTrue(carPTT2.peutEtrePoseeSur(carChiffre2));
        assertFalse(carPTT.peutEtrePoseeSur(carChiffre2));
        assertFalse(carPTT2.peutEtrePoseeSur(carChiffre));
    }

    @Test
    public void testPeutEtrePoseeSur() {

        //Test avec la carte chiffre
        assertFalse(carChiffre.peutEtrePoseeSur(carCDS));
        assertFalse(carChiffre.peutEtrePoseeSur(carCDS2));
        assertTrue(carChiffre2.peutEtrePoseeSur(carCDS));
        assertTrue(carChiffre2.peutEtrePoseeSur(carCDS2));
        assertTrue(carChiffre3.peutEtrePoseeSur(carCDS));
        assertTrue(carChiffre3.peutEtrePoseeSur(carCDS2));

        //Test avec la carte joker
        assertTrue(carJoker.peutEtrePoseeSur(carCDS));
        assertTrue(carJoker.peutEtrePoseeSur(carCDS2));

        //Test avec la carte plus 2
        assertFalse(carPlus2.peutEtrePoseeSur(carCDS));
        assertTrue(carPlus2Bis.peutEtrePoseeSur(carCDS2));
        assertFalse(carPlus2.peutEtrePoseeSur(carCDS2));
        assertTrue(carPlus2Bis.peutEtrePoseeSur(carCDS));

        //Test avec la carte changement de sens
        assertTrue(carCDS.peutEtrePoseeSur(carCDS));
        assertTrue(carCDS2.peutEtrePoseeSur(carCDS2));
        assertTrue(carCDS.peutEtrePoseeSur(carCDS2));
        assertTrue(carCDS2.peutEtrePoseeSur(carCDS));

        //Test avec la carte plus 4
        assertTrue(carPlus4.peutEtrePoseeSur(carCDS));
        assertTrue(carPlus4.peutEtrePoseeSur(carCDS2));

        //Test avec la carte passe ton tour
        assertFalse(carPTT.peutEtrePoseeSur(carCDS));
        assertTrue(carPTT2.peutEtrePoseeSur(carCDS2));
        assertFalse(carPTT.peutEtrePoseeSur(carCDS2));
        assertTrue(carPTT2.peutEtrePoseeSur(carCDS));
    }

    @Test
    public void testPeutEtrePoseeSur1() {

        //Test avec la carte chiffre
        assertFalse(carChiffre.peutEtrePoseeSur(carJoker));
        assertFalse(carChiffre2.peutEtrePoseeSur(carJoker));
        assertFalse(carChiffre3.peutEtrePoseeSur(carJoker));

        //Test avec la carte joker
        assertTrue(carJoker.peutEtrePoseeSur(carJoker));

        //Test avec la carte plus 2
        assertFalse(carPlus2.peutEtrePoseeSur(carJoker));
        assertFalse(carPlus2Bis.peutEtrePoseeSur(carJoker));

        //Test avec la carte changement de sens
        assertFalse(carCDS.peutEtrePoseeSur(carJoker));
        assertFalse(carCDS2.peutEtrePoseeSur(carJoker));

        //Test avec la carte plus 4
        assertTrue(carPlus4.peutEtrePoseeSur(carJoker));

        //Test avec la carte passe ton tour
        assertFalse(carPTT.peutEtrePoseeSur(carJoker));
        assertFalse(carPTT2.peutEtrePoseeSur(carJoker));

    }

    @Test
    public void testPeutEtrePoseeSur2() {

        //Test avec la carte chiffre
        assertFalse(carChiffre.peutEtrePoseeSur(carPTT));
        assertFalse(carChiffre.peutEtrePoseeSur(carPTT2));
        assertFalse(carChiffre2.peutEtrePoseeSur(carPTT));
        assertTrue(carChiffre2.peutEtrePoseeSur(carPTT2));
        assertFalse(carChiffre3.peutEtrePoseeSur(carPTT));
        assertTrue(carChiffre3.peutEtrePoseeSur(carPTT2));

        //Test avec la carte joker
        assertTrue(carJoker.peutEtrePoseeSur(carPTT));
        assertTrue(carJoker.peutEtrePoseeSur(carPTT2));

        //Test avec la carte plus 2
        assertFalse(carPlus2.peutEtrePoseeSur(carPTT));
        assertTrue(carPlus2Bis.peutEtrePoseeSur(carPTT2));
        assertFalse(carPlus2.peutEtrePoseeSur(carPTT2));
        assertFalse(carPlus2Bis.peutEtrePoseeSur(carPTT));

        //Test avec la carte changement de sens
        assertFalse(carCDS.peutEtrePoseeSur(carPTT));
        assertTrue(carCDS2.peutEtrePoseeSur(carPTT2));
        assertTrue(carCDS.peutEtrePoseeSur(carPTT2));
        assertFalse(carCDS2.peutEtrePoseeSur(carPTT));

        //Test avec la carte plus 4
        assertTrue(carPlus4.peutEtrePoseeSur(carPTT));
        assertTrue(carPlus4.peutEtrePoseeSur(carPTT2));

        //Test avec la carte passe ton tour
        assertTrue(carPTT.peutEtrePoseeSur(carPTT));
        assertTrue(carPTT2.peutEtrePoseeSur(carPTT2));
        assertTrue(carPTT.peutEtrePoseeSur(carPTT2));
        assertTrue(carPTT2.peutEtrePoseeSur(carPTT));
    }

    @Test
    public void testPeutEtrePoseeSur3() {

        //Test avec la carte chiffre
        assertFalse(carChiffre.peutEtrePoseeSur(carPlus2));
        assertFalse(carChiffre.peutEtrePoseeSur(carPlus2Bis));
        assertFalse(carChiffre2.peutEtrePoseeSur(carPlus2));
        assertTrue(carChiffre2.peutEtrePoseeSur(carPlus2Bis));
        assertFalse(carChiffre3.peutEtrePoseeSur(carPlus2));
        assertTrue(carChiffre3.peutEtrePoseeSur(carPlus2Bis));

        //Test avec la carte joker
        assertTrue(carJoker.peutEtrePoseeSur(carPlus2));
        assertTrue(carJoker.peutEtrePoseeSur(carPlus2Bis));

        //Test avec la carte plus 2
        assertTrue(carPlus2.peutEtrePoseeSur(carPlus2));
        assertTrue(carPlus2Bis.peutEtrePoseeSur(carPlus2Bis));
        assertTrue(carPlus2.peutEtrePoseeSur(carPlus2Bis));
        assertTrue(carPlus2Bis.peutEtrePoseeSur(carPlus2));

        //Test avec la carte changement de sens
        assertFalse(carCDS.peutEtrePoseeSur(carPlus2));
        assertTrue(carCDS2.peutEtrePoseeSur(carPlus2Bis));
        assertTrue(carCDS.peutEtrePoseeSur(carPlus2Bis));
        assertFalse(carCDS2.peutEtrePoseeSur(carPlus2));

        //Test avec la carte plus 4
        assertTrue(carPlus4.peutEtrePoseeSur(carPlus2));
        assertTrue(carPlus4.peutEtrePoseeSur(carPlus2Bis));

        //Test avec la carte passe ton tour
        assertFalse(carPTT.peutEtrePoseeSur(carPlus2));
        assertTrue(carPTT2.peutEtrePoseeSur(carPlus2Bis));
        assertFalse(carPTT.peutEtrePoseeSur(carPlus2Bis));
        assertFalse(carPTT2.peutEtrePoseeSur(carPlus2));
    }

    @Test
    public void testPeutEtrePoseeSur4() {

        //Test avec la carte chiffre
        assertFalse(carChiffre.peutEtrePoseeSur(carPlus4));
        assertFalse(carChiffre2.peutEtrePoseeSur(carPlus4));
        assertFalse(carChiffre3.peutEtrePoseeSur(carPlus4));

        //Test avec la carte joker
        assertTrue(carJoker.peutEtrePoseeSur(carPlus4));

        //Test avec la carte plus 2
        assertFalse(carPlus2.peutEtrePoseeSur(carPlus4));
        assertFalse(carPlus2Bis.peutEtrePoseeSur(carPlus4));

        //Test avec la carte changement de sens
        assertFalse(carCDS.peutEtrePoseeSur(carPlus4));
        assertFalse(carCDS2.peutEtrePoseeSur(carPlus4));

        //Test avec la carte plus 4
        assertTrue(carPlus4.peutEtrePoseeSur(carPlus4));

        //Test avec la carte passe ton tour
        assertFalse(carPTT.peutEtrePoseeSur(carPlus4));
        assertFalse(carPTT2.peutEtrePoseeSur(carPlus4));
    }
}