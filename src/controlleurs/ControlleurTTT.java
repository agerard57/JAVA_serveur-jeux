package controlleurs;

import java.beans.EventHandler;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import Client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import serveur.InterfaceTTT;

public class ControlleurTTT implements Initializable{

    @FXML
    private Label lblTTT;
    
    @FXML
    private Button btn00;
    
    @FXML
    private Button btn01;
    
    @FXML
    private Button btn02;
    
    @FXML
    private Button btn10;
    
    @FXML
    private Button btn11;
    
    @FXML
    private Button btn12;
    
    @FXML
    private Button btn20;
    
    @FXML
    private Button btn21;
    
    @FXML
    private Button btn22;
    
    @FXML
    private ImageView img00;
    
    @FXML
    private ImageView img01;
    
    @FXML
    private ImageView img02;
    
    @FXML
    private ImageView img10;
    
    @FXML
    private ImageView img11;
    
    @FXML
    private ImageView img12;
    
    @FXML
    private ImageView img20;
    
    @FXML
    private ImageView img21;
    
    @FXML
    private ImageView img22;
    
    private Image cercle = new Image("file:medias/cerclebleu.png");
    private Image croix = new Image("file:medias/croixrouge.png");
       
    private boolean tourJoueur1;
    
    InterfaceTTT jeu;
    public int numTour;

    public int numbtn;
    public Image image;
    
    public char[][] tabJeu = new char[3][3]; //variable qui stocke les croix et les ronds de chaque tour pour permettre de savoir qui a gagné ou perdu
    public String phraseVictoire;
    public boolean victoire;
    
    
    //on débute la classe en la connectant au serveur rmi
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){   
    	try{
    		int port=8000;
    		jeu = (InterfaceTTT) Naming.lookup("rmi://localhost:8000/tictactoe");
    		//récuparation des variables définissant à qui est le tour
    		boolean[] tourDe = jeu.nouvellePartie();
    		tourJoueur1 = tourDe[0];
    		
    		numTour=0;
    		
    		//cette focntion peut servir si on laisse le choix au client de quel joueur commence
    		//meme si ici ça sera toutjours le joueur 1 qui commencera la partie
    		if (tourJoueur1=true){
    			lblTTT.setText("Tour du joueur 1");
    			System.out.println("Tour du joueur 1");
    			//Image image = croix;
    			//	clic00();
    			
    		}else{
    			lblTTT.setText("Tour du joueur 2");
    			System.out.println("Tour du joueur 2");
    			//Image image = cercle;
    		}
    		
    	
    	}catch (Exception e){
    		System.out.println("Client exception : " + e);
    	}
    	}
    
    
    //definit quel joueur vient de jouer
    public boolean cliquer(){
    	if (numTour%2==0){ //si le reste de la division par deux de la variable numTour est égale à zero alors...
    		System.out.println("Le joueur 1 vient de jouer");
    	}else{  //sinon...
    		System.out.println("Le joueur 2 vient de jouer");
    	}
		return tourJoueur1;
    }
    
    /*vérifie si le joueur 1 ou le joueur 2 a gagné
    si aucun des deux n'a gagné et que tout le tableau du tictactoe est rempli, on le signale
    si un des joueurs a gagné, on va affiché sur quelle ligne ou sur quelle colonne ou sur quelle diagonale il a gagné,
    puis on supprime l'accès à tous les boutons pour qu'on ne puisse pas en recocher juste derrière
    possibilité de rajout d'une fonction pour recommencer une partie (temps manquant)
    */
    public void verifVictoire(){
    	victoire=true;
    	//-----victoire J1----------------------------------------------------------------------------------------------------------------------
    	if ((tabJeu[0][0]=='x')&&(tabJeu[0][1]=='x')&&(tabJeu[0][2]=='x')) phraseVictoire="Joueur1 a gagné sur la ligne 1";
    	else if ((tabJeu[1][0]=='x')&&(tabJeu[1][1]=='x')&&(tabJeu[1][2]=='x')) phraseVictoire="Joueur1 a gagné sur la ligne 2";
    	else if ((tabJeu[2][0]=='x')&&(tabJeu[2][1]=='x')&&(tabJeu[2][2]=='x')) phraseVictoire="Joueur1 a gagné sur la ligne 3";
    	else if ((tabJeu[0][0]=='x')&&(tabJeu[1][0]=='x')&&(tabJeu[2][0]=='x')) phraseVictoire="Joueur1 a gagné sur la colonne 1";
    	else if ((tabJeu[0][1]=='x')&&(tabJeu[1][1]=='x')&&(tabJeu[2][1]=='x')) phraseVictoire="Joueur1 a gagné sur la colonne 2";
    	else if ((tabJeu[0][2]=='x')&&(tabJeu[1][2]=='x')&&(tabJeu[2][2]=='x')) phraseVictoire="Joueur1 a gagné sur la colonne 3";
    	else if ((tabJeu[0][0]=='x')&&(tabJeu[1][1]=='x')&&(tabJeu[2][2]=='x')) phraseVictoire="Joueur1 a gagné sur la diagonale G-D";
    	else if ((tabJeu[0][2]=='x')&&(tabJeu[1][1]=='x')&&(tabJeu[2][0]=='x')) phraseVictoire="Joueur1 a gagné sur la diagonale D-G";
    	//-----victoire J2-----------------------------------------------------------------------------------------------------------------------
    	else if ((tabJeu[0][0]=='o')&&(tabJeu[0][1]=='o')&&(tabJeu[0][2]=='o')) phraseVictoire="Joueur2 a gagné sur la ligne 1";
    	else if ((tabJeu[1][0]=='o')&&(tabJeu[1][1]=='o')&&(tabJeu[1][2]=='o')) phraseVictoire="Joueur2 a gagné sur la ligne 2";
    	else if ((tabJeu[2][0]=='o')&&(tabJeu[2][1]=='o')&&(tabJeu[2][2]=='o')) phraseVictoire="Joueur2 a gagné sur la ligne 3";
    	else if ((tabJeu[0][0]=='o')&&(tabJeu[1][0]=='o')&&(tabJeu[2][0]=='o')) phraseVictoire="Joueur2 a gagné sur la colonne 1";
    	else if ((tabJeu[0][1]=='o')&&(tabJeu[1][1]=='o')&&(tabJeu[2][1]=='o')) phraseVictoire="Joueur2 a gagné sur la colonne 2";
    	else if ((tabJeu[0][2]=='o')&&(tabJeu[1][2]=='o')&&(tabJeu[2][2]=='o')) phraseVictoire="Joueur2 a gagné sur la colonne 3";
    	else if ((tabJeu[0][0]=='o')&&(tabJeu[1][1]=='o')&&(tabJeu[2][2]=='o')) phraseVictoire="Joueur2 a gagné sur la diagonale G-D";
    	else if ((tabJeu[0][2]=='o')&&(tabJeu[1][1]=='o')&&(tabJeu[2][0]=='o')) phraseVictoire="Joueur2 a gagné sur la diagonale D-G";
    	//--------si aucun des deux joueurs n'a gagné--------------------------------------------------------------------------------------------------------------------
    	else {victoire=false;
    		phraseVictoire="Il n'a pas gagné, au tour du joueur suivant";
    		lblTTT.setText("Aucun gagnant");
    	}
    	//-------si victoire d'un des deux joueurs---------------------------------------------------------------------------------------------------------------------
    	if (victoire) {
    		lblTTT.setText(phraseVictoire);
    		btn00.setDisable(true);
    		btn01.setDisable(true);
    		btn02.setDisable(true);
    		btn10.setDisable(true);
    		btn11.setDisable(true);
    		btn12.setDisable(true);
    		btn20.setDisable(true);
    		btn21.setDisable(true);
    		btn22.setDisable(true);
    	}
    	//on affiche le résultat de victoire ou de non victoire grace à la variable phraseVictoire qui stocke le résultat
    	System.out.println(phraseVictoire);
    }
    
   
    
    /*
     Toutes les prochaines focntions sont les fonctions évenements répondant au clic sur une des cases du tictactoe
     Ici, les cases sont des boutons, qui une fois cliqué s'effaceront du cadre, 
     et laisseront apparaitre soit une croix soit un rond en fonction du tour du joueur
     */
    
    //bouton en haut à gauche
	public void clic00(){
    	//System.out.println(numTour);
    	cliquer();
    	try{
    	btn00.setVisible(false);
    	if ((numTour==0)||(numTour==2)||(numTour==4)||(numTour==6)||(numTour==8))
    		{img00.setImage(croix);
    		tabJeu[0][0]='x';    		}
    	else {img00.setImage(cercle);
    	tabJeu[0][0]='o';    	}
    	numTour++;
    	//System.out.println(numTour);
    	//System.out.println(tabJeu[0][0]);
    	verifVictoire();
    	}catch(Exception e) {
			e.printStackTrace();
		}
    }

    //bouton en haut au milieu 
    public void clic01(){
    	cliquer();
    	try{
        	btn01.setVisible(false);
        	if ((numTour==0)||(numTour==2)||(numTour==4)||(numTour==6)||(numTour==8)) 
        		{img01.setImage(croix);
        		tabJeu[0][1]='x';}
        	else {img01.setImage(cercle);
        	tabJeu[0][1]='o';        	}
        	numTour++;
        	//System.out.println(numTour);
        	//System.out.println(tabJeu[0][1]);
        	verifVictoire();
        	}catch(Exception e) {
    			e.printStackTrace();
    		}
        }
 
    //bouton en haut à droite
    public void clic02(){
    	cliquer();
    	try{
    	btn02.setVisible(false);
    	if ((numTour==0)||(numTour==2)||(numTour==4)||(numTour==6)||(numTour==8)) 
    		{img02.setImage(croix);
    		tabJeu[0][2]='x';	}
    	else {img02.setImage(cercle);
    	tabJeu[0][2]='o';    	}
    	numTour++;
    	//System.out.println(numTour);
    	//System.out.println(tabJeu[0][2]);
    	verifVictoire();
        	}catch(Exception e) {
    			e.printStackTrace();
    		} 
    	
        } 
    
    //bouton au milieu à gauche
    public void clic10(){
    	cliquer();
    	try{
    	btn10.setVisible(false);
    	if ((numTour==0)||(numTour==2)||(numTour==4)||(numTour==6)||(numTour==8)) 
    		{img10.setImage(croix);
    		tabJeu[1][0]='x';    		}
    	else {img10.setImage(cercle);
    	tabJeu[1][0]='o';    	}
    	numTour++;
    	//System.out.println(numTour);
    	//System.out.println(tabJeu[1][0]);
    	verifVictoire();
        	}catch(Exception e) {
    			e.printStackTrace();
    		} 
    	
        } 
    
    //bouton au milieu
    public void clic11(){
    	cliquer();
    	try{
    	btn11.setVisible(false);
    	if ((numTour==0)||(numTour==2)||(numTour==4)||(numTour==6)||(numTour==8)) 
    		{img11.setImage(croix);
    		tabJeu[1][1]='x';    		}
    	else {img11.setImage(cercle);
    	tabJeu[1][1]='o';    	}
    	numTour++;
    	//System.out.println(numTour);
    	//System.out.println(tabJeu[1][1]);
    	verifVictoire();
        	}catch(Exception e) {
    			e.printStackTrace();
    		} 
    	
        } 
    
    //bouton au milieu à droite
    public void clic12(){
    	cliquer();
    	try{
    	btn12.setVisible(false);
    	if ((numTour==0)||(numTour==2)||(numTour==4)||(numTour==6)||(numTour==8)) 
    		{img12.setImage(croix);
    		tabJeu[1][2]='x';    		}
    	else {img12.setImage(cercle);
    	tabJeu[1][2]='o';    	}
    	numTour++;
    	//System.out.println(numTour);
    	//System.out.println(tabJeu[1][2]);
    	verifVictoire();
        	}catch(Exception e) {
    			e.printStackTrace();
    		} 
    	
        } 
    
    //bouton en bas à gauche
    public void clic20(){
    	cliquer();
    	try{
    	btn20.setVisible(false);
    	if ((numTour==0)||(numTour==2)||(numTour==4)||(numTour==6)||(numTour==8)) 
    		{img20.setImage(croix);
    		tabJeu[2][0]='x';    		}
    	else {img20.setImage(cercle);
    	tabJeu[2][0]='o';    	}
    	numTour++;
    	//System.out.println(numTour);
    	//System.out.println(tabJeu[2][0]);
    	verifVictoire();
        	}catch(Exception e) {
    			e.printStackTrace();
    		} 
    	
        } 
    
    //bouton en bas au milieu
    public void clic21(){
    	cliquer();
    	try{
    	btn21.setVisible(false);
    	if ((numTour==0)||(numTour==2)||(numTour==4)||(numTour==6)||(numTour==8)) 
    		{img21.setImage(croix);
    		tabJeu[2][1]='x';    		}
    	else {img21.setImage(cercle);
    	tabJeu[2][1]='o';    	}
    	numTour++;
    	//System.out.println(numTour);
    	//System.out.println(tabJeu[2][1]);
    	verifVictoire();
        	}catch(Exception e) {
    			e.printStackTrace();
    		} 
    	
        } 
    
    //bouton en bas à droite
    public void clic22(){
    	cliquer();
    	try{
    	btn22.setVisible(false);
    	if ((numTour==0)||(numTour==2)||(numTour==4)||(numTour==6)||(numTour==8)) 
    		{img22.setImage(croix);
    		tabJeu[2][2]='x';    		}
    	else {img22.setImage(cercle);
    	tabJeu[2][2]='o';    	}
    	numTour++;
    	//System.out.println(numTour);
    	//System.out.println(tabJeu[2][2]);
    	verifVictoire();
        	}catch(Exception e) {
    			e.printStackTrace();
    		} 
    	
        } 
    

}

