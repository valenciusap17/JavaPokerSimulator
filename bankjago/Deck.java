package bankjago;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Deck {
    private ArrayList<Card> cards;
    
    Deck() {
        cards = new ArrayList<>();
        Arrays.asList(Rank.values()).forEach(rank -> Arrays.asList(Suit.values()).forEach(suit -> cards.add(new Card(suit, rank))));
    }

    //getter
    public int getSize() {
        return cards.size();
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    
    public Card[] getHandsOfCard() {
        Card[] hand = new Card[5];
        for (int i = 0; i < 5; i++) {
            hand[i] = cards.removeFirst();
        }
        return hand;
    }

    // setter
    public Card popCard(int number) {
        return cards.remove(number);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to determine the Hand Rank
    public Player Validate(String name, Card[] hand) {
        // Conditions for royal flush
        String[] royalFlush = {"Ace", "King", "Queen", "Jack", "Ten"};

        // To store suit information from cards in a hand
        ArrayList<String> cardSuit = new ArrayList<>();
        Set<String> cardSuitSet = new HashSet<>();
        
        // To store rank information from cards in a hand
        ArrayList<String> cardRank = new ArrayList<>();
        ArrayList<Integer> cardRankValue = new ArrayList<>();
        Set<String> cardRankSet = new HashSet<>();

        // Variables which will be filled with most valuable card in hand
        Suit highestSuit = Suit.CLUB;
        Rank highestRank = Rank.TWO;

        Map<Integer, ArrayList<Card>> rankMap = new HashMap<>(); 

        // Processing every card in hand
        for (int i = 0; i < hand.length; i++) {
            cardSuit.add(hand[i].suit.getName());
            cardSuitSet.add(hand[i].suit.getName());
            
            cardRank.add(hand[i].rank.getName());
            cardRankSet.add(hand[i].rank.getName());
            cardRankValue.add(hand[i].rank.getValue());
            
            // Apply hashmap 
            if (rankMap.get(hand[i].rank.getValue()) == null) {
                rankMap.put(hand[i].rank.getValue(), new ArrayList<>());
                rankMap.get(hand[i].rank.getValue()).add(hand[i]);
            } else {
                rankMap.get(hand[i].rank.getValue()).add(hand[i]);
            }

            // getting most valuable card from the rank value
            if (highestRank.getValue() < hand[i].rank.getValue()) {
                highestRank = hand[i].rank;
                highestSuit = hand[i].suit;
            } else if (highestRank.getValue() == hand[i].rank.getValue()){
                if (highestSuit.getValue() < hand[i].suit.getValue()) {
                    highestSuit = hand[i].suit;
                }
            }
            
        }

        // Condition for royal flush
        if (cardRank.containsAll(Arrays.asList(royalFlush)) && cardSuitSet.size() == 1) {
            return new Player(name, HandRanking.ROYAL_FLUSH, highestRank, highestSuit);
        } 
        
        // Condition for Straight flush
        if (cardSuitSet.size() == 1 && cardRankSet.size() == 5 && checkOrdered(cardRankValue)){
            if (cardRankValue.contains(1)){
                return new Player(name, HandRanking.STRAIGHT_FLUSH, Rank.FIVE, highestSuit);
            }
            return new Player(name, HandRanking.STRAIGHT_FLUSH, highestRank, highestSuit);
        } 
        
        // Condition for four of a kind
        HandRankValidationResp result = checkCardsWithSameRank(rankMap, 4);
        if (result.result) {
            return new Player(name, HandRanking.FOUR_OF_A_KIND, result.highestRank, result.highestSuit);
        }
        
        // Condition for full house
        HandRankValidationResp result1 = checkCardsWithSameRank(rankMap, 3);
        HandRankValidationResp result2 = checkCardsWithSameRank(rankMap, 2);
        if (result1.result && result2.result) {
            return new Player(name, HandRanking.FULL_HOUSE, result1.highestRank, result1.highestSuit);
        }
        
        // Condition for flush
        if (cardSuitSet.size() == 1) {
            return new Player(name, HandRanking.FLUSH, highestRank, highestSuit);
        } 
        
        // Condition for straight
        if (cardRankSet.size() == 5 && checkOrdered(cardRankValue)) {
            if (cardRankValue.contains(1)){
                return new Player(name, HandRanking.STRAIGHT, Rank.FIVE, highestSuit);
            }
            return new Player(name, HandRanking.STRAIGHT, highestRank, highestSuit);
        } 
        
        // Condition for three of a kind
        result = checkCardsWithSameRank(rankMap, 3);
        if (result.result) {
            return new Player(name, HandRanking.THREE_OF_A_KIND, result.highestRank, result.highestSuit);
        }
        
        // Condition for two pairs
        result = checkTwoPairsCount(rankMap);
        if (result.result) {
            return new Player(name, HandRanking.TWO_PAIRS, result.highestRank, result.highestSuit);
        } 
        
        // Condition for pairs
        result = checkCardsWithSameRank(rankMap, 2);
        if (result.result) {
            return new Player(name, HandRanking.ONE_PAIR, result.highestRank, result.highestSuit);
        } 

        //Condition for Nothing 
        return new Player(name, HandRanking.NOTHING, highestRank, highestSuit);
    }

    // Method to check if cards in hand is sequantial in ranks
    public boolean checkOrdered(ArrayList<Integer> list) {
        if (list.contains(14)) {
            list.remove(Integer.valueOf(14));
            list.add(1);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i)) max = list.get(i);
            if (min > list.get(i)) min = list.get(i);
        }

        if (max - min == list.size()-1) return true;
        return false;
    }

    // Method to check if two pair condition is occured
    public HandRankValidationResp checkTwoPairsCount(Map<Integer, ArrayList<Card>> map) {
        int count = 0;
        Rank highestRank = Rank.TWO;
        Suit highestSuit = Suit.CLUB;
        
        boolean result = false;
        for (ArrayList<Card> value : map.values()) {
            if (value.size() == 2) {
                count++;
                for (Card current : value) {
                    if (highestRank.getValue() < current.rank.getValue()) {
                        highestRank = current.rank;
                        highestSuit = current.suit;
                    } else if (highestRank.getValue() == current.rank.getValue()) {
                        if (highestSuit.getValue() < current.suit.getValue()) {
                            highestSuit = current.suit;
                        } 
                    }
                }
            }
        }
        if (count >= 2) {
            result = true;
        }
        return new HandRankValidationResp(highestRank, highestSuit, result);

    }

    // Method to check if sum of cards within the same rank is equal to the num given
    public HandRankValidationResp checkCardsWithSameRank(Map<Integer, ArrayList<Card>> map, int num) {
        Rank highestRank = Rank.TWO;
        Suit highestSuit = Suit.CLUB;
        
        boolean result = false;

        for (ArrayList<Card> data: map.values()) {
            if (data.size() == num) {
                result = true;
                for (Card current : data) {
                    if (highestRank.getValue() < current.rank.getValue()) {
                        highestRank = current.rank;
                        highestSuit = current.suit;
                    } else if (highestRank.getValue() == current.rank.getValue()) {
                        if (highestSuit.getValue() < current.suit.getValue()) {
                            highestSuit = current.suit;
                        } 
                    }
                }
            }
        }
        return new HandRankValidationResp(highestRank, highestSuit, result);
    }
}