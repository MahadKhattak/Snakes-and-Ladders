package org.example;
/**
 * Name and ID		Mahad Khattak 40251021
 * COMP249	
 * Assignment #		1
 * Due Date			February 3rd, 2023
 */
import java.util.Scanner;
public class PlayLadderAndSnake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Ask for the number of players
System.out.println("How many players are playing?");
Scanner keyIn = new Scanner(System.in);
LadderAndSnake ladderandsnake1 = new LadderAndSnake(keyIn.nextInt());
ladderandsnake1.play();
keyIn.close();
	}

}
