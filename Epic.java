package com.encryptionproject;

import java.util.Scanner;

public class Epic
{ 
	static boolean retry = true;
	static boolean retryTwo = true;
	static int randomShift = 0;
	

	public static void main(String[] args)
	{
	    	do
			{
	    		
				Scanner codeScanner = new Scanner(System.in);
				Scanner menuScanner = new Scanner(System.in);
				String userInput = null;
				String menuChoice = null;
				

				
				System.out.println("Welcome to Caesar's(Tucker) Cipher!\n");
				System.out.println("Please enter a message: ");
				
				do
				{
					userInput = codeScanner.nextLine();
					if (userInput.matches("[a-z A-Z]+$"))
					{
						retryTwo = false;
					} else
					{
						System.out.println("Numbers and special characters are not valid. Please type only letters or words and try again.");
						retryTwo = true;
					} 
				} while (retryTwo);
					System.out.println("Would you like to: ");
					System.out.println("\n\t 1. Print the encrypted message."
					+ "\n\t 2. Print the decrypted message."
					+ "\n\t 3. Print both the encrypted and decrypted message. "
					+ "\n\t 4. Exit application");
					menuChoice = menuScanner.nextLine();
					
					String theMessageToBeCoded = userInput;
	
				switch(menuChoice)
				{
					case "1":
						if (theMessageToBeCoded.matches("[a-z A-Z]+$")) 
						{
							
							System.out.println(Epic.encrypt(theMessageToBeCoded, 5) + "\n");
						}
						else
						{
							System.out.println("Numbers and special characters are not valid. Please type only letters or words and try again.");
						}
					break;
					
					case "2":
						if (theMessageToBeCoded.matches("[a-z A-Z]+$")) 
							{
								System.out.println(userInput.toUpperCase() + "\n");
							}
							else
							{
								System.out.println("Numbers and special characters are not valid. Please type only letters letters or words and try again.");
							}
					break;
					
					case "3":
							if (theMessageToBeCoded.matches("[a-z A-Z]+$")) 
							{
								
								System.out.println(Epic.encrypt(theMessageToBeCoded, 5));
								System.out.println(userInput.toUpperCase() + "\n");
							}
							else
							{
								System.out.println("Numbers and special characters are not valid. Please type only letters or words and try again.");
							}
					break;
					
					case "4":
						System.out.println("Goodbye!");
						System.exit(0);
				}

			} while (retry == true);
	    	
	}

	
	    public static String decrypt(String encode, int offset) 
	    {
	        return encrypt(encode, 26-offset);
	    }
	 
	    public static String encrypt(String encode, int shift)
	    {
	    	randomShift = (int)(Math.random() *26 + 1);
	        shift = randomShift;
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
	        return encrypted.toString().toUpperCase();
	    }
	
}
