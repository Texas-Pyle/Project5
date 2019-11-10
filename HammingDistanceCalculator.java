import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HammingDistanceCalculator extends Application {

	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage applicationStage) throws Exception {
		GridPane gridPane = new GridPane();
		Scene scene = new Scene(gridPane);
		
		TextField distance0 = new TextField();
		TextField distance1 = new TextField();
		TextField distance2 = new TextField();
		TextField distance3 = new TextField();
		TextField distance4 = new TextField();
		TextField hammingDistance = new TextField();
		hammingDistance.setEditable(false);
		TextField addStationsTxt = new TextField();
		
		TextArea StationsBox = new TextArea();
		StationsBox.setEditable(false);
		StationsBox.setPrefSize(100	,250); 
		
		
		Label hammingDistanceLabel = new Label("Enter Hamming Dist:");
		Label distanceLable0 = new Label("Distance0");
		Label distanceLabel1 = new Label("Distance1");
		Label distanceLabel2 = new Label ("Distance2");
		Label distanceLabel3 = new Label ("Distance3");
		Label distanceLabel4 = new Label ("Distance4");
		Label compareWithLabel = new Label ("Compare with:");
		
		
		
		Button showStation = new Button("Show Station");
		Button calculateHD = new Button("Calculate HD");
		Button addStation = new Button ("Add Station");
		
		ComboBox compareWithDropBox = new ComboBox();
		compareWithDropBox.getItems().addAll("Test");
		
		Slider hammingValue = new Slider();
		hammingValue.setMax(4);
		hammingValue.setMin(1);
		hammingValue.setMinorTickCount(0);
		hammingValue.setMajorTickUnit(1);
		hammingValue.setBlockIncrement(1);
		
		hammingValue.setShowTickMarks(true);
		hammingValue.setSnapToTicks(true);
		hammingValue.setShowTickLabels(true);
		
		gridPane.setColumnSpan(StationsBox, 2);
		
		gridPane.add(hammingDistanceLabel,0,0);
		gridPane.add(hammingDistance,1,0);
		gridPane.add(hammingValue, 0, 1);
		gridPane.add(showStation, 0, 2);
		gridPane.add(StationsBox, 0, 3);
		gridPane.add(compareWithLabel, 0, 4);
		gridPane.add(compareWithDropBox,1,4);
		gridPane.add(calculateHD, 0, 5);
		gridPane.add(distance0, 1, 6);
		gridPane.add(distanceLable0, 0, 7);
		gridPane.add(distance1, 1, 8);
		gridPane.add(distanceLabel1, 0, 8);
		gridPane.add(distance2, 1, 10);
		gridPane.add(distanceLabel2, 0, 10);
		gridPane.add(distance3, 1, 11);
		gridPane.add(distanceLabel3, 0, 11);
		gridPane.add(distance4, 1, 12);
		gridPane.add(distanceLabel4, 0, 12);
		gridPane.add(addStation, 0, 13);
		gridPane.add(addStationsTxt, 1, 13);
		
		
		
		

		
		Insets gdridPadding = new Insets(10,10,10,10);
		gridPane.setPadding(gdridPadding);
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		applicationStage.setScene(scene);
		applicationStage.setTitle("Hamming Distance");
		applicationStage.show();
		
		showStation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//TODO: finish this 
			}
		});
		calculateHD.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//TODO: finish this
			}
		});
		addStation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//TODO: finish this
			}
		});
		
	}
	
	

}
