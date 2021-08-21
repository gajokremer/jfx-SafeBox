package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SafeBoxControllerGUI {

    @FXML
    private Label labTitle;

    @FXML
    private Button btnChange;
    
    private Stage mainStage;

    public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	//---WINDOW 1
	@FXML
	public void openBox(ActionEvent event) throws IOException {
		
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("SafeBox2.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		Scene scene = new Scene(root);
		
		mainStage.setScene(scene);
		mainStage.setTitle("Window 2");
		mainStage.show();
	}
	
	//---WINDOW 2
	 @FXML
    public void changePass(ActionEvent event) throws IOException {

		 FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("SafeBox3.fxml"));
		 fxmlloader.setController(this);
		 Parent root = fxmlloader.load();
		 Scene scene = new Scene(root);
		 
		 mainStage.setScene(scene);
		 mainStage.setTitle("Window 3");
		 mainStage.show();
    }
	
    @FXML
    public void closeBox(ActionEvent event) throws IOException {

    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("SafeBox1.fxml"));
    	fxmlloader.setController(this);
    	Parent root = fxmlloader.load();
    	Scene scene = new Scene(root);
    	
    	mainStage.setScene(scene);
    	mainStage.setTitle("Window 1");
    	mainStage.show();
    }

    //---WINDOW 3
    @FXML
    void closeTheBox(ActionEvent event) throws IOException {

    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("SafeBox1.fxml"));
    	fxmlloader.setController(this);
    	Parent root = fxmlloader.load();
    	Scene scene = new Scene(root);
    	
    	mainStage.setScene(scene);
    	mainStage.setTitle("Window 1");
    	mainStage.show();
    }

    @FXML
    void confirmPass(ActionEvent event) throws IOException {

    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("SafeBox3.fxml"));
    	fxmlloader.setController(this);
    	Parent root = fxmlloader.load();
    	Scene scene = new Scene(root);
    	
    	mainStage.setScene(scene);
    	mainStage.setTitle("Window 3");
    	mainStage.show();    	
    }
}
