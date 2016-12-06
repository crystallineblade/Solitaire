public class DeckTester
{
    public static void main(String[] args) {
        Deck deck = new Deck();
        String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        for (int i = 0; i < 13; i++) {
            for (int x = 0; x < 4;x++) {
                Card c = new Card(symbols[i], values[i]);
                c.setFaceUp(true);
                deck.add(c);
            }
        }
        System.out.println(deck.toString());
        deck.shuffle();
        System.out.println(deck.toString());
    }
}
