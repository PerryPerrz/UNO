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
    CarteChiffre carChiffre;
    CarteJoker carJoker;
    CartePlus2 carPlus2;
    CarteChangementDeSens carCDS;
    CartePlus4 carPlus4;
    CartePasseTonTour carPTT;

    @BeforeEach
    void setUp() {
        uno = new Uno();
        carChiffre = new CarteChiffre(uno, Couleur.ROUGE, 6);
        carJoker = new CarteJoker(uno);
        carPlus2 = new CartePlus2(uno, Couleur.VERT);
        carCDS = new CarteChangementDeSens(uno, Couleur.BLEU);
        carPlus4 = new CartePlus4(uno);
        carPTT = new CartePasseTonTour(uno, Couleur.JAUNE);
    }

    @Test
    public void peutEtreRecouverte() {
        //Classe Abstraite
    }

    @Test
    public void getValeur() {
        //On ne test pas les getter
    }

    @Test
    public void effet() {
        //Classe Abstraite
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

        //Test avec la carte plus 2
        assertFalse(carPlus2.estDeCouleurCompatible(Couleur.ROUGE));
        assertTrue(carPlus2.estDeCouleurCompatible(Couleur.VERT));
        assertFalse(carPlus2.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carPlus2.estDeCouleurCompatible(Couleur.JAUNE));

        //Test avec la carte changement de sens
        assertFalse(carCDS.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carCDS.estDeCouleurCompatible(Couleur.VERT));
        assertTrue(carCDS.estDeCouleurCompatible(Couleur.BLEU));
        assertFalse(carCDS.estDeCouleurCompatible(Couleur.JAUNE));

        //Test avec la carte pase ton tour
        assertFalse(carPTT.estDeCouleurCompatible(Couleur.ROUGE));
        assertFalse(carPTT.estDeCouleurCompatible(Couleur.VERT));
        assertFalse(carPTT.estDeCouleurCompatible(Couleur.BLEU));
        assertTrue(carPTT.estDeCouleurCompatible(Couleur.JAUNE));
    }

    @Test
    public void peutEtrePoseeSur() {
        //Classe Abstraite
    }

    @Test
    public void testPeutEtrePoseeSur() {
        //Classe Abstraite
    }

    @Test
    public void testPeutEtrePoseeSur1() {
        //Classe Abstraite
    }

    @Test
    public void testPeutEtrePoseeSur2() {
        //Classe Abstraite
    }

    @Test
    public void testPeutEtrePoseeSur3() {
        //Classe Abstraite
    }

    @Test
    public void testPeutEtrePoseeSur4() {
        //Classe Abstraite
    }
}