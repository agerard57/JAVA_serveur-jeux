package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ImplAllumettes extends UnicastRemoteObject implements InterfaceAllumettes{
	
	private ArrayList<Integer> tourDe;
	private ArrayList<Integer> idJoueur1;
	private ArrayList<Integer> idJoueur2;
	private ArrayList<Integer> nbAllumettes;
	private ArrayList<Boolean> enAttente;
	
	private int idJeu;

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
	
	public boolean tourDe(int id, int idPartie) throws RemoteException { //Fonction qui vérifie qui peut jouer
		if(tourDe.get(idPartie)%2 == 1){
			return (id == idJoueur1.get(idPartie));
		}else{
			return (id == idJoueur2.get(idPartie));
		}
	}
	
	public void retirerAllumette(int nbAl, int idPartie) throws RemoteException{ //Fonction afin de retirer une/des allumette(s)
		nbAllumettes.set(idPartie,(nbAllumettes.get(idPartie) - nbAl)); //Definit le nouveau nombre d'allumettes 
		tourDe.set(idPartie, (tourDe.get(idPartie) + 1)); //Change le tour 
		synchronized(this){
			this.notifyAll();
		}
//Possible erreur ici
		synchronized(this){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public boolean Fin(int idPartie) throws RemoteException {
		return (nbAllumettes.get(idPartie) == 0); //Fonction vérifiant si il reste des allumettes
	}
	
	public int Gagnant(int idPartie) throws RemoteException {
		return 0;
	}

	public int[] rejoindrePartie() throws RemoteException {
		if(enAttente.get(idJeu)){ //Si le jeu trouve un deuxième joueur...
			int[] info = {idJeu, 2};
			enAttente.set(idJeu, false); //...On désactive l'état d'attente
			synchronized(this){
				this.notifyAll(); //On envoi l'information à tous les joueurs
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return info;
		}else{
			if(idJeu != 0){ //Quand le jeu est "en marche"
				idJeu++;
			}
			tourDe.add(1); //Ajout de l'état "tour du joueur 1"
			idJoueur1.add(1); //Ajout du joueur 1
			idJoueur2.add(2); //Ajout du joueur 2
			nbAllumettes.add(15); //Ajout des allumettes
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
					e.printStackTrace();
				}
			}
			return info;
		}
	}

	public boolean enAttente(int idPart) throws RemoteException {
		return enAttente.get(idPart);
	}

}

