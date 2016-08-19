package com.encryptionproject;

import java.util.Scanner;

public class Explorer
{ 
	static boolean retry = true;

	public static void main(String[] args)
	{
			Scanner codeScanner = new Scanner(System.in);
			String userInput = null;

				
			System.out.println("Welcome to Caesar's Cipher!\n");
			System.out.println("Please enter the message you would like to encrypt: ");
			
			userInput = codeScanner.nextLine();
			String theMessageToBeCoded = userInput;
				
			System.out.println(Explorer.encrypt(theMessageToBeCoded, 5));
	    	
	}

	
	    public static String decrypt(String encode, int offset) 
	    {
	        return encrypt(encode, 26-offset);
	    }
	 
	    public static String encrypt(String encode, int shift)
	    {
	        shift = shift % 26 + 26;
	        StringBuilder encrypted = new StringBuilder();
	        
	        for (char i : encode.toCharArray()) 
	        {
	        	
	            if (Character.isLetter(i)) 
	            {
	            	
	                if (Character.isUpperCase(i)) 
	                {
	                    encrypted.append((char) ('A' + (i - 'A' + shift) % 26 ));
	                } 
	                
	                else 
	                {
	                    encrypted.append((char) ('a' + (i - 'a' + shift) % 26 ));
	                }
	            } 
	            
	            else 
	            {
	                encrypted.append(i);
	            }
	        }
	        return encrypted.toString();
	    }
	
}
