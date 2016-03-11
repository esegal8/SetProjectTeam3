//Elliot and Varun
public class ZetDeck extends Deck
{
    
    
    public ZetDeck()
    {
        super();
        for (int x=0;x<3;x++)
        {
            for(int y=0;y<3;y++)
            {
                for(int z=0;z<3;z++)
                {
                    for(int p=0;p<3;p++)
                    {
                        deck.add(ZetCard(x,y,z,p));
                    }
                }
            }
        }
    }
}