package bankjago;

public enum HandRanking {
    ROYAL_FLUSH("Royal Flush", 10),
    STRAIGHT_FLUSH("Straight Flush", 9),
    FOUR_OF_A_KIND("Four of a Kind", 8),
    FULL_HOUSE("Full House", 7),
    FLUSH("Flush", 6),
    STRAIGHT("Straight", 5),
    THREE_OF_A_KIND("Three of a Kind", 4),
    TWO_PAIRS("Two Pairs", 3),
    ONE_PAIR("One Pair", 2),
    NOTHING("Nothing", 1);
 
    private String name;
    private int value;

    private HandRanking(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // getter
    public String getName() {
        return this.name;
    }

    // setter
    public int getValue() {
        return this.value;
    }
}
