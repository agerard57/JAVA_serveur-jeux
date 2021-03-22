package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface InterfaceAllumettes extends Remote{
	
	public int nbAllumettes(int idPartie) throws RemoteException;
	public boolean tourDe(int id, int idPartie) throws RemoteException;
	public void retirerAllumette(int nbAl, int idPartie) throws RemoteException;
	public int[] rejoindrePartie() throws RemoteException;
	public boolean enAttente(int idP) throws RemoteException;
	public boolean Fin(int idPartie) throws RemoteException;
	public int Gagnant(int idPartie) throws RemoteException;

}
