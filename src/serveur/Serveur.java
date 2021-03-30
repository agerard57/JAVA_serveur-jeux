package serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {

    public static void main(String[] args) {
        try {
            int port = 8001; //Choix du port
            LocateRegistry.createRegistry(port); //Crée une référence locale acceptant les échanges sur le port défini auparavant

            //Définition du jeu du pendu
            ImplPendu pendu = new ImplPendu();
            Naming.rebind("rmi://localhost:8001/pendu", pendu);
           
            //Définition du jeu des allumettes
            ImplAllumettes allumettes = new ImplAllumettes();
            Naming.rebind("rmi://localhost:8001/allumettes", allumettes);

            //Définition du jeu du TTT
            /*ImplTTT tictactoe = new ImplTTT();
            Naming.rebind("rmi://localhost:8000/tictactoe", tictactoe);*/
            
            //Message de confirmation de fonctionnement du serveur
            System.out.println("Le serveur de jeux est prêt");
        } catch (Exception e) {
            //Simple message d'échec du serveur 
            System.out.println("Le serveur de jeux n'a pas pu démarrer :" + e);
            System.out.println(e);
        }
    }
}
