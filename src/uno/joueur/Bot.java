package uno.joueur;

import uno.Uno;
import uno.cartes.Couleur;

import java.util.Random;

public class Bot extends Joueur {

    public Bot(Uno uno, String nom, int no, int difficulte){
       super(uno,nom,no);

    }

    @Override
    public void jouer(String coup){
        Random random = new Random();
        int nb,cpt;
        cpt = 0;
        boolean cartePasTrouvee = true;
        boolean cartePosee = false;
        while(cpt < this.getPdc().getNombreDeCartes() && cartePasTrouvee){
            cartePasTrouvee = !(this.uno.getTalon().getSommet().peutEtreRecouverte(pdc.getCarteIndex(cpt)));
            cpt += 1;
        }
        if(cartePasTrouvee) {
            this.getPdc().ajouter(uno.getPioche().piocher());
            if (this.uno.getTalon().getSommet().peutEtreRecouverte(this.getPdc().getSommet())) {
                this.uno.getTalon().ajouter(this.getPdc().piocher()); //On ajoute la carte du joueur sur le talon et retire la carte de la main du joueur (piocher)
                cartePosee = true;
            }
        }
        else{
            this.uno.getTalon().ajouter(this.getPdc().getCarteIndex(cpt));
            this.getPdc().removeCarteIndex(cpt);
            cartePosee = true;
        }
        if(this.uno.getTalon().getSommet().estSansCouleur() && cartePosee){
            nb = random.nextInt(3) + 1;
            switch(nb){
                case 1 :
                    uno.getTalon().getSommet().setCouleur(Couleur.ROUGE);
                    break;
                case 2 :
                    uno.getTalon().getSommet().setCouleur(Couleur.VERT);
                    break;
                case 3 :
                    uno.getTalon().getSommet().setCouleur(Couleur.BLEU);
                    break;
                case 4 :
                    uno.getTalon().getSommet().setCouleur(Couleur.JAUNE);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + nb);
            }
        }
    }

    @Override
    public boolean isUnBot() {
        return true;
    }
}
