
/**
Write the class PhraseFilter that implements Filter. 
This class should include two private instance variables for 

1) a String representing the type of request that indicates where to search in the title 
and has one of three values: (“start”, ”end”, or “any”), and 

2) a String indicating the phrase to search for in the title of the earthquake 
(Note the title of the earthquake can be obtained through the getInfo method). 

This class also has a constructor to initialize those variables, and a satisfies method 
that returns true if the phrase is found at the requested location in the title. 
If the phrase is not found, this method should return false.
 */
public class PhraseFilter implements Filter 
{
    private String position;
    private String phrase;
    
    public PhraseFilter(String pos,String phr)
    {
        position=pos;
        phrase=phr;
    }
    
    public boolean satisfies(QuakeEntry qe) 
    { 
        if(position.equals("start"))
        {
            return (qe.getInfo().startsWith(phrase));
        }
        
        if(position.equals("end"))
        {
            return (qe.getInfo().endsWith(phrase));
        }
        
        if(position.equals("any"))
        {
            return (qe.getInfo().contains(phrase));
        }
        return false;
    }
    
    public String getName()
    {
        return("Phrase");
    }
}
