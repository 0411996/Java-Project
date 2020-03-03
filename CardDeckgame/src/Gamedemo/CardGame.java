package Gamedemo;
import java.io.*;
import java.util.*;

public class CardGame {
	//array for the card deck
	public static String[] carddeck= new String[52];
	public static String[] suits= {"Diamonds","clubs","Heart","Spade"};
	public static String[] rank= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
public static void main(String[] args)throws IOException
{
	Scanner sc = new Scanner(System.in);
	
	
	//loop to assign and print the cards in the deck
	for(int i=0;i<carddeck.length;i++) {
		carddeck[i]=rank[i%13]+" "+ suits[i/13];
		System.out.println(carddeck[i]);
	}
    System.out.println("Enter 1 for shuffling");
    int a= sc.nextInt();
    if(a==1) {
	shuffles();
	}
    else {
    	System.out.println("card not shuffled");  
    	}
    System.out.println("How many cards you want from the deck");
    int ncards=sc.nextInt();
    System.out.println("Here are"+ ncards +"extracted from the deck");
    deck(ncards);
    System.out.println("Lets start the game");
   
    	System.out.println("choose 1 for a single card game, 2 for 2 card game");
    	int n=sc.nextInt();
    	Gameon(n);	
	}


//to shuffle and print the shuffled deck
private static void shuffles() {
	
	for(int j=0;j<carddeck.length;j++)
	{
		int index=(int)(Math.random()*carddeck.length);
		String temp = carddeck[j];
		carddeck[j]=carddeck[index];
		carddeck[index]=temp;
	}
	for(int i=0;i<carddeck.length;i++) {
		System.out.println(carddeck[i]);
		}
	}


//extract cards from the deck
private static void deck(int n) {
//canner sce =new Scanner(System.in);
	String[] ncards= new String[n];
//List<String> list= new ArrayList<String>();
	
	for(int i=0;i<n;i++) 
	{
		//generating random index to extract random cards from the deck and adding it to an array of extracted cards
		int index=(int)(Math.random()*carddeck.length);
		ncards[i]=carddeck[index];
		//
		//
		// In the commented out code i was trying to Define the array to a list so that it becomes mutable 
		//and we can directly add or remove values from the list easily 
//list= Arrays.asList(carddeck);
//list.remove(index);
		System.out.println(ncards[i]);
	}
	/*
	System.out.println("Remaining Deck after extracting user input number of cards");
	for(String val : list) {
		System.out.println(val);
	}
	*/
	
}
private static void Gameon(int n) {
	//For single card game where each player extracts one card and we compare the card based on rank and suits(if rank is equal)
	if(n==1) {
		System.out.println("player1 draws a card");
		int a=(int)(Math.random()*rank.length);
		int b=(int)(Math.random()*suits.length);
		String user1 = rank[a]+suits[b];
		System.out.println("player1 got the card   " + user1);
		System.out.println("player2 draws the card");
		int c=(int)(Math.random()*rank.length);
		int d=(int)(Math.random()*suits.length);
		String user2 = rank[c]+suits[d];
		System.out.println("player2 got the card   " + user2);
		if(a>c) {
			System.out.println("Player 1 has the bigger card, wins the round");
		}
		else if(c>a) {
			System.out.println("Player 2 has the bigger card, wins the round");
		}
		else if(a==c) {
			if(b>d)
				System.out.println("Player 1 has the bigger card ,wins the round");
			else
				System.out.println("player2 has the bigger card ,wins the round");
			
		}
	
	}
	//for two card game where the rules are set as we give two cards to each player and 
	//the more the combined value of rank wins, but automatic disqualification if the rank combination value exceeds 21,
	//here we have set the player 1 as dealer so in case of a tie the dealer wins the round
	else if(n==2) {
		int val1=0;
		int val2=0;
		System.out.println("player1 draws two cards");
		for(int i=0;i<2;i++) {
		int a=(int)(Math.random()*rank.length);
		int c=(int)(Math.random()*suits.length);
		String crddrwn=rank[a]+suits[c];
		System.out.println(crddrwn);
		String ch = rank[a];
		//assigning int values to each card , all face cards have set value 11
		switch(ch) {
			case "A":
				val1+=1;
				break;
			case "2":
				val1+=2;
				break;
			case "3":
				val1+=3;
				break;
			case "4":
				val1+=4;
				break;
			case "5":
				val1+=5;
				break;
			case "6":
				val1+=6;
				break;
			case "7":
				val1+=7;
				break;
			case "8":
				val1+=8;
				break;
			case "9":
				val1+=9;
				break;
			case "10":
				val1+=10;
				break;
			case "J":
				val1+=11;
				break;
			case "Q":
				val1+=11;
				break;
			case "K":
				val1+=11;
				break;
			default:
				System.out.println("you drew the joker");
				break;
		}
	}
		System.out.println("value of player 1 cards : " +val1);
		if(val1>21) {
			System.out.println("Player 2 automatically wins as player 1 drew more than the 21 limit");
			
		}
		else {
			System.out.println("Now Player 2 draws his two cards");
			for(int i=0;i<2;i++) {
				int b=(int)(Math.random()*rank.length);
				int d=(int)(Math.random()*suits.length);
				String crddrwn1=rank[b]+suits[d];
				System.out.println(crddrwn1);
				
				String ch = rank[b];
				//assigning int values to each card , all face cards have set value 11
				switch(ch) {
					case "A":
						val2+=1;
						break;
					case "2":
						val2+=2;
						break;
					case "3":
						val2+=3;
						break;
					case "4":
						val2+=4;
						break;
					case "5":
						val2+=5;
						break;
					case "6":
						val2+=6;
						break;
					case "7":
						val2+=7;
						break;
					case "8":
						val2+=8;
						break;
					case "9":
						val2+=9;
						break;
					case "10":
						val2+=10;
						break;
					case "J":
						val2+=11;
						break;
					case "Q":
						val2+=11;
						break;
					case "K":
						val2+=11;
						break;
					default:
						System.out.println("you drew the joker");
						break;
				}
				
			}
			System.out.println("value of player 2 cards : " +val2);
			if(val2>21)
			{
				System.out.println("player 1 automatically wins as player 2 crosses the limit value of 21");
			}
		}
		
		if(val1>val2) {
			System.out.println("Player 1 wins");
		}
		else if(val2>val1) {
			System.out.println("Player2 wins");
		}
		else
		{
			System.out.println("Player1 wins, Dealer wins when equal");
		}
	}
}
}
	

