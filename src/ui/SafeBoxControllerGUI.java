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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.PasswordReader;

public class SafeBoxControllerGUI {
	
    @FXML
    private Label labTitle;

    @FXML
    private Button btnChange;
    
    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private Label txtResult;
    
    @FXML
    private Label txtResult1;
    
    @FXML
    private TextArea txtInfo;
    
    @FXML
    private PasswordField txtOldPass;
    
    @FXML
    private PasswordField txtNewPass;
    
    
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
	boolean currentPassword(ActionEvent event) {
		
		String userPass = txtOldPass.getText();
		
		boolean result = PasswordReader.correctPassword(userPass);
		
		return result;
	}
	
	@FXML
	boolean differentPasswords(ActionEvent event) {
		
		String newPass = txtNewPass.getText();
		
		boolean result = PasswordReader.differentPasswords(newPass);
		
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
    public void closeTheBox(ActionEvent event) throws IOException {

    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("SafeBox1.fxml"));
    	fxmlloader.setController(this);
    	Parent root = fxmlloader.load();
    	Scene scene = new Scene(root);
    	
    	mainStage.setScene(scene);
    	mainStage.setTitle("Window 1");
    	mainStage.show();
    }

    @FXML
    public void confirmPass(ActionEvent event) throws IOException {
    	
    	String message = "";
    	
    	if(currentPassword(event) == true && differentPasswords(event) == true) {
    		
    		PasswordReader.changePassword(txtNewPass.getText());
    		
    		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("SafeBox2.fxml"));
    		fxmlloader.setController(this);
    		Parent root = fxmlloader.load();
    		Scene scene = new Scene(root);
    		
    		mainStage.setScene(scene);
    		mainStage.setTitle("Window 2");
    		mainStage.show();    	
    		
    	}
    	
    	if(currentPassword(event) == false){
    		
    		message = "Incorrect current Password!";
    		txtResult1.setText(message);
    	}
    	
    	if(differentPasswords(event) == false) {
    		
    		message = "Passwords can't be the same!";
    		txtResult1.setText(message);
    	}
    }
}
