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
public class Joueur {//
    String nom;
    String couleur;
    Jeton [] ListeJetons= new Jeton[21];
    int nombreDesintegrateurs;
    int nombreJetonsRestant; // nombre de jeton restant	 en possession	 du	 joueur, correspondant	à	la	taille	effective	de	ListeJetons
    
    public Joueur(String name){ // constructeur
        nom=name;
    }
    
    public void affecterCouleur(String color){
        couleur=color;
    }
    
    public void ajouterJeton(Jeton jeton){
        for (int i=0;i<ListeJetons.length;i++){
            ListeJetons[i]=jeton;//
            
        }
    }
    
    public void obtenirDesintegrateur(int nombreDesinte){
        nombreDesintegrateurs=nombreDesinte;
    }
    
    public boolean utiliserDesintegrateur(){
        if (nombreDesintegrateurs>0){
            nombreDesintegrateurs--;
            return true;
        }
        else {
            return false;
        }
        
    }
    
    
    
}
