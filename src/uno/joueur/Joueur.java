package uno.joueur;

import uno.Uno;
import uno.cartes.Carte;
import uno.cartes.PaquetDeCartes;

public abstract class Joueur {

    protected PaquetDeCartes pdc;
    protected Uno uno;
    protected String nom;
    protected int numero;

    public Joueur(Uno uno, String nom, int no) {
        this.pdc = new PaquetDeCartes();
        this.uno = uno;
        this.nom = nom;
        this.numero = no;
    }

    public abstract void jouer(String coup) throws CoupIncorrect;

    //Fonction qui retourne le score du joueur
    public int getScore(){
        int score = 0;
        while(this.getPdc().hasNext()){
            score += this.getPdc().next().getValeur();
        }
        return score;
    }

    //Fonction qui indique quel joueur est en train de jouer
    public abstract boolean isUnBot();

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Joueur").append(this.uno).append(this.nom).append(this.numero);
        return str.toString();
    }

    public PaquetDeCartes getPdc() {
        return pdc;
    }
    public String getNom() {
        return nom;
    }

    public void setPdc(PaquetDeCartes pdc) {
        this.pdc = pdc;
    }
}
