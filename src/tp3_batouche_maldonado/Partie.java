/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_batouche_maldonado;

import java.util.Random;

/**
 *
 * @author maldo
 */
public class Partie {
    Joueur[] ListeJoueurs = new Joueur[1];//creation nouveau joueur
    Joueur joueurCourant;
    public Partie() {
        ListeJoueurs=null;
        joueurCourant=null;
    }
    
    public void attribuerCouleursAuxJoueurs(){
            ListeJoueurs[1].couleur="rouge";//couleur des jetons du joueur 2
            ListeJoueurs[0].couleur="jaune";//couleur des jetons du joueur 1
        }
    public void initialiserPartie(){
        Grille GrilleJeu = null;
        GrilleJeu.viderGrille();
        Random rand = new Random(); 
        int max= 25;
        int a = rand.nextInt(max);//nombre aleatoire de desintegrateur et trou noir a placer
        for (int b = 0 ; b <= a ; b++) {
            int i = rand.nextInt(max);
            int j = rand.nextInt(max);
            int k = rand.nextInt(max);
            int l = rand.nextInt(max);
            GrilleJeu.placerTrouNoir(i,j);//placement du trou noir a une place aleatoire dans la grille
            GrilleJeu.placerDesintegrateur(k,l);//placement du desintegrateur a une place aleatoire dans la grille
        }
        Jeton jetonJ1 = null;
        Jeton jetonJ2 = null;
        jetonJ1.couleur=ListeJoueurs[0].couleur;//attribut couleur jeton joueur 1
        jetonJ2.couleur=ListeJoueurs[1].couleur;//attribut couleur jeton joueur 2
        ListeJoueurs[0].ajouterJeton(jetonJ1);//ajout des jetons au joueur 1
        ListeJoueurs[1].ajouterJeton(jetonJ2);//ajout des jetons au joueur 2
        
}
    public void debuterPartie() {
        //a venir
    }
}