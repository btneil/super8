/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_batouche_maldonado;//

/**
 *
 * @author maldo
 */
public class Cellule {

    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;

    public Cellule() {
        jetonCourant = null;
        trouNoir = false;
        desintegrateur = false;
    }

    public boolean affecterJeton(Jeton jetenot) {//affecte un jeton a une cellule
        if (jetonCourant == null) {
            jetonCourant = jetenot;
            return (true);
        } else {
            return (false);
        }
    }

    public Jeton recupererJeton() {//recupere le jeton de la cellule
        return (jetonCourant);
    }

    public boolean supprimerJeton() {//supprime le jeton de la cellule
        if (jetonCourant != null) {
            jetonCourant = null;
            return (true);
        } else {
            return (false);
        }
    }

    public boolean placerTrouNoir() {//place un trou noir dans la cellule
        if (trouNoir == false) {
            trouNoir = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean placerDesintegrateur() {//place un desintegrateur dans la cellule
        if (desintegrateur == false) {
            desintegrateur = true;
            return (true);
        } else {
            return (false);
        }
    }

    public boolean presenceTrouNoir() {//regarde si la cellule possede un trou noir
        if (trouNoir == true) {
            return (true);
        } else {
            return (false);
        }
    }

    public boolean presenceDesintegrateur() {//regarde si la cellule possede un desintegrateur
        if (desintegrateur == true) {
            return (true);
        } else {
            return (false);
        }
    }

    public String lireCouleurDuJeton() {//lit la couleur du jeton dans la cellulle
        return (jetonCourant.lireCouleur());

    }

    public boolean recupererDesintegrateurs() {//recupere un desintegrateur et le supprime de la cellule
        if (desintegrateur == true) {
            desintegrateur = false;
            return (true);
        } else {
            return (false);
        }
    }

    public boolean activerTrouNoir() {//active le trou noir et le supprime de la cellule
        if (trouNoir == true) {
            jetonCourant = null;
            trouNoir = false;
            return (true);
        } else {
            return (false);
        }
    }

}
