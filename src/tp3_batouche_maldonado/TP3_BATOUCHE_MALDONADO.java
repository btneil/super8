/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_batouche_maldonado;

import java.util.Scanner;

/**
 *
 * @author neilb
 */
public class TP3_BATOUCHE_MALDONADO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {;
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Saisir nom joueur 1");
        String nom1 = sc.next();
        Joueur J1 = new Joueur(nom1);
        System.out.println("Saisir nom joueur 2");
        String nom2=sc.next();
        Joueur J2 = new Joueur(nom2);
                
        Partie Newpartie = new Partie(J1,J2);
        Newpartie.debuterPartie();
    }
    
}
