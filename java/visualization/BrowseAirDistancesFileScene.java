package visualization;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
/*
 * This scene browses for the air distances file
 */
public class BrowseAirDistancesFileScene {
	//fields
    private GridPane pane;
    private Label label;//Greeting User
    private	Button run;//User button to run the map
    private Button browse;//User Button to browse file
	private Button cancel;
  		
    //Constructor accepts a stage
	/**
	 * @param stage
	 */
	public BrowseAirDistancesFileScene(Stage stage) {
      initialize(stage);
    }
	
    //initialization of objects
    /**
     * @param stage
     */
    public void initialize(Stage stage) {
    	//Creating the grid pane
    	pane = new GridPane();
    	pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(70));
		pane.setHgap(7);
		pane.setVgap(10);
		
		//creating a background
		pane.setBackground(null);
		Background bGround = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
		pane.setBackground(bGround); 
		
		//The Palestinian flag image
		Image img = new Image("images/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(150);
		v.setFitHeight(150);
		
		// a disabled button that shows the Logo
		Button logo = new Button();
		logo.setPrefSize(150, 150);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		pane.add(logo, 0, 0);
		
		//Greeting Label
		label = new Label("   	It's the turn of your Air distance file...");
		label.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(label, 1,0);
		
		//The run button
		run = new Button("Run");
		run.setTextFill(Color.BLACK);
		run.setPrefSize(100, 30);
		run.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		run.setStyle("-fx-background-radius: 22, 10;-fx-background-color:lightpink;");
		
		//Button to browse for files
		browse = new Button("Browse"); 
		browse.setStyle("-fx-background-radius: 22, 10;-fx-background-color:lightgrey;");
		browse.setTextFill(Color.BLACK);
		browse.setPrefSize(100, 30);
		browse.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(browse , 2,1);
		
		//User button to exit
		cancel = new Button("Cancel");
		cancel.setFont(Font.font(14)); 
		cancel.setPrefSize(100, 30);
		cancel.setStyle("-fx-background-radius: 22, 10;-fx-background-color:lightgrey;");
		cancel.setTextFill(Color.BLACK);
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(cancel,3,1); 
		
		//Create Scene
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Browse for the Air distance file");
		stage.getIcons().add(new Image("images/logo.png"));
		stage.centerOnScreen();
		stage.show();
    }
    /*
     * Getters and Setters
     */

	/**
	 * @return the pane
	 */
	public GridPane getPane() {
		return pane;
	}

	/**
	 * @param pane the pane to set
	 */
	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	/**
	 * @return the label
	 */
	public Label getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(Label label) {
		this.label = label;
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
	 * @return the browse
	 */
	public Button getBrowse() {
		return browse;
	}

	/**
	 * @param browse the browse to set
	 */
	public void setBrowse(Button browse) {
		this.browse = browse;
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
}