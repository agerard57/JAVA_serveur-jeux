package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfacePendu extends Remote {
//on déclare toutes les fonctions qui se trouvent dans l'implémentation 
    String Mot(int id_game) throws RemoteException;
    String motAffiche(int id_game) throws RemoteException;
    int NbEssais(int id_game) throws RemoteException;
    void proposeLettre(int id_game, char lettre) throws RemoteException;
    int nouveauPendu() throws RemoteException;
    int nouveauPendu(int i) throws RemoteException;
    boolean Fin(int id_game) throws RemoteException;
}