package controlleurs;

import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import serveur.InterfaceAllumettes;

public class ControlleurAllumettes implements Initializable {

	
	
//-----------------------DECLARATIONS--------------------------	
	
	
	
    @FXML
    private Label lblAllumettes;

    @FXML
    private ImageView allumette15;

    @FXML
    private ImageView allumette14;

    @FXML
    private ImageView allumette13;

    @FXML
    private ImageView allumette12;

    @FXML
    private ImageView allumette11;

    @FXML
    private ImageView allumette10;

    @FXML
    private ImageView allumette9;

    @FXML
    private ImageView allumette8;

    @FXML
    private ImageView allumette7;

    @FXML
    private ImageView allumette6;

    @FXML
    private ImageView allumette5;

    @FXML
    private ImageView allumette4;

    @FXML
    private ImageView allumette3;

    @FXML
    private ImageView allumette2;

    @FXML
    private ImageView allumette1;

    @FXML
    private Text lbl_tour;

    @FXML
    private Button btn_nouveau;

    @FXML
    private Button btn_moins1;

    @FXML
    private Button btn_moins2;

    @FXML
    private Button btn_moins3;
    
	ArrayList<ImageView> listeAllu;
	private int idJoueur;
	private int idPartie;
	InterfaceAllumettes jeu;
	
	
	
//--------------------------ITEMS------------------------------

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		listeAllu = new ArrayList<ImageView>();

		//ajout des allumettes dans l'ArrayList "listeAllu"
		listeAllu.add(allumette1);
		listeAllu.add(allumette2);
		listeAllu.add(allumette3);
		listeAllu.add(allumette4);
		listeAllu.add(allumette5);
		listeAllu.add(allumette6);
		listeAllu.add(allumette7);
		listeAllu.add(allumette8);
		listeAllu.add(allumette9);
		listeAllu.add(allumette10);
		listeAllu.add(allumette11);
		listeAllu.add(allumette12);
		listeAllu.add(allumette13);
		listeAllu.add(allumette14);
		listeAllu.add(allumette15);


		try {
			   int port = 8001; 
			   jeu = (InterfaceAllumettes) Naming.lookup("rmi://localhost:8001/allumettes"); //Recherche du serveur
			   System.out.println("En attente d'un adversaire..."); //Message d'attente

			   int []info = jeu.rejoindrePartie();

				idPartie = info[0]; // Initialisation de la partie
				idJoueur = info[1]; // Initialisation de l'id du joueur

				lbl_tour.setText("A votre tour");
				griserButtons(false); // Active les boutons

		} catch (Exception e) {
			   System.out.println("Client exception: " + e);
		}

	}
	
	public void griserButtons(boolean b){ //Fonction frisant tout les boutons
		btn_moins1.setDisable(b); //Griser le bouton 1
		btn_moins2.setDisable(b); //Griser le bouton 2
		btn_moins3.setDisable(b); //Griser le bouton 3
	}
	
    @FXML
    void moins_1(ActionEvent event) { //Fonction de retrait d'une allumette
    	try {
    		
			jeu.retirerAllumette(1, idPartie); //On passe 1 en variable
			majNbAllumettes(1);

			
		} catch (RemoteException e) {
			
			e.printStackTrace();
			
		}
    }

    @FXML
    void moins_2(ActionEvent event) { //Fonction de retrait de deux allumettes
		try {
			
			jeu.retirerAllumette(2, idPartie); //On passe 2 en variable
			majNbAllumettes(2);

			
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
    }

    @FXML
    void moins_3(ActionEvent event) { //Fonction de retrait de trois allumettes
		try {
		
			jeu.retirerAllumette(3, idPartie); //On passe 3 en variable
			majNbAllumettes(3);

			
		} catch (RemoteException e) {
			
			e.printStackTrace();
			
		}
    }
    
    public void majNbAllumettes(int nbmoins) { //Mise-à-jour de la visibilité des allumettes sur l'écran
		int nbAllu;
		try {
			nbAllu = jeu.nbAllumettes(idPartie);

			for(int i = 1; i <= nbAllu; i++) {	//Boucle rendant visible toutes les autres allumettes
				listeAllu.get(i-nbmoins).setVisible(true);
			}
			
			for(int i = nbAllu; i <= 15; i++) { //Boucle enlevant aux 15 allumettes 
				listeAllu.get(i-nbmoins).setVisible(false);
			}

			if(nbAllu <= 0) { //Si il n'a plus d'allumettes

				if(jeu.tourDe(idJoueur, idPartie)){ //On vérifie qui à gagné
					lbl_tour.setText("Vous avez gagné !"); //J1 gagne
				}else
				{
					lbl_tour.setText("Vous avez perdu !"); //J2 gagne
				}

			}else{
				nouveauTour();
			}

			if(nbAllu < 1) {
				
				btn_moins1.setDisable(true); //On grise le bouton si il reste moins d'une allumette
				
			}
			if(nbAllu < 2) {
				
				btn_moins2.setDisable(true); //On grise le bouton si il reste moins de deux allumettes
				
			}
			if(nbAllu < 3) {
				
				btn_moins3.setDisable(true); //On grise le bouton si il reste moins de trois allumettes
				
			}

		} catch (RemoteException e) {
			
			e.printStackTrace();
			
		}

	}
	
	public void nouveauTour() {

	}



}
