
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MarkovModel extends AbstractMarkovModel
{

    private int N;    
    
    public MarkovModel(int numberOfCharacters) 
    {
        myRandom = new Random();
        N = numberOfCharacters;
    }
    
    public void setRandom(int seed)
    {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s)
    {
        myText = s.trim();
    }
    
    public String toString(){
        return "MarkovModel of order "+N;
    }
    
    public String getRandomText(int numChars)
    {
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-N);
        String key=myText.substring(index,index+N);
        sb.append(key);
        
        for(int k=0; k < numChars-N; k++)
        {
            ArrayList<String> follows = getFollows(key);
            //System.out.println("key: "+key+"  "+ follows);
            if (follows.size()==0)
                break;
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }
        
        return sb.toString();
    }


}
