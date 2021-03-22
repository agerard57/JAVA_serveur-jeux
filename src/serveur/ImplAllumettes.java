package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ImplAllumettes extends UnicastRemoteObject implements InterfaceAllumettes{
	
	private ArrayList<Integer> tourDe;
	private ArrayList<Integer> idJoueur1;
	private ArrayList<Integer> idJoueur2;
	private ArrayList<Integer> nbAllumettes;
	private int idJeu;
	private ArrayList<Boolean> enAttente;
	
	public ImplAllumettes() throws RemoteException {
		super();
		idJeu = 0;
		tourDe = new ArrayList<Integer>();
		idJoueur1 = new ArrayList<Integer>();
		idJoueur2 = new ArrayList<Integer>();
		nbAllumettes = new ArrayList<Integer>();
		enAttente = new ArrayList<Boolean>();
		enAttente.add(false);
	}
	
	public int nbAllumettes(int idPartie) throws RemoteException {
		return nbAllumettes.get(idPartie);
	}
	
	public boolean tourDe(int id, int idPartie) throws RemoteException {
		if(tourDe.get(idPartie)%2 == 1){
			return (id == idJoueur1.get(idPartie));
		}else{
			return (id == idJoueur2.get(idPartie));
		}
	}
	
	public void retirerAllumette(int nbAl, int idPartie) throws RemoteException{
		nbAllumettes.set(idPartie,(nbAllumettes.get(idPartie) - nbAl));
		tourDe.set(idPartie, (tourDe.get(idPartie) + 1));
		synchronized(this){
			this.notifyAll();
		}

		synchronized(this){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public boolean Fin(int idPartie) throws RemoteException {
		return (nbAllumettes.get(idPartie) == 0);
	}
	
	public int Gagnant(int idPartie) throws RemoteException {
		return 0;
	}

	public int[] rejoindrePartie() throws RemoteException {
		if(enAttente.get(idJeu)){
			int[] info = {idJeu, 2};
			enAttente.set(idJeu, false);
			synchronized(this){
				this.notifyAll();
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return info;
		}else{
			if(idJeu != 0){
				idJeu++;
			}
			tourDe.add(1);
			idJoueur1.add(1);
			idJoueur2.add(2);
			nbAllumettes.add(13);
			int[] info = {idJeu, 1};
			if(idJeu == 0){
				enAttente.set(0, true);
			}else{
				enAttente.add(true);
			}
			synchronized(this){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return info;
			
		}
		
	}

	public boolean enAttente(int idP) throws RemoteException {
		return enAttente.get(idP);
	}

}

