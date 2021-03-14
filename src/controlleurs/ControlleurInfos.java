package controlleurs;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControlleurInfos 
{
	
 //--------------------------ITEMS------------------------------
	

	
    @FXML
    private Button btnFermer;

    
    
 //--------------------------ACTIONS-----------------------------
    
    
    
    @FXML
    void fermerPage(ActionEvent event) 
    {
		Stage stage = (Stage) btnFermer.getScene().getWindow();
		stage.close();
    }
    

   
    
 //--------------------------A PROPOS------------------------------ 
    
    
    
    @FXML
    void pageGit(MouseEvent event) 
    {
    	try 
    	{
    	    Desktop.getDesktop().browse(new URL("https://github.com/agerard57/Serveur_jeux").toURI());
    	}
    	catch (IOException e) 
    	{
    	    e.printStackTrace();
    	}
    	catch (URISyntaxException e) 
    	{
    	    e.printStackTrace();
    	}

    }

   

    @FXML
    void pageTrello(MouseEvent event) 
    {
    	try 
    	{
    	    Desktop.getDesktop().browse(new URL("https://trello.com/b/RvNkf8NE/serveurjeux").toURI());
    	}
    	catch (IOException e) 
    	{
    	    e.printStackTrace();
    	}
    	catch (URISyntaxException e) 
    	{
    	    e.printStackTrace();
    	}

    }
    
    
    
}

