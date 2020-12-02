package uno.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.Uno;
import static org.junit.jupiter.api.Assertions.*;

class UnoTest {
    Uno uno;

    @BeforeEach
    void setUp() {
        uno = new Uno();
    }

    @Test
    void initialiser() {
        uno.initialiser(6);
        assertEquals(uno.nbJoueurs(),6);
        assertEquals(uno.getPlayers()[0].getNom(), "Humain");
        for(int i = 1 ; i < uno.nbJoueurs() ; ++i) {
            assertEquals(uno.getPlayers()[i].getNom(), "Bot");
        }
        assertEquals(uno.getPioche().getNombreDeCartes(),108 - 6*7 - 1); //Paquet de Uno - les paquets de chaque joueurs - le talon
        for(int i = 0 ; i < uno.nbJoueurs() ; ++i){
            assertEquals(uno.getPlayers()[i].getPdc().getNombreDeCartes(),7);
        }
        assertEquals(uno.getTalon().getNombreDeCartes(),1);
        if(uno.getNoJoueurDistrib() == uno.nbJoueurs() - 1){
            assertEquals(uno.getNoJoueurPlay(),0);
        }
        else{
            assertEquals(uno.getNoJoueurPlay(),uno.getNoJoueurDistrib() + 1);
        }
    }

    @Test
    void creerLesJoueurs() {
        uno.creerLesJoueurs(9);
        assertEquals(uno.nbJoueurs(),9);
        uno.creerLesJoueurs(2);
        assertEquals(uno.nbJoueurs(),2);
    }
}