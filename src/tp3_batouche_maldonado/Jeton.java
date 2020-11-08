/* 

TP3 - PUISSANCE 4
MALDONADO Alexis et BATOUCHE Neil 
Sans interface graphique

*/
package tp3_batouche_maldonado;

/**
 *
 * @author maldo
 */
public class Jeton {

    String couleur;

    public Jeton(String couleurJeton) {
        couleur = couleurJeton;//initialisation de la couleur du jeton
    }

    public String lireCouleur() {
        return (couleur);

    }
}
