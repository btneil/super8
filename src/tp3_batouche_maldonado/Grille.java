package tp3_batouche_maldonado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author neilb
 */
public class Grille {

    Cellule[][] Grille = new Cellule[6][7]; // Cellules est un tableau 2D de type Grille

    public Grille() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                Grille[i][j] = null;

            }
        }

    }

    public boolean ajouterJetonDansColonne(Jeton jetonot, int col) {
        int i = 5;
        while (i >= 0) {
            if (Grille[i][col].recupererJeton() == null) {
                Grille[i][col].affecterJeton(jetonot);
                i--;
            }

        }
        return false;
    }

    public boolean etreRemplie() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                if (Grille[i][j] == null) {
                    return false;
                }

            }
        }
        return true;
    }

    public void viderGrille() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                Grille[i][j] = null;
            }
        }

    }

    public void afficherGrilleSurConsole() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                if (Grille[i][j].presenceTrouNoir() == false) {
                    System.out.print(Grille[i][j].lireCouleurDuJeton() + " ");
                } else if (Grille[i][j].presenceTrouNoir() == true) {
                    System.out.print("T" + " ");

                }
            }

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
                if (Grille[i][j].lireCouleurDuJeton() == joueur.couleur && Grille[i][j + 1].lireCouleurDuJeton() == joueur.couleur && Grille[i][j + 2].lireCouleurDuJeton() == joueur.couleur && Grille[i][j + 3].lireCouleurDuJeton() == joueur.couleur) {
                    return true;
                } else {
                    return false;
                }

            }
        }
        return false;
    }

    public boolean GagnanteColonne(Joueur joueur) {
        for (int i = 2; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                if (Grille[i][j].lireCouleurDuJeton() == joueur.couleur && Grille[i + 1][j].lireCouleurDuJeton() == joueur.couleur && Grille[i + 2][j].lireCouleurDuJeton() == joueur.couleur && Grille[i + 3][j].lireCouleurDuJeton() == joueur.couleur) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean GagnanteDiagMont(Joueur joueur) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {

                if (Grille[i][j].lireCouleurDuJeton() == joueur.couleur && Grille[i + 1][j + 1].lireCouleurDuJeton() == joueur.couleur && Grille[i + 2][j + 2].lireCouleurDuJeton() == joueur.couleur && Grille[i + 3][j + 3].lireCouleurDuJeton() == joueur.couleur) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean GagnanteDiagDesc(Joueur joueur) {
        for (int i = 5; i >= 3; i--) {
            for (int j = 0; j <= 3; j++) {

                if (Grille[i][j].lireCouleurDuJeton() == joueur.couleur && Grille[i - 1][j + 1].lireCouleurDuJeton() == joueur.couleur && Grille[i - 2][j + 2].lireCouleurDuJeton() == joueur.couleur && Grille[i - 3][j + 3].lireCouleurDuJeton() == joueur.couleur) {
                    return true;
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

    public void tasserGrille(int liberee) { // liberee : la ligne qui vient d'etre libere
        for (int j=6;j>=0;j--){
            
            if (Grille[liberee][j]==null){
                Grille[liberee][j]=Grille[liberee+1][j];
            }
        }
        
    }


    public boolean colonneRemplie() {
        int[][] remplissage = new int[6][7];
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                if (Grille[i][j] != null) {
                    return false; // s'arrete des qu'une cellule n'est pas vide

                }
            }
        }
        return true;
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
