package bankjago;

public enum Suit {
    SPADE("Spade", 4),
    HEART("Heart", 3),
    DIAMOND("Diamond", 2),
    CLUB("Club", 1);

    private String name;
    private int value;

    private Suit(String name, int value) {
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

