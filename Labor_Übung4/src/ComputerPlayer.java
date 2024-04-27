import java.util.Random;

public class ComputerPlayer extends Player{
		
	public ComputerPlayer(String[][] gameField) {
        super(gameField);
    }	
	
	//Create method that generates random X on the pitch
	void play() {
		
		Random rand = new Random();
		// Generate a random number between 0 and 2 as x and y coordinates
		int randI = rand.nextInt(3);
		int randJ = rand.nextInt(3);
		
		//Restart method if the selected field on pitch is already taken. Else put X on generated field
		if (gameField[randI][randJ] == "[O]" || gameField[randI][randJ] == "[X]") {
			play();
		} else {
			gameField [randI][randJ] = "[X]";
		}		
	}
}
