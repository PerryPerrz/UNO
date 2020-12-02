package cartes;

public class Uno {

    private Joueur[] players;
    private PaquetDeCartes pdc;

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

    }

    public void choisirQuiJoue(){

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
}
