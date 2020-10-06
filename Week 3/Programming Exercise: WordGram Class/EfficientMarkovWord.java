
/**
 * Write a description of EfficientMarkovWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class EfficientMarkovWord implements IMarkovModel
{
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    private HashMap<WordGram, ArrayList<String>> map;
    
    public EfficientMarkovWord(int order)
    {
        myRandom = new Random();
        myOrder = order;
        map =  new HashMap<WordGram, ArrayList<String>>();
    }
    
    public void setRandom(int seed)
    {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text)
    {
        myText = text.split("\\s+");
        buildMap();
    }
    
    private void buildMap()
    {
        int i;
        for (i=0; i<myText.length-myOrder;i++) 
        {
            WordGram wg = new WordGram(myText,i,myOrder);
            String next = myText[i+myOrder];
            if (map.containsKey(wg))
            {
                map.get(wg).add(next);
            }
            else 
            {
                ArrayList<String> list = new ArrayList<String>();
                list.add(next);
                map.put(wg, list);
            }
            //System.out.println("i:"+i+" myText[i]: "+myText[i]);
            
        }
        WordGram wg = new WordGram(myText,i,myOrder);
        String last = "";
        if (map.containsKey(wg))
            {
                map.get(wg).add(last);
            }
            else 
            {
                ArrayList<String> list = new ArrayList<String>();
                list.add(last);
                map.put(wg, list);
            }
    }
    
    public void printHashMapInfo()
    {
        int maxSetSize = -1;

        for (WordGram wg : map.keySet()) 
        {
            maxSetSize = Math.max(maxSetSize, map.get(wg).size());
            //System.out.println(wg+"\t: "+map.get(wg));
        }

        System.out.println("\nNumber of keys: "+map.keySet().size());
        System.out.println("Max Set Size: "+maxSetSize);
        System.out.println("Keys with Max Size: ");

        for (WordGram wg : map.keySet()) 
        {
            if (map.get(wg).size()==maxSetSize)
                System.out.println(wg+" : "+map.get(wg));
        }
    }
    
    private int indexOf(String[] words, WordGram target, int start) 
    {
        for(int k=start; k < words.length - myOrder; k++) 
        {
            WordGram wg = new WordGram(words,k,myOrder);
            if(wg.equals(target)) 
            {
                return k;
            }
        } 
        return -1;
    }
    
    private ArrayList<String> getFollows(WordGram kGram) 
    {
         return map.get(kGram);
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram key = new WordGram(myText,index,myOrder);
        sb.append(key.toString());
        sb.append(" ");
        for(int k=0; k < numWords-myOrder; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows == null || follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = key.shiftAdd(next);
        }
        return sb.toString().trim();
    }
}
