
package com.aurionpro.inheritance;

public class NegativeAmountException extends RuntimeException {
//	private String message;
//    public NegativeAmountException(String message) {
//        this.message = message;
//    }
//    
//    @Override
//    public String getMessage() {
//    	return message;
//    }
	
	public NegativeAmountException(String message) {
		super(message);
	}
	
}
