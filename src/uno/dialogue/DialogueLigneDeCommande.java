package uno.dialogue;

import uno.Uno;
import uno.joueur.CoupIncorrect;

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

    public void mettreAJour(){
        Scanner scanner = new Scanner(System.in);
        String coup;
        joueurIncorrect = true;
        if(this.uno.isPartieFinie()){ //Si la partie est finie
            System.out.println("Votre score est de : " + this.uno.getPlayers()[0].getScore());
            for(int i = 1 ; i < this.nbJoueur ; ++i){
                System.out.println("Le score du bot n°" + i + " est : " + this.uno.getPlayers()[i].getScore());
            }
        }
        else{
            System.out.println("La carte au sommet du talon est : " + this.uno.getSommetTalon().toString());
            if(this.uno.getCurrentPlayer().isUnBot()){ //Si c'est le tour du bot
                System.out.println("Le " + this.uno.getCurrentPlayer().getNom() + " joue!");
                System.out.println("Le bot possède : " + this.uno.nbCartesJoueurPlay() + " cartes!");
                try {
                    this.uno.getCurrentPlayer().jouer("");
                    try {
                        Thread.sleep(1000); //On fait une pause après le tour du bot
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (CoupIncorrect coupIncorrect) {
                    coupIncorrect.printStackTrace();
                }
            }
            else { //C'est le tour du joueur
                System.out.println("Votre main : ");
                for(int i = 0 ; i < this.uno.nbCartesJoueurPlay() ; ++i){
                    System.out.println("Carte n° " + i + " : " + this.uno.cardsCurrentPlayer(i));
                }
                System.out.println("Quel coup voulez-vous effectuer ?");
                coup = scanner.nextLine();
                while (joueurIncorrect){
                    try {
                        this.uno.getCurrentPlayer().jouer(coup);
                        joueurIncorrect = false;
                    } catch (CoupIncorrect coupIncorrect) {
                        System.out.println(coupIncorrect.getMessage() + "\nVeuillez rentrer un autre coup!" );
                        scanner = new Scanner(System.in);
                        coup = scanner.nextLine();
                        joueurIncorrect = true;
                    }
                }
            }
        }
    }

    public void affichagePTT(){
        System.out.println("Vous devez passer votre tour!");
    }

    public void affichagePiocheBot(){
        System.out.println("Le bot a pioché!");
    }
}