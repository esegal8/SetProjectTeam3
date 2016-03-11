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
    public boolean equals (Object other)
    {
        if (this.compareTo((Card)other)!=1)
        {
            return false;
        }
        return true;
    }
}