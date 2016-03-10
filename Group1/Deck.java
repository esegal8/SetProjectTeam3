/**
 *  Represents a generic deck of cards.
 */

/*

  Tips:

  - Use an ArrayList<Card> to hold the cards.
  - Add and remove cards at the end of the list.
  - Use Collections.shuffle and Collections.sort to shuffle and sort the deck,
    or write your own methods.  If you write your own, use selection sort
    to sort and a similar algorithm to shuffle.  Use Math.random().
  - In the toString method, separate strings for individual cards with "\n".

*/

import java.util.*;

public class Deck
{
    public Deck()
    {

        ArrayList<Card> deck= new ArrayList<Card>();

    }
    public Deck(int numCard)
    {
        
    }
    public int getNumCards()
    {
        return 1;
    }
    public boolean isEmpty()
    {
    }
    public void add (Card card)
    {
        
    }
    public Card takeTop()
    {
    }
    public void shuffle()
    {
    }
    public void sort()
    {
    }
    public String toString()
    {
        String ret="";
        Iterator<Card> iter= deck.iterator();
        while (iter.hasNext())
        {
            ret += System.out.print(iter.next()+ "\n");
        }
        return ret;

    }
   
  
}
