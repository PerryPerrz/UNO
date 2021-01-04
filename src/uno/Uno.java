package uno;

import uno.cartes.Carte;
import uno.cartes.Couleur;
import uno.cartes.FabriqueCartes;
import uno.dialogue.DialogueLigneDeCommande;
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
    private DialogueLigneDeCommande dialogue;

    public Uno(){
        sensHoraire = true;
    }

    public void initialiser(int nbJoueur){
        assert(nbJoueur <= 10 && nbJoueur >= 2) : "Le nombre de joueurs n'est pas bon!";
        creerLesJoueurs(nbJoueur);
        distribuerCartes();
        choisirQuiDistribue();
        choisirQuiJoue();
        sensHoraire = true;
    }

    public void creerLesJoueurs(int nbJoueur){
        this.players = new Joueur[nbJoueur];
        this.players[0] = new JoueurHumain(this, "Humain", 0);
        for(int i = 1 ; i < nbJoueur ; ++i){
            this.players[i] = new Bot(this,"Bot n° " + i,i,1);
        }
    }

    public void distribuerCartes(){
        FabriqueCartes fab = FabriqueCartes.getInstance();
        this.pioche = FabriqueCartes.getPaquetUno(this);
        this.pioche.melanger();
        for(int i = 0 ; i < 7 ; ++ i){ //On donne 7 cartes par joueurs.
            for(int j = 0 ; j < this.nbJoueurs(); ++j){ //On parcours tous les joueurs.
                this.getPlayers()[j].addCartePiochee();
            }
        }
        this.talon = FabriqueCartes.getPaquetVide(); //Au début, le talon est un paquet vide
        this.talon.ajouter(pioche.piocher()); //Une fois que tous les joueurs ont pioché, je met la première carte dans le talon
        if(this.getSommetTalon().effet() == 1 || this.getSommetTalon().effet() == 4){ //Si la première carte jouée est un joker/ un plus4, on lui donne une couleur aléatoire
            this.getSommetTalon().setCouleur(this.getCouleurRandom());
        }
    }

    public void choisirQuiDistribue(){
        Random random = new Random();
        this.noJoueurDistrib = random.nextInt(nbJoueurs());
    }

    public void choisirQuiJoue(){
        if(noJoueurDistrib == this.nbJoueurs() - 1){ //Si on est au dernier uno.joueur, on revient au premier
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
        if(sensHoraire){ //On change le joueur selon le sens horaire
            if(this.getNoJoueurPlay() == this.nbJoueurs() - 1){ //Si on est au dernier uno.joueur, on revient au premier
                this.noJoueurPlay = 0;
            }
            else{
                this.noJoueurPlay = this.getNoJoueurPlay() + 1;
            }
        }
        else{
            if(this.getNoJoueurPlay() == 0){ //Si on est au dernier uno.joueur, on revient au premier (dans le sens inverse)
                this.noJoueurPlay = this.nbJoueurs() - 1;
            }
            else{
                this.noJoueurPlay = this.getNoJoueurPlay() - 1;
            }
        }
    }

    public void distribuerCarteSuivant(int nb){ //On distribue le nombre de cartes aux joueurs suivants
        Carte car2;
        if(this.getPioche().estVide()){ //Si la pioche est vide
            car2 = this.getTalon().piocher();
            this.setPioche(this.getTalon());
            this.getPioche().retourner();
            //On supprime toutes les cartes de la défausse.
            for(int i = 0 ; i  < this.getTalon().getNombreDeCartes() ; ++i){
                this.getTalon().removeCarteIndex(0); //Indice 0 car Arraylist
            }
            this.getTalon().ajouter(car2);
        }
        if(sensHoraire){
            if(this.getNoJoueurPlay() == this.nbJoueurs() - 1){ //Je ne met pas le "if" dans la boucle for car je préfere que le programme effectue une seule fois la conditon if. (Je pense que c'est le mieux en terme d'optimisation)
                for (int i = 0; i < nb; ++i) {
                    this.getPlayers()[0].addCartePiochee();
                }
            }
            else {
                for (int i = 0; i < nb; ++i) {
                    this.getPlayers()[this.getNoJoueurPlay() + 1].addCartePiochee(); //+ 1, on ajoute les cartes au joueur suivant
                }
            }
        }
        else{
            if(this.getNoJoueurPlay() == 0){ //Je ne met pas le "if" dans la boucle for car je préfere que le programme effectue une seule fois la conditon if. (Je pense que c'est le mieux en terme d'optimisation)
                for (int i = 0; i < nb; ++i) {
                    this.getPlayers()[this.nbJoueurs() - 1].addCartePiochee();
                }
            }
            else {
                for (int i = 0; i < nb; ++i) {
                    this.getPlayers()[this.getNoJoueurPlay() - 1].addCartePiochee(); //- 1, on ajoute les cartes au joueur suivant
                }
            }
        }
    }

    public int nbJoueurs(){
        return this.players.length;
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

    public void setPioche(PaquetDeCartes pioche) {
        this.pioche = pioche;
    }

    public PaquetDeCartes getTalon() {
        return talon;
    }

    public boolean isSensHoraire() {
        return sensHoraire;
    }

    public void setDialogue(DialogueLigneDeCommande dialogue) {
        this.dialogue = dialogue;
    }

    public DialogueLigneDeCommande getDialogue() {
        return dialogue;
    }

    public boolean isPartieFinie(){
        for(int i = 0 ; i < this.nbJoueurs() - 1 ; ++i){
            if(this.getPlayers()[i].getPdc().estVide()){
                return true;
            }
        }
        return false;
    }

    public void jeu(){ //Boucle de jeu
        DialogueLigneDeCommande dialogue = new DialogueLigneDeCommande(this) ;
        this.setDialogue(dialogue);
        sensHoraire = !sensHoraire; //On doit appliquer l'effet sur le joueur actuel en se plaçant à un joueur qui précede le joueur actuel. (comme ça que les effets sont construit, on applique l'effet sur le joueur qui suit)
        changerDeJoueur(); //Par exemple, si la première carte du jeu est un plus 4, on simule le fait qu'une personne l'ai posé avant que le premier joueur commence la partie.
        this.getSommetTalon().appliquerEffet(); //On applique l'effet sur le joueur suivant
        sensHoraire = !sensHoraire; //On remet le sens de la partie au sensHoraire initial
        changerDeJoueur();
        dialogue.mettreAJour(); //On complète le dialogue
        while(!isPartieFinie()) {
            this.changerDeJoueur();
            dialogue.mettreAJour();
        }
        dialogue.mettreAJour(); //On complète le dialogue
    }

    public Carte getSommetTalon(){
        return this.getTalon().getSommet();
    }

    public int nbCartesJoueurPlay(){
        return this.getPlayers()[this.getNoJoueurPlay()].getPdc().getNombreDeCartes();
    }

    public Couleur getCouleurRandom(){
        Random random = new Random();
        int couleurRand = random.nextInt(3) + 1;
        switch(couleurRand){
            case 1 :
                return Couleur.ROUGE;
            case 2 :
                return Couleur.VERT;
            case 3 :
                return Couleur.BLEU;
            case 4 :
                return Couleur.JAUNE;
            default:
                throw new IllegalStateException("Unexpected value: " + couleurRand);
        }
    }

    public Joueur getCurrentPlayer(){
        return this.getPlayers()[this.getNoJoueurPlay()];
    }

    //Fonction qui retourne une carte du joueur actuel un indice donné.
    public String cardsCurrentPlayer(int indice){
        return this.getCurrentPlayer().getPdc().getCarteIndex(indice).toString();
    }
}
