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
    Joueur joueurCourant;
    Grille GrilleJeu = new Grille();
    Random rand = new Random();

    public Partie(Joueur J1, Joueur J2) {
        ListeJoueurs[0] = J1;
        ListeJoueurs[1] = J2;
    }

    public void attribuerCouleursAuxJoueurs() {
        int couleur = rand.nextInt((1) + 1) + 1; // tirage aléatoire d'un nombre afin d'affecter aléatoirement les couleurs aux joueurs
        switch (couleur) {
            case 1:
                ListeJoueurs[0].couleur = "R";
                break;
            case 2:
                ListeJoueurs[0].couleur = "J";
        }
        if (ListeJoueurs[0].couleur == "R") {
            ListeJoueurs[1].couleur = "J";
        } else {
            ListeJoueurs[1].couleur = "R";
        }
        System.out.println(ListeJoueurs[0].nom + " sera de la couleur " + ListeJoueurs[0].couleur + " et " + ListeJoueurs[1].nom + " sera de la couleur " + ListeJoueurs[1].couleur);

    }

    public void initialiserPartie() {

        GrilleJeu.viderGrille();
        int max_l = 5;//maximum de ligne possible + maximum de trou/desintegrateur
        int max_c = 6;//maximum colonne

        for (int b = 1; b <= 2; b++) { // on place 2 trous noirs au même endroit que 2 desintégrateurs
            int i = rand.nextInt(max_l);//ligne aleatoire
            int j = rand.nextInt(max_c);//colonne aleatoire
            GrilleJeu.placerTrouNoir(i, j);//placement d'un trou noir a la place (i,j) tiré au hasard
            GrilleJeu.placerDesintegrateur(i, j);//placement desintegrateur a la meme place que le trou noir
        }

        for (int b = 1; b <= 3; b++) { // on complete le nombre de trous noirs (3) et de désintégrateurs (3).  
            int i = rand.nextInt(max_l);
            int j = rand.nextInt(max_c);
            int k = rand.nextInt(max_l);//ligne aleatoire
            int l = rand.nextInt(max_c);//colonne aleatoire
            GrilleJeu.placerTrouNoir(i, j);//placement d'un trou noir a la place (i,j) tiré au hasard
            GrilleJeu.placerDesintegrateur(k, l);//placement desintegrateur a une place differente que celle du trou noir, (k,l)

        }

        Jeton jetonJ1 = new Jeton(ListeJoueurs[0].couleur);
        Jeton jetonJ2 = new Jeton(ListeJoueurs[1].couleur);
        ListeJoueurs[0].ajouterJeton(jetonJ1);//ajout des jetons au joueur 1
        ListeJoueurs[0].nombreJetonsRestant = 21;
        ListeJoueurs[1].ajouterJeton(jetonJ2);
        ListeJoueurs[1].nombreJetonsRestant = 21;
        ListeJoueurs[0].nombreDesintegrateurs = 1; // initialisation du nombre de désintégrateurs de chaque joueur
        ListeJoueurs[1].nombreDesintegrateurs = 1;

    }

    public void debuterPartie() {

        // Tirage aléatoire pour savoir qui commence la partie : 1 correspond à la couleur R et 2 correspond à la couleur J : 
        attribuerCouleursAuxJoueurs();
        int couleur = (rand.nextInt(1) * 2) + 1;//tirage du nombre aleatoire
        if (couleur == 1) {
            System.out.println("Couleur tirée : R ");
        } else {
            System.out.println("Couleur tirée : J ");

        }
        switch (couleur) { // tirage au sort du joueur débutant la partie 
            case 1:
                if (ListeJoueurs[0].couleur == "J") {
                    joueurCourant = ListeJoueurs[1];
                } else {
                    joueurCourant = ListeJoueurs[0];
                }
                break;
            case 2:
                if (ListeJoueurs[0].couleur == "R") {
                    joueurCourant = ListeJoueurs[1];

                } else {
                    joueurCourant = ListeJoueurs[0];

                }
                break;
        }

        Scanner sc = new Scanner(System.in);
        initialiserPartie();

        System.out.println("la partie va commencer");
        while (GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[0]) == false && GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]) == false && GrilleJeu.etreRemplie() == false) {
            GrilleJeu.afficherGrilleSurConsole();//affiche la grille

            boolean i = true; // permet de ne laisser jouer qu'une seule fois chaque joueur.
            while (joueurCourant.nombreJetonsRestant != 0 && i == true) {
                System.out.println("c'est au tour de : " + joueurCourant.nom
                        + "\n"
                        + "Souhaitez vous : "
                        + "\n"
                        + "1) jouer un de vos jetons "
                        + "\n"
                        + "2) recuperer un jeton "
                        + "\n"
                        + "3) desintegrer un jeton"
                        + "\n"
                        + "Saisissez 1, 2, 3 : ");
                int rep = sc.nextInt();
                if (rep == 1) {//condition pour placer un jeton
                    GrilleJeu.afficherGrilleSurConsole();//affichage de la grille une seconde fois pour plus de confort de jeu
                    System.out.println("Saisissez la colonne où mettre le jeton (entre 1 et 7) : ");

                    int saisie = sc.nextInt(); // la saisie se fait entre 1 et 7
                    int col = saisie - 1; // pour Java, les numéros de colonne commencent à 0.

                    if (col >= 0 && col <= 6 && GrilleJeu.colonneRemplie(col) == false) { // test de la saisie et de la colonne

                        int l = 5; // l correspond a la ligne 

                        while (GrilleJeu.Grille[l][col].jetonCourant != null && l >= 0) { // permet de sortir de la boucle des qu'on trouve une cellule où le jetonCourant==null
                            l--; // l correspond donc a la ligne où le jeton sera placé 
                        }

                        if (GrilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[0], col) == true) { // si on ajoute un jeton sur un trou noir, le trou noir disparait et on perd un jeton
                            joueurCourant.nombreJetonsRestant -= 1;
                        }
                        if (GrilleJeu.Grille[l][col].presenceDesintegrateur() == true) {//on regarde si la cellule a un desintegrateur
                            GrilleJeu.Grille[l][col].recupererDesintegrateurs();//recuperation d'un desintegrateur
                            joueurCourant.nombreDesintegrateurs++;

                        }

                        System.out.println("nombre jetons restants pour " + joueurCourant.nom + ": " + joueurCourant.nombreJetonsRestant);
                    } else if (col < 0 || col > 6) {//mauvaise saisie
                        System.out.println("erreur saisie : au joueur suivant !");
                    } else if (GrilleJeu.colonneRemplie(col) == true) {//affichage du numero de la colonne remplie
                        System.out.println("colonne " + (saisie) + " remplie");
                    }

                    i = false;
                } else if (rep == 2) {//condition pour reucperer un jeton
                    System.out.println("Saisissez la ligne i puis la colonne j du jeton a récupérer "
                            + "\n"
                            + "Rq : en bas à gauche cela correspond à la ligne 6 colonne 1. "
                            + "\n"
                            + "Saisissez votre choix : ");
                    int ligne = sc.nextInt();
                    int l = ligne - 1;
                    int colonne = sc.nextInt();
                    int j = colonne - 1;
                    if (GrilleJeu.celluleOccupee(l, j) == false) {//si il n'y a pas de jeton dans la cellule alors on ne peut pas en recuperer 
                        System.out.println("Oups, il n'y a pas de jeton dans cette cellule");
                    } else if (GrilleJeu.lireCouleurDuJeton(l, j) == joueurCourant.couleur) {//il faut que le jeton soit de la meme couleur que celle du joueur 
                        GrilleJeu.recupererJeton(l, j);
                        joueurCourant.nombreJetonsRestant += 1;
                        GrilleJeu.tasserGrille(j); // on tasse la grille apres avoir retiré un jeton de la colonne j.
                    } else {
                        System.out.println("Vous ne pouvez récuperer qu'un de vos jetons!");
                    }
                    i = false;

                } else if (rep == 3) {//condition pour desintegrer un jeton
                    GrilleJeu.afficherGrilleSurConsole();
                    System.out.println("Saisissez la ligne i puis la colonne j du jeton que vous souhaitez désintegrer"
                            + "\n"
                            + "n'oubliez pas que en bas à gauche cela correspond à la ligne 6 colonne 1"
                            + "\n"
                            + "Saisissez votre choix : ");

                    int ligne = sc.nextInt();
                    int l = ligne - 1;
                    int colonne = sc.nextInt();
                    int j = colonne - 1;
                    if (joueurCourant.nombreDesintegrateurs != 0) {//on ne peut desintegrer que les jetons de l'adversaire
                        if (GrilleJeu.celluleOccupee(l, j) == true && GrilleJeu.Grille[l][j].lireCouleurDuJeton() != joueurCourant.couleur) {

                            joueurCourant.utiliserDesintegrateur();
                            GrilleJeu.supprimerJeton(l, j);
                            GrilleJeu.tasserGrille(j);

                        } else if (GrilleJeu.celluleOccupee(l, j) == false) {//permet de verifier si il y a un jeton dans la cellule
                            System.out.println("Il n'y a pas de jetons dans cette cellule");
                        } else if (GrilleJeu.Grille[l][j].lireCouleurDuJeton() == joueurCourant.couleur) {//permet de ne pas desintegrer un de ses jeton
                            System.out.println("Vous ne pouvez pas désintégrer un de vos jetons! ");
                        }

                    } else {//il faut des desintegrateur pour jouer
                        System.out.println("Vous n'avez pas de désintégrateurs, gagnez en un sur la Grille de jeu");
                    }
                    i = false;
                }
            }
            if (joueurCourant == ListeJoueurs[1]) { // a chaque tour de jeu, joueurCourant change et permet de jouer chacun son tour
                joueurCourant = ListeJoueurs[0];
            } else {
                joueurCourant = ListeJoueurs[1];
            }
            if (joueurCourant.nombreJetonsRestant == 0) {

            }

        }
        if (GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[0]) == true) {//condition de victoire
            System.out.println("Joueur gagant :" + ListeJoueurs[0].nom);//affichage du nom du gagnant
        } else if (GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]) == true) {
            System.out.println("Joueur gagant :" + ListeJoueurs[1].nom);
        } else {
            System.out.println("error");
        }
    }
}
