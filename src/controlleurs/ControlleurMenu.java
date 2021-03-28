package controlleurs;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class ControlleurMenu
{

	
	
 //--------------------------ITEMS------------------------------	
	
	
	
    @FXML
    private AnchorPane apMenuPrincipal;
    
    
    @FXML
    private Label lblMenu;

    
    
 //--------------------------ACTIONS-----------------------------    
    
 

    
    
    @FXML
    void txtMenu(MouseEvent event) {
    	lblMenu.setText("Bienvenue dans notre serveur de Jeux !");
    }
    
    @FXML
    void txtPendu(MouseEvent event) {
    	lblMenu.setText("Le jeu du pendu");
    }

    @FXML
    void txtAllumettes(MouseEvent event) {
    	lblMenu.setText("Le jeu des allumettes");
    }

    @FXML
    void txtTTT(MouseEvent event) {
    	lblMenu.setText("Le jeu du Tic-Tac-Toe");
    }

    
    

    @FXML
    void pageJeuPendu(MouseEvent event) throws IOException{
    	VBox pane = FXMLLoader.load(getClass().getResource("/pendu.fxml"));
    	apMenuPrincipal.getChildren().setAll(pane);
    }
    
    @FXML
    void pageJeuAllumettes(MouseEvent event) throws IOException{
    	VBox pane = FXMLLoader.load(getClass().getResource("/allumettes.fxml"));
    	apMenuPrincipal.getChildren().setAll(pane);
    }

    @FXML
    void pageJeuTTT(MouseEvent event) throws IOException{
    	VBox pane = FXMLLoader.load(getClass().getResource("/ttt.fxml"));
    	apMenuPrincipal.getChildren().setAll(pane);
    }
 
}
