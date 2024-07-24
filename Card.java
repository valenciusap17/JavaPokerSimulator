package bankjago;
public class Card {
    Suit suit;
    Rank rank;
    int total;
    
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.total = suit.getValue() + Suit.values().length * (rank.getValue() - 1); 
    }
}
