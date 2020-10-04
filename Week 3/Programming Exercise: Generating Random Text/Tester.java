
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Tester 
{
    public void testGetFollows() 
    {
        MarkovOne markov = new MarkovOne();
        String st = "this is a test yes this is a test.";
        markov.setTraining(st);
        System.out.println("es:  "+markov.getFollows("es"));
        System.out.println(".  : "+markov.getFollows("."));
        System.out.println("t  : "+markov.getFollows("t"));        
    }

    public void testGetFollowsWithFile()
    {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        markov.setTraining(st);
        //System.out.println(markov.getFollows("t").size());
        //System.out.println(markov.getFollows("o").size());
        System.out.println(markov.getFollows("th").size());
    }
}
