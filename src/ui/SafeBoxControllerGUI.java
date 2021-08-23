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
import sun.security.util.Password;

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
	public void openBox(ActionEvent event) throws IOException {
		
		String message = "";
		
		String userPass = txtPassword.getText();
		
		boolean correctPassword = PasswordReader.correctPassword(userPass);
		
		boolean correctLength = PasswordReader.passwordLength(userPass);
		
		if(correctPassword == true && correctLength == true) {
			
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("SafeBox2.fxml"));
			fxmlloader.setController(this);
			Parent root = fxmlloader.load();
			Scene scene = new Scene(root);
			
			mainStage.setScene(scene);
			mainStage.setTitle("Window 2");
			mainStage.show();
			
		} 
		
		if(correctPassword == false) {
			
			message = "Incorrect Password!";
			txtResult.setText(message);
		}
		
		if(correctLength == false) {
			
			message = "Password has to be 6 digits long!";
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
    	
		String oldPass = txtOldPass.getText();
		
		String newPass = txtNewPass.getText();
		
		boolean correctPassword = PasswordReader.correctPassword(oldPass);
		
		boolean differentPasswords = PasswordReader.differentPasswords(newPass);
		
		boolean correctLength = PasswordReader.passwordLength(newPass);
    	
    	if(correctPassword == true && differentPasswords == true && correctLength == true) {
    		
    		PasswordReader.changePassword(newPass);
    		
    		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("SafeBox2.fxml"));
    		fxmlloader.setController(this);
    		Parent root = fxmlloader.load();
    		Scene scene = new Scene(root);
    		
    		mainStage.setScene(scene);
    		mainStage.setTitle("Window 2");
    		mainStage.show();    	
    	}
    	
    	if(correctPassword == false){
    		
    		message = "Incorrect current Password!";
    		txtResult1.setText(message);
    	}
    	
    	if(differentPasswords == false) {
    		
    		message = "Passwords can't be the same!";
    		txtResult1.setText(message);
    	}
    	
    	if(correctLength == false) {
			
			message = "Password has to be 6 digits long!";
			txtResult1.setText(message);
		}
    }
}
