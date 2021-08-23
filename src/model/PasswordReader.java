package model;

public class PasswordReader {
	
	private static String password = "000000";
	
	public String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		PasswordReader.password = password;
	}

	public static boolean correctPassword(String userPass) {
		
		boolean result = false;
		
		if(userPass.equals(password)) {
			
			result = true;
		}
		
		return result;
	}
	
	public static boolean differentPasswords(String newPass) {
		
		boolean result = false;
		
		if(!newPass.equals(password)) {
			
			result = true;
		}
		
		return result;
	}
	
	public static boolean passwordLength(String userPass) {
		
		boolean result = false;
		
		int length = userPass.length();
		
		if(length == 6) {
			
			result = true;
		}
		
		return result;
	}
	
	public static void changePassword(String newPass) {
		
		setPassword(newPass);
	}
}
