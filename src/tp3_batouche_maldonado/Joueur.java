
/* 

TP3 - PUISSANCE 4
MALDONADO Alexis et BATOUCHE Neil 
Sans interface graphique

*/
package tp3_batouche_maldonado;

/**
 *
 * @author neilb
 */
public class Joueur {//

    String nom;
    String couleur;
    Jeton[] ListeJetons = new Jeton[21];
    int nombreDesintegrateurs;
    int nombreJetonsRestant; // nombre de jeton restant	 en possession	 du	 joueur, correspondant	à	la	taille	effective	de	ListeJetons

    public Joueur(String name) { // constructeur
        nom = name;
    }

    public void affecterCouleur(String color) {
        couleur = color;
    }

    public void ajouterJeton(Jeton jeton) {
        for (int i = 0; i < ListeJetons.length; i++) {
            ListeJetons[i] = jeton;//initialisation des jetons 

        }
    }

    public void obtenirDesintegrateur(int nombreDesinte) {
        nombreDesintegrateurs = nombreDesinte;//permet d'avoir un nombre de desintegrateur
    }

    public boolean utiliserDesintegrateur() {//permet d'utiliser les desintegrateurs
        if (nombreDesintegrateurs > 0) {
            nombreDesintegrateurs--;
            return true;
        } else {
            return false;
        }

    }

}
