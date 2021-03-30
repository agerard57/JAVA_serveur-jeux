package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ImplTTT extends UnicastRemoteObject implements InterfaceTTT{

	private boolean tourJoueur1;
	private boolean tourJoueur2;

	protected ImplTTT() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[] nouvellePartie() {
			tourJoueur1=true;
			tourJoueur2=false;
			boolean[] tourDe ={tourJoueur1 , tourJoueur2};
		//	boolean[] tourDe ={tourJoueur1};
			return tourDe;
	}
	
	public int numTour(){
		int numT=0;
		return numT;
	}
		


	

}
