import java.util.*;

public class EfficientMarkovModel extends AbstractMarkovModel 
{
    private int N;    
    private HashMap<String, ArrayList<String>> map;
    
    public EfficientMarkovModel(int numberOfCharacters) 
    {
        myRandom = new Random();
        N = numberOfCharacters;
        map = new HashMap<String, ArrayList<String>>();
    }
    
    public void setRandom(int seed)
    {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s)
    {
        myText = s.trim();
    }
    
    public String toString()
    {
        return "MarkovModel of order "+N;
    }
    
    public void buildMap()
    {
        int i;
        //Build hashmap
        for (i = 0; i<myText.length()-N;i++)
        {
            String newKey = myText.substring(i, i+N);
             if(!map.containsKey(newKey))
             {
                 ArrayList<String> list = getFollows(newKey);
                 map.put(newKey,list);
             }
        }
        ArrayList<String> empty = new ArrayList<String>();
        map.put(myText.substring(i),empty);
    }
    
    public void printHashMapInfo()
    {
       buildMap();
       System.out.println("Keys in the hashmap: "+(map.size()));
       int max =0;
       
       for (String s : map.keySet())
       {
           if(map.get(s).size()> max)
           {
            max = map.get(s).size();
           }
           System.out.println(s + "  " + map.get(s));
        }
       
       System.out.println("Maximum number of Keys: "+max);
       /*
       for (String s : map.keySet())
       {
           if(map.get(s).size() == max)
           {
               System.out.print(" ' "+s+" ' ");
           }
        }*/
    }
    
    public String getRandomText(int numChars)
    {
        buildMap();
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-N);
        String key=myText.substring(index,index+N);
        sb.append(key);
        
        for(int k=0; k < numChars-N; k++)
        {
            
            ArrayList<String> follows = map.get(key);
            //ArrayList<String> follows = getFollows(key);
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