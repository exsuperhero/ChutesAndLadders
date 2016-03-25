# ChutesAndLadders
#Written by an exsuperhero.
#March 9, 2016
Chutes and Ladders Game

About the Program:

This is a one-player Chutes and Ladders game that can be played without internet connection
No longer do I need to:
	-make friends
	-pay for WiFi
	-or play MMO's with complete strangers
	#WINNING

This program contains 2 classes, Board.java and Game.java
The Board class contains the configuration of the board and also all of the methods.
Board.java contains all of the getters, setters, the constructor, and the print board method.
Game.java contains the main method and creates an instance of the board. It contains a do-while loop 
so that the game will run until the computer or the player wins. Inside the loop, it "rolls a dice"
by generating a random number and moving the position of the player/computer on the board. It calls the setter 
and then changes the position. If the player or the computer reaches the end of the board, then it will print
that they have won and then will terminate the program by using System.exit(0).
The configuration file contains numbers for chutes and ladders. For instance, if the player has
landed on the number 5, then it will go to position 12 on the board (it has used a ladder). The same
is true for if the player has hit a "chute".
Though this is a game, this is not an interactive game. It runs until the player or computer has reached the
end of the board. The user can always run the program again if he/she has nothing else to do.
