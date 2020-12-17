package uno.cartes;

import uno.Uno;

public class CartePasseTonTour extends Carte{

    public CartePasseTonTour(Uno uno) {
        super(uno);
    }

    public CartePasseTonTour(Uno uno, Couleur couleur) {
        super(uno, couleur);
    }

    public boolean peutEtreRecouverte(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    public int getValeur() {
        return 20;  //Ajoute 20 pts si on a encore cette carte dans la main à la fin du jeu
    }

    public int effet() {
        return 5;   //5 correspond à l'effet PasseTonTour
    }

    @Override
    public void appliquerEffet() {
        this.uno.changerDeJoueur();
    }

    public boolean peutEtrePoseeSur(CarteChiffre c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CarteChangementDeSens c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CarteJoker c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CartePasseTonTour c) {
        return true;
    }

    public boolean peutEtrePoseeSur(CartePlus2 c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CartePlus4 c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public String toString(){
        return "PasseTonTour" + this.getCouleur().getNom();
    }
}
