package Client;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Client extends Application{
	
    private double xPos = 0;
    private double yPos = 0; //Initialisation de la position X et Y de la fenêtre
    
	 @Override
	    public void start(final Stage primaryStage) throws IOException {
	        primaryStage.initStyle(StageStyle.UNDECORATED); //Enlève la barre supérieure de la fenêtre
	        primaryStage.setTitle("Serveur de Jeux"); //Titre de l'application
	        primaryStage.getIcons().add(new Image("file:medias/jeux.png")); //Image représentant l'application

			Parent root = FXMLLoader.load(this.getClass().getResource("/gabarit.fxml")); //Chargement du gabarit

			//Fonction "clique sur la fenêtre"
	        root.setOnMousePressed(new EventHandler<MouseEvent>() { 
	            @Override
	            public void handle(MouseEvent event) {
	                xPos = event.getSceneX();
	                yPos = event.getSceneY();
	            }
	        });
	        root.setOnMouseDragged(new EventHandler<MouseEvent>() { 
	            @Override
	            public void handle(MouseEvent event) {
	                primaryStage.setX(event.getScreenX() - xPos);
	                primaryStage.setY(event.getScreenY() - yPos);
	            }
	        });

	        Scene scene = new Scene(root, 800, 500); //Taille de la fenêtre
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	    }
		

	
	public static void main(String[] args){
		launch(Client.class, args);
}
	

}