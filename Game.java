import java.util.Random; 
import java.io.*;

public class Game{


	public static void main(String[] args) throws IOException {
		Board boardGame = new Board("configurationfile.txt");
		int pPosition;
		int cPosition;
		
		Random ranNumber = new Random();


		//keeps playing until someone has one chutes and ladders
		do{

			//rolls the dice for the player
			//and then sets the position on the board
			int dice = ranNumber.nextInt(6) + 1;

			pPosition = boardGame.getPlayerPosition() + dice;


			System.out.println("You rolled a " + dice);
			boardGame.setPlayerPosition(dice);

			//rolls the dice for the computer
			//and then sets the position on the board
			dice = ranNumber.nextInt(6) + 1;
			cPosition = boardGame.getComputerPosition() + dice;


			System.out.println("The computer rolled a " + dice);
			boardGame.setComputerPosition(dice);


			boardGame.printBoard();
			System.out.println();



		} while (pPosition < boardGame.getBoardSize() 
		 	|| cPosition < boardGame.getBoardSize());


		

	}
}