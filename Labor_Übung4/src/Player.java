
public abstract class Player {
	
	//Declaration of variable
	String[][] gameField;

	//Constructor of Game Class
    public Player(String[][] gameField) {
        this.gameField = gameField;
    }
	
    //Create abstract method because it is used in both extended methods
	abstract void play();

}
