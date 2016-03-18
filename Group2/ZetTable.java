/**
 *  Represents a card table with a deck and an array of open cards for the game of Set.
 */
import java.util.ArrayList;

/*
Tips:
- The largest number of cards that don't have a "set" is 20.  There is no
need ever to have more than 21 cards open.  The default number of open cards is 12.

- Keep open cards in an array.  Although open cards are displayed on a two-dimensional
grid, this is a matter for the display class to handle.  Here it is easier to use a
one-dimensional array.

- The open cards array may have gaps: if a card is missing, the corresponding element is
set to null.

- Don't forget to shuffle the deck after it has been created.

- Note that getOpenCard(i) must check that i is within bounds and return null
if it isn't.

- open3Cards places each card into the first available slot.

- In the toString method, separate strings for individual cards with "\n".

- compactCards fills the gaps among the first dfltOpenCards cards with
the cards available beyond the first dfltOpenCards.  A simple algorithm to
accomplish that is similar to the partitioning algorithm:

 * Start at both ends of the array.
 * Proceed for as long as the left index is less than dfltOpenCards and
the right index is greater or equal dfltOpenCards.
 * If you find a card on the left, increment the left index.
 * If you find a gap on the right, decrement the right index.
 * If you find a gap on the left and a card on the right, fill the gap
with that card and advance both indices.

 */

public class ZetTable
{
    private final int dfltOpenCards = 12;
    ArrayList<ZetCard> openCards = new ArrayList<ZetCard>();
    ZetDeck deck = new ZetDeck();
    /**
     *  Creates a new deck and opens dfltOpenCards cards.
     */
    public ZetTable()
    {
        deck.shuffle();
        for(int i=0; i< dfltOpenCards; i++)
        {
            ZetCard TempCard=(ZetCard) deck.takeTop();
            TempCard= (ZetCard) TempCard;
            openCards.add(TempCard);
        }
    }

    /**
     *  Returns the number of cards left in the deck.
     *  @return the number of cards left in the deck.
     */
    public int cardsInDeck()
    {
        return  deck.getNumCards();
    }

    /**
     *  Returns the open card with a given index. If the index is out of bounds
     *  or the card with this index is not open, returns null.
     *  @return the open card with a given index, or null if the index
     *  is out of bounds.
     */
    public ZetCard getOpenCard(int i)
    {
        if(i>=0 && i<openCards.size())//openCards.get(i)==null
        {
            return openCards.get(i);
        }
        else{
            return null;
        }
    }

    /**
     *  Indicates whether there is a sufficient number of open cards.
     *  @return true if numOpenCards >= dfltOpenCards; false otherwise.
     */
    public boolean enoughOpen()
    {
        if(openCards.size()>=dfltOpenCards){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *  Finds a "set" in the open cards.
     *  @return an array of the indices of the three "set" cards,
     *  or null if no sets are found.
     */
    public int[] findZet()
    { 
        int size=openCards.size();
        for(int i=0;i<size-2;i++){
            for(int j=i;j<size-1;j++){
                for(int x=j;x<size;x++){
                    int num=0;
                    int shape=0;
                    int color=0;
                    int fill=0;
                    ZetCard fCard=openCards.get(i);
                    ZetCard sCard=openCards.get(j);
                    ZetCard tCard=openCards.get(x);
                    int a=fCard.getNumber();
                    int y=sCard.getNumber();
                    int z=tCard.getNumber();
                    if(a==y && y==z || a!=y && y!=z && a!=z){
                        num=1;
                    }
                    a=fCard.getShape();
                    y=sCard.getShape();
                    z=tCard.getShape();
                    if(a==y && y==z || a!=y && y!=z && a!=z){
                        shape=1;
                    }
                    a=fCard.getFill();
                    y=sCard.getFill();
                    z=tCard.getFill();
                    if(a==y && y==z || a!=y && y!=z && a!=z){
                        fill=1;
                    }
                    a=fCard.getColor();
                    y=sCard.getColor();
                    z=tCard.getColor();
                    if(a==y && y==z || a!=y && y!=z && a!=z){
                        color=1;
                    }
                    if(num==1 && shape==1 && fill==1 && color==1){
                        int[] set=new int[3];
                        set[0]=i;
                        set[1]=j;
                        set[2]=x;
                        return set;
                    }
                }
            }
        }
        return null;
    }

    /**
     *  Opens three cards from the deck if three cards are available in the deck.
     *  @return true if the cards are opened; false otherwise.
     */
    public boolean open3Cards()
    {
        if(deck.getNumCards()<2){
            return false;
        }
        else{
            for(int j=0; j<=2; j++)
            {
                openCards.add((ZetCard) deck.takeTop());
            }
            return true;
        }
    }

    /**
     *  Removes three cards with given indices from the open cards.
     *  @precondition The cards with indices[0], indices[1], indices[2] are open.
     */
    public void remove3Cards(int[] indices)
    {
        for(int d=0; d<=2; d++)
        {
            int i=indices[0];
            openCards.set(i,null);
        }
    }

    /**
     *  If there are gaps in the first dfltOpenCards and some open cards
     *  beyond dfltOpenCards, the latter are moved to fill the gaps.
     */
    public void compactOpenCards()
    {
        int backInd=openCards.size()-1;
        for(int i=0;i<dfltOpenCards;i++){
            if(openCards.get(i)==null){
                openCards.set(i,openCards.get(backInd));
                backInd--;
            }
        }
    }

    /**
     *  Returns a string representation of this "set table".
     *  @return a string that lists all the open cards (including null cards)
     *  followed by an '\n' character, and finally the count of cards
     *  left in the deck.representation of this "set table".
     *  @return a string that lists all the open card
     */
    public String toString()
    {
        String s="";
        for(int i=0;i<openCards.size();i++){
            if(openCards.get(i)==null){
                s+="null: ";
            }
            else{
                s+=openCards.get(i).toString();
            }
        }
        return s;
    }
}
