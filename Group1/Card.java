import java.util.*;

public class Card implements Comparable<Card>

{
    private int ID;
    
    public Card(int id)
    {
        ID=id;
    }
    public int getId()
    {
        return ID;
    }
    public int compareTo(Card other)
    {
        int x= this.compareTo(other);
        return x;
    }
    public boolean equals (Card other)
    {
        int x= this.compareTo(other);
        if (x==0)
            return true;
        return false;
    }
    public String toString()
    {
        String represent= ""+this.getId();
        return represent;
    }
}