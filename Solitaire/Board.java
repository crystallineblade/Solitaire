import java.util.*;
public class Board
{   
    /* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
    // Attributes
    ArrayList<Deck> stacks;
    Deck drawPile;
    ArrayList<Deck> completed;
    String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
    int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    /**
     *  Sets up the Board and fills the stacks and draw pile from a Deck
     *  consisting of numDecks Decks.  The number of Cards in a Deck
     *  depends on the number of suits. Here are examples:
     *  
     *  # suits     # numDecks      #cards in overall Deck
     *      1            1          13 (all same suit)
     *      1            2          26 (all same suit)
     *      2            1          26 (one of each suit)
     *      2            2          52 (two of each suit)
     *      4            2          104 (two of each suit)
     *      
     *  Once the overall Deck is built, it is shuffled and half the cards
     *  are placed as evenly as possible into the stacks.  The other half
     *  of the cards remain in the draw pile.  If you'd like to specify
     *  more than one suit, feel free to add to the parameter list.
     */    
    public Board(int numStacks, int numDecks) {
        stacks = new ArrayList<Deck>();
        drawPile = new Deck();
        completed = new ArrayList<Deck>();
        for (int i = 0; i < numStacks; i++) {
            stacks.add(new Deck());
        }
        Deck deck = new Deck();
        for (int i = 0; i < numDecks; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(new Card(symbols[j],values[j]));
            }
        }
        deck.shuffle();
        int x = deck.size()/2;
        for (int i = 0; i < x; i++) {
            drawPile.add(deck.draw());
        }
        int divide = x/numStacks;
        int reminder = x%numStacks;
        for (int i = 0; i < numStacks; i++) {
            for (int j = 0; j < divide; j++) {
                stacks.get(i).add(deck.draw());
            }
        }
        for (int i = 0; i < reminder; i++) {
            stacks.get(i).add(deck.draw());
        }
        for (int i = 0; i < numStacks; i++) {
            stacks.get(i).get(stacks.get(i).size()-1).setFaceUp(true);
        }

    }

    /**
     *  Moves a run of cards from src to dest (if possible) and flips the
     *  next card if one is available.  Change the parameter list to match
     *  your implementation of Card if you need to.
     */
    public void makeMove(String symbol, int src, int dest) {
        int x = -1;
        Card c = new Card(symbol, 0);
        for (int i = stacks.get(src).size()-1; i >= 0; i--) {
            if (stacks.get(src).get(i).equals(c)){
                x = i;
                break;
            }
        }
        if (x == -1) {
            System.out.println("Error: Card not found");
            return;
        }
        if (!stacks.get(src).get(x).isFaceUp()) {
            System.out.println("Error: Card not found");
            return;
        }
        if (x == 0) {
            ;
        }
        else {
            for (int i = x+1; i < stacks.get(src).size(); i++) {
                if (stacks.get(src).get(i-1).compareTo(stacks.get(src).get(i)) != 1) {
                    System.out.println("Error: Illegal move");
                    return;
                }
            }
        }
        if (stacks.get(dest).size() == 0) {
            while (x <= stacks.get(src).size()-1) {
                stacks.get(dest).add(stacks.get(src).get(x));
                stacks.get(src).remove(x);
            }
        }
        else if (x !=0 && stacks.get(dest).get(stacks.get(dest).size()-1).compareTo(stacks.get(src).get(x)) != 1){
            System.out.println("Error: Illegal move");
        }
        else {
            while (x <= stacks.get(src).size()-1) {
                stacks.get(dest).add(stacks.get(src).get(x));
                stacks.get(src).remove(x);
            }
        }
        if (stacks.get(src).size() != 0 && !stacks.get(src).get(stacks.get(src).size()-1).isFaceUp()) {
            stacks.get(src).get(stacks.get(src).size()-1).setFaceUp(true);
        }
    }

    /** 
     *  Moves one card onto each stack, or as many as are available
     */
    public void drawCards() {
        for (int i = 0; i < stacks.size(); i++) {
            if (stacks.get(i).size() == 0) {
                System.out.println("Error: Empty stack");
                return;
            }
        }
        if (drawPile.size() >= stacks.size()) {
            for (int i = 0; i < stacks.size(); i++) {
                Card c = drawPile.draw();
                c.setFaceUp(true);
                stacks.get(i).add(c);
            }
        }
        else {
            int i = 0;
            while (drawPile.size()>0) {
                Card c = drawPile.draw();
                c.setFaceUp(true);
                stacks.get(i).add(c);
                i++;
            }
        }
    }

    /**
     *  Returns true if all stacks and the draw pile are all empty
     */ 
    public boolean isEmpty() {
        for (int i = 0; i < stacks.size(); i++) {
            if (stacks.get(i).size() > 0) {
                return false;
            }
        }
        if (drawPile.size() > 0) {
            return false;
        }
        return true;
    }

    /**
     *  If there is a run of A through K starting at the end of sourceStack
     *  then the run is removed from the game or placed into a completed
     *  stacks area.
     *  
     *  If there is not a run of A through K starting at the end of sourceStack
     *  then an invalid move message is displayed and the Board is not changed.
     */
    public void clear(int sourceStack) {
        if (sourceStack < 0 || sourceStack >= stacks.size()) {
            System.out.println("Error: source stack is out of bounds");
            return;
        }
        if (stacks.get(sourceStack).size()>= 13) {
            for (int i = stacks.get(sourceStack).size()-12; i < stacks.get(sourceStack).size(); i++) {
                if (stacks.get(sourceStack).get(i).compareTo(stacks.get(sourceStack).get(i-1)) != -1) {
                    System.out.println("Error: invalid move");
                    return;
                }
            }
            for (int i = stacks.get(sourceStack).size()-1; i >= 0; i--) {
                if (stacks.get(sourceStack).get(i).equals(new Card("K",13))) {
                    stacks.get(sourceStack).remove(i);
                    break;
                }
                else {
                    stacks.get(sourceStack).remove(i);
                }
            }
        }
        else {
            System.out.println("Error: invalid move");
        }
    }

    /**
     * Prints the board to the terminal window by displaying the stacks, draw
     * pile, and done stacks (if you chose to have them)
     */
    public void printBoard() {
        System.out.println("Stacks:");
        for (int i = 0; i < stacks.size(); i++) {
            System.out.printf("%d: %s\n", i+1, stacks.get(i).toString());
        }
        System.out.println();
        System.out.println("Draw Pile:");
        System.out.println(drawPile.toString());
    }
}