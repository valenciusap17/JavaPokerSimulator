package bankjago;

public class HandRankValidationResp {
    Card highestRankCard;
    Card highestSuitCard;     
    boolean result;

    public HandRankValidationResp(Card highestRankCard, Card highestSuitCard, boolean result) {
        this.highestRankCard = highestRankCard;
        this.highestSuitCard = highestSuitCard;
        this.result = result;
    }
}