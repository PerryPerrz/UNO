package uno.dialogue;

import uno.Uno;

import java.util.Scanner;

public class DialogueLigneDeCommande {
    Uno uno;
    int nbJoueur;
    boolean joueurIncorrect;
    public DialogueLigneDeCommande(Uno uno){
        this.uno = uno;
        joueurIncorrect = true;
        Scanner scanner = new Scanner(System.in);
        while(joueurIncorrect) {
            System.out.println("Bienvenue ! Prenez une chaise et installez vous ! Le Uno va commencer!");
            System.out.println("Combien de joueurs êtes-vous ? (entre 2 et 10)");
            nbJoueur = scanner.nextInt();

            if (nbJoueur <= 10 && nbJoueur >= 2) {
                joueurIncorrect = false;
            }
            else{
                System.out.print("\nAttention, le nombre de joueur est incorrect!, veuillez recommencer!");
                scanner = new Scanner(System.in);
            }
        }
        //Difficulté du joueur.

        //Lancement du jeu.
        uno.initialiser(nbJoueur);
    }
}