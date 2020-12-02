package uno.cartes;

import uno.Uno;

/**
 * La class abstraite Carte
 */

public abstract class Carte {

    protected Uno uno;
    protected Couleur couleur;

    public Carte(Uno uno) { //Carte sans couleur
        this.setUno(uno);
        this.setCouleur(null);
    }

    public Carte(Uno uno, Couleur couleur){  //Carte avec couleur
        this.setUno(uno);
        this.setCouleur(couleur);
    }

    abstract boolean peutEtreRecouverte(Carte c);

    abstract int getValeur();

    abstract int effet();

    public boolean estSansCouleur(){
        return this.getCouleur().equals(null);
    }

    public abstract void appliquerEffet();

    public boolean estDeCouleurCompatible(Couleur c){
        return this.getCouleur() == c;
    }

    public abstract boolean peutEtrePoseeSur(CarteChiffre c);

    public abstract boolean peutEtrePoseeSur(CarteChangementDeSens c);

    abstract boolean peutEtrePoseeSur(CarteJoker c);

    abstract boolean peutEtrePoseeSur(CartePasseTonTour c);

    abstract boolean peutEtrePoseeSur(CartePlus2 c);

    abstract boolean peutEtrePoseeSur(CartePlus4 c);
/*
    public String toString() {
        return "Carte{" + "valeur =" + valeur + ", couleur =" + couleur + '}';
    }*/

   protected void setUno(Uno uno) {
        this.uno = uno;
    }

    protected Couleur getCouleur() {
        return couleur;
    }

    protected void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    protected Uno getUno() {
        return uno;
    }
}