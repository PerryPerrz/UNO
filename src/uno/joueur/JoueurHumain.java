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
    public void jouer(String coup) throws CoupIncorrect {
        Matcher matcher;
        String strNb;
        int indiceCarte;
        Carte car;

        matcher = Pattern.compile("\\d+").matcher(coup);
        if (coup.equals("p")) { //On vérifie que toute la chaine de de caractère est égale à 'p'
            this.getPdc().ajouter(uno.getPioche().piocher());
            if (uno.getSommetTalon().peutEtreRecouverte(this.pdc.getSommet())) {
                uno.getTalon().ajouter(this.getPdc().piocher());
                this.uno.getSommetTalon().appliquerEffet();
            }
        }
        else{
            if(matcher.find()){ //Je groupe seulement si le matcher à trouvé un entier
                strNb = matcher.group();
                indiceCarte = Integer.parseInt(strNb); //On récupère l'indice de la carte pour pouvoir la remove une fois que l'on à ajouté celle-ci sur le talon
            }
            else{
                throw new CoupIncorrect("La fonction n'a trouvé aucun entiers!");
            }
            if (strNb.equals("")) { //Si il y a aucun nombre, si le joueur veut passer son tour
                uno.changerDeJoueur();
            } else {
                car = this.carteChoisie(coup);
                if (uno.getSommetTalon().peutEtreRecouverte(car)) {
                    coup = coup.replace(strNb, ""); //On garde que les couleurs
                    if (coup.length() == 0 || coup.length() == 1) { //On veut prendre que le première lettre : par exemple, si l'utilisateur écrit "violet" ça ne doit pas marcher (marche si on à que 1 chiffre ou 1 chiffre et une lettre
                        if (car.effet() == 1 || car.effet() == 4) { //On gère le cas lorsque la carte est un joker ou bien un plus 4
                            switch (coup.charAt(0)) {
                                case 'r':
                                    car.setCouleur(Couleur.ROUGE);
                                    break;
                                case 'v':
                                    car.setCouleur(Couleur.VERT);
                                    break;
                                case 'b':
                                    car.setCouleur(Couleur.BLEU);
                                    break;
                                case 'j':
                                    car.setCouleur(Couleur.JAUNE);
                                    break;
                            }
                        }
                        uno.getTalon().ajouter(car); //On ajoute la carte sur le talon
                        this.pdc.removeCarteIndex(indiceCarte); //On enlève la carte de la main
                        this.uno.getSommetTalon().appliquerEffet(); //On applique l'effet de la carte posée
                    }
                    else{ //Si l'utilisateur rentre une couleur invalide (plus d'un caractère)
                        this.uno.getDialogue().affichagePTT();
                    }
                }
                else{ //Si on peut pas la poser
                    throw new CoupIncorrect("On ne peut pas poser cette carte!");
                }
            }
        }
    }

    public Carte carteChoisie(String coup) throws CoupIncorrect {
        Matcher matcher;
        String strNb;
        int indiceCarte;
        //On stock le nombre dans un int et dans un string

        matcher = Pattern.compile("\\d+").matcher(coup);

        if (matcher.find()){
            strNb = matcher.group(0);
            indiceCarte = Integer.parseInt(strNb);
        }
        else {
            throw new CoupIncorrect("Attention, aucun entiers trouvés!");
        }
        if(indiceCarte >= this.getPdc().getNombreDeCartes() || indiceCarte < 0){
            throw new CoupIncorrect("Attention, la carte n'existe pas!");
        }
        else{ //La carte existe, il faut regarder si la couleur est bonne et +4/joker
            coup = coup.replace(strNb,""); //On remplace les nombres par "" pour pouvoir récupérer la couleur, pour ce faire, on peut seulement remplacer un string par un string (avec replace) donc il faut passer par un string (strNb)
            if(this.effetCarteIndex(indiceCarte) == 1 || this.effetCarteIndex(indiceCarte) == 4) { //Si c'est un joker ou un plus 4, on change la couleur de la carte.
                if(coup.equals("") || !(coup.charAt(0) == 'r') && !(coup.charAt(0) == 'v') && !(coup.charAt(0) == 'b') && !(coup.charAt(0) == 'j')){ //Il ne reste plus que les lettres qui représentent les couleurs, il suffit donc de prendre le premier char.
                    throw new CoupIncorrect("Attention, la couleur donnée n'existe pas!");
                }
            }
            else{
                if(!coup.equals("")){
                    throw new CoupIncorrect("Attention, cette carte ne demande pas de couleur!");
                }
            }
        }
        return this.getPdc().getCarteIndex(indiceCarte);
    }

    @Override
    public boolean isUnBot() {
        return false;
    }
}
