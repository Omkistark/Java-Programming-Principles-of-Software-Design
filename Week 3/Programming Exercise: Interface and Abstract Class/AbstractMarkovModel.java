
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);
    
    protected ArrayList<String> getFollows(String key)
    {
        ArrayList<String> list = new ArrayList<String>();
        int i=0;
        while((myText.indexOf(key,i)!=-1) && (myText.indexOf(key,i)+key.length()<myText.length()) )
        {
            list.add(Character.toString(myText.charAt(myText.indexOf(key,i)+key.length())));
            i=myText.indexOf(key,i)+1;
        }
        return (list);
    }


}
