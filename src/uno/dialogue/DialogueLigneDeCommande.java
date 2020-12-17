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
            System.out.println("Votre score est de :" + this.uno.getPlayers()[this.uno.getNoJoueurPlay()].getScore());
        }
        else{
            System.out.println("La carte au sommet du talon est : " + this.uno.getTalon().getSommet().toString());
            if(this.uno.getPlayers()[this.uno.getNoJoueurPlay()].isUnBot()){ //Si c'est le tour du bot
                try {
                    this.uno.getPlayers()[this.uno.getNoJoueurPlay()].jouer("");
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
                while(this.uno.getPlayers()[this.uno.getNoJoueurPlay()].getPdc().hasNext()){
                    System.out.println(this.uno.getPlayers()[this.uno.getNoJoueurPlay()].getPdc().next().toString());
                }
                System.out.println("Quel coup voulez-vous effectuer ?");
                coup = scanner.nextLine();
                while (joueurIncorrect){
                    try {
                        this.uno.getPlayers()[this.uno.getNoJoueurPlay()].jouer(coup);
                        joueurIncorrect = false;
                    } catch (CoupIncorrect coupIncorrect) {
                        System.out.println("Attention, le coup que vous demandez de faire est inexécutable!");
                        System.out.println("Veuillez rentrer un autre coup!");
                        scanner = new Scanner(System.in);
                        coup = scanner.nextLine();
                        joueurIncorrect = true;
                    }
                }
            }
        }
    }
}