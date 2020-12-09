package uno.joueur;

import uno.Uno;
import uno.cartes.Carte;
import uno.cartes.Couleur;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoueurHumain extends Joueur {

    public JoueurHumain(Uno uno, String nom, int no){
        super(uno,nom,no);
    }

    @Override
    void jouer(String coup) {

    }

    Carte carteChoisie(String coup) throws CoupIncorrect {
        String strNb;
        Matcher matcher = Pattern.compile("\\d+").matcher("");
        //On stock le nombre dans un int et dans un string

        int numCarteChoisie = 0;

        if (matcher.find()) {
            strNb = matcher.group(0);
            numCarteChoisie = Integer.parseInt(strNb);
        }
        else {
            throw new CoupIncorrect("Attention, aucun entiers trouvés");
        }
        if(numCarteChoisie >= this.getPdc().getNombreDeCartes() || numCarteChoisie < 0){
            throw new CoupIncorrect("Attention, la carte n'existe pas!");
        }
        else{ //La carte existe, il faut regarder si la couleur est bonne et +4/joker
            coup.replace(strNb,""); //On remplace les nombres par "" pour pouvoir récupérer la couleur, pour ce faire, on peut seulement remplacer un string par un string (avec replace) donc il faut passer par un string (strNb)
            if(this.getPdc().getCarteIndex(numCarteChoisie).effet() == 1 || this.getPdc().getCarteIndex(numCarteChoisie).effet() == 4) { //Si c'est un joker ou un plus 4, on change la couleur de la carte.
                if((coup.charAt(0) == 'r') || (coup.charAt(0) == 'v') || (coup.charAt(0) == 'b') || (coup.charAt(0) == 'j')){ //Il ne reste plus que les lettres qui représentent les couleurs, il suffit donc de prendre le premier char.
                    switch (coup.charAt(0)) {
                        case 'r':
                            this.getPdc().getCarteIndex(numCarteChoisie).setCouleur(Couleur.ROUGE);
                            break;
                        case 'v':
                            this.getPdc().getCarteIndex(numCarteChoisie).setCouleur(Couleur.VERT);
                            break;
                        case 'b':
                            this.getPdc().getCarteIndex(numCarteChoisie).setCouleur(Couleur.BLEU);
                            break;
                        case 'j':
                            this.getPdc().getCarteIndex(numCarteChoisie).setCouleur(Couleur.JAUNE);
                            break;
                    }
                }
                else{
                    throw new CoupIncorrect("Attention, la couleur donnée n'existe pas!");
                }
            }
            else{
                if(!coup.equals("")){
                    throw new CoupIncorrect("Attention, cette carte ne demande pas de couleur!");
                }
            }
        }
        return this.getPdc().getCarteIndex(numCarteChoisie);
    }
}
