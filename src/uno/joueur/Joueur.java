package uno.joueur;

import uno.Uno;
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

    abstract void jouer(String coup);

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
}
