package cartes;

import java.util.ArrayList;
import java.util.Collections;
import cartes.Carte;

/**
 * Une class PaquetDeCartes
 * 
 * @author Hugo Iopeti
 */

public class PaquetDeCartes {
	ArrayList<Carte> paquet;

	/**
	 * Constructeur d'un paquet de carte
	 */
	public PaquetDeCartes() {
		this.paquet = new ArrayList<>(32); // On initialise un paquet à 32 cartes
	}

	/**
	 * Ajoute une carte à un paquet de cartes
	 * 
	 * @param cartes la/les cartes à ajouter
	 */
	public void ajouter(Carte... cartes) { // ... = Soit on en prend une soit on en prend plusieurs (cartes de type Carte)
		for (Carte i : cartes) {
			this.paquet.add(i);
		}
	}

	/**
	 * Retourne le nombre de carte d'un paquet de cartes
	 * 
	 * @return un entier qui correspond au nombre de carte d'un paquet de cartes
	 */
	public int getNombreDeCartes() {
		int nb = 0;
		for (Carte i : this.paquet) {
			nb += 1;
		}
		return nb;
	}

	/**
	 * Retourne vrai si this est vide
	 * 
	 * @return vrai si this(paquet) est vide
	 */
	public boolean estVide() {
		return this.getNombreDeCartes() == 0;
	}

	/**
	 * Retourne la somme de toutes les cartes d'un paquet
	 * 
	 * @return Retourne un entier qui correspond à la somme de toutes les cartes
	 *         d'un paquet
	 */
	public int getValeur() {
		int nb = 0;
		for (Carte i : this.paquet) {
			nb += i.getValeur(); // On utilise la fonction getValeur() qui prend une carte
		}
		return nb;
	}

	public String toString() {
		StringBuilder str = new StringBuilder(this.getNombreDeCartes() * 30); // 29 caractères dans le toString de cartes + l'espace rajouté (dans mes tests pour des raisons de propretés)
		for (Carte i : this.paquet) {
			str.append(i.toString()).append(" "); // On rajoute i.toString et l'espace à la suite str.
		}
		return str.toString(); // str.toString() car on doit retourner un string donc on convertit str de type string builder en string
	}

	/**
	 * Ajoute un paquet de cartes à un paquet de cartes
	 * 
	 * @param pdc le paquet de cartes à ajouter
	 */
	public void ajouter(PaquetDeCartes pdc) { // On ajoute des paquets de cartes
		for (Carte i : pdc.paquet) { // paquet est une "enveloppe" qui contient pdc.
			this.paquet.add(i); // On ajoute les cartes du second paquet (pdc) dans le premier (this.paquet)
		}
	}

	/**
	 * melange le paquet
	 */
	public void melanger() {
		Collections.shuffle(this.paquet); //J'utilise la fonction "shuffle" de la bibliothèque collection
	}

	/**
	 * retourne le paquet
	 */
	public void retourner() {
		Collections.reverse(this.paquet); //J'utilise la fonction "reverse" de la bibliothèque collection
	}

	/**
	 * Retourne la carte située en haut du paquet de carte
	 * 
	 * @return Le sommet d'un paquet de carte
	 */
	public Carte getSommet() {
		if (this.estVide()){
			return null;
		}
		return this.paquet.get(0); // get(0) prend la carte à l'indice 0
	}

	/**
	 * Pioche une carte dans un paquet de carte.
	 * 
	 * @return La carte piochée
	 */
	public Carte piocher() {
		if (this.estVide()){
			return null;
		}
		Carte c1;
		c1 = this.paquet.get(0); // On stock la carte piochée
		this.paquet.remove(0); // On enlève la carte piochée au paquet
		return c1;
	}
}
