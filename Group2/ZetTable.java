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
    ArrayList<ZetCards> openCards = new ArrayList<ZetCards>();
    ZetDeck deck = new ZetDeck();
    /**
     *  Creates a new deck and opens dfltOpenCards cards.
     */
    public ZetTable()
    {
        deck.shuffle();
        for(int i=0; i< dfltOpenCards; i++)
        {
            openCards.add(deck.takeTop());
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
        if(openCards.get(i)==null)
        {
            return null;
        }
        return openCards.get(i);
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
        for(i=0;i<size-2;i++){
            for(j=i;j<size-1;j++){
                for(x=j;x<size;x++){
                    int num=0;
                    int shape=0;
                    int color=0;
                    int fill=0;
                    zetCard fCard=openCards.get(i);
                    zetCard sCard=openCards.get(j);
                    zetCard tCard=openCards.get(x);
                    int x=fCard.getNumber();
                    int y=sCard.getNumber();
                    int z=tCard.getNumber();
                    if(x==y && y==z || x!=y && y!=z && x!=z){
                        num=1;
                    }
                    int x=fCard.getShape();
                    int y=sCard.getShape();
                    int z=tCard.getShape();
                    if(x==y && y==z || x!=y && y!=z && x!=z){
                        shape=1;
                    }
                    int x=fCard.getFill();
                    int y=sCard.getFill();
                    int z=tCard.getFill();
                    if(x==y && y==z || x!=y && y!=z && x!=z){
                        fill=1;
                    }
                    int x=fCard.getColor();
                    int y=sCard.getColor();
                    int z=tCard.getColor();
                    if(x==y && y==z || x!=y && y!=z && x!=z){
                        color=1;
                    }
                    if(num==1 && shape==1 && fill==1 && color==1){
                        int[] set=new set(3);
                        set[1]=fCard;
                        set[2]=sCard;
                        set[3]=tCard;
                        return set;
                    }
                }
            }
        }
    }

    /**
     *  Opens three cards from the deck if three cards are available in the deck.
     *  @return true if the cards are opened; false otherwise.
     */
    public boolean open3Cards()
    {
        for(int j=0; j<=2; j++)
        {
            openCards.add(deck.takeTop());
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
        for(i=0;i<dfltOpenCards;i++){
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
        for(i=0;i<openCards.size();i++){
           if(openCards(i)==null){
               s+="null: ";
            }
            else{
                s+=openCards.get(i).toString();
            }
        }
    }
}
