/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_batouche_maldonado;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author maldo
 */
public class Partie {

    Joueur[] ListeJoueurs = new Joueur[2];//creation nouveau joueur
    Joueur joueurCourant = ListeJoueurs[1];
    Grille GrilleJeu = new Grille();

    public Partie(Joueur J1, Joueur J2) {
        ListeJoueurs[0] = J1;
        ListeJoueurs[1] = J2;
    }

    public void attribuerCouleursAuxJoueurs() {
        ListeJoueurs[0].couleur = "R";//couleur des jetons du joueur 1
        ListeJoueurs[1].couleur = "J";//couleur des jetons du joueur 2
    }

    public void initialiserPartie() {
        
        // [BD] : l'erreur est la : 
        // en REcréant grilleJeu DANS initialiserPArtie, ce n'est pas la meme que la grilleJeu de la ligne 19
        // [BD] - 1 Il faut supprimer la ligne ci dessus, car la grille est déjà créée plus haut
        // sinon vous créez uen seconde grille juste le temps de placer les trous noirs
        
        
        GrilleJeu.viderGrille();
        Random rand = new Random();
        int max_l = 5;//maximum de ligne possible + maximum de trou/desintegrateur
        int max_c = 6;//maximum colonne

        for (int b = 1; b <= 2; b++) {
            int i = rand.nextInt(max_l);//ligne aleatoire
            int j = rand.nextInt(max_c);//colonne aleatoire
            GrilleJeu.placerTrouNoir(i, j);//placement d'un trou noir a la place i j
            GrilleJeu.placerDesintegrateur(i, j);//placement desintegrateur a la meme place que le trou noir
        }


        
        for (int b = 1; b <= 3; b++) {
            int i = rand.nextInt(max_l);//ligne aleatoire
            int j = rand.nextInt(max_c);//colonne aleatoire
            int k = rand.nextInt(max_l);//ligne aleatoire
            int l = rand.nextInt(max_c);//colonne aleatoire
            GrilleJeu.placerTrouNoir(i, j);//placement d'un trou noir a la place i j
            GrilleJeu.placerDesintegrateur(k, l);//placement desintegrateur a une place differente que celle du trou noir

        } 

        Jeton jetonJ1 = new Jeton("R");
        Jeton jetonJ2 = new Jeton("J");
        ListeJoueurs[0].ajouterJeton(jetonJ1);//ajout des jetons au joueur 1
        ListeJoueurs[0].nombreJetonsRestant = 21;
        ListeJoueurs[1].ajouterJeton(jetonJ2);//ajout des jetons au joueur 2
        ListeJoueurs[1].nombreJetonsRestant = 21;

    }

    public void debuterPartie() {
        Scanner sc = new Scanner(System.in);
        initialiserPartie();
        attribuerCouleursAuxJoueurs();
        System.out.println("la partie va commencer");
        while (GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[0]) == false && GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]) == false && GrilleJeu.etreRemplie() == false) {
            GrilleJeu.afficherGrilleSurConsole();
            if (joueurCourant == ListeJoueurs[1]) { // a chaque tour de jeu, joueurCourant change et permet de jouer chacun son tour
                joueurCourant = ListeJoueurs[0];
            } else {
                joueurCourant = ListeJoueurs[1];
            }
            if (joueurCourant.nombreJetonsRestant==0){
                
            }
            boolean i = true; // permet de ne laisser jouer qu'une seule fois chaque joueur.
            while (joueurCourant.nombreJetonsRestant != 0 && i == true) {
                System.out.println("c'est au tour de : " + joueurCourant.nom);
                System.out.println("Saisissez la colonne où mettre le jeton : ");//j'ai changer la colonne en ligne pour etre en raccord avec la v1.0
                int col = sc.nextInt();

                if (col >= 0 && col <= 6 && GrilleJeu.colonneRemplie(col) == false) { // test de la saisie et de la colonne
                    GrilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[0], col);
                    //System.out.println("ListeJetons[0] : " + joueurCourant.ListeJetons[0]);
                    joueurCourant.nombreJetonsRestant -= 1;
                    System.out.println("nombre jetons restants pour " + joueurCourant.nom + ": " + joueurCourant.nombreJetonsRestant);
                } else if (col < 0 || col > 6) {
                    System.out.println("erreur saisie : au joueur suivant !");
                }
                if (GrilleJeu.colonneRemplie(col)==true){
                    System.out.println("colonne " + col + " remplie");
                }
                
            i = false;
            }

        }
        System.out.println("test");
    }
}
