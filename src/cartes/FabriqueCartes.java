package cartes;

/**
 * Un singleton FabriqueCartes
 * 
 * @author Hugo Iopeti
 */

public class FabriqueCartes {
	private static FabriqueCartes instance = new FabriqueCartes();

	public static FabriqueCartes getInstance() {
		return instance;
	}

	public PaquetDeCartes getPaquetVide() {
		return new PaquetDeCartes();
	}

	public PaquetDeCartes getPaquet1Vert() {
		PaquetDeCartes paq = new PaquetDeCartes();
		paq.ajouter(new Carte(6, Couleur.VERT));
		return paq;
	}

	public PaquetDeCartes getPaquet5Vert() {
		PaquetDeCartes paq = new PaquetDeCartes();
		for (int i = 1; i <= 5; ++i) {
			paq.ajouter(new Carte(i, Couleur.VERT)); // Couleur est une énumération
		}
		return paq;
	}

	public PaquetDeCartes getPaquet32() {
		PaquetDeCartes paq = new PaquetDeCartes();
		for (int i = 1; i <= 8; ++i) { // Une boucle pour pour chaque couleur
			paq.ajouter(new Carte(i, Couleur.ROUGE)); // On ajoute 8 cartes rouges au paquet
		}
		for (int i = 1; i <= 8; ++i) {
			paq.ajouter(new Carte(i, Couleur.VERT));// On ajoute 8 cartes vertes au paquet
		}
		for (int i = 1; i <= 8; ++i) {
			paq.ajouter(new Carte(i, Couleur.BLEU));// On ajoute 8 cartes bleues au paquet
		}
		for (int i = 1; i <= 8; ++i) {
			paq.ajouter(new Carte(i, Couleur.JAUNE));// On ajoute 8 cartes jaunes au paquet
		}
		return paq;
	}
}
