//Elliot and Varun
public class ZetCard extends Card
{

    private int num;
    private int shape;
    private int fill;
    private int color;
    private final String[] shapeA = {null,"oval","squiggle","diamond"};
    private final String[] fillA = {null,"outlined","solid","stripped"};
    private final String[] colorA = {null,"red","green","blue"};
    public ZetCard(int n, int s, int f, int c)
    {

        num = n;
        shape = s;
        fill = f;
        color = c;
    }

    public int getNumber()
    {
        return num;
    }

    public int getShape()
    {
        return shape;
    }

    public int getFill()
    {
        return fill;
    }

    public int getColor()
    {
        return color;
    }

    public String toString()
    {
        return ("This card has "+num+" "+shapeA[shape]+"s that are "+fillA[fill]+" and "+colorA[color]+".");
    }
}