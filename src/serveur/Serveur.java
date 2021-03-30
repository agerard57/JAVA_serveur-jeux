package serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {

    public static void main(String[] args) {
        try {
            int port = 8001; //Choix du port
            LocateRegistry.createRegistry(port); //Cr�e une r�f�rence locale acceptant les �changes sur le port d�fini auparavant

            //D�finition du jeu du pendu
            ImplPendu pendu = new ImplPendu();
            Naming.rebind("rmi://localhost:8001/pendu", pendu);
           
            //D�finition du jeu des allumettes
            ImplAllumettes allumettes = new ImplAllumettes();
            Naming.rebind("rmi://localhost:8001/allumettes", allumettes);

            //D�finition du jeu du TTT
            /*ImplTTT tictactoe = new ImplTTT();
            Naming.rebind("rmi://localhost:8000/tictactoe", tictactoe);*/
            
            //Message de confirmation de fonctionnement du serveur
            System.out.println("Le serveur de jeux est pr�t");
        } catch (Exception e) {
            //Simple message d'�chec du serveur 
            System.out.println("Le serveur de jeux n'a pas pu d�marrer :" + e);
            System.out.println(e);
        }
    }
}
