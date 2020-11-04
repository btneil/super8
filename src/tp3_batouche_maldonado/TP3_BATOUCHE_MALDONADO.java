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
public class TP3_BATOUCHE_MALDONADO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Partie partie = null;
        partie.attribuerCouleursAuxJoueurs();
        partie.initialiserPartie();
        System.out.println("la partie va commencer");
        partie.debuterPartie();
    }
    
}
