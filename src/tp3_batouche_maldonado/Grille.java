/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_batouche_maldonado;

/**
 *
 * @author neilb
 */
public class Grille {

    Cellule[][] Grille = new Cellule[6][7]; // Cellules est un tableau 2D de type Grille
    // la cellule Grille[0][0] est située en haut à gauche ici.

    public Grille() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                Grille[i][j] = new Cellule();

            }
        }

    }

    public boolean ajouterJetonDansColonne(Jeton jetonot, int col) {
        int i = 5;

        while (i >= 0) {
            if (Grille[i][col].jetonCourant == null){// && Grille[i][col].trouNoir == false) { // S'il n'y a pas de trou noir et que le jetonCourant de la cellule est null, on peut ajouter un jeton
                Grille[i][col].affecterJeton(jetonot);
                if (Grille[i][col].presenceTrouNoir()==true){
                    Grille[i][col].activerTrouNoir();
                    return true;
                }
                else if (Grille[i][col].presenceDesintegrateur()==true){
                    Grille[i][col].recupererDesintegrateurs();
                    return true;
                 }
                return true;
            }
            /*else if (Grille[i][col].jetonCourant==null && Grille[i][col].trouNoir==true){ // s'il y a un trou noir, le jeton ne se positionne pas.
                Grille[i][col].trouNoir=false; // on enleve egalement le trou noir
                System.out.println("Jeton perdu");
                return true;
            }*/

            i--;

        }
        return false;

    }

    public boolean etreRemplie() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                if (Grille[i][j].jetonCourant == null) {
                    return false;
                }

            }
        }
        return true;
    }

    public void viderGrille() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                Grille[i][j] = new Cellule();
            }
        }

    }

    public void afficherGrilleSurConsole() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                if (Grille[i][j].presenceTrouNoir() == true) {
                    System.out.print("T");
                } else if (Grille[i][j].presenceDesintegrateur() == true) {
                    System.out.print("D");
                } else {
                    // BD : ajout de l'affichage des jetons 
                    if (Grille[i][j].jetonCourant==null) {
                    System.out.print(" ");
                    }
                    else {
                         System.out.print(Grille[i][j].jetonCourant.couleur);
                    }
                }
            }
            System.out.print("\n");
        }
    }

    public boolean celluleOccupee(int i, int j) {
        if (Grille[i][j].jetonCourant != null) {
            return true;
        } else {
            return false;
        }

    }

    public String lireCouleurDuJeton(int i, int j) {
        return Grille[i][j].lireCouleurDuJeton();
    }

    public boolean GagnanteLigne(Joueur joueur) {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 3; j++) {
                if (Grille[i][j].jetonCourant != null && Grille[i][j + 1].jetonCourant != null && Grille[i][j + 2].jetonCourant != null && Grille[i][j + 3].jetonCourant != null) {
                    if (Grille[i][j].jetonCourant.lireCouleur() == joueur.couleur && Grille[i][j + 1].jetonCourant.lireCouleur() == joueur.couleur && Grille[i][j + 2].jetonCourant.lireCouleur() == joueur.couleur && Grille[i][j + 3].jetonCourant.lireCouleur() == joueur.couleur) {
                        return true;
                    } else {
                        return false;
                    }
                }

            }
        }
        return false;
    }

    public boolean GagnanteColonne(Joueur joueur) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 6; j++) {
                if (Grille[i][j].jetonCourant != null && Grille[i + 1][j].jetonCourant != null && Grille[i + 2][j].jetonCourant != null && Grille[i + 3][j].jetonCourant != null) {
                    if (Grille[i][j].lireCouleurDuJeton() == joueur.couleur && Grille[i + 1][j].lireCouleurDuJeton() == joueur.couleur && Grille[i + 2][j].lireCouleurDuJeton() == joueur.couleur && Grille[i + 3][j].lireCouleurDuJeton() == joueur.couleur) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
  
    public boolean GagnanteDiagMont(Joueur joueur) {
        for (int i = 3; i <= 5; i++) {
            for (int j = 0; j <= 3; j++) {
                if (Grille[i][j].jetonCourant != null && Grille[i - 1][j + 1].jetonCourant != null && Grille[i - 2][j + 2].jetonCourant != null && Grille[i - 3][j + 3].jetonCourant != null) {
                    if (Grille[i][j].lireCouleurDuJeton() == joueur.couleur && Grille[i - 1][j + 1].lireCouleurDuJeton() == joueur.couleur && Grille[i - 2][j + 2].lireCouleurDuJeton() == joueur.couleur && Grille[i - 3][j + 3].lireCouleurDuJeton() == joueur.couleur) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public boolean GagnanteDiagDesc(Joueur joueur) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                if (Grille[i][j].jetonCourant != null && Grille[i + 1][j + 1].jetonCourant != null && Grille[i + 2][j + 2].jetonCourant != null && Grille[i + 3][j + 3].jetonCourant != null) {
                    if (Grille[i][j].lireCouleurDuJeton() == joueur.couleur && Grille[i + 1][j + 1].lireCouleurDuJeton() == joueur.couleur && Grille[i + 2][j + 2].lireCouleurDuJeton() == joueur.couleur && Grille[i + 3][j + 3].lireCouleurDuJeton() == joueur.couleur) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean etreGagnantePourJoueur(Joueur joueur) {
        if (GagnanteColonne(joueur) == true || GagnanteLigne(joueur) == true || GagnanteDiagMont(joueur) == true || GagnanteDiagDesc(joueur) == true) {
            return true;
        } else {
            return false;
        }

    }

    public void tasserGrille(int liberee) { // liberee : la colonne ou le jeton a été supprimé
        for (int i = 5; i >= 1; i--) {

            if (Grille[i][liberee].jetonCourant == null) {
                Grille[i][liberee].jetonCourant = Grille[i + 1][liberee].jetonCourant;
            }
        }

    }

    public boolean colonneRemplie(int col) {
        // on cherche a regarder si pour la ligne la plus elevée du jeu (ici i=0), les colonnes j de 0 à 6 inclus sont remplis donc : 
        //int i = 0; // la ligne tout au dessus doit être vide pour que la colonne puisse accepter un nouveau jeton.
        boolean verif=false;
        if (col>6){//empeche l'entree d'une colonne>6
            verif=false;
        }
        else {
            if(Grille[0][col].jetonCourant!=null){
            verif=true;
            }
        }
        return verif;
}

    public boolean placerTrouNoir(int i, int j) {
        return Grille[i][j].placerTrouNoir();

    }

    public boolean placerDesintegrateur(int i, int j) {
        return Grille[i][j].placerDesintegrateur();

    }

    public boolean supprimerJeton(int i, int j) {
        return Grille[i][j].supprimerJeton();

    }

    public Jeton recupererJeton(int i, int j) {
        Jeton ref = Grille[i][j].recupererJeton();
        Grille[i][j].supprimerJeton();
        return ref;
    }
}
