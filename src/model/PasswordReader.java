package model;

public class PasswordReader {
	
	private static String password = "000000";
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		PasswordReader.password = password;
	}

	public static boolean correctPassword(String userPass) {
		
		boolean result = false;
		
		if(userPass.equals(password)) {
			
			result = true;
		}
		
		return result;
	}

}
