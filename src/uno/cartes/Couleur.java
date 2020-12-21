package uno.cartes;

/**
 * La class Couleur
 * 
 * @author Hugo Iopeti
 */

public enum Couleur {
	ROUGE("Rouge"), VERT("Vert"), BLEU("Bleu"), JAUNE("Jaune");

	private final String nom;

	Couleur(String nomColor) {
		boolean b;
		b = (nomColor.equals("Rouge") || nomColor.equals("Vert") || nomColor.equals("Bleu")
				|| nomColor.equals("Jaune")); // Quand on veut comparer 2 chaines de caractères on utilise "equals" et non "=="
		assert (b) : "Le champ nom est faux";
		this.nom = nomColor;
	}

	public String getNom() {
		return this.nom;
	}
}
