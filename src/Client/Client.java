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
    private double yPos = 0; //Initialisation de la position X et Y de la fen�tre
    
	 @Override
	    public void start(final Stage primaryStage) throws IOException {
	        primaryStage.initStyle(StageStyle.UNDECORATED); //Enl�ve la barre sup�rieure de la fen�tre
	        primaryStage.setTitle("Serveur de Jeux"); //Titre de l'application
	        primaryStage.getIcons().add(new Image("file:medias/jeux.png")); //Image repr�sentant l'application

			Parent root = FXMLLoader.load(this.getClass().getResource("/gabarit.fxml")); //Chargement du gabarit

			//Fonction "clique sur la fen�tre"
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

	        Scene scene = new Scene(root, 800, 500); //Taille de la fen�tre
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	    }
		

	
	public static void main(String[] args){
		launch(Client.class, args);
}
	

}