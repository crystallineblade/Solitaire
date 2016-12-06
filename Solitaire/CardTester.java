public class CardTester
{
    public static void main(String[] args) {
        Card card1 = new Card("10", 10);
        Card card2 = new Card("10", 10);
        Card card3 = new Card("5", 5);
        System.out.println("Card 3 symbol: " + card3.getSymbol());
        System.out.println("Card 2 value: " + card2.getValue());
        System.out.println("Card 1 face up:" + card1.isFaceUp());
        card2.setFaceUp(true);
        System.out.println("Card 2 face up:" + card2.isFaceUp());
        System.out.println("Card 2 = Card 1: " + card2.equals(card1));
        System.out.println("Card 3 compared to Card 2:" + card3.compareTo(card2));
        System.out.println(card1.toString() +" "+ card2.toString() +" " + card3.toString());
    }
}
