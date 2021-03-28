package serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {

    public static void main(String[] args) {
        try {
            int port = 8001;
            LocateRegistry.createRegistry(port);

            ImplPendu pendu = new ImplPendu();
            Naming.rebind("rmi://localhost:8001/pendu", pendu);
           
            ImplAllumettes allumettes = new ImplAllumettes();
            Naming.rebind("rmi://localhost:8001/allumettes", allumettes);

            /*ImplTTT tictactoe = new ImplTTT();
            Naming.rebind("rmi://localhost:8000/tictactoe", tictactoe);*/
            
            System.out.println("Le serveur de jeux est prêt");
        } catch (Exception e) {
            System.out.println("Le serveur de jeux n'a pas pu démarrer :" + e);
            System.out.println(e);
        }
    }
}
