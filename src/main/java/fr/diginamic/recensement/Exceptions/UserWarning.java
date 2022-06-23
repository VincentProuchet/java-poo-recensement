package fr.diginamic.recensement.Exceptions;

public class UserWarning extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8474899608611033858L;
		
	public UserWarning(String message) {
		System.err.println(message);
	}
	
}
