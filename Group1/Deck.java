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
import java.math.*;
public class Deck
{
    private ArrayList<Card> deck;
    public Deck()
    {
        ArrayList<Card> deck= new ArrayList<Card>();
    }
    public Deck(int numCard)
    {
        ArrayList<Card> deck= new ArrayList<Card>(numCard);
    }
    public int getNumCards()
    {
        return deck.size();
    }
    public boolean isEmpty()
    {
        if (deck.size()==0)
            return true;
        return false;
    }
    public void add (Card c)
    {
        deck.add(0,c);

    }
    public Card takeTop()
    {



        return deck.remove(0);

    }
    public void shuffle()
    {
        //for (int x=0;x<200;x++)
        //{
            //int temp=(int)(Math.random()*81);
            //Card tempC = deck.get(temp);
            //int temp2 = (int)(Math.random()*81);
            //Card tempC2 = deck.get(temp2);
            
        //}
        Collections.shuffle(deck);
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
            ret = ret + iter.next().toString();
        }
        return ret;

    }
   
  
}
