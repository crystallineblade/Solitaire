import java.util.*;
public class Deck
{
    ArrayList<Card> deck;
    Random rand;
    public Deck() {
        deck = new ArrayList<Card>();
        rand = new Random();
    }
    public void add(Card c){
        deck.add(c);
    }
    public void remove(int index) {
        deck.remove(index);
    }
    public int size() {
        return deck.size();
    }
    public Card draw() {
        Card c = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return c;
    }
    public Card get(int index) {
        return deck.get(index);
    }
    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int x = rand.nextInt(deck.size());
            Card c = deck.get(i);
            deck.set(i,deck.get(x));
            deck.set(x,c);
        }
    }
    @Override
    public String toString() {
        return Arrays.toString(deck.toArray());
    }
}
