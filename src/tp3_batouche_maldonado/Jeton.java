/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
