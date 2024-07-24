package bankjago;

public class HandRankValidationResp {
    Rank highestRank;
    Suit highestSuit;     
    boolean result;

    public HandRankValidationResp(Rank highestRank, Suit highestSuit, boolean result) {
        this.highestRank = highestRank;
        this.highestSuit = highestSuit;
        this.result = result;
    }
}