package uno;

import uno.cartes.FabriqueCartes;
import uno.joueur.Bot;
import uno.joueur.Joueur;
import uno.joueur.JoueurHumain;
import uno.cartes.PaquetDeCartes;

import java.util.Random;

public class Uno {

    private Joueur[] players;

    private PaquetDeCartes pioche;
    private PaquetDeCartes talon;
    private boolean sensHoraire;
    private int noJoueurDistrib;
    private int noJoueurPlay;

    public Uno(){

    }

    public void initialiser(int nbJoueur){
        assert(nbJoueur <= 10 && nbJoueur >= 2) : "Le nombre de joueurs n'est pas bon!";
        creerLesJoueurs(nbJoueur);
        distribuerCartes();
        choisirQuiDistribue();
        choisirQuiJoue();
    }

    public void creerLesJoueurs(int nbJoueur){
        this.players = new Joueur[nbJoueur];
        this.players[0] = new JoueurHumain(this, "Humain", 0);
        for(int i = 1 ; i < nbJoueur ; ++i){
            this.players[i] = new Bot(this,"Bot",i,1);
        }
    }

    public void distribuerCartes(){
        FabriqueCartes fab = FabriqueCartes.getInstance();
        this.pioche = FabriqueCartes.getPaquetUno();
        for(int i = 0 ; i < 7 ; ++ i){ //On donne 7 cartes par joueurs.
            for(int j = 0 ; j < this.nbJoueurs(); ++j){ //On parcours tous les joueurs.
                this.getPlayers()[j].getPdc().ajouter(pioche.piocher());
            }
        }
        this.talon = FabriqueCartes.getPaquetVide(); //Au début, le talon est un paquet vide
        this.talon.ajouter(pioche.piocher()); //Une fois que tous les joueurs ont pioché, je met la première carte dans le talon
    }

    public void choisirQuiDistribue(){
        Random random = new Random();
        this.noJoueurDistrib = random.nextInt(nbJoueurs());
    }

    public void choisirQuiJoue(){
        if(noJoueurDistrib == this.nbJoueurs()){ //Si on est au dernier uno.joueur, on revient au premier
           this.noJoueurPlay = 0;
        }
        else{
            this.noJoueurPlay = noJoueurDistrib + 1; //Le uno.joueur qui joue est celui qui suit le uno.joueur qui distribue
        }
    }

    public void changerSensDuJeu(){
        this.sensHoraire = !this.sensHoraire;
    }

    public void changerDeJoueur(){ //Le joueur actuel passe son tours
        if(noJoueurDistrib == this.nbJoueurs()){ //Si on est au dernier uno.joueur, on revient au premier
            this.noJoueurPlay = 0;
        }
        else{
            this.noJoueurPlay = this.noJoueurPlay + 1;
        }
    }

    public void distribuerCarteSuivant(int nb){ //On distribue le nombre de cartes aux joueurs suivants
        for(int i = 0 ; i < nb ; ++i){
            this.getPlayers()[i].getPdc().ajouter(pioche.piocher());
        }
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

    public PaquetDeCartes getPioche() {
        return pioche;
    }

    public PaquetDeCartes getTalon() {
        return talon;
    }

    public int nbJoueurs(){
        return this.players.length;
    }
}
