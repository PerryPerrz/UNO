package uno.cartes;

import uno.Uno;

public class CarteJoker extends Carte{

    public CarteJoker(Uno uno) {
        super(uno);
    }

    public boolean peutEtreRecouverte(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    public int getValeur() {
        return 50;  //Ajoute 50 pts si on a encore cette carte dans la main à la fin du jeu
    }

    public int effet() {
        return 1;   //1 correspond à l'effet Joker
    }

    @Override
    public void appliquerEffet() {
        //On peut appliquer aucun effet pour Joker
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
            return "Joker " + "PasDeCouleur";
        }
        else{
            return "Joker " + getCouleur().getNom();
        }
    }
}
