//*******************************************************************
// Name: Eric Lin
// Course: CS114-011
// Assignment: Lab02 - MiniWar
// Due Date: 10-06-2022
// Brief: This program implements a simple card game of War.
//*******************************************************************
package lists114;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import lists114.queue.AQueue;

public class MiniWar {
	
	// Cards in deck
	private static final Integer[] CARDS = {1, 1, 2, 2, 3, 3};
	
	private Random coin;
	private AQueue<Integer> deck1;
	private AQueue<Integer> deck2;
	
	// Constructor
	public MiniWar() {
		coin = new Random();
	}
	
	
	/* Play a game of miniWar. Input: players' names. */
	public void playGame(String player1, String player2){
		
		//Create card decks
		initGame();
		int round = 1;
		
		System.out.print(player1 + " starts with deck: " );
		deck1.printQueue();
		System.out.print(player2 + " starts with deck: " );
		deck2.printQueue();

		int a = 0;
		int b = 0;
		int r = 0;
		
		// Play rounds until one of the decks is empty
		while(deck1.length() != 0 && deck2.length() != 0)
		{

			if(deck1.frontValue() > deck2.frontValue())
			{
				a = deck1.dequeue();
				b = deck2.dequeue();
				deck1.enqueue(a);
				deck1.enqueue(b);
			}
			else if(deck1.frontValue() < deck2.frontValue())
			{
				a = deck2.dequeue();
				b = deck1.dequeue();
				deck2.enqueue(a);
				deck2.enqueue(b);
			}
			else if(deck1.frontValue() == deck2.frontValue())
			{
				a = deck1.dequeue();
				b = deck2.dequeue();
				r = flipCoin();

				if(r == 1)
				{
					deck1.enqueue(a);
					deck1.enqueue(b);
				}
				else if(r == 2)
				{
					deck2.enqueue(a);
					deck2.enqueue(b);
				}
			}

			System.out.println("Round: " + round);
			System.out.println("**********");
			printDecks(player1, player2);
			System.out.println("----------------------------");
			round++;
		}
		
		// The empty deck is the player that lost the game
		if (deck1.length() == 0)
			System.out.println(player2 + " won!");
		else
			System.out.println(player1 + " won!");
	}
	
	/* Returns 1 or 2, randomly - use this as a coin flip */
	private int flipCoin() {
		if (coin.nextBoolean()) 
			return 1;
		else 
			return 2;
	}
	
	// Initiate 2 decks with shuffled cards
	public void initGame() {
		
		// create new empty decks
		deck1 = new AQueue<Integer>(CARDS.length*2);
		deck2 = new AQueue<Integer>(CARDS.length*2);
		
		Integer[] cards = CARDS.clone();
		
		// shuffle cards for first deck
		Collections.shuffle(Arrays.asList(cards));
		
		//Add cards to first deck
		for (Integer c : cards){
			deck1.enqueue(c);
		}
		
		// shuffle cards for first deck
		Collections.shuffle(Arrays.asList(cards));			
		
		//Add cards to second deck
		for (Integer c : cards){
			deck2.enqueue(c);
		}
	}
	
	// Print the players and their decks
	public void printDecks(String player1, String player2) {
		System.out.print(player1 + ": " );
		deck1.printQueue();
		System.out.print(player2 + ": " );
		deck2.printQueue();	
		
	}
}
 