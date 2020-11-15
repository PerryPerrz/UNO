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

	public static PaquetDeCartes getPaquetVide() {
		return new PaquetDeCartes();
	}

	public static PaquetDeCartes getPaquet1Vert() {
		PaquetDeCartes paq = new PaquetDeCartes();
		Uno uno = new Uno();

		paq.ajouter(new CarteChiffre(uno,Couleur.VERT,6));
		return paq;
	}

	public static PaquetDeCartes getPaquet2Bleu() {
		PaquetDeCartes paq = new PaquetDeCartes();
		Uno uno = new Uno();

		paq.ajouter(new CarteChiffre(uno,Couleur.BLEU,1));
		paq.ajouter(new CarteChiffre(uno,Couleur.BLEU,3));
		return paq;
	}

	public static PaquetDeCartes getPaquet5Vert() {
		PaquetDeCartes paq = new PaquetDeCartes();
		Uno uno = new Uno();

		for (int i = 1; i <= 5; ++i) {
			paq.ajouter(new CarteChiffre(uno,Couleur.VERT,i)); // Couleur est une énumération
		}
		return paq;
	}

	public static PaquetDeCartes getPaquetUno() {
		PaquetDeCartes paq = new PaquetDeCartes();
		Uno uno = new Uno();

		paq.ajouter(new CarteChiffre(uno,Couleur.ROUGE,0)); //Un 0 par couleur
		paq.ajouter(new CarteChiffre(uno,Couleur.VERT,0));
		paq.ajouter(new CarteChiffre(uno,Couleur.BLEU,0));
		paq.ajouter(new CarteChiffre(uno,Couleur.JAUNE,0));
		for(int k = 1; k <= 4; ++k) {
			if(k == 1) {
				for (int i = 1; i <= 9; ++i) { // Une boucle pour pour chaque couleur
					paq.ajouter(new CarteChiffre(uno, Couleur.ROUGE, i)); // On ajoute 8 cartes rouges au paquet
					paq.ajouter(new CarteChiffre(uno, Couleur.ROUGE, i)); //Les cartes de 1 à 9 sont doublés dans un jeu de Uno
				}
			}
			if(k == 2) {
				for (int i = 1; i <= 9; ++i) {
					paq.ajouter(new CarteChiffre(uno, Couleur.VERT, i));// On ajoute 8 cartes vertes au paquet
					paq.ajouter(new CarteChiffre(uno, Couleur.VERT, i));
				}
			}
			if(k == 3) {
				for (int i = 1; i <= 9; ++i) {
					paq.ajouter(new CarteChiffre(uno, Couleur.BLEU, i));// On ajoute 8 cartes bleues au paquet
					paq.ajouter(new CarteChiffre(uno, Couleur.BLEU, i));
				}
			}
			if(k == 4) {
				for (int i = 1; i <= 9; ++i) {
					paq.ajouter(new CarteChiffre(uno, Couleur.JAUNE, i));// On ajoute 8 cartes jaunes au paquet
					paq.ajouter(new CarteChiffre(uno, Couleur.JAUNE, i));
				}
			}
		}
		for (int i = 1; i <= 4; ++i) {
			paq.ajouter(new CarteJoker(uno));// On ajoute les 4 Jokers
			paq.ajouter(new CartePlus4(uno));// On ajoute les 4 Plus4
		}
		for(int k = 1; k <= 4; ++k){
			if(k == 1){
					paq.ajouter(new CartePlus2(uno, Couleur.ROUGE));// On ajoute les Plus2 rouges
					paq.ajouter(new CartePlus2(uno, Couleur.ROUGE));
					paq.ajouter(new CarteChangementDeSens(uno, Couleur.ROUGE));// On ajoute les ChangementDeSens rouges
					paq.ajouter(new CarteChangementDeSens(uno, Couleur.ROUGE));
					paq.ajouter(new CartePasseTonTour(uno, Couleur.ROUGE));// On ajoute les PasseTonTour rouges
					paq.ajouter(new CartePasseTonTour(uno, Couleur.ROUGE));
			}
			if(k == 2){
					paq.ajouter(new CartePlus2(uno, Couleur.VERT));// On ajoute les Plus2 verts
					paq.ajouter(new CartePlus2(uno, Couleur.VERT));
					paq.ajouter(new CarteChangementDeSens(uno, Couleur.VERT));// On ajoute les ChangementDeSens verts
					paq.ajouter(new CarteChangementDeSens(uno, Couleur.VERT));
					paq.ajouter(new CartePasseTonTour(uno, Couleur.VERT));// On ajoute les PasseTonTour verts
					paq.ajouter(new CartePasseTonTour(uno, Couleur.VERT));
			}
			if(k == 3){
					paq.ajouter(new CartePlus2(uno, Couleur.BLEU));// On ajoute les Plus2 bleus
					paq.ajouter(new CartePlus2(uno, Couleur.BLEU));
					paq.ajouter(new CarteChangementDeSens(uno, Couleur.BLEU));// On ajoute les ChangementDeSens bleus
					paq.ajouter(new CarteChangementDeSens(uno, Couleur.BLEU));
					paq.ajouter(new CartePasseTonTour(uno, Couleur.BLEU));// On ajoute les PasseTonTour bleus
					paq.ajouter(new CartePasseTonTour(uno, Couleur.BLEU));
			}
			if(k == 4){
					paq.ajouter(new CartePlus2(uno, Couleur.JAUNE));// On ajoute les Plus2 jaunes
					paq.ajouter(new CartePlus2(uno, Couleur.JAUNE));
					paq.ajouter(new CarteChangementDeSens(uno, Couleur.JAUNE));// On ajoute les ChangementDeSens jaunes
					paq.ajouter(new CarteChangementDeSens(uno, Couleur.JAUNE));
					paq.ajouter(new CartePasseTonTour(uno, Couleur.JAUNE));// On ajoute les PasseTonTour jaunes
					paq.ajouter(new CartePasseTonTour(uno, Couleur.JAUNE));
			}
		}
		return paq;
	}
}