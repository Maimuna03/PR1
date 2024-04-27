import java.util.*;

public class RomDezConverter {
	
	//Create a method to convert roman numbers to decimal numbers
	public static int romDezConv(String romanNumber) {
		
		/*First convert the exceptions*/
		
		//Create arrays that contain the roman symbols of the exceptions and the related decimal values
		int decimalExcepValue[] = {900, 400, 90, 40, 9, 4};
		String romExcepSymbole[] = {"CM","CD","XC","XL","IX","IV"};
		
		//Declare and Initialize variable for the decimal value of the exceptions for further calculating
		int excepDezValue = 0;
		//Declare and Initialize variable for the remaining decimal value of the roman number after removing the exceptions for further calculating
		int remainingDezValue = 0;
		//Declare and Initialize variable for the result for further calculating
		int finalDezValue = 0;
		
		//Create Loop which goes through all the roman exeption symbols
		for (int i = 0; i < romExcepSymbole.length; i++) {
						
			//Create Loop which checks if the roman number from user input contains roman exception symbols
			if (romanNumber.contains(romExcepSymbole[i])) {
				
				//Add the decimal value of the roman exception symbol to the variable
				excepDezValue += decimalExcepValue[i];
				
				//Remove roman exception symbol from roman number for further calculation
				romanNumber = romanNumber.replace(romExcepSymbole[i], "");
			
			} 
			
		}	
		
		/*Secondly convert the remaining roman number*/
		
		//Create arrays for the remaining decimal values and matching symbols (without exceptions)
		int decimalValue[] = {1000, 500, 100, 50, 10, 5, 1};
		char romSymbol[] = {'M','D','C','L','X','V','I'};
		
		//Create loop which goes through the remaining roman number (without the exeption symbols)
		for (int j = 0; j < romanNumber.length(); j++) {
			//Save current roman symbol into variable
			char currentChar = romanNumber.charAt(j);
			
			//Create loop which goes throgh all of the roman symbols (without the exceptions)
			for (int k = 0; k < romSymbol.length; k++) {
				//Check if the current roman number equals the current roman symbol(number) from the array
				if (currentChar == romSymbol[k]) {
					//Add the decimal value to the variable if the condition is met 
					remainingDezValue += decimalValue[k];
				}
			}
			
		}
		
		//Calculate the final decimal value using the exception value and the value of the remaining roman number 
		finalDezValue = remainingDezValue + excepDezValue;
		
		//Return the result
		return finalDezValue;
	}
	
	//Create a method to convert roman numbers to decimal numbers
	public static String dezRomConv(int decimalNumber) {
		
		//Create arrays that contain all the roman symbols and the related decimal values
		int decimalValue[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String romSymbole[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		//Create variables for further calculation
		int restValue = 0;
		int dividedValue = 0;
		String finalRomNumber = ""; 
		
		//Create loop which goes through the array with the decimal values
		for (int i = 0; i < decimalValue.length; i++) {
			//Devide the decimal number from the user input through the curent decimal value and save into variable for further calculation
			dividedValue = decimalNumber / decimalValue[i];
			//Check if the decimal number fits into the current decimal value
			if (dividedValue >= 1) {
				/*If the condition is met, then add the current roman symbol to the result and repeat the symbol 
				if the devided value is bigger than one */
				finalRomNumber += romSymbole[i].repeat(dividedValue);
			} else {
				//If the condition is not met, then break the current loop and continue with the next one (i++)
				continue;
			}
			//Save the rest from devision of the decimal number with the current decimal value into variable
			restValue = decimalNumber % decimalValue[i];
			
			//Save the previous calculation into variable for the next loop
			decimalNumber = restValue;
			
		}
		
		//Return the final result 
		return finalRomNumber;
	}
	
	//Create a main function
	public static void main(String[] args) {
		
		//Welcoming
		System.out.println("Welcome !\n");
		
		//Create a new Scanner
		Scanner menuScanner = new Scanner(System.in);
		
		//declaration of a variabe before a loop
		String userAnswer;
		
		//Create a loop that provides the menu and then asks if the program is needed again
		do {
			//User information that provides the menu 
			System.out.println("\nPlease choose from the following menu:");
			System.out.println("Type (1) to convert a roman number into a decimal number.");
			System.out.println("Type (2) to convert a decimal number into a roman number.");
			
			//User information that shows the user where to type the answer
			System.out.print("Your input: ");
			
			//Save the answer of the user into variable for further use
			int menuChoice = menuScanner.nextInt();	
			
			// Consume newline left-over
			menuScanner.nextLine();
			
			//Check if the user has chosen the first converter (roman to decimal converter)
			if (menuChoice == 1) {
				
				//User information (titel of the converter)
				System.out.println("\n***ROMAN TO DECIMAL CONVERTER***");
				
				//Print user information to enter a roman number
				System.out.print("Please enter a roman number: ");
				
				//Scan input and save input into variable and to capitalized letter
				String romanNumber = menuScanner.nextLine().toUpperCase();
				
				//Calling the function to convert a roman number into a decimal number and save into variable
				int finalDezNumber = romDezConv(romanNumber);
				
			    //Print the solution (converted decimal Number)
				System.out.println("The given roman number equals the following decimal number: " + finalDezNumber);
				
				//Else check if the user has chosen the second converter (decimal to roman converter)
			} else if (menuChoice == 2) {

				//User information (titel)
				System.out.println("\n***DECIMAL TO ROMAN CONVERTER***");
				
				//Print user information to enter a decimal number
				System.out.print("Please enter a decimal number: ");
				
				//Scan input and save input into variable
				int decimalNumber = menuScanner.nextInt();
				
				// Consume newline left-over
				menuScanner.nextLine();
				
				//Calling the function to convert a roman number into a decimal number and save into variable
				String finalRomNumber = dezRomConv(decimalNumber);
				
				//Print the solution (converted roman Number)
				System.out.println("The given decimal number equals the following roman number: " + finalRomNumber);
				
				//Else the user has neither chosen the first or the second menu choice
			} else {
				//User information that the input has been invalid
				System.out.println("\nInvalid entry!");
			}
			
			//User information to ask the user whether another conversion is needed
			System.out.println("\nDo you need another conversion ?");
			//User information to let user know where to type its answer
			System.out.print("Please enter yes (Y/y) or no (N/n): ");
			
			//Scan user answer and save into variable
			userAnswer = menuScanner.nextLine();
		
			//Repeat the conversion programm if the user whishes to do another conversion
		} while (userAnswer.equals("Y") || userAnswer.equals("y"));
				
		// Close Scanner
		menuScanner.close();
		
		//User information that the program ends at this point
		System.out.println("END OF PROGRAM!");
		
	}

}
