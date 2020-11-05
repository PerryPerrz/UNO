package tests;

import cartes.FabriqueCartes;
import cartes.Couleur;
import cartes.Carte;
import cartes.PaquetDeCartes;

/**
 * Un fichier de test pour la class PaquetDeCartes
 * 
 * @author Hugo Iopeti
 */

public class TestPaquetDeCartes {

	public static void main(String[] args) {
		testGetNombreDeCartes();
		testEstVideVrai();
		testEstVideFaux();
		testGetValeur();
		testToString();
		testAjouterCarte();
		testAjouterPaquet();
		testMelanger();
		testRetourner();
		testGetSommet();
		testPiocher();
	}

	public static void testGetNombreDeCartes() {
		boolean b;
		FabriqueCartes fabc = FabriqueCartes.getInstance();

		// Test avec un paquetVide
		b = fabc.getPaquetVide().getNombreDeCartes() == 0;
		assert (b) : "La fonction getNombreDeCartes est fausse (avec un paquet vide)";

		// Test avec un paquet de 1 carte verte
		b = fabc.getPaquet1Vert().getNombreDeCartes() == 1;
		assert (b) : "La fonction getNombreDeCartes est fausse (avec un paquet de 1 carte verte";

		// Test avec un paquet de 5 cartes vertes
		b = fabc.getPaquet5Vert().getNombreDeCartes() == 5;
		assert (b) : "La fonction getNombreDeCartes() est fausse (avec un paquet de 5 cartes vertes";

		// Test avec un paquet de 32 cartes
		b = fabc.getPaquet32().getNombreDeCartes() == 32;
		assert (b) : "La fonction getNombreDeCartes() est fausse (avec un paquet de 32 cartes";
	}

	public static void testEstVideVrai() {
		boolean b;
		FabriqueCartes fabc = FabriqueCartes.getInstance();

		// Test avec un paquetVide
		b = fabc.getPaquetVide().estVide();
		assert (b) : "La fonction estVide() est fausse (avec un paquet vide)";
	}

	public static void testEstVideFaux() {
		boolean b;
		FabriqueCartes fabc = FabriqueCartes.getInstance();

		// Test avec un paquet de 1 carte verte
		b = fabc.getPaquet1Vert().estVide();
		assert (!b) : "La fonction estVide() est fausse (avec un paquet de 1 carte)";

		// Test avec un paquet de 5 cartes vertes
		b = fabc.getPaquet5Vert().estVide();
		assert (!b) : "La fonction estVide() est fausse (avec un paquet de 5 cartes vertes";

		// Test avec un paquet de 32 cartes
		b = fabc.getPaquet32().estVide();
		assert (!b) : "La fonction estVide() est fausse (avec un paquet de 32 cartes";
	}

	public static void testGetValeur() {
		boolean b;
		FabriqueCartes fabc = FabriqueCartes.getInstance();

		// Test avec un paquetVide
		b = fabc.getPaquetVide().getValeur() == 0;
		assert (b) : "La fonction getValeur est fausse (avec un paquet vide)";

		// Test avec un paquet de 1 carte verte
		b = fabc.getPaquet1Vert().getValeur() == 6;
		assert (b) : "La fonction getValeur est fausse (avec un paquet de 1 carte verte";

		// Test avec un paquet de 5 cartes vertes
		b = fabc.getPaquet5Vert().getValeur() == 15;
		assert (b) : "La fonction getValeur est fausse (avec un paquet de 5 cartes vertes";

		// Test avec un paquet de 32 cartes
		b = fabc.getPaquet32().getValeur() == 144;
		assert (b) : "La fonction getValeur est fausse (avec un paquet de 32 cartes";
	}

	public static void testToString() {
		boolean b;
		FabriqueCartes fabc = FabriqueCartes.getInstance();

		// Test avec un paquet vide
		b = fabc.getPaquetVide().toString().equals("");
		assert (b) : "La fonction toString est fausse (avec un paquet vide)";

		// Test avec un paquet de 1 carte verte
		b = fabc.getPaquet1Vert().toString().equals("Carte{valeur=6, couleur=VERT} ");
		assert (b) : "La fonction toString est fausse (avec un paquet de 1 carte)";

		// Test avec un paquet de 5 cartes vertes
		b = fabc.getPaquet32().toString().equals(
				"Carte{valeur=1, couleur=ROUGE} Carte{valeur=2, couleur=ROUGE} Carte{valeur=3, couleur=ROUGE} Carte{valeur=4, couleur=ROUGE} Carte{valeur=5, couleur=ROUGE} Carte{valeur=6, couleur=ROUGE} Carte{valeur=7, couleur=ROUGE} Carte{valeur=8, couleur=ROUGE} Carte{valeur=1, couleur=VERT} Carte{valeur=2, couleur=VERT} Carte{valeur=3, couleur=VERT} Carte{valeur=4, couleur=VERT} Carte{valeur=5, couleur=VERT} Carte{valeur=6, couleur=VERT} Carte{valeur=7, couleur=VERT} Carte{valeur=8, couleur=VERT} Carte{valeur=1, couleur=BLEU} Carte{valeur=2, couleur=BLEU} Carte{valeur=3, couleur=BLEU} Carte{valeur=4, couleur=BLEU} Carte{valeur=5, couleur=BLEU} Carte{valeur=6, couleur=BLEU} Carte{valeur=7, couleur=BLEU} Carte{valeur=8, couleur=BLEU} Carte{valeur=1, couleur=JAUNE} Carte{valeur=2, couleur=JAUNE} Carte{valeur=3, couleur=JAUNE} Carte{valeur=4, couleur=JAUNE} Carte{valeur=5, couleur=JAUNE} Carte{valeur=6, couleur=JAUNE} Carte{valeur=7, couleur=JAUNE} Carte{valeur=8, couleur=JAUNE} ");
		assert (b) : "La fonction toString est fausse (avec un paquet de 32 cartes)";
	}

	public static void testAjouterCarte() {
		boolean b;
		PaquetDeCartes p1;

		// Test avec un paquet de 1 carte verte
		FabriqueCartes fabc = FabriqueCartes.getInstance();
		p1 = fabc.getPaquetVide();
		p1.ajouter(new Carte(6, Couleur.VERT));

		b = !p1.estVide() && p1.getValeur() == 6 && p1.getNombreDeCartes() == 1;
		assert (b) : "La fonction ajouter carte est fausse (avec un paquet de 1 carte)";

		// Test avec un paquet de 5 cartes
		p1 = fabc.getPaquetVide();

		for (int i = 1; i <= 5; ++i) {
			p1.ajouter(new Carte(i, Couleur.VERT));
		}

		b = !p1.estVide() && p1.getValeur() == 15 && p1.getNombreDeCartes() == 5;
		assert (b) : "La fonction ajouter carte est fausse (avec un paquet de 5 cartes)";
	}

	public static void testAjouterPaquet() {
		boolean b;
		PaquetDeCartes p1, p2;

		// Test avec un paquet de 1 carte verte
		FabriqueCartes fabc = FabriqueCartes.getInstance();
		p1 = fabc.getPaquetVide();
		p2 = fabc.getPaquet1Vert();
		p1.ajouter(p2); // p2 -> p1

		b = !p1.estVide() && p1.getNombreDeCartes() == 1 && p1.getValeur() == 6;
		assert (b) : "La fonction ajouter carte est fausse (avec un paquet de 1 carte)";

		// Test avec un paquet de 5 cartes
		p1 = fabc.getPaquetVide();
		p2 = fabc.getPaquet5Vert();
		p1.ajouter(p2);

		b = !p1.estVide() && p1.getNombreDeCartes() == 5 && p1.getValeur() == 15;
		assert (b) : "La fonction ajouter carte est fausse (avec un paquet de 5 cartes)";
	}

	public static void testMelanger() {
		// Je test la fonction melanger, or étant donné que j'utilise la fonction
		// shuffle de la bibliothèque collection, et que je ne peux pas comparer 2
		// cartes
		// 1 à 1 ou bien 2 paquets 1 a 1, je peux seulement regarder si melanger ne
		// supprime ou n'ajoute pas de cartes.
		boolean b;
		PaquetDeCartes p1;

		// Test avec un paquet de 5 cartes
		FabriqueCartes fabc = FabriqueCartes.getInstance();
		p1 = fabc.getPaquet5Vert();
		p1.melanger();
		b = p1.getNombreDeCartes() == 5 && p1.getValeur() == 15;
		assert (b) : "La fonction melanger carte est fausse (avec un paquet de 5 cartes)";
	}

	public static void testRetourner() {
		// Je test la fonction retourner, or étant donné que j'utilise la fonction
		// reverse de la bibliothèque collection, et que je ne peux pas comparer 2
		// cartes 1 à 1 ou bien 2 paquets 1 a 1, je peux seulement regarder si retourner
		// ne supprime ou n'ajoute pas de cartes.
		boolean b;
		PaquetDeCartes p1;

		// Test avec un paquet de 5 cartes
		FabriqueCartes fabc = FabriqueCartes.getInstance();
		p1 = fabc.getPaquet5Vert();
		p1.retourner();
		b = p1.getNombreDeCartes() == 5 && p1.getValeur() == 15;
		assert (b) : "La fonction retourner carte est fausse (avec un paquet de 5 cartes)";
	}

	public static void testGetSommet() {
		boolean b;
		Carte c1;
		PaquetDeCartes p1;
		FabriqueCartes fabc = FabriqueCartes.getInstance();

		// Test avec un paquet de 1 carte verte
		p1 = fabc.getPaquet1Vert();
		c1 = p1.getSommet();
		b = !p1.estVide() && p1.getNombreDeCartes() == 1 && c1.getCouleur() == Couleur.VERT && c1.getValeur() == 6;
		assert (b) : "La fonction getSommet est fausse (avec un paquet de 1 carte)";

		// Test avec un paquet de 5 cartes vertes
		p1 = fabc.getPaquet5Vert();
		c1 = p1.getSommet();
		b = !p1.estVide() && p1.getNombreDeCartes() == 5 && c1.getCouleur() == Couleur.VERT && c1.getValeur() == 1;
		assert (b) : "La fonction getSommet est fausse (avec un paquet de 5 cartes vertes)";

		// Test avec un paquet de 32 cartes
		p1 = fabc.getPaquet32();
		c1 = p1.getSommet();
		b = !p1.estVide() && p1.getNombreDeCartes() == 32 && c1.getCouleur() == Couleur.ROUGE && c1.getValeur() == 1;
		assert (b) : "La fonction getSommet est fausse (avec un paquet de 32 cartes)";
	}

	public static void testPiocher() {
		boolean b;
		Carte c1;
		PaquetDeCartes p1;
		FabriqueCartes fabc = FabriqueCartes.getInstance();

		// Test avec un paquet de 1 carte verte
		p1 = fabc.getPaquet1Vert();
		c1 = p1.piocher();
		b = p1.estVide() && c1.getCouleur() == Couleur.VERT && c1.getValeur() == 6;
		assert (b) : "La fonction piocher est fausse (avec un paquet de 1 carte)";

		// Test avec un paquet de 5 cartes vertes
		p1 = fabc.getPaquet5Vert();
		c1 = p1.piocher();
		b = !p1.estVide() && p1.getNombreDeCartes() == 4 && c1.getCouleur() == Couleur.VERT && c1.getValeur() == 1;
		assert (b) : "La fonction piocher est fausse (avec un paquet de 1 carte)";

		// Test avec un paquet de 32 cartes
		p1 = fabc.getPaquet32();
		c1 = p1.piocher();
		b = !p1.estVide() && p1.getNombreDeCartes() == 31 && c1.getCouleur() == Couleur.ROUGE && c1.getValeur() == 1;
		assert (b) : "La fonction piocher est fausse (avec un paquet de 1 carte)";
	}
}
