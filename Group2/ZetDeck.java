//Elliot and Varun
import java.util.*;
public class ZetDeck extends Deck
{
    private ArrayList<Card> deck = new ArrayList<Card>();
    
    public ZetDeck()
    {
        Card c;
        for (int x=1;x<4;x++)
        {
            for(int y=1;y<4;y++)
            {
                for(int z=1;z<4;z++)
                {
                    for(int p=1;p<4;p++)
                    {
                        c = new ZetCard(x,y,z,p);
                        deck.add(c);
                    }
                }
            }
        }
        setDeck(deck);
    }
}