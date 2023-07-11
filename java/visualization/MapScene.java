package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
import model.Map;

/*
 * This class creates a Map scene
 */
public class MapScene {
	// Fields
	private Button cancel;
	private Button run;
	private Button reset;
	private ComboBox<String> target;
	private ComboBox<String> source;
	private ComboBox<String> algorithm;
	private GraphicsContext gc;
	// Constructor
	/**
	 * @param stage
	 * @param map
	 */

	public MapScene(Stage stage, Map map) {
		initialize(stage, map);

	}

	/**
	 * The main grid pane will contain two gridpane the root and the pane the root
	 * will be for the map and the ppoints the pane will be for the buttons and
	 * labels inputs
	 */
	/**
	 * @param stage
	 * @param map
	 */
	private void initialize(Stage stage, Map map) {
		BackgroundFill bgf1 = new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY);
		Background bg1 = new Background(bgf1);

		GridPane main = new GridPane();
		main.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		Image mapimage = new Image("images/palestine.png");
		Canvas canvas = new Canvas(540, 800);
		gc = canvas.getGraphicsContext2D();
		gc.drawImage(mapimage, 0, 0);
		gc.setFont(Font.font("Lucida Sans Unicode", FontWeight.LIGHT, FontPosture.REGULAR, 14));

		for (City city : map.getCities()) {
			gc.strokeText(city.getCity_name(), city.getX(), city.getY());
			gc.setFill(Color.LIGHTGREEN);
			gc.fillOval(city.getX(), city.getY(), 12, 12);
		}

		GridPane root = new GridPane();
		root.getChildren().add(canvas);
		root.setAlignment(Pos.CENTER);
		main.add(root, 0, 0);

		GridPane pane = new GridPane();
		pane.setPadding(new Insets(50));
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(15);

		main.add(pane, 1, 0);

		// Labels
		Label mapp = new Label("Palestine Map");
		mapp.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(mapp, 0, 0);

		Label cityl = new Label("Algorithm:");
		cityl.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(cityl, 0, 1);

		Label sourcel = new Label("Source:");
		sourcel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(sourcel, 0, 2);

		// This label will be updated by process of file importing
		Label targetl = new Label("Target:");
		targetl.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(targetl, 0, 3);

		source = new ComboBox<String>();
		source.setPrefHeight(30);
		source.setPrefWidth(150);
		source.setBackground(bg1);
		for (int i = 0; i < map.getCities().size(); i++) {
			source.getItems().add(map.getCities().get(i).getCity_name());
		}
		source.setStyle("-fx-background-radius: 10, 5;-fx-background-color:lightgreen;");
		source.setValue(map.getCities().get(0).getCity_name());
		pane.add(source, 1, 2);

		target = new ComboBox<String>();
		target.setPrefHeight(30);
		target.setPrefWidth(150);
		target.setBackground(bg1);
		for (int i = 0; i < map.getCities().size(); i++) {
			target.getItems().add(map.getCities().get(i).getCity_name());
		}
		target.setStyle("-fx-background-radius: 10, 5;-fx-background-color:lightgreen;");
		target.setValue(map.getCities().get(1).getCity_name());
		pane.add(target, 1, 3);

		algorithm = new ComboBox<String>();
		algorithm.setPrefHeight(30);
		algorithm.setPrefWidth(150);
		algorithm.setBackground(bg1);
		algorithm.getItems().add("Through A*");
		algorithm.getItems().add("Through Greedy");
		algorithm.setValue("Through A*");
		algorithm.setStyle("-fx-background-radius: 10, 5;-fx-background-color:lightgreen;");
		pane.add(algorithm, 1, 1);

		// User button to run the shortest path
		run = new Button("Run");
		run.setFont(Font.font(14));
		run.setPrefSize(100, 30);
		run.setStyle("-fx-background-radius: 22, 10;-fx-background-color:lightgrey;");
		run.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(run, 0, 4);

		// User button to exit
		cancel = new Button("Exit");
		cancel.setFont(Font.font(14));
		cancel.setPrefSize(100, 30);
		GridPane.setHalignment(cancel, HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 22, 10;-fx-background-color:lightgrey;");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(cancel, 1, 4);

		// Scene setting
		Scene scene = new Scene(main);
		stage.setTitle("Palestine Map");
		stage.getIcons().add(new Image("images/logo.png"));
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}

	/*
	 * Getters and Setters
	 */
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
	 * @return the run
	 */
	public Button getRun() {
		return run;
	}

	/**
	 * @param run the run to set
	 */
	public void setRun(Button run) {
		this.run = run;
	}

	/**
	 * @return the reset
	 */
	public Button getReset() {
		return reset;
	}

	/**
	 * @param reset the reset to set
	 */
	public void setReset(Button reset) {
		this.reset = reset;
	}

	/**
	 * @return the target
	 */
	public ComboBox<String> getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(ComboBox<String> target) {
		this.target = target;
	}

	/**
	 * @return the source
	 */
	public ComboBox<String> getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(ComboBox<String> source) {
		this.source = source;
	}

	/**
	 * @return the algorithm
	 */
	public ComboBox<String> getAlgorithm() {
		return algorithm;
	}

	/**
	 * @param algorithm the algorithm to set
	 */
	public void setAlgorithm(ComboBox<String> algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * @return the gc
	 */
	public GraphicsContext getGc() {
		return gc;
	}

	/**
	 * @param gc the gc to set
	 */
	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}
}