package org.comstudy21.notice;

import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class

public class TestDate {
	public static void main(String[] args) { 
		    LocalDateTime myDateObj = LocalDateTime.now();  
		    //System.out.println("Before formatting: " + myDateObj);  
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss");  
		    
		    String formattedDate = myDateObj.format(myFormatObj);  
		    System.out.println("After formatting: " + formattedDate);  
		  }  

	}

