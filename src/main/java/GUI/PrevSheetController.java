package GUI;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class PrevSheetController extends Application {
	private MainViewController mvc;
	@FXML 
	public CodeArea mxlTextPre;  
	
	@FXML 
	public void initialize() {
		mxlTextPre.setParagraphGraphicFactory(LineNumberFactory.get(mxlTextPre));
	}
	@Override
	
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Group box = new Group();
		for (int i=0;i<5;i++) {
			Line line = new Line();
			line.setStartX(100.0);
			line.setStartY(250.0-10.0*i);
			line.setEndX(900.0);
			line.setEndY(250.0-10.0*i);
			box.getChildren().add(line);
			}
		

		Scene scene = new Scene(box,1000,600);
		
		primaryStage.setTitle("music sheet");
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	

    public void setMainViewController(MainViewController mvcInput) {
    
		
		
    	mvc = mvcInput;
    	

    }
    
}
