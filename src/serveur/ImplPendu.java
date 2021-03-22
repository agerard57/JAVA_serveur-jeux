package serveur;

import javafx.scene.control.Button;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ImplPendu extends UnicastRemoteObject implements InterfacePendu{

	 ArrayList<ArrayList<Character>> listeListeLettre;
	    ArrayList<String> listeMot;
	    ArrayList<Integer> listeEssais;

	    ArrayList<String> toutLesMots;

	    int nbGame;

	    public ImplPendu() throws RemoteException {
	        super();
	        nbGame = -1;
	        listeListeLettre = new ArrayList<ArrayList<Character>>();
	        listeMot = new ArrayList<String>();
	        listeEssais = new ArrayList<Integer>();
	        toutLesMots = new ArrayList<String>();

	        toutLesMots.add("Carotte");
	        toutLesMots.add("Choux Fleur");
	        toutLesMots.add("Pois Chiche");
	        toutLesMots.add("Table");
	        toutLesMots.add("Chat");
	        toutLesMots.add("Etabli");
	        toutLesMots.add("Bureau");
	        toutLesMots.add("Tapis de jeu");
	    }

	    @Override
	    public String motAffiche(int id_game) {
	        String affichage = new String();
	        boolean found;
	        int i;
	        int j;

	        i = 0;
	        while (i < listeMot.get(id_game).length()) {
	            j = 0;

	            found = false;
	            while (j < listeListeLettre.get(id_game).size()) {
	                if (listeListeLettre.get(id_game).get(j) == listeMot.get(id_game).charAt(i) || listeListeLettre.get(id_game).get(j) == Character.toLowerCase(listeMot.get(id_game).charAt(i))) {
	                    found = true;
	                    affichage = affichage + " " + listeMot.get(id_game).charAt(i);
	                }
	                j++;
	            }
	            if (!found)
	                affichage = affichage + " _";
	            i++;
	        }

	        return (affichage);
	    }

	    @Override
	    public String Mot(int id_game) {
	        return (listeMot.get(id_game));
	    }

	    @Override
	    public int NbEssais(int id_game) {
	        return (listeEssais.get(id_game));
	    }

	    @Override
	    public void proposeLettre(int id_game, char lettre) {
	        if (!listeMot.get(id_game).contains(Character.toString(lettre)) && !listeMot.get(id_game).contains(Character.toString(lettre).toUpperCase())) {
	            listeEssais.set(id_game, listeEssais.get(id_game) + 1);
	        }
	        else
	        listeListeLettre.get(id_game).add(lettre);
	    }

	    @Override
	    public boolean Fin(int id_game) {
	        if (listeEssais.get(id_game) >= 7)
	            return (true);
	        else {
	            boolean found;
	            int i;

	            i = 0;
	            found = true;
	            while (found && i < listeMot.get(id_game).length()) {
	                if (!listeListeLettre.get(id_game).contains(listeMot.get(id_game).charAt(i)) && !listeListeLettre.get(id_game).contains(Character.toLowerCase(listeMot.get(id_game).charAt(i)))) {
	                    found = false;
	                }
	                i++;
	            }

	            if (!found)
	                return (false);
	            return (true);
	        }
	    }

	    @Override
	    public int nouveauPendu() {
	        listeListeLettre.add(new ArrayList<Character>());
	        listeMot.add(toutLesMots.get((int) (Math.random() * toutLesMots.size())));
	        listeEssais.add(0);

	        nbGame++;
	        listeListeLettre.get(nbGame).add(' ');
	        listeListeLettre.get(nbGame).add('\'');
	        return (nbGame);
	    }
	
	
}
