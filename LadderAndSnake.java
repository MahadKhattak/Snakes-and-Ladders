package org.example;
/**
 * Name and ID		Mahad Khattak 40251021
 * COMP249	
 * Assignment #		1
 * Due Date			February 6th, 2023
 */
public class LadderAndSnake {
	private String[][] board;
	private int players;
	/**
	 * Constructor that asks for the number of players.
	 * <p>
	 * Constructor that asks for the number of players and has different cases if the user
	 * does not enter 2.
	 * </p>
	 * @param players Need to put 2. If user puts less, there is an error message; if they put more,
	 * it is automatically set to 2 and the game starts.
	 */
	public LadderAndSnake(int players) //Parameterized Constructor
	{
		if (players > 2)
			{
			System.out.println("Initialization was attempted for " + players + " member of players; however, this is only expected for an extended version of the game. Value will be set to 2.");
			this.players=2;
			this.board = new String[10][10];
			}
		else if (players < 2 )
			{
				System.out.println("Error: Cannot execute the game with less than 2 players!");
				System.exit(0);
			}
		else if (players==2)
			this.players = players;
		this.board = new String[10][10]; //Will be used to create a 10x10 board
	}
	public LadderAndSnake() //Default constructor
	{
		this.players = 2;
		this.board = new String[10][10];
	}
	public LadderAndSnake(LadderAndSnake ladderandsnake1) //Copy constructor
	{
		this.players = ladderandsnake1.players;
		this.board = ladderandsnake1.board;
	}
	public void setPlayers(int players)
	{
		this.players = players;
	}
	public int getPlayers()
	{
		return this.players;
	}
	/**
	 * Gives a random number between 1 and 6, emulating a die flip.
	 * <p>
	 * Since Math.random() gives a double from 0 to anything under 1, we must multiply by 6
	 * and add 1 to make it possible to get values of 1 to 6. The int casting is done because
	 * the result is a double, and we need to convert it to return an int.
	 * </p>
	 * @return Returns a random number between 1 and 6
	 */
	public int flipDice() //We need an integer between 1 and 6.
	{
		return (int)(Math.random()*6+1);
		
	}
	/**
	 * The play method is the main engine used to start the game. 
	 * <p>
	 *First the method decides who goes first by alternating dice flipping. There is a while loop set
	 *to keep repeating the rolling if both players roll the same value.
	 * </p>
	 *  <p>
	 *Then, the board is filled with strings from 1 to 100 and printed out, using the printBoard() method.
	 * </p>
	 * <p>
	 *After the first player's score is determined, a switch is used to determine whether he stepped
	 *on a snake or a ladder; the method called ladderOrSnake() checks if the player's score corresponds to a snake/ladder square.
	 * </p>
	 * <p>
	 *The calculate() method handles all the rest of the calculation for the player's new score.
	 * </p>
	 *<p>
	 *It should be noted that there are 2 for loops, one for the case where player 1 goes first
	 *and another for the case where player 2 goes first.
	 *</p>
	 */
	public void play()
	{
		//First we decide who goes first
		Player playerOne = new Player();
		Player playerTwo = new Player();
		System.out.println("Now deciding who will go first.");
		playerOne.setPlayerRolled(flipDice());
		playerTwo.setPlayerRolled(flipDice());
		int count = 1; //To count how many loops it took before a decision was made.
		System.out.println("Player 1 scored " + playerOne.getPlayerRolled() + ".");
		System.out.println("Player 2 scored " + playerTwo.getPlayerRolled() + ".");
		while(playerOne.getPlayerRolled()==playerTwo.getPlayerRolled())
		{
			System.out.println("A tie was achieved between Player 1 and Player 2. Attempting to break the tie...");
			playerOne.setPlayerRolled(flipDice());
			playerTwo.setPlayerRolled(flipDice());
			System.out.println("Player 1 scored " + playerOne.getPlayerRolled() + ".");
			System.out.println("Player 2 scored " + playerTwo.getPlayerRolled() + ".");
			count++;
		}
		int playerOneScore, playerTwoScore;
		if (playerOne.getPlayerRolled()>playerTwo.getPlayerRolled())
		{
			System.out.println("Reached final decision on order of playing. Player 1 then Player 2. It took " + count + " attempt(s) before a decision could be made.");
			for(playerOneScore = 0, playerTwoScore = 0; playerOneScore<100&&playerTwoScore<100;) //Conditions to win are not met
			{
				playerOneScore = playerOne.getPlayerScore(); //We need the for loop's inside to be variables so we reinitialize them every time the for loop goes again to check the condition after every loop.
				playerTwoScore = playerTwo.getPlayerScore();
				calculate(playerOne, playerTwo, 1); //We calculate player 1 and then player 2
				calculate(playerOne, playerTwo, 2);
			}
		}
		else
		{
			System.out.println("Reached final decision on order of playing. Player 2 then Player 1. It took " + count + " attempt(s) before a decision could be made.");
			for(playerOneScore = 0, playerTwoScore = 0; playerOneScore<100&&playerTwoScore<100;) {
				playerOneScore = playerOne.getPlayerScore();
				playerTwoScore = playerTwo.getPlayerScore();
				calculate(playerOne, playerTwo, 2); //We calculate player 2 and then player 1
				calculate(playerOne, playerTwo, 1);
			}
		}
		}

	/**
	 * Method that checks if any of the players have reached a ladder or a snake.
	 * <p>
	 * The method simply executes a switch statement where if any of the conditions are met, the player's score is updated to the new position depending on which ladder or snake was reached.
	 * </p>
	 * @param playerScore Is used to check where the player has landed to know if his position should be updated.
	 * @param player Is used to know which player the method is supposed to move.
	 * @return Returns the new value of the player's score, updated in the calculate() method.
	 */
		public int ladderOrSnake(int playerScore, int player){
			switch(playerScore)
			{//Ladders
				case 1:{
					System.out.println("Player " + player + " reached a ladder!");
					return 38;
				}
				case 4:{
					System.out.println("Player " + player + " reached a ladder!");
					return 14;
				}
				case 9:{
					System.out.println("Player " + player + " reached a ladder!");
					return 31;
				}
				case 21:{
					System.out.println("Player " + player + " reached a ladder!");
					return 42;
				}
				case 28:{
					System.out.println("Player " + player + " reached a ladder!");
					return 84;
				}
				case 36:{
					System.out.println("Player " + player + " reached a ladder!");
					return 44;
				}
				case 51:{
					System.out.println("Player " + player + " reached a ladder!");
					return 67;
				}
				case 71:{
					System.out.println("Player " + player + " reached a ladder!");
					return 91;
				}
				case 80:{
					System.out.println("Player " + player + " reached a ladder!");
					System.out.println("Player " + player + " won!");
					System.exit(0);
				}//Snakes
				case 16:{
					System.out.println("Player " + player + " reached a snake!");
					return 6;
				}
				case 48:{
					System.out.println("Player " + player + " reached a snake!");
					return 30;
				}
				case 64:{
					System.out.println("Player " + player + " reached a snake!");
					return 60;
				}
				case 79:{
					System.out.println("Player " + player + " reached a snake!");
					return 19;
				}
				case 93:{
					System.out.println("Player " + player + " reached a snake!");
					return 68;
				}
				case 95:{
					System.out.println("Player " + player + " reached a snake!");
					return 24;
				}
				case 97:{
					System.out.println("Player " + player + " reached a snake!");
					return 76;
				}
				case 98:{
					System.out.println("Player " + player + " reached a snake!");
					return 78;
				}
				case 100:{
					System.out.println("Player " + player + " won!");
					System.exit(0);
					break;
				}
			}
			return playerScore;
		}

	/**
	 * Prints the board.
	 * <p>
	 * Simply prints the 10x10 board and adjusts the positions of players 1 and 2 (A and B respectively) depending on their scores.
	 * </p>
	 * @param playerOneScore Is used to pass player one's score and display his position (A) on the board.
	 * @param playerTwoScore Is used to pass player two's score and display his position (B) on the board.
	 */
		public void printBoard(int playerOneScore, int playerTwoScore){
			for(int i = 0; i<=9; i++) {
				System.out.println();
				System.out.println();
				for (int j = 0; j<=9; j++)
				{
					board[i][j] = String.valueOf(10*i + (j+1));
					if(playerOneScore==Integer.parseInt(board[i][j]))
						board[i][j]="A";
					else if(playerTwoScore==Integer.parseInt(board[i][j]))
						board[i][j]="B";
					System.out.print(board[i][j] + "\t");
				} //These are the visuals, we use A for Player 1 and B for Player 2, and we print the board every iteration.
			}
		}

	/**
	 * This method implements all special conditions (like stepping on players, going over 100) and calculates the player's position after they have rolled the die and moved to their next position.
	 * <p>
	 * We first print the board to let the players visualize the situation. Then, the die is rolled and the "going over 100" condition is checked. Then, if the player reaches a ladder or snake,
	 * their score is updated; afterwards, if the player steps on the other player, the other player is shot down to square 0.
	 * </p>
	 * @param playerOne Passed to know all the values (playerJustRolled, playerScore) of Player 1.
	 * @param playerTwo Passed to know all the values (playerJustRolled, playerScore) of Player 2.
	 * @param i Passed to know which player is the one we are calculating the values for. If i=1, we are calculating the new score for Player 1. If i=2, we are calculating the new score for Player 2.
	 */
		public void calculate(Player playerOne, Player playerTwo, int i){
			if(i==1){
				printBoard(playerOne.getPlayerScore(), playerTwo.getPlayerScore());
				playerOne.setPlayerJustRolled(flipDice());
				playerOne.setPlayerScore(playerOne.getPlayerScore()+playerOne.getPlayerJustRolled());
				System.out.println();
				if(playerOne.getPlayerScore()>100)
					playerOne.setPlayerScore(100-(playerOne.getPlayerScore()-100)); //Move back a couple of spaces depending on how many extra points the player has.
				System.out.println();
				System.out.println("Player 1 rolled " + playerOne.getPlayerJustRolled());
				playerOne.setPlayerScore(ladderOrSnake(playerOne.getPlayerScore(), 1)); //Check for ladders and snakes
				if(playerOne.getPlayerScore()==playerTwo.getPlayerScore()) {
					System.out.println("Player 1 stepped on Player 2! Player 2 is now on square 0.");
					playerTwo.setPlayerScore(0);
				}//If player one steps on player two
				System.out.println("Player 1 is now on square " + playerOne.getPlayerScore());
			}
			if(i==2){
				printBoard(playerOne.getPlayerScore(), playerTwo.getPlayerScore());
				playerTwo.setPlayerJustRolled(flipDice());
				playerTwo.setPlayerScore(playerTwo.getPlayerScore()+playerTwo.getPlayerJustRolled());
				if(playerTwo.getPlayerScore()>100)
					playerTwo.setPlayerScore(100-(playerTwo.getPlayerScore()-100));
				System.out.println();
				System.out.println();
				System.out.println("Player 2 rolled " + playerTwo.getPlayerJustRolled());
				playerTwo.setPlayerScore(ladderOrSnake(playerTwo.getPlayerScore(), 2));//Check for ladders and snakes
				if(playerOne.getPlayerScore()==playerTwo.getPlayerScore()){
					System.out.println("Player 2 stepped on player 1! Player 1 is now on square 0.");
					playerTwo.setPlayerScore(0);//If player 2 steps on player 1
				}
				System.out.println("Player 2 is now on square " + playerTwo.getPlayerScore());
			}
		}
		}

	
	
