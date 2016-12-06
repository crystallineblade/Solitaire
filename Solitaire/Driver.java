/* Julia Shuieh, 12/4/2016, Period 3
 * 
 * I spent 2 hours on this lab. 
 * 
 * This lab was pretty easy at some parts, but I had a large problem that I was not able to solve. The Card class was fairly simple to write as most of the imformation was give in the instructions. For the Deck class,
 * I did not implement many methods. I used a static ArrayList<> to contain all of the cards, but I think I should have used getters and other methods to change the ArrayList<>. I spent the most time writing the 
 * Board class, using 1.5 hours. It seemed simple to create, but for some reason, the ArrayList<> would have 1.5 decks in them instead of 3. I tried many ways to solve this problem, such as changing it to an array, 
 * changing the structure of the constructor, and changing the printBoard() method. However, I was still unable to solve the problem. I will resubmit it with the corrected code. In conclusion, I spent all of time in
 * solving one problem with the Board class, and I will resubmit the code when I solve it.
 */

public class Driver
{
    public static void main(String[] args) {
        new SpiderSolitaire().play();
        
    }
}
