package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.City;
/*
 * This class creates a scene where the path, distance are displayed
 */
public class PathDistanceDisplayScene {
	//Fields
	private TextField distance;
	private TextArea path;
	private Button cancel;
	private Stage stage;
	private TextField ef1;

	//Constructor
	/**
	 * @param source
	 * @param distanation
	 */
	public PathDistanceDisplayScene(City source, City distanation) {
		initialize(source,distanation);
	}
	
	//Initialize Objects
	/**
	 * @param source
	 * @param distantion
	 */
	private void initialize(City source, City distantion){
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(60));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setBackground(background);

		Image img = new Image("images/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(70);
		v.setFitHeight(70);

		Button logo = new Button();
		logo.setPrefSize(70, 70);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);
		
		Label oath = new Label("From "+source.getCity_name()+" to "+distantion.getCity_name());
		oath.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.ITALIC, 20));
		pane.add(oath,0,1);
		
		stage = new Stage();
		Label pathl = new Label("Shortest path:");
		pathl.setPrefWidth(180);
		pathl.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(pathl,0,2);

		Label distl = new Label("Distance in KM:");
		distl.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(distl,0,4);
		
		Label ef = new Label("Effecincy in ms:");
		ef.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(ef,0,6);

		//Prints the path that gives the shortest path
		path = new TextArea();
		path.setPrefHeight(300);
		path.setPrefWidth(250);
		path.setEditable(false);
		path.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(path, 0, 3);

		//Calculates the shortest destination
		distance = new TextField();
		distance.setPrefHeight(40);
		distance.setPrefWidth(150);
		distance.setEditable(false);
		distance.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(distance, 0, 5);
		
		//Calculates the run time
		ef1 = new TextField();
		ef1.setPrefHeight(40);
		ef1.setPrefWidth(150);
		ef1.setEditable(false);
		ef1.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(ef1, 0, 7);
		
		//User button to exit
		//this button will be like the reset button
		cancel = new Button("Okay");
		cancel.setFont(Font.font(14));
		cancel.setPrefSize(100, 30);
		GridPane.setHalignment(cancel, HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 22, 10;-fx-background-color:lightgrey;");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(cancel,0,8); 
		
		//Scene setting
    	Scene scene = new Scene(pane); 
    	stage.setTitle("Palestine Map");
		stage.getIcons().add(new Image("images/logo.png"));
		stage.setScene(scene);  
		stage.setX(1100);
		stage.setY(10);
    	stage.show();
	}
	/*
	 * Getters and Setters
	 */

	/**
	 * @return the distance
	 */
	public TextField getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(TextField distance) {
		this.distance = distance;
	}

	/**
	 * @return the path
	 */
	public TextArea getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(TextArea path) {
		this.path = path;
	}

	/**
	 * @return the cancel
	 */
	public Button getCancel() {
		return cancel;
	}

	/**
	 * @param cancel the cancel to set
	 */
	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	/**
	 * @return the stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * @param stage the stage to set
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * @return the ef1
	 */
	public TextField getEf1() {
		return ef1;
	}

	/**
	 * @param ef1 the ef1 to set
	 */
	public void setEf1(TextField ef1) {
		this.ef1 = ef1;
	}
}