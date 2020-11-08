package cartes;

public class CartePlus2 extends Carte {

    public CartePlus2(Uno uno) {
        super(uno);
    }

    public CartePlus2(Uno uno, Couleur couleur) {
        super(uno, couleur);
    }

    public boolean peutEtreRecouverte(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    public int getValeur() {
        return 20;  //Ajoute 20 pts si on a encore cette carte dans la main à la fin du jeu
    }

    public int effet() {
        return 2;   //2 correspond à l'effet Plus2
    }

    public boolean peutEtrePoseeSur(CarteChiffre c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CarteChangementDeSens c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public  boolean peutEtrePoseeSur(CarteJoker c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CartePasseTonTour c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CartePlus2 c) {
        return true;
    }

    public boolean peutEtrePoseeSur(CartePlus4 c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }
}
