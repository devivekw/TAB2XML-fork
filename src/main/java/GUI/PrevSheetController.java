package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class PrevSheetController extends Application {
	private MainViewController mvc;
	  
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

    public void setMainViewController(MainViewController mvcInput) {
    	mvc = mvcInput;
    }
    
}
