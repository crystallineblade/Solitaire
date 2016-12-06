/**
 * Card.java
 *
 * <code>Card</code> represents a basic playing card.
 */
public class Card implements Comparable<Card>
{
    /** String value that holds the symbol of the card.
    Examples: "A", "Ace", "10", "Ten", "Wild", "Pikachu"
     */
    private String symbol;

    /** int value that holds the value this card is worth */
    private int value;

    /** boolean value that determines whether this card is face up or down */
    private boolean isFaceUp;

    /**
     * Creates a new <code>Card</code> instance.
     *
     * @param symbol  a <code>String</code> value representing the symbol of the card
     * @param value an <code>int</code> value containing the point value of the card
     */    
    public Card(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
        isFaceUp = false;
    }

    /**
     * Getter method to access this <code>Card</code>'s symbol.
     * 
     * @return this <code>Card</code>'s symbol.
     */
    public String getSymbol() {
        return symbol;
    }
    
    /**
     * Getter method to access this <code>Card</code>'s point value.
     * 
     * @return this <code>Card</code>'s point value.
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Getter method to access if <code>Card</code> is face up.
     * 
     * @return whether or not this <code>Card</code> is face up.
     */
    public boolean isFaceUp() {
        return isFaceUp;
    }
    
    /**
     * Setter method to set whether or not <code>Card</code> is face up.
     * 
     * @param state a <code>boolean</code> value representing whether or not the card is face up.
     */
    public void setFaceUp(boolean state) {
        isFaceUp = state;
    }

    /**
     * Returns whether or not this <code>Card</code> is equal to another
     *  
     *  @return whether or not this Card is equal to other.
     */
    public boolean equals(Card other) {
        if (other.symbol == this.symbol && other.value == this.value) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Returns the difference in value between this <code>Card</code> and another.
     * 
     * @return the difference between this Card and the other.
     */
    public int compareTo(Card other) {
        return this.value - other.value;
    }
    /**
     * Returns this card as a String.  If the card is face down, "X"
     * is returned.  Otherwise the symbol of the card is returned.
     *
     * @return a <code>String</code> containing the symbol and point
     *         value of the card.
     */
    @Override
    public String toString() {
        if (isFaceUp) {
            return symbol;
        }
        else {
            return "X";
        }
    }
}
