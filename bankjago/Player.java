package bankjago;
public class Player {
    String name;
    HandRanking handRanking;
    Rank highestRank;
    Suit highestSuit;

    public Player (String name, HandRanking handRanking, Rank highestRank, Suit highestSuit) {
        this.name = name;
        this.handRanking = handRanking;
        this.highestRank = highestRank;
        this.highestSuit = highestSuit;
    }
    
}
