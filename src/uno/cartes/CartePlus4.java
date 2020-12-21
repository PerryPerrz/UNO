package uno.cartes;

import uno.Uno;

public class CartePlus4 extends Carte{

    public CartePlus4(Uno uno) {
        super(uno);
    }

    public boolean peutEtreRecouverte(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    public int getValeur() {
        return 50;  //Ajoute 50 pts si on a encore cette carte dans la main à la fin du jeu
    }

    public int effet() {
        return 4;   //4 correspond à l'effet Plus4
    }

    @Override
    public void appliquerEffet() {
        this.uno.distribuerCarteSuivant(4);
        this.uno.changerDeJoueur();
    }

    public boolean peutEtrePoseeSur(CarteChiffre c) {
        return true;
    }

    public boolean peutEtrePoseeSur(CarteChangementDeSens c) {
        return true;
    }

    public boolean peutEtrePoseeSur(CarteJoker c) {
        return true;
    }

    public boolean peutEtrePoseeSur(CartePasseTonTour c) {
        return true;
    }

    public boolean peutEtrePoseeSur(CartePlus2 c) {
        return true;
    }

    public boolean peutEtrePoseeSur(CartePlus4 c) {
        return true;
    }

    public String toString(){
        if(this.estSansCouleur()){
            return "Plus4 " + "PasDeCouleur";
        }
        else{
            return "Plus4 " + getCouleur().getNom();
        }
    }
}
