package uno.joueur;

import uno.Uno;
import uno.cartes.Carte;
import uno.cartes.Couleur;

import java.util.Random;

public class Bot extends Joueur {

    public Bot(Uno uno, String nom, int no, int difficulte){
        super(uno,nom,no);
    }

    @Override
    public void jouer(String coup){
        Carte car2;
        Random random = new Random();
        int nb,cpt;
        cpt = 0;
        boolean cartePasTrouvee = true;
        boolean cartePosee = false;
        while(cpt < this.getPdc().getNombreDeCartes() && cartePasTrouvee){
            cartePasTrouvee = !(this.uno.getSommetTalon().peutEtreRecouverte(pdc.getCarteIndex(cpt)));
            cpt += 1;
        }
        cpt -= 1; //Exemple, si la première carte que l'on veut poser est posable, cartePasTrouvee = false, on incrémente cpt, puis sort de la boucle, or cpt "pointe" la carte d'après, il faut donc lui soustraire 1.
        if(cartePasTrouvee) {
            if(uno.getPioche().estVide()){ //Si la pioche est vide
                car2 = uno.getTalon().piocher();
                uno.setPioche(uno.getTalon());
                uno.getPioche().retourner();
                //On supprime toutes les cartes de la défausse.
                for(int i = 0 ; i  < uno.getTalon().getNombreDeCartes() ; ++i){
                    uno.getTalon().removeCarteIndex(0); //Indice 0 car Arraylist
                }
                uno.getTalon().ajouter(car2);
            }
            this.getPdc().ajouter(uno.getPioche().piocher());
            this.uno.getDialogue().affichagePiocheBot();
            if (this.uno.getSommetTalon().peutEtreRecouverte(this.getPdc().getSommet())) {
                this.uno.getTalon().ajouter(this.getPdc().piocher()); //On ajoute la carte du joueur sur le talon et retire la carte de la main du joueur (piocher)
                this.uno.getSommetTalon().appliquerEffet();
                cartePosee = true;
            }
        }
        else{
            this.uno.getTalon().ajouter(this.getPdc().getCarteIndex(cpt));
            this.getPdc().removeCarteIndex(cpt);
            this.uno.getSommetTalon().appliquerEffet();
            cartePosee = true;
        }
        if(this.uno.getSommetTalon().estSansCouleur() && cartePosee){
           uno.getSommetTalon().setCouleur(uno.getCouleurRandom());
        }
    }

    @Override
    public boolean isUnBot() {
        return true;
    }
}
