/**
 * Provides static methods for finding sets.
 */
/*
Tips:
- Given a, b, c from {1, 2, 3}, they are all equal or all different if and only if
(a + b + c) % 3 == 0. This property can be used for testing three cards for a set
easily.
(For more mathematically inclined, the SET deck corresponds to the 4-dimensional vector
space over the algebraic field {0, 1, 2} with modulo 3 arithmetic. Three cards form a "set"
if and only if the sum of the corresponding vectors is 0.)
- isZet and findZet are static methods.
- in isZet, don't forget to check that the cards are not all the same.
- Note that an array passed to findZet can have nulls in some of the elements.
 */
public class ZetAnalyzer
{
    boolean numberZet, colorZet, fillZet, shapeZet;
    private static int cardOne, cardTwo, cardThree;
    public static boolean isZet(ZetCard card1, ZetCard card2, ZetCard card3)
    {
        cardOne = card1.getNumber();
        cardTwo = card2.getNumber();
        cardThree = card3.getNumber();
        int increment = 0;
        if ((cardOne + cardTwo + cardThree) % 3 == 0)
        {
            increment++;
        }

        cardOne = card1.getColor();
        cardTwo = card2.getColor();
        cardThree = card3.getColor();

        if ((cardOne + cardTwo + cardThree) % 3 == 0)
        {
            increment++;
        }

        cardOne = card1.getShape();
        cardTwo = card2.getShape();
        cardThree = card3.getShape();

        if (( cardOne + cardTwo + cardThree) % 3 == 0)
        {
            increment++;
        }

        cardOne = card1.getFill();
        cardTwo = card2.getFill();
        cardThree = card3.getFill();

        if ((cardOne + cardTwo + cardThree) % 3 == 0)
        {
            increment++;
        }

        if(increment == 4)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int[] findZet(ZetCard[] cards)
    {
        int length = cards.length-1;
        for (int x = 0; x <= length; x++)
        {
            for (int z =1; z <= length; z++)
            {
                for (int i =2; i <= length; i++)
                {
                    if (isZet(cards[x], cards[i], cards[z]) == true)
                    {
                        int[] arrayZet = {x,i,z};
                        return arrayZet;

                    }
                }
            }
        }
        return null;
    }
}