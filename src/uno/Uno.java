package uno;

import uno.joueur.Bot;
import uno.joueur.Joueur;
import uno.joueur.JoueurHumain;
import uno.cartes.PaquetDeCartes;

import java.util.Random;

public class Uno {

    private Joueur[] players;
    private PaquetDeCartes pdc;
    private boolean sensHoraire;
    private int noJoueurDistrib;
    private int noJoueurPlay;

    public Uno(){

    }

    public void init(int nbJoueur){
        creerLesJoueurs(nbJoueur);
        distribuerCartes();
        choisirQuiDistribue();
        choisirQuiJoue();
    }

    public void creerLesJoueurs(int nbJoueur){
        players = new Joueur[nbJoueur];
        players[0] = new JoueurHumain(this, "Humain", 0);
        for(int i = 1 ; i < nbJoueur ; ++i){
            players[i] = new Bot(this,"Bot",i,1);
        }
    }

    public void distribuerCartes(){

    }

    public void choisirQuiDistribue(){
        Random random = new Random();
        noJoueurDistrib = random.nextInt(nbJoueurs());
    }

    public void choisirQuiJoue(){
        if(noJoueurDistrib == this.getPlayers().length){ //Si on est au dernier uno.joueur, on revient au premier
            noJoueurPlay = 0;
        }
        else{
            noJoueurPlay = noJoueurDistrib + 1; //Le uno.joueur qui joue est celui qui suit le uno.joueur qui distribue
        }
    }

    public void Joker(){

    }

    public void Plus2(){

    }

    public void ChangementDeSens(){

    }

    public void Plus4(){

    }

    public void PasseTonTour(){

    }

    public Joueur[] getPlayers() {
        return players;
    }

    public int getNoJoueurDistrib() {
        return noJoueurDistrib;
    }

    public int getNoJoueurPlay() {
        return noJoueurPlay;
    }

    public int nbJoueurs(){
        return this.players.length;
    }
}
