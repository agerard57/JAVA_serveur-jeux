package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceTTT extends Remote {
	void Notifier() throws RemoteException;
	void Jouer() throws RemoteException;
	boolean[] nouvellePartie() throws RemoteException;
	char Fin(int index) throws RemoteException;
}