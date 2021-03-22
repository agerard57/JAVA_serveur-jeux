package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfacePendu extends Remote {

    String Mot(int id_game) throws RemoteException;
    String motAffiche(int id_game) throws RemoteException;
    int NbEssais(int id_game) throws RemoteException;
    void proposELettre(int id_game, char lettre) throws RemoteException;
    int nouveauPendu() throws RemoteException;
    boolean Fin(int id_game) throws RemoteException;
}