package controlleurs;

import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import serveur.InterfaceAllumettes;

public class ControlleurAllumettes implements Initializable {

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
    
	ArrayList<ImageView> listAllu;
	private int idJoueur;
	private int idPartie;
	private int choix;
	private int nbAllumettes;
	InterfaceAllumettes jeu;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listAllu = new ArrayList<ImageView>();
		listAllu.add(allumette1);
		listAllu.add(allumette2);
		listAllu.add(allumette3);
		listAllu.add(allumette4);
		listAllu.add(allumette5);

		listAllu.add(allumette6);
		listAllu.add(allumette7);
		listAllu.add(allumette8);
		listAllu.add(allumette9);
		listAllu.add(allumette10);

		listAllu.add(allumette11);
		listAllu.add(allumette12);
		listAllu.add(allumette13);
		listAllu.add(allumette14);
		listAllu.add(allumette15);

		nbAllumettes = 15;

		try {
			   int port = 8000;
			   jeu = (InterfaceAllumettes) Naming.lookup("rmi://localhost:8000/allumettes");
			   System.out.println("En attente d'un adversaire...");

			   int []info = jeu.rejoindrePartie();

				idPartie = info[0];
				idJoueur = info[1];

				lbl_tour.setText("A votre tour");
				griserButtons(false);

		} catch (Exception e) {
			   System.out.println("Client exception: " + e);
		}

	}
	
    @FXML
    void moins_1(MouseEvent event) {
    	try {
    		griserButtons(true);
			jeu.retirerAllumette(1, idPartie);
			majNbAllumettes();
			griserButtons(false);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void moins_2(MouseEvent event) {
		try {

			majAffichage(nbAllumettes);
			jeu.retirerAllumette(2, idPartie);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void moins_3(MouseEvent event) {
		try {
			griserButtons(true);
			jeu.retirerAllumette(3, idPartie);
			majNbAllumettes();
			griserButtons(false);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
    
    public void majNbAllumettes() {
		int nbAlu;
		try {
			nbAlu = jeu.nbAllumettes(idPartie);

			for(int i = 1; i <= nbAlu; i++) {
				listAllu.get(i-1).setVisible(true);
			}
			for(int i = nbAlu; i <= 13; i++) {
				listAllu.get(i-1).setVisible(false);
			}

			if(nbAlu <= 0) {

				if(jeu.tourDe(idJoueur, idPartie)){
					lbl_tour.setText("Vous avez gagné !");
				}else{
					lbl_tour.setText("Vous avez perdu !");
				}

			}else {
				nouveauTour();
			}

			if(nbAlu < 3) {
				btn_moins3.setDisable(true);
			}
			if(nbAlu < 2) {
				btn_moins2.setDisable(true);
			}
			if(nbAlu < 1) {
				btn_moins1.setDisable(true);
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void nouveauTour() {

	}

	public void majAffichage(int nbAlu){
		for(int i = 1; i <= nbAlu; i++) {
			listAllu.get(i-1).setVisible(true);
		}
		for(int i = nbAlu; i <= 13; i++) {
			listAllu.get(i-1).setVisible(false);
		}
	}
	
	public void griserButtons(boolean b){
		btn_moins1.setDisable(b);
		btn_moins2.setDisable(b);
		btn_moins3.setDisable(b);
	}
}
