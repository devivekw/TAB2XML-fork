package GUI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import converter.*;
//import javafx.scene.layout.AnchorPane;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import java.io.ByteArrayInputStream;
//import javafx.scene.Scene;


public class PrevSheetController extends Application {
	private MainViewController mvc;
//	public Converter converter;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
//		FXMLLoader loader = new FXMLLoader();
//		AnchorPane layout = (AnchorPane) loader.load(
//		  new ByteArrayInputStream(converter.getMusicXML().getBytes())
//		);
//		primaryStage.setScene(new Scene(layout));
//	    primaryStage.show();
	}
	

    public void setMainViewController(MainViewController mvcInput) {
    	mvc = mvcInput;
    }
    
}
