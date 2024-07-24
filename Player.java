package bankjago;
public class Player {
    String name;
    HandRanking handRanking;
    Card highestRankCard;
    Card highestSuitCard;

    public Player (String name, HandRanking handRanking, Card highestRankCard, Card highestSuitCard) {
        this.name = name;
        this.handRanking = handRanking;
        this.highestRankCard = highestRankCard;
        this.highestSuitCard = highestSuitCard;
    }
    
}
