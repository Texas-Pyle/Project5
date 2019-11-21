
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.io.IOException;
import java.util.ArrayList;

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
	TextField distance0;
	TextField distance1;
	TextField distance2;
	TextField distance3;
	TextField distance4;
	TextField hammingDistance;
	TextField addStationsTxt;
	
	TextArea StationsBox;
	
	Label hammingDistanceLabel;
	Label distanceLablel0;
	Label distanceLablel1;
	Label distanceLablel2;
	Label distanceLablel3;
	Label distanceLablel4;
	Label compareWithLabel;
	
	Button showStation;
	Button calculateHD;
	Button addStation;
	ComboBox<String> compareWithDropBox;
	
	Slider hammingValue;
	GridPane gridPane;
	
	Scene scene;
	
	ArrayList<String> stations;
	public static void main(String[] args) {
		launch(args);
		
	}

	
	@Override
	public void start(Stage applicationStage) throws Exception {
	
		initilizeStationsList();
		
		initizeTextField();
		
		initilizeTextArea();
		
		initilizeLabels();
		
		initilizeButtons();
		
		initilizeComboBox();
		
		initilizeSlider();
		
		initilizePane();
		
		
		
		applicationStage.setScene(scene);
		applicationStage.setTitle("Hamming Distance");
		applicationStage.show();
		
		showStation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				StationsBox.setText("");
				StringBuilder stationsText = new StringBuilder();
				String comparingTo = compareWithDropBox.getValue();
				int desieredHammingDistance = (int) hammingValue.getValue();
				for (int i = 0; i < stations.size(); ++i) {
					if (HammingDist.distCalculator(stations.get(i), comparingTo) == desieredHammingDistance)
						stationsText.append(stations.get(i)+"\n");
				}
				StationsBox.setText(stationsText.toString());
			}
		});
		calculateHD.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String comparingTo = compareWithDropBox.getValue();

				distance0.setText(Integer.toString(HammingDist.simmilarDistance(stations, comparingTo, 0)));

				distance1.setText(Integer.toString(HammingDist.simmilarDistance(stations, comparingTo, 1)));

				distance2.setText(Integer.toString(HammingDist.simmilarDistance(stations, comparingTo, 2)));

				distance3.setText(Integer.toString(HammingDist.simmilarDistance(stations, comparingTo, 3)));

				distance4.setText(Integer.toString(HammingDist.simmilarDistance(stations, comparingTo, 4)));

			}
		});
		addStation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (addStationsTxt.getText().length() ==  4){
				compareWithDropBox.getItems().addAll(addStationsTxt.getText());
					if (StationsBox.getText().equals("Station must be four letters long!!!")) {
						StationsBox.setText("");
					}
				}else 
					StationsBox.setText("Station must be four letters long!!!");	
				
			}
		});
		hammingValue.valueProperty().addListener(new ChangeListener<Number>() {
			
			public void changed(ObservableValue<? extends Number> ov,Number old_val, Number new_val) {
				double currentValue = Math.floor(hammingValue.getValue());
				hammingDistance.setText(Double.toString(currentValue));
			}
		});
	}


	private void initilizeStationsList() throws IOException {
		MesontReader MR = new MesontReader();
		 stations = MR.fileReader();
		
	}


	private void initilizePane() {
		 gridPane = new GridPane();
		 scene = new Scene(gridPane);
		
		gridPane.setColumnSpan(StationsBox, 2);
		
		gridPane.add(hammingDistanceLabel,0,0);
		gridPane.add(hammingDistance,1,0);
		gridPane.add(hammingValue, 0, 1);
		gridPane.add(showStation, 0, 2);
		gridPane.add(StationsBox, 0, 3);
		gridPane.add(compareWithLabel, 0, 4);
		gridPane.add(compareWithDropBox,1,4);
		gridPane.add(calculateHD, 0, 5);
		gridPane.add(distance0, 1, 7);
		gridPane.add(distanceLablel0, 0, 7);
		gridPane.add(distance1, 1, 8);
		gridPane.add(distanceLablel1, 0, 8);
		gridPane.add(distance2, 1, 9);
		gridPane.add(distanceLablel2, 0, 9);
		gridPane.add(distance3, 1, 10);
		gridPane.add(distanceLablel3, 0, 10);
		gridPane.add(distance4, 1, 11);
		gridPane.add(distanceLablel4, 0, 11);
		gridPane.add(addStation, 0, 12);
		gridPane.add(addStationsTxt, 1, 12);
		
		Insets gdridPadding = new Insets(10,10,10,10);
		gridPane.setPadding(gdridPadding);
		gridPane.setVgap(10);
		gridPane.setHgap(10);
	}


	private void initilizeSlider() {
		hammingValue = new Slider();
		hammingValue.setMax(4);
		hammingValue.setMin(1);
		hammingValue.setMinorTickCount(0);
		hammingValue.setMajorTickUnit(1);
		hammingValue.setBlockIncrement(1);
		
		hammingValue.setShowTickMarks(true);
		hammingValue.setSnapToTicks(true);
		hammingValue.setShowTickLabels(true);
		hammingValue.setValue(2);
		
	}


	private void initilizeComboBox() {
		compareWithDropBox = new ComboBox<String>();
		compareWithDropBox.getItems().addAll(stations);
		compareWithDropBox.setValue("Select Station");
		
	}


	private void initilizeButtons() {
		 showStation = new Button("Show Station");
		 calculateHD = new Button("Calculate HD");
		 addStation = new Button ("Add Station");
		
	}


	private void initilizeLabels() {
		 hammingDistanceLabel = new Label("Enter Hamming Dist:");
		 distanceLablel0 = new Label("Distance0");
		 distanceLablel1 = new Label("Distance1");
		 distanceLablel2 = new Label ("Distance2");
		 distanceLablel3 = new Label ("Distance3");
		 distanceLablel4 = new Label ("Distance4");
		 compareWithLabel = new Label ("Compare with:");
		
	}


	private void initilizeTextArea() {
		StationsBox = new TextArea();
		StationsBox.setEditable(false);
		StationsBox.setPrefSize(100	,250); 
		
	}


	private void initizeTextField() {
		distance0 = new TextField();
		distance0.setEditable(false);
		distance1 = new TextField();
		distance1.setEditable(false);
		distance2 = new TextField();
		distance2.setEditable(false);
		distance3 = new TextField();
		distance3.setEditable(false);
		distance4 = new TextField();
		distance4.setEditable(false);
		hammingDistance = new TextField();
		hammingDistance.setEditable(false);
		addStationsTxt = new TextField();
		hammingDistance.setText("2.0");

	}
	
	

}
