package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceTTT extends Remote {
	boolean[] nouvellePartie() throws RemoteException;

}