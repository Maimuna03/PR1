
public class Main {

	public static void main(String[] args) {
		
		//Instantiate new objects from all the classes
		Board board = new Board();
		Game chessGame = new Game(board.getGameField());
		ComputerPlayer player1 = new ComputerPlayer(board.getGameField());
		HumanPlayer player2 = new HumanPlayer(board.getGameField());
		
		//User information
		System.out.println("Herzlich Willkommen zu TicTacToe !");
		
		//Calling the method to fill the playing field with empty fields
		board.createPitch();
		
		//Calling the method to print the current pitch which is still empty
		board.currentPitch();
		
		System.out.println();
		
		//Let game continue as long as there is now winner and game is not undiceded
		do {
			//Calling the methods to generate random X on field, print the current pitch and check if there is a winner
			player1.play();
			board.currentPitch();
			chessGame.checkWinner();
			
			//Continue with game if it is not undecided and player did not loose
			if (chessGame.checkWinner() != "Es ist unentschieden!") {
				if (chessGame.checkWinner() != "Schade ! Du hast verloren !") {
					//Calling the methods to allow player input, print the current pitch and check if there is a winner
					player2.play();
					board.currentPitch();
					chessGame.checkWinner();
					
				}
				
			}
			System.out.println();
			
		} while (chessGame.checkWinner() == "continue");
		
		//Print the winner
		System.out.println(chessGame.checkWinner());
		
	}

}
