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

    public void appliquerEffet(){
        int effect = this.effet();
        switch(effect){
            case 0 : //On ne doit rien faire.
                break;
            case 1 :
                this.getUno().Joker(); //Car Joker() est une fonction de uno.Uno
                break;
            case 2 :
                this.getUno().Plus2(); //Car Plus2() est une fonction de uno.Uno
                break;
            case 3 :
                this.getUno().ChangementDeSens(); //Car ChangementDeSens() est une fonction de uno.Uno
                break;
            case 4 :
                this.getUno().Plus4(); //Car Plus4() est une fonction de uno.Uno
                break;
            case 5 :
                this.getUno().PasseTonTour(); //Car PasseTonTour() est une fonction de uno.Uno
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + effect);
        }
    }

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