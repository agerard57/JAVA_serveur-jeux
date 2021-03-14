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
	
    private double xOffset = 0;
    private double yOffset = 0;
    
	 @Override
	    public void start(final Stage primaryStage) throws IOException {
	        primaryStage.initStyle(StageStyle.UNDECORATED);
	        primaryStage.setTitle("Serveur de Jeux");
	        primaryStage.getIcons().add(new Image("file:medias/jeux.png"));

			Parent root = FXMLLoader.load(this.getClass().getResource("/gabarit.fxml"));


	        root.setOnMousePressed(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                xOffset = event.getSceneX();
	                yOffset = event.getSceneY();
	            }
	        });
	        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                primaryStage.setX(event.getScreenX() - xOffset);
	                primaryStage.setY(event.getScreenY() - yOffset);
	            }
	        });

	        Scene scene = new Scene(root, 658, 405);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	    }
		

	
	public static void main(String[] args){
		launch(Client.class, args);
}
	

}