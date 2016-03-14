import java.util.*;
public class TestDeck
{
    public static void main (String[] args)
    {
        Deck testDeck= new Deck();
        
        Card testCard= new Card(1); 
        Card testCard1= new Card(2);
        Card testCard2= new Card(3);

        
        System.out.println("Card ID: "+testCard.getId());
        System.out.println("Card1 ID: "+testCard1.getId());
        System.out.println("Card2 ID: "+testCard2.getId());

        
        testDeck.add(testCard);
        testDeck.add(testCard1);
        testDeck.add(testCard2);
        
        System.out.println(testDeck);
        System.out.println("----------------------------------------");
        
        testDeck.shuffle();
        
        System.out.println(testDeck);
        System.out.println("----------------------------------------");
        
        testDeck.sort();
        
        System.out.println(testDeck);
        
        
        while (! testDeck.isEmpty())
        {

           System.out.print(testDeck.takeTop());

        }
        
        System.out.println(testDeck);
    }
}