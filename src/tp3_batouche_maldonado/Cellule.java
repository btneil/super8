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
   
    public Cellule(){
        jetonCourant = null;
        trouNoir = false;
        desintegrateur = false;
        }
    public boolean affecterJeton(Jeton jetenot){
        if (jetonCourant == null) {//jetoncourant n'est pas affecter
            jetonCourant=jetenot;
            return(true);
        }
        else {
            return(false);
        }
    }
    public Jeton recupererJeton(){
        return(jetonCourant);
    }
    public boolean supprimerJeton(){
        if (jetonCourant!=null) {
            jetonCourant=null;
            return(true);
        }
        else {
            return(false);
        }
    }
    public boolean placerTrouNoir(){
        if (trouNoir == false) {
            trouNoir=true;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean placerDesintegrateur(){
        if (desintegrateur==false) {
            desintegrateur =true;
            return(true);
        }
        else {
            return(false);
        }
    }
    public boolean presenceTrouNoir(){
        if (trouNoir==true){
            return(true);
        }
        else{
            return(false);
        }
    }
    public boolean presenceDesintegrateur(){
        if (desintegrateur==true){
            return(true);
        }
        else {
            return(false);
        }
    }
    public String lireCouleurDuJeton() {
        return (jetonCourant.lireCouleur());

    }
    public boolean recupererDesintegrateurs(){
        if (desintegrateur == true){
            desintegrateur=false;
            return(true);
        }
        else {
            return(false);
        }
    }
    public boolean activerTrouNoir() {
        if (trouNoir==true){
            jetonCourant=null;
            trouNoir=false;
            return(true);
        }
        else {
            return(false);
        }
    }
    
    
}


    

