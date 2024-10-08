package bankjago;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static Scanner scanner; 
    public static void main(String[] args) throws IOException {
        // Creating input reader
        scanner = new Scanner(System.in);

        // Initializing deck for poker game
        Deck deck = new Deck();

        // Shuffle the card order
        deck.shuffle();

        // Decide the number of players
        // The maximum amount of players will be 10
        Queue<String> playerNames = new LinkedList<>();
        int playersCount = 0;
        while (playersCount < 1 || playersCount > 10) {
            System.out.print("Enter the number of players (1-10): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Your input is not in a valid number format");
                scanner.nextLine(); // Clearing the input
                System.out.print("Please re-enter the valid number: ");
            }
            playersCount = scanner.nextInt();
            scanner.nextLine();
            if (playersCount < 1 || playersCount > 10) {
                System.out.println("Number of players must be more than 0 and less than 11");
            }
        }
        System.out.println("Enter players name: ");
        for (int i = 1; i <= playersCount; i++) {
            System.out.print("Player " + i + ":");
            playerNames.add(scanner.nextLine());
        }

        PriorityQueue<Player> playerHandRanksPq = new PriorityQueue<>(playersCount, new Comparator<Player>() {
            public int compare(Player p1, Player p2) {
                int handRanksComparison = Integer.compare(p2.handRanking.getValue(), p1.handRanking.getValue());
                if (handRanksComparison == 0) {
                    if (p1.handRanking.getValue() > 5) {
                        //Highest suit then highest rank
                        handRanksComparison = Integer.compare(p2.highestSuit.getValue(), p1.highestSuit.getValue());
                        if (handRanksComparison == 0) {
                            handRanksComparison = Integer.compare(p2.highestRank.getValue(), p1.highestRank.getValue());
                        }
                    } else {
                        //Highest rank then highest suit
                        handRanksComparison = Integer.compare(p2.highestRank.getValue(), p1.highestRank.getValue());
                        if (handRanksComparison == 0) {
                            handRanksComparison = Integer.compare(p2.highestSuit.getValue(), p1.highestSuit.getValue());
                        }
                    }
                }
                return handRanksComparison;
            }           
        });


        System.out.println();
        
        // Giving each player a hands of card
        for (int i = 0; i < playersCount; i++) {
            Card[] handsOfCards = deck.getHandsOfCard();
            // Card[] handsOfCards = PokerHandTest.getCustomTest();
            String playerName = playerNames.poll();

            // Printing out the hand of cards given to each player
            System.out.println("Cards for " + playerName + ":");
            for (int j = 0; j < handsOfCards.length; j++) {
                System.out.print(handsOfCards[j].rank.getName() + " " + handsOfCards[j].suit.getName());
                System.out.print(", ");                 
            }

            Player player = deck.Validate(playerName, handsOfCards);
            System.out.println("hand rank name: " + player.handRanking.getName());
            playerHandRanksPq.add(player);
        }
        System.out.println();

        // Print output according to the validation results that we get
        int counter = 1;
        while (!playerHandRanksPq.isEmpty()) {
            System.out.println("Player with rank " + counter);
            Player currentPlayer = playerHandRanksPq.poll();
            if (currentPlayer.handRanking.getValue() > 5) {
                System.out.println(currentPlayer.name + " with hand rank: " + currentPlayer.handRanking.getName() + ", most valuable card rank: " + currentPlayer.highestRank.getName() + " and it's suit: " + currentPlayer.highestSuit.getName());
            } else {
                System.out.println(currentPlayer.name + " with hand rank: " + currentPlayer.handRanking.getName() + ", most valuable card rank: " + currentPlayer.highestRank.getName() + " and it's suit: " + currentPlayer.highestSuit.getName());
            }
            counter++;
        }

        // Uncomment code below to use test cases in PokerHandTest.java 
        // System.out.println("exeecute test case: ");
        // Player custom = deck.Validate("experiment", PokerHandTest.getCustomTest());
        // System.out.println(custom.handRanking.getName());
        // System.out.println(custom.highestRank.getName());
        // System.out.println(custom.highestSuit.getName());

        scanner.close();
    }
}
