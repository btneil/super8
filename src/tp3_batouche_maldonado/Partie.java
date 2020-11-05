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
    Joueur joueurCourant= ListeJoueurs[1];
    Grille GrilleJeu=new Grille();
    public Partie(Joueur J1, Joueur J2) {
        ListeJoueurs[0]=J1;
        ListeJoueurs[1]=J2;
    }
    
    public void attribuerCouleursAuxJoueurs(){
            ListeJoueurs[1].couleur="R";//couleur des jetons du joueur 2
            ListeJoueurs[0].couleur="J";//couleur des jetons du joueur 1
        }
    public void initialiserPartie(){
        Grille GrilleJeu=new Grille();
        GrilleJeu.viderGrille();
        Random rand = new Random(); 
        int max1= 5;//maximum de ligne possible + maximum de trou/desintegrateur
        int max2= 6;//maximum colonne
        int a = rand.nextInt(max1);//nombre aleatoire de desintegrateur et trou noir a placer
        for (int b = 0 ; b <= a ; b++) {
            int i = rand.nextInt(max1); // i comme k sont des indices de lignes, compris entre 0 et 5 
            int j = rand.nextInt(max2); // j comme l sont des indices de colonnes, compris entre 0 et 6
            int k = rand.nextInt(max1);
            int l = rand.nextInt(max2);
            GrilleJeu.placerTrouNoir(i,j);//placement du trou noir a une place aleatoire dans la grille
            GrilleJeu.placerDesintegrateur(k,l);//placement du desintegrateur a une place aleatoire dans la grille
        }
 
        Jeton jetonJ1=new Jeton("cj1");
        Jeton jetonJ2=new Jeton("cj2");
        jetonJ1.couleur=ListeJoueurs[0].couleur;//attribut couleur jeton joueur 1
        jetonJ2.couleur=ListeJoueurs[1].couleur;//attribut couleur jeton joueur 2
        ListeJoueurs[0].ajouterJeton(jetonJ1);//ajout des jetons au joueur 1
        ListeJoueurs[0].nombreJetonsRestant=21;
        ListeJoueurs[1].ajouterJeton(jetonJ2);//ajout des jetons au joueur 2
        ListeJoueurs[1].nombreJetonsRestant=21;
        
        
}
    public void debuterPartie() {
        Scanner sc= new Scanner (System.in);        
        initialiserPartie();
        attribuerCouleursAuxJoueurs();
        System.out.println("la partie va commencer");
        while (GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])==false && GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])==false && GrilleJeu.etreRemplie()==false) {
            GrilleJeu.afficherGrilleSurConsole();
            if (joueurCourant==ListeJoueurs[1]){ // a chaque tour de jeu, joueurCourant change et permet de jouer chacun son tour
                joueurCourant=ListeJoueurs[0];
            }
            else {
                joueurCourant=ListeJoueurs[1];
            }
           
            
            boolean i=true; // permet de ne laisser jouer qu'une seule fois chaque joueur.
            while (joueurCourant.nombreJetonsRestant!=0 && i==true ){
                System.out.println("c'est au tour de : "+joueurCourant.nom);
                System.out.println("Saisissez la colonne où mettre le jeton : ");
                int col=sc.nextInt();
                
                if (col>=0 &&col<=6 && GrilleJeu.colonneRemplie()==false){ // test de la saisie et de la colonne
                    GrilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[0], col);
                    joueurCourant.nombreJetonsRestant-=1;
                }
                i=false;
            }
            
        
        }
        System.out.println("test");
}
}
