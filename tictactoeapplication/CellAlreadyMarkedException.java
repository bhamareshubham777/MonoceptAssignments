package com.techlabs.tictactoeapplication;

public class CellAlreadyMarkedException extends RuntimeException {
	String message;
    
	public CellAlreadyMarkedException(String message) {
        this.message=message;
    }
	
	public String getMessage() {
		return "Cell is already marked";
	}
}
