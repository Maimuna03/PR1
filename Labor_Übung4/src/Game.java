
public class Game {
	
	//Declaration of variable
	String[][] gameField;
	
	//Constructor of Game Class
	public Game (String[][] gameField) {
        this.gameField = gameField;
    }

	//Create method that checks if there is a winner
	public String checkWinner() {		
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
		
		

}
