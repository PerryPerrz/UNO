package uno.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.Uno;
import uno.cartes.*;
import uno.joueur.CoupIncorrect;
import uno.joueur.JoueurHumain;

import static org.junit.jupiter.api.Assertions.*;

class JoueurHumainTest {
    FabriqueCartes fabc;
    PaquetDeCartes pdc1,pdc2,pdc3,pdc4;
    Uno uno;
    JoueurHumain player;
    Carte car;

    @BeforeEach
    void setUp() {
        fabc = FabriqueCartes.getInstance();
        pdc1 = FabriqueCartes.getPaquet1Vert();
        pdc1.ajouter(new CarteChangementDeSens(uno,Couleur.BLEU));

        pdc2 = FabriqueCartes.getPaquet2Bleu();
        pdc2.ajouter(new CartePlus4(uno));

        pdc3 = FabriqueCartes.getPaquet5Vert();
        pdc3.ajouter(new CarteJoker(uno));
        pdc3.ajouter(new CartePasseTonTour(uno,Couleur.ROUGE));

        pdc4 = FabriqueCartes.getPaquetUno();
        pdc4.ajouter(new CartePlus2(uno,Couleur.JAUNE));

        uno = new Uno();
        player = new JoueurHumain(uno,"playerOne",1);
    }

    @Test
    void carteChoisie(){
        try {
            player.setPdc(pdc1);
            car = player.carteChoisie("0");
            assertEquals(car.getCouleur(), Couleur.VERT);
            assertEquals(car.getValeur(),6);
            assertEquals(car.effet(),0);

            player.setPdc(pdc2);
            car = player.carteChoisie("0");
            assertEquals(car.getCouleur(), Couleur.BLEU);
            assertEquals(car.getValeur(),1);
            assertEquals(car.effet(),0);
            car = player.carteChoisie("1");
            assertEquals(car.getCouleur(), Couleur.BLEU);
            assertEquals(car.getValeur(),3);
            assertEquals(car.effet(),0);

            player.setPdc(pdc3);
            car = player.carteChoisie("5b");
            assertTrue(car.estSansCouleur());
            assertEquals(car.getValeur(),50);
            assertEquals(car.effet(),1);

            player.setPdc(pdc4);
            car = player.carteChoisie("108");
            assertEquals(car.getCouleur(),Couleur.JAUNE);
            assertEquals(car.getValeur(),20);
            assertEquals(car.effet(),2);

            player.setPdc(pdc1);
            car = player.carteChoisie("1");
            assertEquals(car.getCouleur(), Couleur.BLEU);
            assertEquals(car.getValeur(),20);
            assertEquals(car.effet(),3);

            player.setPdc(pdc2);
            car = player.carteChoisie("2j");
            assertTrue(car.estSansCouleur());
            assertEquals(car.getValeur(),50);
            assertEquals(car.effet(),4);

            player.setPdc(pdc3);
            car = player.carteChoisie("6");
            assertEquals(car.getCouleur(), Couleur.ROUGE);
            assertEquals(car.getValeur(),20);
            assertEquals(car.effet(),5);

        } catch (CoupIncorrect coupIncorrect) {
            coupIncorrect.printStackTrace();
        }
    }
}