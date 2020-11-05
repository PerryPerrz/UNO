package cartes;

/**
 * La class Carte
 */

public class Carte {

    private int valeur;

    private Couleur couleur;

    public Carte(int valeur, Couleur couleur) {
        boolean b;
        this.valeur = valeur;
        this.couleur = couleur;
        b = valeur <= 8 && valeur >= 1;
        assert (b) : "Parametre incorrect(Carte)";
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        boolean b;
        this.couleur = couleur;
        b = valeur <= 8 && valeur >= 1;
        assert (b) : "Parametre incorrect (setCouleur)";
    }

    public String toString() {
        return "Carte{" + "valeur=" + valeur + ", couleur=" + couleur + '}';
    }

}
