package GUI;

import java.util.List;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import converter.Score;
import converter.measure.TabMeasure;
import custom_exceptions.TXMLException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Part;
import models.part_list.PartList;
import models.part_list.ScorePart;


public class PrevSheetController extends Application {
	private MainViewController mvc;
	@FXML 
	public CodeArea mxlTextPre;  

	
	@FXML 
	public void initialize() {
		mxlTextPre.setParagraphGraphicFactory(LineNumberFactory.get(mxlTextPre));
		
		//String musicXml = mvc.converter.getMusicXML();
		//System.out.println(musicXml);
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
    
    public void printMusicXml()  {
		String musicXml = mvc.converter.getMusicXML();
		
		Score score1 = mvc.converter.getScore();

		System.out.println(musicXml);
		//Score score = new Score(musicXml);

		//int printStr1 = score.getMeasureList().size();
		int scoreMeasureListSize = mvc.converter.getScore().getMeasureList().size();
		int noteSize = score1.getMeasureList().get(1).getSortedNoteList().size();
		List<TabMeasure> measureList = score1.getMeasureList();
		for(int i=0; i<measureList.size();i++) {
			for (int j=0; j<measureList.get(i).getSortedNoteList().size();j++)
			{
				String note = measureList.get(i).getSortedNoteList().get(j).getModel().getUnpitched().getDisplayStep();
				System.out.println(note);
			}
			
		}
		System.out.println("note size: "+ noteSize);
		int printStr11 = score1.getMeasureList().size();
		
		List<Part> partList = score1.getModel().getParts();
		
		System.out.println("score counts: "+score1.getModel().getScoreCount());
		

		
		String clef = partList.get(0).getMeasures().get(0).getAttributes().clef.sign;
		//String printStr2 = score.getModel().getParts().get(0).getId();
		//int printInt = score.getModel().getPartList().getScoreParts().size();
		System.out.printf("clef of this music sheet: %s", clef);
		
    }
}
