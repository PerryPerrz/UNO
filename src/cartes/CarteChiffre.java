package cartes;

public class CarteChiffre extends Carte {

    private int chiffre;

    public CarteChiffre(Uno uno,int valeur) {
        super(uno);
        this.setChiffre(valeur);
    }

    public CarteChiffre(Uno uno, Couleur couleur, int valeur) {
        super(uno, couleur);
        this.setChiffre(valeur);
    }

    public boolean peutEtreRecouverte(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    public int getValeur() {
        return this.chiffre;    //Ajoute le nombre de points qui est égal à la valeur de la carte.
    }

    public int effet() {
        return 0;   //0 correspond à une carte "sans effet"
    }

    public boolean peutEtrePoseeSur(CarteChiffre c) {
        return this.getCouleur() == c.getCouleur() || this.getValeur() == c.getValeur();
    }

    public boolean peutEtrePoseeSur(CarteChangementDeSens c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CarteJoker c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CartePasseTonTour c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CartePlus2 c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public boolean peutEtrePoseeSur(CartePlus4 c) {
        return this.estDeCouleurCompatible(c.getCouleur());
    }

    public void setChiffre(int valeur) {
        this.chiffre = valeur;
    }
}
