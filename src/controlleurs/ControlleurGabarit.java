package controlleurs;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControlleurGabarit  
{
 
	
	
 //-----------------------DECLARATIONS--------------------------
    
	
	
    @FXML
    private ImageView btnClose;

    
    @FXML
    private AnchorPane apMenuPrincipal;

    
    
 //--------------------------ITEMS------------------------------
   
    
    
	@FXML
	public void initialize() throws IOException
	{
		VBox pane = FXMLLoader.load(getClass().getResource("/menu.fxml"));
		apMenuPrincipal.getChildren().setAll(pane);	
	}
	
	
	
	@FXML 
    void pageHome(MouseEvent event) throws IOException 
	{
    	VBox pane = FXMLLoader.load(getClass().getResource("/menu.fxml"));
    	apMenuPrincipal.getChildren().setAll(pane);
    }
    
	
	
    @FXML 
    void pageInfos(MouseEvent event) throws IOException 
    {
    	Parent part = FXMLLoader.load(getClass().getResource("/infos.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setTitle("Informations");
        stage.getIcons().add(new Image("file:medias/infos.png"));
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    @FXML 
    void pageReduire(MouseEvent event)
    {
    	Stage stage = (Stage) btnClose.getScene().getWindow(); 
    	stage.setIconified(true);
    }

    
    
    @FXML 
	void pageFermer(MouseEvent event)
    {
		Stage stage = (Stage) btnClose.getScene().getWindow();
		stage.close();
		System.exit(1);
    }

    

}
