/*
 * TicTacToe Game
 * @author Maimuna Chemingui
 */
package Übung2;

import java.util.*;

public class TicTacToe {
	
	//Create method that creates game pitch
	public static void createPitch(String gameField[][]) {
		//this is a loop that goes through the game Field in y-direction
		for (int i = 0; i < gameField.length; i++) {
			//this is a loop that goes through the game Field in x-direction
			for (int j = 0; j < gameField.length; j++) {
				//put square brackets on each field to visualize the game Field
				gameField [i][j] = "[ ]";
			}
		}
	}
	
	//Create method that generates random X on the pitch
	public static void randomX(String gameField[][]) {

		Random rand = new Random();
		// Generate a random number between 0 and 2 as x and y coordinates
		int randI = rand.nextInt(3);
		int randJ = rand.nextInt(3);
		
		//Restart method if the selected field on pitch is already taken. Else put X on generated field
		if (gameField[randI][randJ] == "[O]" || gameField[randI][randJ] == "[X]") {
			randomX(gameField);
		} else {
			gameField [randI][randJ] = "[X]";
		}
						
	}
	
	//Create method that prints the current pitch
	public static void currentPitch(String gameField[][]) {
				
		//Repeat loops that go through the game Field and print each field
		for (int i = 0; i < gameField.length; i++) {
			for (int j = 0; j < gameField.length; j++) {
				System.out.print(gameField[i][j]);
			}
			System.out.println();
		}
	}
	
	//Create method that allows player to play
	public static void playerInput(String gameField[][]) {
				
		Scanner sc = new Scanner(System.in);
		
		//User information to type the x coordinate of the game field
		System.out.print("Geben Sie die x-Koordinate [1-3] ein: ");
		int xKoordinate = sc.nextInt();
		//Subtract 1 from the input to match the array index
		xKoordinate -= 1;
		
		//User information to type the y coordinate of the game field
		System.out.print("Geben Sie die y-Koordinate [1-3] ein: ");
		int yKoordinate = sc.nextInt();
		//Subtract 1 from the input to match the array index
		yKoordinate -= 1;
		
		if ((xKoordinate > 2 || xKoordinate < 0) && (yKoordinate > 2 || yKoordinate < 0)) {
			System.out.println("\nBitte wählen Sie Zahlen zwischen 1 und 3 !\n");
			playerInput(gameField);
		}
		
		//Check if the chosen field is already taken, if so then request the player to repeat input and restart the method. Else put O on selected field
		if (gameField[yKoordinate][xKoordinate] == "[X]" || gameField[yKoordinate][xKoordinate] == "[O]") {
			System.out.println("Bitte wiederholen Sie Ihre Eingabe und wählen Sie ein freies Feld.");
			playerInput(gameField);
			
		} else {
			gameField [yKoordinate][xKoordinate] = "[O]";
		}
		
	}	
	
	//Create method that checks if there is a winner
	public static String checkWinner(String gameField[][]) {
		
		//Check for winner in the lines 
        for (int i = 0; i < gameField.length; i++) {
            if (gameField[i][0] == gameField[i][1] && gameField[i][1] == gameField[i][2] && gameField[i][0] != "[ ]") {
            	
            	if (gameField[i][0] == "[X]") {
        			return "Schade ! Du hast verloren !";
        		} else if (gameField[i][0] == "[O]") {
        			return "Herzlichen Glückwunsch ! Du hast gewonnen !";
          		}
            }
        }
        
        //Check for winner in the columns
        for (int j = 0; j < gameField.length; j++) {
            if (gameField[0][j] == gameField[1][j] && gameField[1][j] == gameField[2][j] && gameField[0][j] != "[ ]") {
                
            	if (gameField[0][j] == "[X]") {
        			return "Schade ! Du hast verloren !";
        		} else if (gameField[0][j] == "[O]") {
        			return "Herzlichen Glückwunsch ! Du hast gewonnen !";
        		}
            }
        }
        
        //Check for winner in the diagonals
        if (gameField[0][0] == gameField[1][1] && gameField[1][1] == gameField[2][2] && gameField[0][0] != "[ ]") {
            
        	if (gameField[0][0] == "[X]") {
    			return "Schade ! Du hast verloren !";
    		} else if (gameField[0][0] == "[O]") {
    			return "Herzlichen Glückwunsch ! Du hast gewonnen !";
        	}
        }
        
        if (gameField[0][2] == gameField[1][1] && gameField[1][1] == gameField[2][0] && gameField[0][2] != "[ ]") {
            
        	if (gameField[0][2] == "[X]") {
    			return "Schade ! Du hast verloren !";
    		} else if (gameField[0][2] == "[O]") {
    			return "Herzlichen Glückwunsch ! Du hast gewonnen !";
    		}
        }
        
     // Check if all fields are occupied
	    for (int i = 0; i < gameField.length; i++) {
	        for (int j = 0; j < gameField[i].length; j++) {
	            if (gameField[i][j] == "[ ]") {
	                return "continue"; // If any field is empty, the game continues
	            }
	        }
	    }
	    
	    // If no winner and all fields are occupied, the game is undecided
	    return "Es ist unentschieden!";
        
	}
	
	
	public static void main(String[] args) {
		//Create two dimensional array as playing field 
		String gameField[][] = new String [3][3];
		
		//User information
		System.out.println("Herzlich Willkommen zu TicTacToe !");
		
		//Calling the method to fill the playing field with empty fields
		createPitch(gameField);
		
		//Calling the method to print the current pitch which is empty 
		currentPitch(gameField);
		
		System.out.println();
		
		//Let game continue as long as there is now winner and game is not undiceded
		do {
			//Calling the methods to generate random X on field, print the current pitch and check if there is a winner
			randomX(gameField);
			currentPitch(gameField);
			checkWinner(gameField);
			
			//Continue with game if it is not undicided and player did not loose
			if (checkWinner(gameField) != "Es ist unentschieden!") {
				if (checkWinner(gameField) != "Schade ! Du hast verloren !") {
					//Calling the methods to allow player input, print the current pitch and check if there is a winner
					playerInput(gameField);
					currentPitch(gameField);
					checkWinner(gameField);
				}
			}

			System.out.println();
		} while (checkWinner(gameField) == "continue");
		
		//Print the winner
		System.out.println(checkWinner(gameField));
	}

}

