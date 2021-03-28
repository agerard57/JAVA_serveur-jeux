package controlleurs;

import java.beans.EventHandler;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

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
    private boolean tourJoueur2;
    InterfaceTTT jeu;
    public int numTour;

    public int numbtn;
    public Image image;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){   
    	try{
    		int port=8000;
    		jeu = (InterfaceTTT) Naming.lookup("rmi://localhost:8000/tictactoe");
    		boolean[] tourDe = jeu.nouvellePartie();
    		
    		tourJoueur1 = tourDe[0];
    		tourJoueur2 = tourDe[1];
    		
    		numTour=0;
    		
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
    
    public Image cliquer(){
    	if (numTour%2==0){
    		image=croix;
    	}else{
    		image=cercle;
    	}
		return image;
    }
   
     public void clic00(Image image){
    	try{
    	btn00.setVisible(false);
    	img00.setImage(image);
    	
    		tourJoueur1=true;
    		tourJoueur2=false;
    	}catch(Exception e) {
			e.printStackTrace();
		}
    }

     
    public void clic01(){
    	try{
        	btn01.setVisible(false);
        	if (tourJoueur1=true){
        		img01.setImage(croix);}
        	else {
        		img01.setImage(cercle);};
        	}catch(Exception e) {
    			e.printStackTrace();
    		}
        }
 
    
    public void clic02(){
    	try{
        	
        	}catch(Exception e) {
    			e.printStackTrace();
    		} 
    	
        } 
    
    @FXML
    void clic10(MouseEvent event){
    	try{
    		btn00.setDisable(false);
			img00.setImage(croix);
    	//lblTTT.setText("Okk");
    	}catch(Exception e) {
			e.printStackTrace();
		}
    } 
    @FXML
    void clic11(MouseEvent event){
    	try{
    		btn00.setDisable(false);
			img00.setImage(croix);
    	//lblTTT.setText("Okk");
    	}catch(Exception e) {
			e.printStackTrace();
		}
    } 
    @FXML
    void clic12(MouseEvent event){
    	try{
    		btn00.setDisable(false);
			img00.setImage(croix);
    	//lblTTT.setText("Okk");
    	}catch(Exception e) {
			e.printStackTrace();
		}
    } 
    @FXML
    void clic20(MouseEvent event){
    	try{
    		btn00.setDisable(false);
			img00.setImage(croix);
    	//lblTTT.setText("Okk");
    	}catch(Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    void clic21(MouseEvent event){
    	try{
    		btn00.setDisable(false);
			img00.setImage(croix);
    	//lblTTT.setText("Okk");
    	}catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clic22(MouseEvent event){
    	try{
    		btn00.setDisable(false);
			img00.setImage(croix);
    	//lblTTT.setText("Okk");
    	}catch(Exception e) {
			e.printStackTrace();
		}
    }
    public void clicBoutons (Image image){
    	if (btn00.getOnMouseClicked() != null){
    		
    	}
   // 	btn00.setOnAction(new EventHandler<ActionEvent>(){});
   	}
    
}
