import java.util.Scanner;

public class HumanPlayer extends Player {
	
	//Constructor of Game Class to access the 
	public HumanPlayer(String[][] gameField) {
        super(gameField);
    }
		
	//String gameField[][] = board.getGameField();

	void play() {
		
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
		
		//Check if input coordinates are valid
		if ((xKoordinate > 2 || xKoordinate < 0) && (yKoordinate > 2 || yKoordinate < 0)) {
			System.out.println("\nBitte wählen Sie Zahlen zwischen 1 und 3 !\n");
			play();
		}
		
		//Check if the chosen field is already taken, if so then request the player to repeat input and restart the method. Else put O on selected field
		if (gameField[yKoordinate][xKoordinate] == "[X]" || gameField[yKoordinate][xKoordinate] == "[O]") {
			System.out.println("Bitte wiederholen Sie Ihre Eingabe und wählen Sie ein freies Feld.");
			play();
			
		} else {
			gameField [yKoordinate][xKoordinate] = "[O]";
		}
		
	}

}
