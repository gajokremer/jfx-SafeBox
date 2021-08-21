package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import model.PasswordReader;

public class SafeBoxControllerGUI {
	
//	private String password = "000000";
//
//	public String getPassword() {
//		return password;
//	}
//	
//	public void setPassword(String password) {
//		this.password = password;
//	}
	
    @FXML
    private Label labTitle;

    @FXML
    private Button btnChange;
    
    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private Label txtResult;
    
    
    private Stage mainStage;

	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	//---WINDOW 1
	@FXML	
	boolean correctPassword(ActionEvent event) {
			
		String userPass = txtPassword.getText();
		
		boolean result = PasswordReader.correctPassword(userPass);
		
		return result;
	}
	
	@FXML
	public void openBox(ActionEvent event) throws IOException {
		
		String message = "";
		
		if(correctPassword(event) == true) {
			
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("SafeBox2.fxml"));
			fxmlloader.setController(this);
			Parent root = fxmlloader.load();
			Scene scene = new Scene(root);
			
			mainStage.setScene(scene);
			mainStage.setTitle("Window 2");
			mainStage.show();
			
		} else {
			
			message = "Incorrect Password!";
			txtResult.setText(message);
		}
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
