import java.util.*;
/**
 * Write a description of class ZetTestAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestZetAnalyzer
{
    public static void main (String [] args)
    {
        ZetCard c1 = new ZetCard(1,1,1,1);
        ZetCard c2 = new ZetCard(2,2,2,2);
        ZetCard c3 = new ZetCard(3,3,3,3);
        
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        
        System.out.println(ZetAnalyzer.isZet(c1,c2,c3));        
        
        c3 = new ZetCard(3,3,3,1);
        System.out.println(c3);
        
        System.out.print(ZetAnalyzer.isZet(c1,c2,c3));
        
        //KOOOOOOOOOLLLLLLLLLLLLLLLIIIOOOOOOOOOOOOSIDOURFEARLESSLEADER
        //GUMMINGER<3GAMMALGARD 
        //KYUTE
    }
}