
public class Board {
	
	//Create two dimensional array as playing field 
	private String gameField[][] = new String[3][3];
    
	//Setter method to update the game Field 
	void setGameField(String gameField[][]) {
		this.gameField = gameField;
	}
	
	//Getter method to access the current game Field
	public String[][] getGameField() {
        return gameField;
    }
	
	//Create method that creates game pitch
	public void createPitch() {
		//this is a loop that goes through the game Field in y-direction
		for (int i = 0; i < gameField.length; i++) {
			//this is a loop that goes through the game Field in x-direction
			for (int j = 0; j < gameField.length; j++) {
				//put square brackets on each field to visualize the game Field
				gameField [i][j] = "[ ]";
			}
		}
	}
	
	//Create method that prints the current pitch
	public void currentPitch() {
		//Repeat loops that go through the game Field and print each field
		for (int i = 0; i < gameField.length; i++) {
			for (int j = 0; j < gameField.length; j++) {
				System.out.print(gameField[i][j]);
			}
			System.out.println();
		}
	}
	



	
	
}
