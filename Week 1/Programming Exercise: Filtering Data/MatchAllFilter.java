
/**
 Write the class MatchAllFilter that implements Filter. 
 This class has a private ArrayList of Filters that is created in the constructor 
 that has no parameters. This class has two methods, 
 1) a void method named addFilter with one Filter parameter that adds the Filter to its private ArrayList, and 
 2) a method named satisfies that has one QuakeEntry parameter and returns true if the QuakeEntry satisfies all the filter conditions, 
 otherwise it returns false. 
 */

import java.util.*;
import edu.duke.*;
public class MatchAllFilter implements Filter
{
    private ArrayList<Filter> filters;
    HashSet<String> h = new HashSet<String>();
    
    public MatchAllFilter()
    {
        filters= new ArrayList<Filter>();
    }
    public void addFilter(Filter f)
    {
        filters.add(f);
    }
    public boolean satisfies(QuakeEntry qe)
    {
        for(Filter f:filters)
        {
            if(!f.satisfies(qe))
            {
                return false;
            }
            else
            {
                h.add(f.getName());
            }
        }

        return true;
    }
    
    public String getName()
    {
        return h.toString();
    }
}
