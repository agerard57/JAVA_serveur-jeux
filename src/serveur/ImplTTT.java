package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ImplTTT extends UnicastRemoteObject implements InterfaceTTT{

	private boolean idJoueur1;
	private boolean idJoueur2;
	private boolean tourJoueur1;
	private boolean tourJoueur2;
	private int idJeu;
	private ArrayList<Boolean> enAttente;
	
	protected ImplTTT() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public void Notifier() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Jouer() throws RemoteException {
		// TODO Auto-generated method stub
		if (tourJoueur1=true){
			
		}
		if (tourJoueur2=true){
			
		}
	}

	@Override
	public boolean[] nouvellePartie() {
			tourJoueur1=true;
			tourJoueur2=false;
			boolean[] tourDe ={tourJoueur1 , tourJoueur2};
		//	boolean[] tourDe ={tourJoueur1};
			return tourDe;
	}
		
	
	public boolean enAttente(int idP) throws RemoteException {
		return enAttente.get(idP);
	}

	
	@Override
	public char Fin(int index) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
