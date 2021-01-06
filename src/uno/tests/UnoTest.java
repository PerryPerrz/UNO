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
            assertEquals(uno.getPlayers()[i].getNom(), "Bot n° " + i);
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
        assertTrue(uno.isSensHoraire());
    }

    @Test
    void creerLesJoueurs() {
        uno.creerLesJoueurs(9);
        assertEquals(uno.nbJoueurs(),9);
        uno.creerLesJoueurs(2);
        assertEquals(uno.nbJoueurs(),2);
    }

    @Test
    void changerSensDuJeu(){
        uno.initialiser(6);
        assertTrue(uno.isSensHoraire());
        uno.changerSensDuJeu();
        assertFalse(uno.isSensHoraire());
    }

    @Test
    void changerDeJoueur(){
        uno.initialiser(6);
        int indiceJoueur = uno.getNoJoueurPlay();
        uno.changerDeJoueur();
        if(indiceJoueur == uno.nbJoueurs() - 1){    //Si le joueur qui joue est le dernier, on repasse au premier
            assertEquals(uno.getNoJoueurPlay(),0);
        }
        else{
            assertEquals(indiceJoueur,uno.getNoJoueurPlay() - 1);
        }
    }

    @Test
    void distribuerCarteSuivant(){
        uno.initialiser(6);
        if(uno.getNoJoueurPlay() == uno.nbJoueurs() - 1){
            assertEquals(uno.getPlayers()[0].getPdc().getNombreDeCartes(),7);
        }
        else{
            assertEquals(uno.getPlayers()[uno.getNoJoueurPlay() + 1].getPdc().getNombreDeCartes(),7);
        }
        assertEquals(uno.getPioche().getNombreDeCartes(),108 - 6 * 7 - 1); //- 1 pour la défausse

        uno.distribuerCarteSuivant(1);

        if(uno.getNoJoueurPlay() == uno.nbJoueurs() - 1){
            assertEquals(uno.getPlayers()[0].getPdc().getNombreDeCartes(),8);
        }
        else{
            assertEquals(uno.getPlayers()[uno.getNoJoueurPlay() + 1].getPdc().getNombreDeCartes(),8);

        }
        assertEquals(uno.getPioche().getNombreDeCartes(),108 - 6 * 7 - 1 - 1);

        uno.distribuerCarteSuivant(0);

        if(uno.getNoJoueurPlay() == uno.nbJoueurs() - 1){
            assertEquals(uno.getPlayers()[0].getPdc().getNombreDeCartes(),8);
        }
        else{
            assertEquals(uno.getPlayers()[uno.getNoJoueurPlay() + 1].getPdc().getNombreDeCartes(),8);

        }
        assertEquals(uno.getPioche().getNombreDeCartes(),108 - 6 * 7 - 1 - 1);
    }
}