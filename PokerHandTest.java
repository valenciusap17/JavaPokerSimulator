package bankjago;

public class PokerHandTest {

    public static Card[] getRoyalFlushTest() {
        return new Card[]{
            new Card(Suit.SPADE, Rank.ACE), 
            new Card(Suit.SPADE, Rank.QUEEN), 
            new Card(Suit.SPADE, Rank.JACK), 
            new Card(Suit.SPADE, Rank.TEN), 
            new Card(Suit.SPADE, Rank.KING), 
        };
    } 

    public static Card[] getStraightFlushTest() {
        return new Card[]{
            new Card(Suit.HEART, Rank.SEVEN), 
            new Card(Suit.HEART, Rank.TWO), 
            new Card(Suit.HEART, Rank.THREE), 
            new Card(Suit.HEART, Rank.FOUR), 
            new Card(Suit.HEART, Rank.FIVE),     
        };
    }

    public static Card[] getFourOfAKindTest() {
        return new Card[] {
           new Card(Suit.HEART, Rank.THREE), 
           new Card(Suit.CLUB, Rank.THREE), 
           new Card(Suit.HEART, Rank.THREE), 
           new Card(Suit.SPADE, Rank.THREE), 
           new Card(Suit.HEART, Rank.EIGHT), 
       };
    }
    public static Card[] getFullHouseTest () {
        return new Card[]{
            new Card(Suit.HEART, Rank.THREE), 
            new Card(Suit.CLUB, Rank.THREE), 
            new Card(Suit.HEART, Rank.THREE), 
            new Card(Suit.SPADE, Rank.FIVE), 
            new Card(Suit.HEART, Rank.FIVE), 
        };
    };
    public static Card[] getFlushTest() {
        return new Card[]{
            new Card(Suit.HEART, Rank.THREE), 
            new Card(Suit.HEART, Rank.SEVEN), 
            new Card(Suit.HEART, Rank.SEVEN), 
            new Card(Suit.HEART, Rank.THREE), 
            new Card(Suit.HEART, Rank.QUEEN), 
        };
    };
    public static Card[] getStraightTest(){
        return new Card[]{
            new Card(Suit.HEART, Rank.TWO), 
            new Card(Suit.DIAMOND, Rank.FOUR), 
            new Card(Suit.DIAMOND, Rank.THREE), 
            new Card(Suit.HEART, Rank.FIVE), 
            new Card(Suit.SPADE, Rank.ACE), 
        };
    };
    public static Card[] getThreeOfAKindTest() {
        return new Card[]{
            new Card(Suit.DIAMOND, Rank.SEVEN), 
            new Card(Suit.HEART, Rank.SEVEN), 
            new Card(Suit.DIAMOND, Rank.SEVEN), 
            new Card(Suit.HEART, Rank.FIVE), 
            new Card(Suit.SPADE, Rank.FOUR), 
        };
    };
    public static Card[] getTwoPairsTest(){
        return new Card[]{
            new Card(Suit.DIAMOND, Rank.ACE), 
            new Card(Suit.HEART, Rank.SEVEN), 
            new Card(Suit.SPADE, Rank.ACE), 
            new Card(Suit.SPADE, Rank.SEVEN), 
            new Card(Suit.SPADE, Rank.FOUR), 
        };
    };
    public static Card[] getOnePairTest() {
        return new Card[]{
            new Card(Suit.DIAMOND, Rank.EIGHT), 
            new Card(Suit.HEART, Rank.SEVEN), 
            new Card(Suit.SPADE, Rank.ACE), 
            new Card(Suit.CLUB, Rank.EIGHT), 
            new Card(Suit.SPADE, Rank.FOUR), 
        };
    };

    public static Card[] getCustomTest() {
        return new Card[]{
            new Card(Suit.HEART, Rank.KING), 
            new Card(Suit.DIAMOND, Rank.KING), 
            new Card(Suit.DIAMOND, Rank.SIX), 
            new Card(Suit.CLUB, Rank.EIGHT), 
            new Card(Suit.DIAMOND, Rank.TEN), 
        };
    };
}