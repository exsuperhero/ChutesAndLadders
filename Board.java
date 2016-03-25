import java.util.Scanner;
import java.io.*;
public class Board{



	// A chutes and ladders configuration array (configuration) that will serve as a 
	//lookup table to move the player/computer to a new location if a chute or ladder is at
	 //that position on the board.	
	// A constant integer variable that contains the size of the boardGame
	private final int boardSize = 100;
	private int[] configuration = new int[boardSize];
	private String[][] positions; 

	// A way to store the current index of the player and the current index of the computer
	private int playerPosition;
	private int computerPosition;


	Scanner fileScan;
	Scanner scan2;
	String fileLine;




// A constructor that takes in the name of the chutes and ladders configuration file. 
	//Initialize the positions array. Set the player and the computer to index 0 to get started.
	public Board(String fileName) throws IOException{



		//reads the file 
		fileScan = new Scanner(new File(fileName));
		//fileScan = new Scanner(file);

		while (fileScan.hasNext()){
			fileLine = fileScan.nextLine();

			//reads each line and saves it as a new League object
			scan2 = new Scanner(fileLine);

			//divides the line and saves each as a paramater to make a new player object
			//we did this in class so this is right.
			scan2.useDelimiter(",");

			
			String number1 = scan2.next();
			number1 = number1.trim();
			int iNumber1 = Integer.parseInt(number1);

			String number2 = scan2.next();
			number2 = number2.trim();
			int iNumber2 = Integer.parseInt(number2);



		}


		//holds the player/computer position on the board
		positions = new String[boardSize][2];

		this.positions[0][0] = "P";
		this.positions[0][1] = "C";
		this.playerPosition = 0;
		this.computerPosition = 0;

	}


	public int getBoardSize(){
		return this.boardSize;
	}


	//prints the board and the position of the
	//computer and the player
	public void printBoard(){


		for (int x = 0; x < this.boardSize; x++){

				System.out.print(x + 1);

				if (this.positions[x][0] == "P"){
					System.out.print("*P*");
				}
				if (this.positions[x][1] == "C"){
					System.out.print("*C*");
				}

				System.out.print("  ");

				if ((x + 1) %10 == 0){
					System.out.println("");
				}


		}


	}


// returns the current position of the player
	public int getPlayerPosition(){
		return this.playerPosition;
	}


//returns the current position of the computer
	public int getComputerPosition(){
		return this.computerPosition;
	}


	public void setPlayerPosition(int dice){

		//resets the current position of the board to nothing.
		positions[this.playerPosition][0] = "0";
		this.playerPosition += dice;
		int originalPos = this.playerPosition;


		//increases the size of the array if the player postion + 1 is bigger
		if (this.playerPosition + 1 >= configuration.length)
				increaseSize();

		//exits if the player has won
		if (this.playerPosition >= this.getBoardSize()){
			System.out.println("You win!");
			System.exit(0);
		}

		//exicutes of the player went through a chute/ladder
		if (configuration[this.playerPosition+1] != 0){
			this.playerPosition = configuration[this.playerPosition +1] - 1;

			if (originalPos > this.playerPosition)
				System.out.println("You went down a chute!");
			else if (originalPos < this.playerPosition)
				System.out.println("You went up a ladder!");
		} 




		positions[this.playerPosition][0] = "P";
	}



	public void setComputerPosition(int dice){

		//resets the current position to nothing.
		positions[this.computerPosition][1] = "0";
		this.computerPosition += dice;

		//exits if the computer has won
		if (this.computerPosition >= this.getBoardSize()){
			System.out.println("The computer wins!");
			System.exit(0);
		}

		int originalPos = this.computerPosition;

		if (this.computerPosition + 1 >= configuration.length)
			increaseSize();


		if (configuration[this.computerPosition+1] != 0){
			this.computerPosition = configuration[this.computerPosition + 1] - 1;

			//notifies the user if the computer went up/down a chute.
			if (originalPos > this.computerPosition)
				System.out.println("The computer went down a chute!");
			else if (originalPos < this.computerPosition)
				System.out.println("The computer went up a ladder!");
		}



		positions[this.computerPosition][1] = "C";
	}


	//book example page 399
	//increases the capacity of the list by creating a larger array
	//copies the existing array into the new one
	private void increaseSize(){
		int[] temp = new int[configuration.length * 2];

		for (int x = 0; x < configuration.length; x++)
			temp[x] = configuration[x];

		configuration = temp;
	}



}