package cartes;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Une class PaquetDeCartes
 * 
 * @author Hugo Iopeti
 */

public class PaquetDeCartes {
	private ArrayList<Carte> paquet;

	/**
	 * Constructeur d'un paquet de carte
	 */
	public PaquetDeCartes() {
		this.paquet = new ArrayList<>(108); // On initialise un paquet à 108 cartes (un jeu complet de Uno)
	}

	/**
	 * Ajoute une carte à un paquet de cartes
	 *
	 * @param cartes la/les cartes à ajouter
	 */
	public void ajouter(Carte... cartes) { // ... = Soit on en prend une soit on en prend plusieurs (cartes de type Carte)
		Collections.addAll(this.paquet, cartes);
	}

	/**
	 * Retourne le nombre de carte d'un paquet de cartes
	 *
	 * @return un entier qui correspond au nombre de carte d'un paquet de cartes
	 */
	public int getNombreDeCartes() {
		int nb = 0;
		for (Carte ignored : this.paquet) {
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
	 * d'un paquet
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
		// paquet est une "enveloppe" qui contient pdc.
		// On ajoute les cartes du second paquet (pdc) dans le premier (this.paquet)
		this.paquet.addAll(pdc.paquet);
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
		if (this.estVide()) {
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
		if (this.estVide()) {
			return null;
		}
		Carte c1;
		c1 = this.paquet.get(0); // On stock la carte piochée
		this.paquet.remove(0); // On enlève la carte piochée au paquet
		return c1;
	}

	/**
	 * Ecrire toutes les cartes du paquet dans le fichier dont le nom est passé en paramètre
	 *
	 * @param nomDeFichier fichier qui contiendra toutes les cartes du paquet
	 */
	public void ecrire(String nomDeFichier) throws ErreurFichier { //Peut importe ce qu'il se passe dans cette fonction, si il trouve "ErreurFichier", il renvoit cette erreur.
		BufferedWriter flotFiltre;
		FileWriter flot;
		File chemin = new File("/home/hugo/IdeaProjects/projetBPO/src" + nomDeFichier);
		boolean estLa = chemin.exists();
		if (!estLa) {
			try {
				flot = new FileWriter(nomDeFichier);
				flotFiltre = new BufferedWriter(flot);
				for (int i = 0; i < this.getNombreDeCartes(); ++i) { //On parcourt toutes les cartes du jeu de uno
					switch (this.paquet.get(i).effet()) { //On regarde l'effet de la carte d'indice i située dans le paquet
						case 0:
							flotFiltre.write(this.paquet.get(i).getValeur() + "" + " " + this.paquet.get(i).getCouleur().toString()); //On convertit le int en string
							break;
						case 1:
							flotFiltre.write("Joker NoColor"); //On affiche le nom des cartes "bonus"
							break;
						case 2:
							flotFiltre.write("Plus2" + " " + this.paquet.get(i).getCouleur().toString());
							break;
						case 3:
							flotFiltre.write("ChangementDeSens" + " " + this.paquet.get(i).getCouleur().toString());
							break;
						case 4:
							flotFiltre.write("Plus4 NoColor");
							break;
						case 5:
							flotFiltre.write("PasseTonTour" + " " + this.paquet.get(i).getCouleur().toString());
							break;
					}
					flotFiltre.newLine();
				}
				flotFiltre.close();
			} catch (IOException e) {
				System.out.println("Impossible de créer le fichier");
			}
		} else {
			throw new ErreurFichier("Attention, le fichier existe déja!");
		}
	}

	/**
	 * Initialiser un paquet de cartes avec toutes les cartes décrites dans le fichier dont le nom est passé en paramètre
	 *
	 * @param nomDeFichier fichier qui contient toutes les cartes du paquet
	 */
	public void lire(String nomDeFichier) throws ErreurFichier {
		BufferedReader flot = null;
		File chemin = new File("/home/hugo/IdeaProjects/Flots/" + nomDeFichier);
		boolean estLa = chemin.exists();
		if (estLa) {
			try {
				flot = new BufferedReader(new FileReader(nomDeFichier));
			} catch (Exception e) {
				e.printStackTrace();
			}
			Scanner filtre = null;
			if (flot != null) {
				filtre = new Scanner(flot);
			}
			Uno uno = new Uno();
			int nb; //On doit passer par une variable intermediaire car sinon, en faisant "next", on passe aux suivants et donc, on évite des valeurs/on va beaucoup trop loin.
			String str; //Une second variable intermediaire
			if (filtre != null) {
				while (filtre.hasNext()) {
					if (filtre.hasNextInt()) {
						nb = filtre.nextInt();	//next = prend la valeur qui est en train d'être lu et on passe au prochain
						switch (filtre.next()) {	//On prend un entier, on le stock, on passe au truc suivant, c'est une couleur, on fait le switch, on passe au truc suivant. (Le buffer passe au suivant, pas le code)
							case "ROUGE":
								this.ajouter(new CarteChiffre(uno, Couleur.ROUGE, nb));
								break;
							case "VERT":
								this.ajouter(new CarteChiffre(uno, Couleur.VERT, nb));
								break;
							case "BLEU":
								this.ajouter(new CarteChiffre(uno, Couleur.BLEU, nb));
								break;
							case "JAUNE":
								this.ajouter(new CarteChiffre(uno, Couleur.JAUNE, nb));
								break;
							default:
								throw new ErreurFichier("Le fichier n'existe pas");
						}
					}
					str = filtre.next();
					if (str.equals("Joker")) {
						this.ajouter(new CarteJoker(uno));
						filtre.next(); //Pour passer le string "NoColor"
					}
					if (str.equals("Plus2")) {
						switch (filtre.next()) {
							case "ROUGE":
								this.ajouter(new CartePlus2(uno, Couleur.ROUGE));
								break;
							case "VERT":
								this.ajouter(new CartePlus2(uno, Couleur.VERT));
								break;
							case "BLEU":
								this.ajouter(new CartePlus2(uno, Couleur.BLEU));
								break;
							case "JAUNE":
								this.ajouter(new CartePlus2(uno, Couleur.JAUNE));
								break;
							default:
								throw new ErreurFichier("Le fichier n'existe pas");
						}
					}
					if (str.equals("ChangementDeSens")) {
						switch (filtre.next()) {
							case "ROUGE":
								this.ajouter(new CarteChangementDeSens(uno, Couleur.ROUGE));
								break;
							case "VERT":
								this.ajouter(new CarteChangementDeSens(uno, Couleur.VERT));
								break;
							case "BLEU":
								this.ajouter(new CarteChangementDeSens(uno, Couleur.BLEU));
								break;
							case "JAUNE":
								this.ajouter(new CarteChangementDeSens(uno, Couleur.JAUNE));
								break;
							default:
								throw new ErreurFichier("Le fichier n'existe pas");
						}
					}
					if (str.equals("Plus4")) {
						this.ajouter(new CartePlus4(uno));
						filtre.next(); //Pour passer le string "NoColor"
					}
					if (str.equals("PasseTonTour")) {
						switch (filtre.next()) {
							case "ROUGE":
								this.ajouter(new CartePasseTonTour(uno, Couleur.ROUGE));
								break;
							case "VERT":
								this.ajouter(new CartePasseTonTour(uno, Couleur.VERT));
								break;
							case "BLEU":
								this.ajouter(new CartePasseTonTour(uno, Couleur.BLEU));
								break;
							case "JAUNE":
								this.ajouter(new CartePasseTonTour(uno, Couleur.JAUNE));
								break;
							default:
								throw new ErreurFichier("Le fichier n'existe pas");
						}
					}
				}
			} else {
				throw new ErreurFichier("Le fichier n'existe pas");
			}
		}
	}
}