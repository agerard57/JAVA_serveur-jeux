package serveur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ImplPendu extends UnicastRemoteObject implements InterfacePendu{

	 ArrayList<ArrayList<Character>> listeListeLettre;
	    ArrayList<String> listeMot;
	    ArrayList<Integer> listeEssais;

	    ArrayList<String> tousLesMots;

	    int nbGame;

	    public ImplPendu() throws RemoteException {
	        super();
	        nbGame = -1;
	        listeListeLettre = new ArrayList<ArrayList<Character>>();
	        listeMot = new ArrayList<String>();
	        listeEssais = new ArrayList<Integer>();
	        tousLesMots = new ArrayList<String>();
//lecture d'un fichier pour stocker dans une ArrayList tous les mots s'y trouvant 
	        String line;
	        BufferedReader fichier;
	        try
	        {
	        	fichier = new BufferedReader(new FileReader(new File("save.txt")));
	        	while((line = fichier.readLine()) != null ) {
	        		tousLesMots.add(line.replace('\n', ' ').trim());
	        	}
	        	fichier.close();
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	    }
// génère l'affichage du mot en tenant compte des lettres trouvées
	    @Override
	    public String motAffiche(int id_game) {
	        String affichage = new String();
	        boolean trouve;
	        int i;
	        int j;
	        
	        i = 0;
	        while (i < listeMot.get(id_game).length()) {
	            j = 0;

	            trouve = false;
	            while (j < listeListeLettre.get(id_game).size()) {
	                if (listeListeLettre.get(id_game).get(j) == listeMot.get(id_game).charAt(i) || listeListeLettre.get(id_game).get(j) == Character.toLowerCase(listeMot.get(id_game).charAt(i))) {
	                    trouve = true;
	                    affichage = affichage + " " + listeMot.get(id_game).charAt(i);
	                }
	                j++;
	            }
	            if (!trouve)
	                affichage = affichage + " _";
	            i++;
	        }

	        return (affichage);
	    }

	    //on récupère le mot
	    @Override
	    public String Mot(int id_game) {
	        return (listeMot.get(id_game));
	    }

	    //donne le nombre d'essais
	    @Override
	    public int NbEssais(int id_game) {
	        return (listeEssais.get(id_game));
	    }
	    //regarde si la lettre en entrée correspond bien à une lettre du mot de la partie actuelle
	    @Override
	    public void proposeLettre(int id_game, char lettre) {
	        if (!listeMot.get(id_game).contains(Character.toString(lettre)) && !listeMot.get(id_game).contains(Character.toString(lettre).toUpperCase())) {
	            listeEssais.set(id_game, listeEssais.get(id_game) + 1);
	        }
	        else
	        listeListeLettre.get(id_game).add(lettre);
	    }

	    //s'occupe de gérer la fin, que le mot ait été trouvé ou non 
	    @Override
	    public boolean Fin(int id_game) {
	        if (listeEssais.get(id_game) >= 10)
	            return (true);
	        else {
	            boolean trouve;
	            int i;

	            i = 0;
	            trouve = true;
	            while (trouve && i < listeMot.get(id_game).length()) {
	                if (!listeListeLettre.get(id_game).contains(listeMot.get(id_game).charAt(i)) && !listeListeLettre.get(id_game).contains(Character.toLowerCase(listeMot.get(id_game).charAt(i)))) {
	                    trouve = false;
	                }
	                i++;
	            }

	            if (!trouve)
	                return (false);
	            return (true);
	        }
	    }

	    //nouveau pendu si c'est la première partie
	    @Override
	    public int nouveauPendu() {
	        listeListeLettre.add(new ArrayList<Character>());
	        listeMot.add(tousLesMots.get((int) (Math.random() * tousLesMots.size())));
	        listeEssais.add(0);

	        nbGame++;
	        listeListeLettre.get(nbGame).add(' ');
	        listeListeLettre.get(nbGame).add('\'');
	        return (nbGame);
	    }
	    //nouveau pendu si il y avait déjà une partie avant celle la 
	    @Override
	    public int nouveauPendu(int i) {
	    	if (i >= nbGame) {
	    		
	    	listeListeLettre.add(new ArrayList<Character>());
	    	listeMot.add(tousLesMots.get((int) (Math.random() * tousLesMots.size())));
	    	listeEssais.add(0);
	    	
	    	nbGame++;
	    	listeListeLettre.get(nbGame).add(' ');
	    	listeListeLettre.get(nbGame).add('\'');
	    	return (nbGame);
	    	}
	    	else {
	    		
	    		listeListeLettre.set(i, new ArrayList<Character>());
	    		listeMot.set(i, tousLesMots.get((int) (Math.random() * tousLesMots.size())));
	    		listeEssais.set(i, 0);
	    		
	    		listeListeLettre.get(i).add(' ');
	    		listeListeLettre.get(i).add('\'');
	    		return (i);
	    	}
	    }
	
	
}
